package drmdgg.marijuanacraft.init.blocks.trees;


import drmdgg.marijuanacraft.lists.ItemList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.LogBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.GameRules;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.IPlantable;



public class PotStalk extends LogBlock {
	

 

	 private final MaterialColor verticalColor;
	 protected static final VoxelShape SHAPE = Block.makeCuboidShape(-1.0D, -1.0D, 1.0D, 12.0D, 12.0D, 12.0D);
	 

	 public PotStalk(MaterialColor p_i48367_1_, Block.Properties p_i48367_2_) {

		      

		 super(p_i48367_1_, p_i48367_2_);

		 this.verticalColor = p_i48367_1_;

		   

	 }
	 @OnlyIn(Dist.CLIENT)
     public BlockRenderType getRenderType(BlockState state)
     {
          return BlockRenderType.MODEL;
     }
     @OnlyIn(Dist.CLIENT)
     public BlockRenderType getBlockLayer()
     {
         return BlockRenderType.MODEL;
     }
 	
	

	public MaterialColor getMaterialColor(BlockState state, IBlockReader worldIn, BlockPos pos) {

		      

		return state.get(AXIS) == Direction.Axis.Y ? this.verticalColor : this.materialColor;

		   

	}

	   

	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {

  

		if (!(player.getHeldItem(handIn).getItem() == ItemList.marijuana_bud)) {

		    	  

            return ActionResultType.SUCCESS;


		         

		} else



			player.inventory.addItemStackToInventory(new ItemStack(ItemList.marijuana_bud));

		    player.getHeldItem(handIn).shrink(1);	

            return ActionResultType.SUCCESS;

		      

	}



	public static void spawnAsEntity(World worldIn, BlockPos pos, ItemStack stack) {

		      

		if (!worldIn.isRemote && !stack.isEmpty() && worldIn.getGameRules().getBoolean(GameRules.DO_TILE_DROPS) && !worldIn.restoringBlockSnapshots) { 

		

			double d0 = (double)(worldIn.rand.nextFloat() * 0.5F) + 0.25D;       

			double d1 = (double)(worldIn.rand.nextFloat() * 0.5F) + 0.25D;

			double d2 = (double)(worldIn.rand.nextFloat() * 0.5F) + 0.25D;       

			ItemEntity itementity = new ItemEntity(worldIn, (double)pos.getX() + d0, (double)pos.getY() + d1, (double)pos.getZ() + d2, stack);    

			itementity.setDefaultPickupDelay();

			worldIn.addEntity(itementity);

		}

		}

		public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
		{

		      

			return SHAPE;

			  

		}

		

		public boolean isOpaqueCube(BlockState state)
		{

			

			return false;

			

		}

		

		public boolean isFullCube(BlockState state)
		{

			

			return false;

			

		}
		
		public boolean canSustainLeaves(BlockState state, IBlockReader world, BlockPos pos)
		{
			return true;
		}
		
		{

	

}
}
