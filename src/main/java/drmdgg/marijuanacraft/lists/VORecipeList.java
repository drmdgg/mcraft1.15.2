package drmdgg.marijuanacraft.lists;

import drmdgg.marijuanacraft.recipes.PurgingRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.registries.ObjectHolder;

public class VORecipeList {

	@ObjectHolder("marijuanacraft:purging")
	public static IRecipeSerializer<PurgingRecipe> PURGING;
	
	//public static final IRecipeSerializer<PurgingRecipe> PURGING = new VORecipeSerializer<>(PurgingRecipe::new, 200);
	
}