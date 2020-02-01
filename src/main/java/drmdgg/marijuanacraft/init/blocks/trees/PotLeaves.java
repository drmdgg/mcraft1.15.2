package drmdgg.marijuanacraft.init.blocks.trees;

import java.util.Random;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class PotLeaves extends LeavesBlock{

	public PotLeaves(Properties properties) {
		super(properties);
	
	}
	public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
	      return type == EntityType.OCELOT || type == EntityType.PARROT;
	   }
	

	@Override
	public void beginLeaveDecay(BlockState state, IWorldReader world, BlockPos pos) {
		
		super.beginLeaveDecay(state, world, pos);
	}

	@Override
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		super.animateTick(stateIn, worldIn, pos, rand);
		if (worldIn.isRainingAt(pos.up())) {
			if (rand.nextInt(15) == 1) {
				BlockPos blockpos = pos.down();
				BlockState blockstate = worldIn.getBlockState(blockpos);
				if (!blockstate.isSolid() || !blockstate.isSolidSide(worldIn, blockpos, Direction.UP)) {
					double d0 = (double)((float)pos.getX() + rand.nextFloat());
					double d1 = (double)pos.getY() - 0.05D;
					double d2 = (double)((float)pos.getZ() + rand.nextFloat());
					worldIn.addParticle(ParticleTypes.DRIPPING_WATER, d0, d1, d2, 0.0D, 0.0D, 0.0D);
				}
			}
	    }
	}
	@Override
	public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
		return super.isFlammable(state, world, pos, face);
}
	
	
	public BlockRenderType getRenderLayer()
	{
		return BlockRenderType.MODEL;
	}
}