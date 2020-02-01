package drmdgg.marijuanacraft.client.renders;

import drmdgg.marijuanacraft.MarijuanaCraft;
import drmdgg.marijuanacraft.client.models.LunaModel;
import drmdgg.marijuanacraft.entities.LunaEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.WolfRenderer;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class LunaRender extends WolfRenderer
{

	public LunaRender(EntityRendererManager manager) {
		super(manager);
		
	}
	public ResourceLocation getEntityTexture(WolfEntity entity)
	{
		return MarijuanaCraft.location("textures/entity/luna.png");
	}
	
	
	
}

