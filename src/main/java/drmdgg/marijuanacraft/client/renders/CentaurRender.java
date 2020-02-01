package drmdgg.marijuanacraft.client.renders;

import javax.annotation.Nullable;

import drmdgg.marijuanacraft.MarijuanaCraft;
import drmdgg.marijuanacraft.client.models.CentaurModel;
import drmdgg.marijuanacraft.entities.CentaurEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


@OnlyIn(Dist.CLIENT)
public class CentaurRender extends MobRenderer<CentaurEntity, CentaurModel> {



    private static final ResourceLocation TEXTURE = new ResourceLocation(MarijuanaCraft.modid, "textures/entity/centaur.png");



    public CentaurRender(EntityRendererManager manager) {

        super(manager, new CentaurModel(), 0.5f);

    }



    @Nullable

    @Override

    public ResourceLocation getEntityTexture(CentaurEntity entity) {

        return TEXTURE;

    }

}


