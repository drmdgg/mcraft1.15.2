
package drmdgg.marijuanacraft.init.blocks.tileentities;



import java.util.Optional;



import javax.annotation.Nonnull;

import javax.annotation.Nullable;



import drmdgg.marijuanacraft.container.VacuumOvenContainer;

import drmdgg.marijuanacraft.init.ModTileEntityTypes;
import drmdgg.marijuanacraft.lists.BlockList;
import drmdgg.marijuanacraft.lists.ItemList;
import drmdgg.marijuanacraft.lists.VORecipeList;
import drmdgg.marijuanacraft.recipes.PurgingRecipe;
import drmdgg.marijuanacraft.recipes.VORecipeSerializer;
import net.minecraft.block.BlockState;

import net.minecraft.entity.player.PlayerEntity;

import net.minecraft.entity.player.PlayerInventory;

import net.minecraft.inventory.Inventory;

import net.minecraft.inventory.InventoryHelper;

import net.minecraft.inventory.container.Container;

import net.minecraft.inventory.container.INamedContainerProvider;

import net.minecraft.item.ItemStack;

import net.minecraft.item.crafting.FurnaceRecipe;

import net.minecraft.item.crafting.IRecipeType;

import net.minecraft.nbt.CompoundNBT;

import net.minecraft.tileentity.FurnaceTileEntity;

import net.minecraft.tileentity.ITickableTileEntity;

import net.minecraft.tileentity.TileEntity;

import net.minecraft.util.Direction;

import net.minecraft.util.text.ITextComponent;

import net.minecraft.util.text.TranslationTextComponent;

import net.minecraftforge.common.ForgeHooks;

import net.minecraftforge.common.capabilities.Capability;

import net.minecraftforge.common.util.LazyOptional;

import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraftforge.items.ItemStackHandler;



public class VacuumOvenTileEntity extends TileEntity implements ITickableTileEntity, INamedContainerProvider {

		public static final int INPUT_SLOT = 0;

	public static final int OUTPUT_SLOT = 1;

	private static final String INVENTORY_TAG = "inventory";

	private static final String SMELT_TIME_LEFT_TAG = "smeltTimeLeft";

	private static final String MAX_SMELT_TIME_TAG = "maxSmeltTime";

	private static final String FUEL_BURN_TIME_LEFT_TAG = "fuelBurnTimeLeft";

	private static final String MAX_FUEL_BURN_TIME_TAG = "maxFuelBurnTime";


	public final ItemStackHandler inventory = new ItemStackHandler(2) {

		@Override

		public boolean isItemValid(final int slot, @Nonnull final ItemStack stack) {

			switch (slot) {

				case INPUT_SLOT:

					return isInput(stack) || stack.getItem() == ItemList.extract2;

				case OUTPUT_SLOT:

					return isOutput(stack) || stack.getItem() == ItemList.shatter;
				
				default:

					return false;

			}

		}



		@Override

		protected void onContentsChanged(final int slot) {

			super.onContentsChanged(slot);

			VacuumOvenTileEntity.this.markDirty();

		}

	};



	private final LazyOptional<ItemStackHandler> inventoryCapabilityExternal = LazyOptional.of(() -> this.inventory);



	public short smeltTimeLeft = 1;

	public short maxSmeltTime = 1;

	public short fuelBurnTimeLeft = 1;

	public short maxFuelBurnTime = 1;

	public boolean lastBurning = true;



	public VacuumOvenTileEntity() {

		super(ModTileEntityTypes.vacuumoven);

	}



	private boolean isInput(final ItemStack stack) {

		if (stack.isEmpty())

			return false;

		return getRecipe(stack).isPresent();

	}



	private boolean isOutput(final ItemStack stack) {

		final Optional<ItemStack> result = getResult(inventory.getStackInSlot(INPUT_SLOT));

		return result.isPresent() && ItemStack.areItemsEqual(result.get(), stack);

	}

	private Optional<PurgingRecipe> getRecipe(final ItemStack input) {

		return getRecipe(new Inventory(input));

	}



	private Optional<PurgingRecipe> getRecipe(final Inventory inventory) {

		return world.getRecipeManager().getRecipe(PurgingRecipe.purging, inventory, world);

	}



	private Optional<ItemStack> getResult(final ItemStack input) {

		final Inventory inventory = new Inventory(input);

		return getRecipe(inventory).map(recipe -> recipe.getCraftingResult(inventory));

	}



	@Override

	public void tick() {

		if (world == null || world.isRemote)

			return;



		boolean hasFuel = false;

		if (isBurning()) {

			hasFuel = true;

			--fuelBurnTimeLeft;

		}

		

		// Always burn fuel because we don't have a separate fuel slot

		if (!hasFuel)

			if (burnFuel())

				hasFuel = true;



		final ItemStack input = inventory.getStackInSlot(INPUT_SLOT);

		final ItemStack result = getResult(input).orElse(ItemStack.EMPTY);

		if (!result.isEmpty() && isInput(input) || FurnaceTileEntity.isFuel(input)) {

			final boolean canInsertResultIntoOutput = inventory.insertItem(OUTPUT_SLOT, result, true).isEmpty();

			if (canInsertResultIntoOutput) {

				if (hasFuel) {

					if (smeltTimeLeft == -1) { 

						smeltTimeLeft = maxSmeltTime = getSmeltTime(input);

					} else { 

						--smeltTimeLeft;

						if (smeltTimeLeft == 0) {

							inventory.insertItem(OUTPUT_SLOT, result, false);

							input.shrink(1);

							inventory.setStackInSlot(INPUT_SLOT, input);

							if (input.hasContainerItem()) {

								final ItemStack containerItem = input.getContainerItem();

								final boolean canInsertContainerItemIntoInput = inventory.insertItem(INPUT_SLOT, containerItem, true).isEmpty();

								if (canInsertContainerItemIntoInput)

									inventory.insertItem(INPUT_SLOT, containerItem, false);

								else

									InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), containerItem);

							}

						}

					}

				} else 

					if (smeltTimeLeft < maxSmeltTime)

						++smeltTimeLeft;

			}

		} else 

			smeltTimeLeft = maxSmeltTime = -1;



		if (lastBurning != this.isBurning()) {

			this.markDirty();

			final BlockState blockState = this.getBlockState();

			world.notifyBlockUpdate(pos, blockState, blockState, 2);

			lastBurning = this.isBurning();	

		}



	}





	private short getSmeltTime(final ItemStack input) {

		final Optional<PurgingRecipe> recipe = getRecipe(input);

		if (recipe.isPresent())

			return (short) recipe.get().getProcessTime();

		return 200;

	}



	public boolean burnFuel() {

		final ItemStack fuelStack = inventory.getStackInSlot(INPUT_SLOT);

		if (!fuelStack.isEmpty()) {

			final int burnTime = ForgeHooks.getBurnTime(fuelStack);

			if (burnTime > 0) {

				this.fuelBurnTimeLeft = this.maxFuelBurnTime = ((short) burnTime);

				fuelStack.shrink(1);

				return true;

			}

		}

		return false;

	}



	public boolean isBurning() {

		return this.fuelBurnTimeLeft > 1;

	}



	@Nonnull

	@Override

	public <T> LazyOptional<T> getCapability(@Nonnull final Capability<T> cap, @Nullable final Direction side) {

		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)

			return inventoryCapabilityExternal.cast();

		return super.getCapability(cap, side);

	}



	@Override

	public void onLoad() {

		super.onLoad();



		if (world != null && !world.isRemote)

			lastBurning = isBurning();

	}



	@Override

	public void read(final CompoundNBT compound) {

		super.read(compound);

		this.inventory.deserializeNBT(compound.getCompound(INVENTORY_TAG));

		this.smeltTimeLeft = compound.getShort(SMELT_TIME_LEFT_TAG);

		this.maxSmeltTime = compound.getShort(MAX_SMELT_TIME_TAG);

		this.fuelBurnTimeLeft = compound.getShort(FUEL_BURN_TIME_LEFT_TAG);

		this.maxFuelBurnTime = compound.getShort(MAX_FUEL_BURN_TIME_TAG);

	}



	@Nonnull

	@Override

	public CompoundNBT write(final CompoundNBT compound) {

		super.write(compound);

		compound.put(INVENTORY_TAG, this.inventory.serializeNBT());

		compound.putShort("smeltTimeLeft", this.smeltTimeLeft);

		compound.putShort("maxSmeltTime", this.maxSmeltTime);

		compound.putShort("fuelBurnTimeLeft", this.fuelBurnTimeLeft);

		compound.putShort("maxFuelBurnTime", this.maxFuelBurnTime);

		return compound;

	}



	@Nonnull

	public CompoundNBT getUpdateTag() {

		return this.write(new CompoundNBT());

	}



	@Override

	public void remove() {

		super.remove();

		inventoryCapabilityExternal.invalidate();

	}



	@Nonnull

	@Override

	public ITextComponent getDisplayName() {

		return new TranslationTextComponent(BlockList.vacuumoven.getTranslationKey());

	}



	@Nonnull

	@Override

	public Container createMenu(final int windowId, final PlayerInventory inventory, final PlayerEntity player) {

		return new VacuumOvenContainer(windowId, inventory, this);

	}

}