package drmdgg.marijuanacraft.client.models;
//Made with Blockbench


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import drmdgg.marijuanacraft.entities.CentaurEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.model.ModelRenderer;

@OnlyIn(Dist.CLIENT)
public class CentaurModel extends EntityModel<CentaurEntity> {
	private final ModelRenderer root;
	private final ModelRenderer leftlegtop;
	private final ModelRenderer leftlegbottom;
	private final ModelRenderer leftlegbackbottom;
	private final ModelRenderer rightlegbackbottom2;
	private final ModelRenderer rightlegtop;
	private final ModelRenderer rightlegbottom;
	private final ModelRenderer body;
	private final ModelRenderer tailmiddle;
	private final ModelRenderer leftlegbacktop;
	private final ModelRenderer tailtop;
	private final ModelRenderer tailbottom;
	private final ModelRenderer rightlegbacktop;
	private final ModelRenderer rightlegbackbottom;
	private final ModelRenderer rightbackhoof;
	private final ModelRenderer righthoof;
	private final ModelRenderer chest;
	private final ModelRenderer head;
	private final ModelRenderer nose;
	private final ModelRenderer leftarm;
	private final ModelRenderer armconnected;
	private final ModelRenderer rightarm;

	public CentaurModel() {
		this.textureWidth = 128;
		this.textureHeight = 128;

		this.root = new ModelRenderer(this);
		this.root.setRotationPoint(0.0F, 0.0F, 0.0F);

		this.leftlegtop = new ModelRenderer(this);
		this.leftlegtop.setRotationPoint(-4.0F, 9.0F, -8.0F);
		this.root.addChild(leftlegtop);
		this.leftlegtop.addBox(44, 0, -1.1F, -1.0F, -2.1F, 3);

		this.leftlegbottom = new ModelRenderer(this);
		this.leftlegbottom.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.leftlegtop.addChild(leftlegbottom);
		this.leftlegbottom.addBox(84, 0, 6.1F, 4.0F, -1.6F, 3);

		this.leftlegbackbottom = new ModelRenderer(this);
		this.leftlegbackbottom.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.leftlegbottom.addChild(leftlegbackbottom);
		this.leftlegbackbottom.addBox(84, 0, 6.1F, 4.0F, 17.4F, 3);

		this.rightlegbackbottom2 = new ModelRenderer(this);
		this.rightlegbackbottom2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.leftlegbackbottom.addChild(rightlegbackbottom2);
		this.rightlegbackbottom2.addBox(84, 0, -1.1F, 4.0F, 17.4F, 3);

		this.rightlegtop = new ModelRenderer(this);
		this.rightlegtop.setRotationPoint(4.0F, 9.0F, -8.0F);
		this.root.addChild(rightlegtop);
		this.rightlegtop.addBox(58, 0, -1.9F, -1.0F, -2.1F, 3);

		this.rightlegbottom = new ModelRenderer(this);
		this.rightlegbottom.setRotationPoint(4.0F, 16.0F, -8.0F);
		this.root.addChild(rightlegbottom);
		this.rightlegbottom.addBox(84, 0, -9.1F, -3.0F, -1.6F, 3);

		this.body = new ModelRenderer(this);
		this.body.setRotationPoint(0.0F, 11.0F, 9.0F);
		this.root.addChild(body);
		this.body.addBox(0, 8, -5.0F, -8.0F, -19.0F, 10);

		this.tailmiddle = new ModelRenderer(this);
		this.tailmiddle.setRotationPoint(0.0F, 3.0F, 14.0F);
		this.setRotationAngle(tailmiddle, -1.309F, 0.0F, 0.0F);
		this.root.addChild(tailmiddle);
		this.tailmiddle.addBox(96, 0, -1.5F, -2.0F, 3.0F, 3);

		this.leftlegbacktop = new ModelRenderer(this);
		this.leftlegbacktop.setRotationPoint(-4.0F, 9.0F, 11.0F);
		this.root.addChild(leftlegbacktop);
		this.leftlegbacktop.addBox(0, 7, -1.5F, -2.0F, -2.5F, 4);

		this.tailtop = new ModelRenderer(this);
		this.tailtop.setRotationPoint(0.0F, 3.0F, 14.0F);
		this.setRotationAngle(tailtop, -1.309F, 0.0F, 0.0F);
		this.root.addChild(tailtop);
		this.tailtop.addBox(109, 0, -1.0F, -1.0F, 0.0F, 2);

		this.tailbottom = new ModelRenderer(this);
		this.tailbottom.setRotationPoint(0.0F, 3.0F, 14.0F);
		this.setRotationAngle(tailbottom, -1.5708F, 0.0F, 0.0F);
		this.root.addChild(tailbottom);
		this.tailbottom.addBox(65, 8, -1.5F, -4.5F, 9.0F, 3);

		this.rightlegbacktop = new ModelRenderer(this);
		this.rightlegbacktop.setRotationPoint(4.0F, 9.0F, 11.0F);
		this.root.addChild(rightlegbacktop);
		this.rightlegbacktop.addBox(85, 11, -2.5F, -2.0F, -2.5F, 4);

		this.rightlegbackbottom = new ModelRenderer(this);
		this.rightlegbackbottom.setRotationPoint(4.0F, 16.0F, 11.0F);
		this.root.addChild(rightlegbackbottom);

		this.rightbackhoof = new ModelRenderer(this);
		this.rightbackhoof.setRotationPoint(4.0F, 16.0F, 11.0F);
		this.root.addChild(rightbackhoof);

		this.righthoof = new ModelRenderer(this);
		this.righthoof.setRotationPoint(4.0F, 16.0F, -8.0F);
		this.root.addChild(righthoof);

		this.chest = new ModelRenderer(this);
		this.chest.setRotationPoint(4.0F, -14.0F, -9.0F);
		this.root.addChild(chest);
		this.chest.addBox(97, 23, -8.0F, 1.0F, 0.0F, 8);

		this.head = new ModelRenderer(this);
		this.head.setRotationPoint(4.0F, -23.5F, -10.1F);
		this.setRotationAngle(head, 0.0F, -0.0175F, 0.0F);
		this.root.addChild(head);
		this.head.addBox(60, 34, -8.0F, 1.0F, 0.0F, 8);

		this.nose = new ModelRenderer(this);
		this.nose.setRotationPoint(-4.4F, 6.9F, 4.0F);
		this.setRotationAngle(nose, 0.0F, -0.0698F, 0.0F);
		this.head.addChild(nose);
		this.nose.addBox(119, 0, -1.0F, -1.0F, -6.0F, 2);

		this.leftarm = new ModelRenderer(this);
		this.leftarm.setRotationPoint(-4.4F, -11.1F, -8.5F);
		this.setRotationAngle(leftarm, -0.9076F, 0.0F, 0.0F);
		this.root.addChild(leftarm);
		this.leftarm.addBox(44, 19, -4.0F, 0.0F, 0.0F, 4);

		this.armconnected = new ModelRenderer(this);
		this.armconnected.setRotationPoint(3.8F, -8.7F, -11.5F);
		this.setRotationAngle(armconnected, -0.8727F, 0.0F, 0.0F);
		this.root.addChild(armconnected);
		this.armconnected.addBox(60, 21, -9.0F, 0.0F, 0.0F, 10);

		this.rightarm = new ModelRenderer(this);
		this.rightarm.setRotationPoint(8.6F, -11.1F, -8.6F);
		this.setRotationAngle(rightarm, -0.8901F, 0.0F, 0.0F);
		this.root.addChild(rightarm);
		this.rightarm.addBox(0, 42, -4.0F, 0.0F, 0.0F, 4);
	}
	private int state = 1;


public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}


	@Override
	public void render(MatrixStack arg0, IVertexBuilder arg1, int arg2, int arg3, float arg4, float arg5, float arg6,
			float arg7) {
		this.root.render(arg0, arg1, arg3, arg3, arg4, arg5, arg6, arg7);
		this.rightarm.render(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
		this.leftarm.render(arg0, arg1, arg3, arg2, arg4, arg5, arg6, arg7);
		this.nose.render(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
		this.head.render(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
		this.leftlegtop.render(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
		this.leftlegbottom.render(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
		this.leftlegbackbottom.render(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
		this.rightlegbackbottom2.render(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
		this.rightlegtop.render(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
		this.rightlegbottom.render(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
		this.body.render(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
		this.tailmiddle.render(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
		this.leftlegbacktop.render(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
		this.tailtop.render(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
		this.tailbottom.render(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
		this.rightlegbackbottom.render(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
		this.rightbackhoof.render(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
		this.righthoof.render(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
		this.chest.render(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
		this.armconnected.render(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
	}

	@Override
	public void render(CentaurEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		  this.head.rotateAngleY = netHeadYaw * 0.00F;

	        this.head.rotateAngleX = headPitch * 0.00F;
	        
	        this.leftlegbackbottom.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * limbSwingAmount;

	        this.rightlegbackbottom.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 0.3F) * limbSwingAmount;

	        this.leftlegbottom.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI + 0.3F) * limbSwingAmount;

	        this.rightlegbottom.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		
	}
}