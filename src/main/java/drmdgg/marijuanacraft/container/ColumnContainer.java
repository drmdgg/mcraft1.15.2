package drmdgg.marijuanacraft.container;

import javax.annotation.Nonnull;

import drmdgg.marijuanacraft.ModUtil;
import drmdgg.marijuanacraft.init.ModContainerTypes;
import drmdgg.marijuanacraft.init.blocks.tileentities.ColumnTileEntity;
import drmdgg.marijuanacraft.lists.BlockList;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IWorldPosCallable;
import net.minecraftforge.items.SlotItemHandler;

public class ColumnContainer extends Container {



	public final ColumnTileEntity tileEntity;

	private final IWorldPosCallable canInteractWithCallable;



	/**

	 * Logical-client-side constructor, called from {@link ContainerType#create(IContainerFactory)}

	 * Calls the logical-server-side constructor with the TileEntity at the pos in the PacketBuffer

	 */

	public ColumnContainer(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data) {

		this(windowId, playerInventory, ModUtil.getTileEntityOrCrash(playerInventory, data, ColumnTileEntity.class));

	}



	/**

	 * Constructor called logical-server-side from {@link ColumnTileEntity#createMenu}

	 * and logical-client-side from {@link #ColumnContainer(int, PlayerInventory, PacketBuffer)}

	 */

	public ColumnContainer(final int windowId, final PlayerInventory playerInventory, final ColumnTileEntity tileEntity) {

		super(ModContainerTypes.column, windowId);

		this.tileEntity = tileEntity;

		this.canInteractWithCallable = IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos());



		// Add tracking for data (Syncs to client/updates value when it changes)

		this.trackInt(new FunctionalIntReferenceHolder(() -> tileEntity.smeltTimeLeft, v -> tileEntity.smeltTimeLeft = (short) v));

		this.trackInt(new FunctionalIntReferenceHolder(() -> tileEntity.maxSmeltTime, v -> tileEntity.maxSmeltTime = (short) v));

		this.trackInt(new FunctionalIntReferenceHolder(() -> tileEntity.fuelBurnTimeLeft, v -> tileEntity.fuelBurnTimeLeft = (short) v));

		this.trackInt(new FunctionalIntReferenceHolder(() -> tileEntity.maxFuelBurnTime, v -> tileEntity.maxFuelBurnTime = (short) v));



		// Add all the slots for the tileEntity's inventory and the playerInventory to this container



		// Tile inventory slot(s)

		  this.addSlot(new SlotItemHandler(tileEntity.inventory, ColumnTileEntity.INPUT_SLOT, 79, 17));
	      this.addSlot(new SlotItemHandler(tileEntity.inventory, ColumnTileEntity.OUTPUT_SLOT, 79, 58));
	      this.addSlot(new SlotItemHandler(tileEntity.inventory, ColumnTileEntity.FUEL_SLOT, 17, 17));



		final int playerInventoryStartX = 8;

		final int playerInventoryStartY = 84;

		final int slotSizePlus2 = 18; // slots are 16x16, plus 2 (for spacing/borders) is 18x18



		// Player Top Inventory slots

		for (int row = 0; row < 3; ++row) {

			for (int column = 0; column < 9; ++column) {

				this.addSlot(new Slot(playerInventory, 9 + (row * 9) + column, playerInventoryStartX + (column * slotSizePlus2), playerInventoryStartY + (row * slotSizePlus2)));

			}

		}



		final int playerHotbarY = playerInventoryStartY + slotSizePlus2 * 3 + 4;

		// Player Hotbar slots

		for (int column = 0; column < 9; ++column) {

			this.addSlot(new Slot(playerInventory, column, playerInventoryStartX + (column * slotSizePlus2), playerHotbarY));

		}

	}



	/**

	 * Generic & dynamic version of {@link Container#transferStackInSlot(PlayerEntity, int)}.

	 * Handle when the stack in slot {@code index} is shift-clicked.

	 * Normally this moves the stack between the player inventory and the other inventory(s).

	 *

	 * @param player the player passed in

	 * @param index  the index passed in

	 * @return the {@link ItemStack}

	 */

	@Nonnull

	@Override

	public ItemStack transferStackInSlot(final PlayerEntity player, final int index) {

		ItemStack returnStack = ItemStack.EMPTY;

		final Slot slot = this.inventorySlots.get(index);

		if (slot != null && slot.getHasStack()) {

			final ItemStack slotStack = slot.getStack();

			returnStack = slotStack.copy();



			final int containerSlots = this.inventorySlots.size() - player.inventory.mainInventory.size();

			if (index < containerSlots) {

				if (!mergeItemStack(slotStack, containerSlots, this.inventorySlots.size(), true)) {

					return ItemStack.EMPTY;

				}

			} else if (!mergeItemStack(slotStack, 0, containerSlots, false)) {

				return ItemStack.EMPTY;

			}

			if (slotStack.getCount() == 0) {

				slot.putStack(ItemStack.EMPTY);

			} else {

				slot.onSlotChanged();

			}

			if (slotStack.getCount() == returnStack.getCount()) {

				return ItemStack.EMPTY;

			}

			slot.onTake(player, slotStack);

		}

		return returnStack;

	}



	@Override

	public boolean canInteractWith(@Nonnull final PlayerEntity player) {

		return isWithinUsableDistance(canInteractWithCallable, player, BlockList.column);

	}



}