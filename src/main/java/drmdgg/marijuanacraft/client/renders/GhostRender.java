package drmdgg.marijuanacraft.client.renders;

import javax.annotation.Nullable;

import drmdgg.marijuanacraft.MarijuanaCraft;
import drmdgg.marijuanacraft.client.models.GhostModel;
import drmdgg.marijuanacraft.entities.GhostEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)

public class GhostRender extends MobRenderer<GhostEntity, GhostModel> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(MarijuanaCraft.modid, "textures/entity/ghost.png");

    public GhostRender(EntityRendererManager manager) {
        super(manager, new GhostModel(), 0.5f);
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(GhostEntity entity) {
        return TEXTURE;
    }
}
