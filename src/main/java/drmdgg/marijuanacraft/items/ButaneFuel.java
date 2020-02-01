package drmdgg.marijuanacraft.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.extensions.IForgeItem;

public class ButaneFuel extends Item implements IForgeItem { 
	
	 public ButaneFuel(Properties group) {
		super(group);
	}
	 
	 @Override
	public int getBurnTime(ItemStack stack) {
		
		return stack.isEmpty() ? super.getBurnTime(stack) : 200;
	}
	
	
}
