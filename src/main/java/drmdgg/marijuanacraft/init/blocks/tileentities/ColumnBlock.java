package drmdgg.marijuanacraft.init.blocks.tileentities;

import javax.annotation.Nullable;

import drmdgg.marijuanacraft.init.ModTileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.ItemStackHandler;

public class ColumnBlock extends Block {



	public static final BooleanProperty BURNING = BooleanProperty.create("burning");



	public ColumnBlock(final Properties properties) {

		super(properties);

		this.setDefaultState(this.getDefaultState().with(BURNING, false));

	}



	@Override

	public boolean hasTileEntity(final BlockState state) {

		return true;

	}

	public boolean isOpaqueCube(BlockState state)
	{
		return false;
	}
	
	public BlockRenderType getRenderLayer()
	{
		return BlockRenderType.MODEL;
	}

	@Nullable

	@Override

	public TileEntity createTileEntity(final BlockState state, final IBlockReader world) {

		// Always use TileEntityType#create to allow registry overrides to work.

		return ModTileEntityTypes.column.create();

	}



	/**

	 * Called on the logical server when a BlockState with a TileEntity is replaced by another BlockState

	 *

	 * @deprecated Call via {@link BlockState#onReplaced(World, BlockPos, BlockState, boolean)}

	 * Implementing/overriding is fine.

	 */

	@Override

	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {

		if (state.getBlock() != newState.getBlock()) {

			TileEntity tileEntity = worldIn.getTileEntity(pos);

			if (tileEntity instanceof ColumnTileEntity) {

				final ItemStackHandler inventory = ((ColumnTileEntity) tileEntity).inventory;

				for (int slot = 0; slot < inventory.getSlots(); ++slot) {

					InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), inventory.getStackInSlot(slot));

				}

			}

		}

		super.onReplaced(state, worldIn, pos, newState, isMoving);

	}



	/**

	 * @deprecated Call via {@link BlockState#onBlockActivated(World, PlayerEntity, Hand, BlockRayTraceResult)} whenever possible.

	 * Implementing/overriding is fine.

	 */
@Override
	public ActionResultType onBlockActivated(final BlockState state, final World worldIn, final BlockPos pos, final PlayerEntity player, final Hand handIn, final BlockRayTraceResult hit) {

		if (!worldIn.isRemote) {

			final TileEntity tileEntity = worldIn.getTileEntity(pos);

			if (tileEntity instanceof ColumnTileEntity) {

				NetworkHooks.openGui((ServerPlayerEntity) player, (ColumnTileEntity) tileEntity, pos);
		       } else {
	                throw new IllegalStateException("Our named container provider is missing!");
	            }
	            return ActionResultType.SUCCESS;
	        }
	        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
	    }


	@Override

	protected void fillStateContainer(final StateContainer.Builder<Block, BlockState> builder) {

		super.fillStateContainer(builder.add(BURNING));

	}



}


