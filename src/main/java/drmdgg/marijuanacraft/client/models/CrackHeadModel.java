package drmdgg.marijuanacraft.client.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import drmdgg.marijuanacraft.entities.CrackHeadEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CrackHeadModel extends EntityModel<CrackHeadEntity> {
    public ModelRenderer head;
    public ModelRenderer rightarm;
    public ModelRenderer leftarm;
    public ModelRenderer forearms;
    public ModelRenderer leftleg;
    public ModelRenderer body;
    public ModelRenderer coat;
    public ModelRenderer rightleg;
    public ModelRenderer nose;

    public CrackHeadModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.nose = new ModelRenderer(this, 24, 0);
        this.nose.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.nose.addBox(-1.0F, -1.0F, -6.0F, 2, 4, 2);
        this.body = new ModelRenderer(this, 16, 20);
        this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.body.addBox(-4.0F, 0.0F, -3.0F, 8, 12, 6);
        this.rightarm = new ModelRenderer(this, 44, 22);
        this.rightarm.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.rightarm.addBox(-8.0F, -2.0F, -2.0F, 4, 8, 4);
        this.setRotateAngle(rightarm, -0.7499679795819634F, 0.0F, 0.0F);
        this.rightleg = new ModelRenderer(this, 0, 22);
        this.rightleg.setRotationPoint(-2.0F, 12.0F, 0.0F);
        this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head.addBox(-4.0F, -10.0F, -4.0F, 8, 10, 8);
        this.leftarm = new ModelRenderer(this, 44, 22);
        this.leftarm.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.leftarm.addBox(4.0F, -2.0F, -2.0F, 4, 8, 4);
        this.setRotateAngle(leftarm, -0.7499679795819634F, 0.0F, 0.0F);
        this.coat = new ModelRenderer(this, 0, 38);
        this.coat.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.coat.addBox(-4.0F, 0.0F, -3.0F, 8, 18, 6);
        this.forearms = new ModelRenderer(this, 40, 38);
        this.forearms.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.forearms.addBox(-4.0F, 2.0F, -2.0F, 8, 4, 4);
        this.setRotateAngle(forearms, -0.7499679795819634F, 0.0F, 0.0F);
        this.leftleg = new ModelRenderer(this, 0, 22);
        this.leftleg.mirror = true;
        this.leftleg.setRotationPoint(2.0F, 12.0F, 0.0F);
        this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
        this.head.addChild(this.nose);
    }
 //  public void render(CrackHead entity, float f, float f1, float f2, float f3, float f4, float f5) { 
 //       this.body.(f5);
//        this.rightarm.render(f5);
 //       this.rightleg.render(f5);
 //this.head.render(f5);
 //       this.leftarm.render(f5);
  //      this.coat.render(f5);
  //      this.forearms.render(f5);
   //     this.leftleg.render(f5);
   // }
   
  // public void setRotationAngles(CrackHeadEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor)

   //{

    // this.head.rotateAngleY = netHeadYaw * 0.017453292F;
// this.head.rotateAngleX = headPitch * 0.017453292F;
       
    //   this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;

      // this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount * 0.5F;

    //   this.rightleg.rotateAngleY = 0.0F;

    //   this.rightleg.rotateAngleY = 0.0F;

  // }


    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

	@Override
	public void render (CrackHeadEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	       this.head.rotateAngleY = netHeadYaw * 0.017453292F;

	       this.head.rotateAngleX = headPitch * 0.017453292F;
	       
	       this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;

	       this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount * 0.5F;

	       this.rightleg.rotateAngleY = 0.0F;

	       this.rightleg.rotateAngleY = 0.0F;
		
	}
	@Override
	public void render(MatrixStack arg0, IVertexBuilder arg1, int arg2, int arg3, float arg4, float arg5, float arg6,
			float arg7) {
		body.render(arg0, arg1, arg3, arg3, arg4, arg5, arg6, arg7);
		head.render(arg0, arg1, arg2, arg3);
		rightarm.render(arg0, arg1, arg2, arg3);
		leftarm.render(arg0, arg1, arg2, arg3);
		forearms.render(arg0, arg1, arg2, arg3);
		leftleg.render(arg0, arg1, arg2, arg3);
		coat.render(arg0, arg1, arg2, arg3);
		rightleg.render(arg0, arg1, arg2, arg3);
		nose.render(arg0, arg1, arg2, arg3);
	}
}
