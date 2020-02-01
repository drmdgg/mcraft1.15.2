package drmdgg.marijuanacraft.container;

import javax.annotation.Nonnull;

import drmdgg.marijuanacraft.ModUtil;
import drmdgg.marijuanacraft.init.ModContainerTypes;
import drmdgg.marijuanacraft.init.blocks.tileentities.VacuumOvenTileEntity;
import drmdgg.marijuanacraft.lists.BlockList;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IWorldPosCallable;
import net.minecraftforge.items.SlotItemHandler;

public class VacuumOvenContainer extends Container {

	public final VacuumOvenTileEntity tileEntity;
	private final IWorldPosCallable canInteractWithCallable;


	public VacuumOvenContainer(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data) {
		this(windowId, playerInventory, ModUtil.getTileEntityOrCrash(playerInventory, data, VacuumOvenTileEntity.class));
	}

	public VacuumOvenContainer(final int windowId, final PlayerInventory playerInventory, final VacuumOvenTileEntity tileEntity) {
		super(ModContainerTypes.vacuumoven, windowId);
		this.tileEntity = tileEntity;
		this.canInteractWithCallable = IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos());

		// Add tracking for data (Syncs to client/updates value when it changes)
		this.trackInt(new FunctionalIntReferenceHolder(() -> tileEntity.smeltTimeLeft, v -> tileEntity.smeltTimeLeft = (short) v));
		this.trackInt(new FunctionalIntReferenceHolder(() -> tileEntity.maxSmeltTime, v -> tileEntity.maxSmeltTime = (short) v));
		this.trackInt(new FunctionalIntReferenceHolder(() -> tileEntity.fuelBurnTimeLeft, v -> tileEntity.fuelBurnTimeLeft = (short) v));
		this.trackInt(new FunctionalIntReferenceHolder(() -> tileEntity.maxFuelBurnTime, v -> tileEntity.maxFuelBurnTime = (short) v));

		// Add all the slots for the tileEntity's inventory and the playerInventory to this container

		// Tile inventory slot(s)
		this.addSlot(new SlotItemHandler(tileEntity.inventory, VacuumOvenTileEntity.INPUT_SLOT, 56, 53));
		this.addSlot(new SlotItemHandler(tileEntity.inventory, VacuumOvenTileEntity.OUTPUT_SLOT, 116, 35));

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
		return isWithinUsableDistance(canInteractWithCallable, player, BlockList.vacuumoven);
	}

} 


