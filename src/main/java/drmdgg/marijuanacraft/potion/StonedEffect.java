package drmdgg.marijuanacraft.potion;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;

public class StonedEffect extends StatusEffect {
	
	public static final Effect STONED = new StonedEffect();
	public StonedEffect()
	{
		super("stoned", EffectType.BENEFICIAL, 12858015);
	}
	
	   @Override
	    public boolean isReady(int duration, int amplifier) {
	        return true;
	    }
	
	public static void RegisterEffects(final RegistryEvent.Register<Effect> event) 
	{
		event.getRegistry().registerAll(STONED);			
	}
		
	public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
		 entityLivingBaseIn.addPotionEffect(new EffectInstance(Effects.NAUSEA, 100, 0, false, false, false));

	       if (entityLivingBaseIn instanceof MobEntity && entityLivingBaseIn.getRNG().nextInt(100) <= amplifier) {

	            ((MobEntity) entityLivingBaseIn).setAttackTarget(null);

	            ((MobEntity) entityLivingBaseIn).setAggroed(false);

	        }

	        if (entityLivingBaseIn.world.isRemote);

	        



	    }



	    @OnlyIn(Dist.CLIENT)

	    private void handleDistortion() {

	        //have fancy stuff I guess?

	    }
}