package drmdgg.marijuanacraft.recipes;

import drmdgg.marijuanacraft.lists.BlockList;
import drmdgg.marijuanacraft.lists.VORecipeList;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

public class PurgingRecipe extends AbstractVORecipe{

	public PurgingRecipe(ResourceLocation idIn, String groupIn, Ingredient ingredientIn,
			ItemStack resultIn, float experienceIn, int processTimeIn) {
		
		super(purging, idIn, groupIn, ingredientIn, resultIn, experienceIn, processTimeIn);
	}
	
	public static final IRecipeType<PurgingRecipe> purging = IRecipeType.register("purging");
	
	public ItemStack getIcon() {
		
		return new ItemStack(BlockList.vacuumoven);
	}
	

	@Override
	public IRecipeSerializer<?> getSerializer() {
		
		return IRecipeSerializer.register("purging", VORecipeList.PURGING);
	}

}
