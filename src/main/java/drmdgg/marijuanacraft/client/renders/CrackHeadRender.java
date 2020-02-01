package drmdgg.marijuanacraft.client.renders;

import javax.annotation.Nullable;

import drmdgg.marijuanacraft.MarijuanaCraft;
import drmdgg.marijuanacraft.client.models.CrackHeadModel;
import drmdgg.marijuanacraft.entities.CrackHeadEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)

public class CrackHeadRender extends MobRenderer<CrackHeadEntity, CrackHeadModel> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(MarijuanaCraft.modid, "textures/entity/crack_head.png");

    public CrackHeadRender(EntityRendererManager manager) {
        super(manager, new CrackHeadModel(), 0.5f);
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(CrackHeadEntity entity) {
        return TEXTURE;
    }
}
