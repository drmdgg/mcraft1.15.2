package drmdgg.marijuanacraft.potion;

import drmdgg.marijuanacraft.MarijuanaCraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class StatusEffect extends Effect{

	public StatusEffect(String name, EffectType type, int liquidColorIn) {

        super(type, liquidColorIn);

        setRegistryName(MarijuanaCraft.modid, name);

    }



    public boolean hasEffect(LivingEntity entity) {

        return hasEffect(entity, this);

    }



    public boolean hasEffect(LivingEntity entity, Effect effect) {

        return entity.getActivePotionEffect(effect) != null;

    }



}

