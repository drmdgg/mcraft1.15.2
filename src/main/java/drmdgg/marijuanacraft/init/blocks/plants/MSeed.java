package drmdgg.marijuanacraft.init.blocks.plants;

import drmdgg.marijuanacraft.lists.BlockList;
import drmdgg.marijuanacraft.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;

public class MSeed extends BlockNamedItem implements IPlantable{

		public MSeed(Block cropBlockIn, Properties properties)
		{
			super(cropBlockIn, new Properties().group(ItemGroup.MATERIALS));
		}
		
		 public void registerModels()
		    {
		        ClientProxy.registerItemRenderer(this, 0, "inventory");
		    }
		 
		   
		    public ActionResultType onItemUse(PlayerEntity player, World worldIn, BlockPos pos, Hand hand, Direction direction, float hitX, float hitY, float hitZ)
		    {
		        ItemStack stack = player.getHeldItem(hand);
		        BlockState state = worldIn.getBlockState(pos);
		        if(direction == Direction.UP && player.canPlayerEdit(pos.offset(direction), direction, stack) && state.getBlock().canSustainPlant(state, worldIn, pos, Direction.UP, this) && worldIn.isAirBlock(pos))
		        {
		            worldIn.setBlockState(pos.up(), BlockList.mplant.getDefaultState());
		            stack.shrink(1);
		            return ActionResultType.SUCCESS;
		        }
		        else return ActionResultType.FAIL;
		    }
		   @Override
		    public PlantType getPlantType(IBlockReader world, BlockPos pos)
		    {
		        return PlantType.Crop;
		    }
		 @Override
		    public  BlockState getPlant(IBlockReader world, BlockPos pos)
		    {
		        return BlockList.mplant.getDefaultState();
		    }

		 protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		      return state.getBlock() == Blocks.FARMLAND;
		   }
		 
		}

