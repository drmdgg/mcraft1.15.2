package drmdgg.marijuanacraft;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ModItemGroup extends ItemGroup
{

	private IItemProvider icon;
		public ModItemGroup(String label, IItemProvider icon) 
		{
			super(label);
			this.icon = icon;
		}
		
		@OnlyIn(Dist.CLIENT)
		@Override
		public ItemStack createIcon()
		{
			return new ItemStack(icon);
		}

}
