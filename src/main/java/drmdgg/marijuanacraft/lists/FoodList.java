package drmdgg.marijuanacraft.lists;

import drmdgg.marijuanacraft.potion.StonedEffect;
import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;



public class FoodList {

			public static final Food apple_bong; 
			public static final Food plastic_bong;
			public static final Food hashbrow;
			public static final Food pot_cookie;
			public static final Food baked_apple;


	static {
		apple_bong = (new Food.Builder().hunger(1).saturation(0.1F).effect(new EffectInstance(StonedEffect.STONED, 200, 2), 1.0f).setAlwaysEdible().build());
		plastic_bong = (new Food.Builder().hunger(1).saturation(0.1F).effect(new EffectInstance(StonedEffect.STONED, 200, 2), 1.0f).setAlwaysEdible().build());
		hashbrow = (new Food.Builder().hunger(1).saturation(0.1F).effect(new EffectInstance(StonedEffect.STONED, 200, 2), 1.0f).setAlwaysEdible().effect(new EffectInstance(Effects.HUNGER, 100, 2), 1.0F).effect(new EffectInstance(Effects.INSTANT_HEALTH, 100, 2), 1.0f)).build();
		pot_cookie = (new Food.Builder().hunger(1).saturation(0.1F).effect(new EffectInstance(StonedEffect.STONED, 200, 2), 1.0f).setAlwaysEdible().effect(new EffectInstance(Effects.HUNGER, 100, 2), 1.0F).effect(new EffectInstance(Effects.INSTANT_HEALTH, 75, 2), 1.0f)).build();
		baked_apple = (new Food.Builder().hunger(1).saturation(0.1F).effect(new EffectInstance(Effects.INSTANT_HEALTH, 100, 2), 1.0f).setAlwaysEdible().build());
	}
	
}