package drmdgg.marijuanacraft.init.blocks.trees;
 
import com.mojang.datafixers.Dynamic;
 
 
 
import drmdgg.marijuanacraft.lists.BlockList;

import java.util.Random;
 
import java.util.Set;
 
import java.util.function.Function;
 
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
 
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.IWorldGenerationReader;
 
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
 
 
 
public class BasicTreeFeature extends AbstractTreeFeature<BaseTreeFeatureConfig> {
	   private static final BlockState TRUNK = BlockList.potstalk.getDefaultState();
	   private static final BlockState LEAF = BlockList.potleaves.getDefaultState();
	   protected net.minecraftforge.common.IPlantable sapling = (net.minecraftforge.common.IPlantable)BlockList.clone;


	   public BasicTreeFeature(Function<Dynamic<?>, ? extends BaseTreeFeatureConfig> p_i51429_1_, boolean p_i51429_2_) {
	      super(p_i51429_1_);
	      setSapling((net.minecraftforge.common.IPlantable)BlockList.clone);
	   }
	   
	   protected BasicTreeFeature setSapling(net.minecraftforge.common.IPlantable value) {
		      this.sapling = value;
		      return this;
		   }

		   public net.minecraftforge.common.IPlantable getSapling() {
		       return this.sapling;
		   }

	   public boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos position, MutableBoundingBox boundsIn) {
	      int i = rand.nextInt(3) + 2;
	      int j = 0 + 1;
	      int k = i - j;
	      int l = 1 + 5;
	      boolean flag = true;
	      if (position.getY() >= 1 && position.getY() + i + 1 <= worldIn.getMaxHeight()) {
	         for(int i1 = position.getY(); i1 <= position.getY() + 1 + i && flag; ++i1) {
	            int j1;
	            if (i1 - position.getY() < j) {
	               j1 = 0;
	            } else {
	               j1 = l;
	            }

	            BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();

	            for(int k1 = position.getX() - j1; k1 <= position.getX() + j1 && flag; ++k1) {
	               for(int l1 = position.getZ() - j1; l1 <= position.getZ() + j1 && flag; ++l1) {
	                  if (i1 >= 0 && i1 < worldIn.getMaxHeight()) {
	                     blockpos$mutableblockpos.setPos(k1, i1, l1);
	                     if (!isAirOrLeaves(worldIn, blockpos$mutableblockpos)) {
	                        flag = false;
	                     }
	                  } else {
	                     flag = false;
	                  }
	               }
	            }
	         }

	         if (!flag) {
	            return false;
	         } else if (isSoil(worldIn, position.down(), getSapling()) && position.getY() < worldIn.getMaxHeight() - i - 1) {
	            this.setDirtAt(worldIn, position.down(), position);
	            int i3 = rand.nextInt(2);
	            int j3 = 1;
	            int k3 = 0;

	            for(int l3 = 0; l3 <= k; ++l3) {
	               int j4 = position.getY() + i - l3;

	               for(int i2 = position.getX() - i3; i2 <= position.getX() + i3; ++i2) {
	                  int j2 = i2 - position.getX();

	                  for(int k2 = position.getZ() - i3; k2 <= position.getZ() + i3; ++k2) {
	                     int l2 = k2 - position.getZ();
	                     if (Math.abs(j2) != i3 || Math.abs(l2) != i3 || i3 <= 0) {
	                        BlockPos blockpos = new BlockPos(i2, j4, k2);
	                        if (isAirOrLeaves(worldIn, blockpos) || isTallPlants(worldIn, blockpos)) {
	                           this.setBlockState(worldIn, blockpos, LEAF);
	                        }
	                     }
	                  }
	               }

	               if (i3 >= j3) {
	                  i3 = k3;
	                  k3 = 1;
	                  ++j3;
	                  if (j3 > l) {
	                     j3 = l;
	                  }
	               } else {
	                  ++i3;
	               }
	            }

	            int i4 = rand.nextInt(3);

	            for(int k4 = 0; k4 < i - i4; ++k4) {
	               if (isAirOrLeaves(worldIn, position.up(k4))) {
	                  this.setBlockState(worldIn, position.up(k4), TRUNK);
	               }
	            }

	            return true;
	         } else {
	            return false;
	         }
	      } else {
	         return false;
	      }
	   }
	   public static boolean isTallPlants(IWorldGenerationBaseReader p_214576_0_, BlockPos p_214576_1_) {
		      return p_214576_0_.hasBlockState(p_214576_1_, (p_227218_0_) -> {
		         Material material = p_227218_0_.getMaterial();
		         return material == Material.TALL_PLANTS;
		      });
		   }
	   public boolean generate(IWorldGenerationReader world, Random rand, BlockPos position, Set<BlockPos> p_225557_4_, Set<BlockPos> p_225557_5_, MutableBoundingBox p_208519_5_, BaseTreeFeatureConfig p_225557_7_) {
			  
	 	      if (isSoil(world, position.down(), p_225557_7_.getSapling())) {
	         	this.setBlockState(world, position, BasicTreeFeature.TRUNK);

		         for(int i = position.getY(); i <= position.getY() + 2; ++i) {
		            int j = i - position.getY();
		            int k = 2 - j;

		            for(int l = position.getX() - k; l <= position.getX() + k; ++l) {
		               int i1 = l - position.getX();

		               for(int j1 = position.getZ() - k; j1 <= position.getZ() + k; ++j1) {
		                  int k1 = j1 - position.getZ();
		                  if (Math.abs(i1) != k || Math.abs(k1) != k || rand.nextInt(3) == 0) {
		                     BlockPos blockpos = new BlockPos(l, i, j1);
		                     if (isAirOrLeaves(world, blockpos)) {
		                     	this.setBlockState(world, blockpos, this.LEAF);
		                     }
		                  }
		               }
		            }
		         }
		      }

		      return true;
		   }

	@Override
	protected boolean func_225557_a_(IWorldGenerationReader p_225557_1_, Random p_225557_2_, BlockPos p_225557_3_,
			Set<BlockPos> p_225557_4_, Set<BlockPos> p_225557_5_, MutableBoundingBox p_225557_6_,
			BaseTreeFeatureConfig p_225557_7_) {
		// TODO Auto-generated method stub
		return false;
	}

		}