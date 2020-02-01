package drmdgg.marijuanacraft.client.models;
//Made with Blockbench
//Paste this code into your mod.

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import drmdgg.marijuanacraft.entities.GhostEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class GhostModel extends EntityModel<GhostEntity> {
	private final ModelRenderer root;
	private final ModelRenderer leftarm;
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer rightarm;
	private final ModelRenderer hood;
	private final ModelRenderer hood2;

	public GhostModel() {
		textureWidth = 64;
		textureHeight = 64;

		this.root = new ModelRenderer(this);
		this.root.setRotationPoint(0.0F, 0.0F, 0.0F);

		this.leftarm = new ModelRenderer(this);
		this.leftarm.setRotationPoint(5.0F, 2.0F, 0.0F);
		this.setRotationAngle(leftarm, -1.2217F, 0.0F, -0.1F);
		this.root.addChild(leftarm);
		this.leftarm.addBox(8, 32, -1.0F, -2.0F, -1.0F, 2);

		this.head = new ModelRenderer(this);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.root.addChild(head);
		this.head.addBox(0, 0, -4.0F, -8.0F, -4.0F, 8);
		this.head.addBox(0, 0, -4.0F, -8.0F, -4.0F, 8);

		this.body = new ModelRenderer(this);
		this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.root.addChild(body);
		this.body.addBox(0, 16, -4.0F, 0.0F, -2.0F, 8);

		this.rightarm = new ModelRenderer(this);
		this.rightarm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		this.setRotationAngle(rightarm, -1.3963F, 0.0F, 0.1F);
		this.root.addChild(rightarm);
		this.rightarm.addBox(8, 32, -1.0F, -2.0F, -1.0F, 2);

		this.hood = new ModelRenderer(this);
		this.hood.setRotationPoint(0.0F, 24.0F, 0.0F);
		this.hood.addBox(4, 0, -1.0F, -33.0F, -6.0F, 1);
		this.hood.addBox(4, 0, 0.0F, -33.0F, -6.0F, 1);
		this.hood.addBox(4, 0, 1.0F, -32.0F, -6.0F, 1);
		this.hood.addBox(4, 0, 1.0F, -31.0F, -6.0F, 1);
		this.hood.addBox(4, 0, -3.0F, -31.0F, -5.0F, 1);
		this.hood.addBox(4, 0, -4.0F, -31.0F, -5.0F, 1);
		this.hood.addBox(4, 0, -5.0F, -31.0F, -5.0F, 1);
		this.hood.addBox(4, 0, -5.0F, -30.0F, -5.0F, 1);
		this.hood.addBox(4, 0, -6.0F, -30.0F, -5.0F, 1);
		this.hood.addBox(4, 0, -6.0F, -29.0F, -5.0F, 1);
		this.hood.addBox(4, 0, -5.0F, -28.0F, -4.0F, 1);
		this.hood.addBox(4, 0, -7.0F, -24.0F, -4.0F, 1);
		this.hood.addBox(4, 0, -4.0F, -25.0F, -5.0F, 1);
		this.hood.addBox(4, 0, -6.0F, -28.0F, -4.0F, 1);
		this.hood.addBox(4, 0, -2.0F, -31.0F, -6.0F, 1);
		this.hood.addBox(4, 0, -2.0F, -32.0F, -6.0F, 1);
		this.hood.addBox(4, 0, -2.0F, -33.0F, -5.0F, 1);
		this.hood.addBox(4, 0, -2.0F, -32.0F, -5.0F, 1);
		this.hood.addBox(4, 0, 1.0F, -33.0F, -5.0F, 1);
		this.hood.addBox(4, 0, 1.0F, -32.0F, -5.0F, 1);
		this.hood.addBox(4, 0, 1.0F, -34.0F, -4.0F, 1);
		this.hood.addBox(4, 0, 2.0F, -33.0F, -4.0F, 1);
		this.hood.addBox(4, 0, 3.0F, -33.0F, -4.0F, 1);
		this.hood.addBox(4, 0, 2.0F, -34.0F, -3.0F, 1);
		this.hood.addBox(4, 0, 3.0F, -34.0F, -2.0F, 1);
		this.hood.addBox(4, 0, 4.0F, -33.0F, -2.0F, 1);
		this.hood.addBox(4, 0, 3.0F, -33.0F, -3.0F, 1);
		this.hood.addBox(4, 0, 2.0F, -35.0F, -2.0F, 1);
		this.hood.addBox(4, 0, 2.0F, -35.0F, -1.0F, 1);
		this.hood.addBox(4, 0, 2.0F, -35.0F, 0.0F, 1);
		this.hood.addBox(4, 0, 1.0F, -35.0F, -3.0F, 1);
		this.hood.addBox(4, 0, 1.0F, -36.0F, -2.0F, 1);
		this.hood.addBox(4, 0, 1.0F, -36.0F, 0.0F, 1);
		this.hood.addBox(4, 0, 1.0F, -36.0F, -1.0F, 1);
		this.hood.addBox(4, 0, -3.0F, -33.0F, -4.0F, 1);
		this.hood.addBox(4, 0, -4.0F, -33.0F, -3.0F, 1);
		this.hood.addBox(4, 0, -5.0F, -33.0F, -2.0F, 1);
		this.hood.addBox(4, 0, -5.0F, -33.0F, -1.0F, 1);
		this.hood.addBox(4, 0, -5.0F, -33.0F, 0.0F, 1);
		this.hood.addBox(4, 0, -5.0F, -33.0F, 1.0F, 1);
		this.hood.addBox(4, 0, -4.0F, -34.0F, -2.0F, 1);
		this.hood.addBox(4, 0, -4.0F, -34.0F, -1.0F, 1);
		this.hood.addBox(4, 0, -4.0F, -34.0F, 0.0F, 1);
		this.hood.addBox(4, 0, -4.0F, -33.0F, -4.0F, 1);
		this.hood.addBox(4, 0, -3.0F, -34.0F, -3.0F, 1);
		this.hood.addBox(4, 0, -3.0F, -35.0F, -1.0F, 1);
		this.hood.addBox(4, 0, -3.0F, -35.0F, 0.0F, 1);
		this.hood.addBox(4, 0, -4.0F, -35.0F, 1.0F, 1);
		this.hood.addBox(4, 0, -5.0F, -34.0F, 1.0F, 1);
		this.hood.addBox(4, 0, -3.0F, -35.0F, 2.0F, 1);
		this.hood.addBox(4, 0, -3.0F, -34.0F, 3.0F, 1);
		this.hood.addBox(4, 0, -4.0F, -34.0F, 2.0F, 1);
		this.hood.addBox(4, 0, -5.0F, -33.0F, 2.0F, 1);
		this.hood.addBox(4, 0, -3.0F, -33.0F, 3.0F, 1);
		this.hood.addBox(4, 0, -4.0F, -33.0F, 3.0F, 1);
		this.hood.addBox(24, 8, -5.0F, -32.0F, -4.0F, 1);
		this.hood.addBox(24, 8, -6.0F, -31.0F, -4.0F, 1);
		this.hood.addBox(24, 8, -7.0F, -30.0F, -4.0F, 1);
		this.hood.addBox(24, 8, -7.0F, -29.0F, -4.0F, 1);
		this.hood.addBox(24, 8, -7.0F, -28.0F, -4.0F, 1);
		this.hood.addBox(24, 8, -7.0F, -27.0F, -4.0F, 1);
		this.hood.addBox(24, 8, 6.0F, -27.0F, -4.0F, 1);
		this.hood.addBox(24, 8, 6.0F, -28.0F, -4.0F, 1);
		this.hood.addBox(24, 8, 6.0F, -29.0F, -4.0F, 1);
		this.hood.addBox(24, 8, 6.0F, -30.0F, -4.0F, 1);
		this.hood.addBox(24, 8, 5.0F, -31.0F, -4.0F, 1);
		this.hood.addBox(24, 8, 4.0F, -32.0F, -4.0F, 1);
		this.hood.addBox(24, 8, -7.0F, -26.0F, -4.0F, 1);
		this.hood.addBox(24, 8, 6.0F, -26.0F, -4.0F, 1);
		this.hood.addBox(24, 8, -7.0F, -25.0F, -4.0F, 1);
		this.hood.addBox(24, 8, 6.0F, -25.0F, -4.0F, 1);
		this.hood.addBox(24, 8, -8.0F, -24.0F, -4.0F, 1);
		this.hood.addBox(24, 8, 7.0F, -24.0F, -4.0F, 1);
		this.hood.addBox(4, 0, -3.0F, -32.0F, 4.0F, 1);
		this.hood.addBox(4, 0, -4.0F, -32.0F, 4.0F, 1);
		this.hood.addBox(4, 0, -5.0F, -31.0F, 4.0F, 1);
		this.hood.addBox(4, 0, -6.0F, -30.0F, 4.0F, 1);
		this.hood.addBox(4, 0, -7.0F, -25.0F, 3.0F, 1);
		this.hood.addBox(4, 0, -3.0F, -33.0F, 3.0F, 1);
		this.hood.addBox(4, 0, -3.0F, -36.0F, 1.0F, 1);
		this.hood.addBox(4, 0, -3.0F, -35.0F, -2.0F, 1);
		this.hood.addBox(4, 0, -2.0F, -35.0F, -3.0F, 1);
		this.hood.addBox(4, 0, -2.0F, -36.0F, -2.0F, 1);
		this.hood.addBox(4, 0, -2.0F, -36.0F, -1.0F, 1);
		this.hood.addBox(4, 0, -2.0F, -36.0F, 1.0F, 1);
		this.hood.addBox(4, 0, -2.0F, -36.0F, 2.0F, 1);
		this.hood.addBox(4, 0, -2.0F, -34.0F, 4.0F, 1);
		hood.addBox(4, 0, -2.0F, -33.0F, 4.0F, 1);
		hood.addBox(4, 0, -2.0F, -35.0F, 3.0F, 1);
		hood.addBox(4, 0, -2.0F, -37.0F, 1.0F, 1);
		hood.addBox(4, 0, -2.0F, -36.0F, 0.0F, 1);
		hood.addBox(4, 0, -2.0F, -34.0F, -4.0F, 1);
		hood.addBox(4, 0, -3.0F, -31.0F, -6.0F, 1);
		hood.addBox(4, 0, 2.0F, -31.0F, -5.0F, 1);
		hood.addBox(4, 0, 2.0F, -31.0F, -6.0F, 1);
		hood.addBox(4, 0, 2.0F, -30.0F, -6.0F, 1);
		hood.addBox(4, 0, -3.0F, -30.0F, -6.0F, 1);
		hood.addBox(4, 0, -4.0F, -30.0F, -6.0F, 1);
		hood.addBox(4, 0, 3.0F, -29.0F, -6.0F, 1);
		hood.addBox(4, 0, 3.0F, -30.0F, -5.0F, 1);
		hood.addBox(4, 0, 4.0F, -29.0F, -5.0F, 1);
		hood.addBox(4, 0, 4.0F, -30.0F, -4.0F, 1);
		hood.addBox(4, 0, 4.0F, -31.0F, -4.0F, 1);
		hood.addBox(4, 0, -4.0F, -29.0F, -6.0F, 1);
		hood.addBox(4, 0, -5.0F, -29.0F, -6.0F, 1);
		hood.addBox(4, 0, 4.0F, -28.0F, -6.0F, 1);
		hood.addBox(4, 0, 5.0F, -28.0F, -5.0F, 1);
		hood.addBox(4, 0, 5.0F, -27.0F, -5.0F, 1);
		hood.addBox(4, 0, 5.0F, -30.0F, -4.0F, 1);
		hood.addBox(4, 0, 4.0F, -27.0F, -6.0F, 1);
		hood.addBox(4, 0, 4.0F, -25.0F, -5.0F, 1);
		hood.addBox(4, 0, 6.0F, -24.0F, -5.0F, 1);
		hood.addBox(4, 0, 4.0F, -22.0F, -6.0F, 1);
		hood.addBox(4, 0, -6.0F, -23.0F, -5.0F, 1);
		hood.addBox(4, 0, -7.0F, -23.0F, -5.0F, 1);
		hood.addBox(4, 0, -5.0F, -23.0F, -5.0F, 1);
		hood.addBox(4, 0, -4.0F, -23.0F, -6.0F, 1);
		hood.addBox(4, 0, 3.0F, -22.0F, -6.0F, 1);
		hood.addBox(4, 0, 5.0F, -22.0F, -6.0F, 1);
		hood.addBox(4, 0, 6.0F, -22.0F, -6.0F, 1);
		hood.addBox(0, 0, -5.0F, -28.0F, -6.0F, 1);
		hood.addBox(4, 0, 3.0F, -25.0F, -6.0F, 1);
		hood.addBox(4, 0, 3.0F, -24.0F, -5.0F, 1);
		hood.addBox(4, 0, 1.0F, -20.0F, -6.0F, 1);
		hood.addBox(4, 0, 0.0F, -15.0F, -6.0F, 1);
		hood.addBox(4, 0, -1.0F, -15.0F, -6.0F, 1);
		hood.addBox(4, 0, -2.0F, -17.0F, -6.0F, 1);
		hood.addBox(4, 0, 1.0F, -15.0F, -6.0F, 1);
		hood.addBox(4, 0, -2.0F, -20.0F, -6.0F, 1);
		hood.addBox(0, 4, -4.0F, -25.0F, -6.0F, 2);
		hood.addBox(4, 0, -1.0F, -34.0F, -5.0F, 1);
		hood.addBox(4, 0, 0.0F, -34.0F, -5.0F, 1);
		hood.addBox(4, 0, 0.0F, -35.0F, -4.0F, 1);
		hood.addBox(4, 0, -1.0F, -35.0F, -4.0F, 1);
		hood.addBox(4, 0, -1.0F, -36.0F, -3.0F, 1);
		hood.addBox(4, 0, 0.0F, -36.0F, -3.0F, 1);
		hood.addBox(4, 0, -1.0F, -37.0F, -2.0F, 1);
		hood.addBox(4, 0, -1.0F, -37.0F, -1.0F, 1);
		hood.addBox(4, 0, -1.0F, -37.0F, 0.0F, 1);
		hood.addBox(4, 0, 0.0F, -37.0F, -2.0F, 1);
		hood.addBox(4, 0, 0.0F, -37.0F, -1.0F, 1);
		hood.addBox(4, 0, 0.0F, -37.0F, 0.0F, 1);
		hood.addBox(4, 0, 1.0F, -37.0F, 1.0F, 1);
		hood.addBox(4, 0, 2.0F, -36.0F, 1.0F, 1);
		hood.addBox(4, 0, 3.0F, -35.0F, 1.0F, 1);
		hood.addBox(4, 0, 3.0F, -34.0F, 2.0F, 1);
		hood.addBox(4, 0, 3.0F, -33.0F, 2.0F, 1);
		hood.addBox(4, 0, 4.0F, -34.0F, 1.0F, 1);
		hood.addBox(4, 0, 4.0F, -33.0F, 1.0F, 1);
		hood.addBox(4, 0, 1.0F, -36.0F, 2.0F, 1);
		hood.addBox(4, 0, 2.0F, -34.0F, 3.0F, 1);
		hood.addBox(4, 0, 2.0F, -33.0F, 3.0F, 1);
		hood.addBox(4, 0, 3.0F, -33.0F, 3.0F, 1);
		hood.addBox(4, 0, 1.0F, -35.0F, 3.0F, 1);
		hood.addBox(4, 0, 2.0F, -35.0F, 2.0F, 1);
		hood.addBox(4, 0, 1.0F, -34.0F, 4.0F, 1);
		hood.addBox(4, 0, 1.0F, -33.0F, 4.0F, 1);
		hood.addBox(4, 0, 2.0F, -32.0F, 4.0F, 1);
		hood.addBox(4, 0, 3.0F, -32.0F, 4.0F, 1);
		hood.addBox(4, 0, 4.0F, -31.0F, 4.0F, 1);
		hood.addBox(4, 0, 3.0F, -16.0F, 4.0F, 1);
		hood.addBox(4, 0, 7.0F, -16.0F, 3.0F, 1);
		hood.addBox(4, 0, 7.0F, -13.0F, 2.0F, 1);
		hood.addBox(4, 0, 7.0F, -14.0F, 1.0F, 1);
		hood.addBox(4, 0, 7.0F, -14.0F, 0.0F, 1);
		hood.addBox(4, 0, 7.0F, -17.0F, -1.0F, 1);
		hood.addBox(4, 0, 7.0F, -16.0F, -2.0F, 1);
		hood.addBox(4, 0, 7.0F, -16.0F, -4.0F, 1);
		hood.addBox(4, 0, 2.0F, -16.0F, 4.0F, 1);
		hood.addBox(4, 0, 1.0F, -16.0F, 4.0F, 1);
		hood.addBox(4, 0, 0.0F, -16.0F, 4.0F, 1);
		hood.addBox(4, 0, -1.0F, -16.0F, 4.0F, 1);
		hood.addBox(4, 0, -2.0F, -16.0F, 4.0F, 1);
		hood.addBox(4, 0, -3.0F, -16.0F, 4.0F, 1);
		hood.addBox(4, 0, -4.0F, -16.0F, 4.0F, 1);
		hood.addBox(4, 0, 5.0F, -30.0F, 4.0F, 1);
		hood.addBox(4, 0, 6.0F, -24.0F, 4.0F, 1);
		hood.addBox(4, 0, -1.0F, -37.0F, 2.0F, 1);
		hood.addBox(4, 0, 0.0F, -36.0F, 3.0F, 1);
		hood.addBox(4, 0, -1.0F, -36.0F, 3.0F, 1);
		hood.addBox(4, 0, 0.0F, -35.0F, 4.0F, 1);
		hood.addBox(4, 0, -1.0F, -35.0F, 4.0F, 1);
		hood.addBox(4, 0, 0.0F, -34.0F, 5.0F, 1);
		hood.addBox(4, 0, -1.0F, -34.0F, 5.0F, 1);
		hood.addBox(4, 0, 0.0F, -33.0F, 5.0F, 1);
		hood.addBox(4, 0, -1.0F, -33.0F, 5.0F, 1);
		hood.addBox(24, 24, -4.0F, -32.0F, 5.0F, 8);
		hood.addBox(4, 0, 0.0F, -38.0F, 1.0F, 1);
		hood.addBox(4, 0, -1.0F, -38.0F, 1.0F, 1);

		hood2 = new ModelRenderer(this);
		hood2.setRotationPoint(0.0F, 24.0F, 0.0F);
		hood2.addBox(4, 0, -1.0F, -33.0F, -6.0F, 1);
		hood2.addBox(4, 0, 0.0F, -33.0F, -6.0F, 1);
		hood2.addBox(4, 0, 1.0F, -32.0F, -6.0F, 1);
		hood2.addBox(4, 0, 1.0F, -31.0F, -6.0F, 1);
		hood2.addBox(4, 0, -3.0F, -31.0F, -5.0F, 1);
		hood2.addBox(4, 0, -4.0F, -31.0F, -5.0F, 1);
		hood2.addBox(4, 0, -5.0F, -31.0F, -5.0F, 1);
		hood2.addBox(4, 0, -5.0F, -30.0F, -5.0F, 1);
		hood2.addBox(4, 0, -6.0F, -30.0F, -5.0F, 1);
		hood2.addBox(4, 0, -6.0F, -29.0F, -5.0F, 1);
		hood2.addBox(4, 0, -2.0F, -31.0F, -6.0F, 1);
		hood2.addBox(4, 0, -2.0F, -32.0F, -6.0F, 1);
		hood2.addBox(4, 0, -2.0F, -33.0F, -5.0F, 1);
		hood2.addBox(4, 0, -3.0F, -33.0F, -4.0F, 1);
		hood2.addBox(4, 0, -4.0F, -33.0F, -3.0F, 1);
		hood2.addBox(4, 0, -5.0F, -33.0F, -2.0F, 1);
		hood2.addBox(4, 0, -5.0F, -33.0F, -1.0F, 1);
		hood2.addBox(4, 0, -5.0F, -33.0F, 0.0F, 1);
		hood2.addBox(4, 0, -5.0F, -33.0F, 1.0F, 1);
		hood2.addBox(4, 0, -4.0F, -34.0F, -2.0F, 1);
		hood2.addBox(4, 0, -4.0F, -34.0F, -1.0F, 1);
		hood2.addBox(4, 0, -4.0F, -34.0F, 0.0F, 1);
		hood2.addBox(4, 0, -4.0F, -33.0F, -4.0F, 1);
		hood2.addBox(4, 0, -3.0F, -34.0F, -3.0F, 1);
		hood2.addBox(4, 0, -3.0F, -35.0F, -1.0F, 1);
		hood2.addBox(4, 0, -3.0F, -35.0F, 0.0F, 1);
		hood2.addBox(4, 0, -4.0F, -35.0F, 1.0F, 1);
		hood2.addBox(4, 0, -5.0F, -34.0F, 1.0F, 1);
		hood2.addBox(4, 0, -3.0F, -35.0F, 2.0F, 1);
		hood2.addBox(4, 0, -3.0F, -34.0F, 3.0F, 1);
		hood2.addBox(4, 0, -4.0F, -34.0F, 2.0F, 1);
		hood2.addBox(4, 0, -5.0F, -33.0F, 2.0F, 1);
		hood2.addBox(4, 0, -3.0F, -33.0F, 3.0F, 1);
		hood2.addBox(4, 0, -4.0F, -33.0F, 3.0F, 1);
		hood2.addBox(24, 8, -5.0F, -32.0F, -4.0F, 1);
		hood2.addBox(24, 8, -6.0F, -31.0F, -4.0F, 1);
		hood2.addBox(24, 8, -7.0F, -30.0F, -4.0F, 1);
		hood2.addBox(24, 8, -7.0F, -29.0F, -4.0F, 1);
		hood2.addBox(24, 8, -7.0F, -28.0F, -4.0F, 1);
		hood2.addBox(24, 8, -7.0F, -27.0F, -4.0F, 1);
		hood2.addBox(4, 0, -3.0F, -32.0F, 4.0F, 1);
		hood2.addBox(4, 0, -4.0F, -32.0F, 4.0F, 1);
		hood2.addBox(4, 0, -3.0F, -33.0F, 3.0F, 1);
		hood2.addBox(4, 0, -3.0F, -36.0F, 1.0F, 1);
		hood2.addBox(4, 0, -3.0F, -35.0F, -2.0F, 1);
		hood2.addBox(4, 0, -2.0F, -35.0F, -3.0F, 1);
		hood2.addBox(4, 0, -2.0F, -36.0F, -2.0F, 1);
		hood2.addBox(4, 0, -2.0F, -36.0F, -1.0F, 1);
		hood2.addBox(4, 0, -2.0F, -36.0F, 1.0F, 1);
		hood2.addBox(4, 0, -2.0F, -36.0F, 2.0F, 1);
		hood2.addBox(4, 0, -2.0F, -34.0F, 4.0F, 1);
		hood2.addBox(4, 0, -2.0F, -33.0F, 4.0F, 1);
		hood2.addBox(4, 0, -2.0F, -35.0F, 3.0F, 1);
		hood2.addBox(4, 0, -2.0F, -37.0F, 1.0F, 1);
		hood2.addBox(4, 0, -2.0F, -36.0F, 0.0F, 1);
		hood2.addBox(4, 0, -2.0F, -34.0F, -4.0F, 1);
		hood2.addBox(4, 0, -3.0F, -31.0F, -6.0F, 1);
		hood2.addBox(4, 0, 2.0F, -31.0F, -6.0F, 1);
		hood2.addBox(4, 0, 2.0F, -30.0F, -6.0F, 1);
		hood2.addBox(4, 0, -3.0F, -30.0F, -6.0F, 1);
		hood2.addBox(4, 0, -4.0F, -30.0F, -6.0F, 1);
		hood2.addBox(4, 0, 3.0F, -29.0F, -6.0F, 1);
		hood2.addBox(4, 0, -4.0F, -29.0F, -6.0F, 1);
		hood2.addBox(4, 0, -5.0F, -29.0F, -6.0F, 1);
		hood2.addBox(4, 0, 4.0F, -28.0F, -6.0F, 1);
		hood2.addBox(4, 0, 4.0F, -27.0F, -6.0F, 1);
		hood2.addBox(4, 0, 4.0F, -26.0F, -6.0F, 1);
		hood2.addBox(0, 0, -5.0F, -28.0F, -6.0F, 1);
		hood2.addBox(4, 0, 3.0F, -25.0F, -6.0F, 1);
		hood2.addBox(4, 0, 2.0F, -25.0F, -6.0F, 1);
		hood2.addBox(4, 0, 2.0F, -24.0F, -6.0F, 1);
		hood2.addBox(4, 0, -3.0F, -24.0F, -6.0F, 1);
		hood2.addBox(0, 4, -4.0F, -25.0F, -6.0F, 2);
		hood2.addBox(20, 17, -2.0F, -16.0F, -6.0F, 4);
		hood2.addBox(4, 0, -1.0F, -34.0F, -5.0F, 1);
		hood2.addBox(4, 0, 0.0F, -34.0F, -5.0F, 1);
		hood2.addBox(4, 0, 0.0F, -35.0F, -4.0F, 1);
		hood2.addBox(4, 0, -1.0F, -35.0F, -4.0F, 1);
		hood2.addBox(4, 0, -1.0F, -36.0F, -3.0F, 1);
		hood2.addBox(4, 0, 0.0F, -36.0F, -3.0F, 1);
		hood2.addBox(4, 0, -1.0F, -37.0F, -2.0F, 1);
		hood2.addBox(4, 0, -1.0F, -37.0F, -1.0F, 1);
		hood2.addBox(4, 0, -1.0F, -37.0F, 0.0F, 1);
		hood2.addBox(4, 0, 0.0F, -37.0F, -2.0F, 1);
		hood2.addBox(4, 0, 0.0F, -37.0F, -1.0F, 1);
		hood2.addBox(4, 0, 0.0F, -37.0F, 0.0F, 1);
		hood2.addBox(4, 0, 0.0F, -37.0F, 2.0F, 1);
		hood2.addBox(4, 0, -1.0F, -37.0F, 2.0F, 1);
		hood2.addBox(4, 0, 0.0F, -36.0F, 3.0F, 1);
		hood2.addBox(4, 0, -1.0F, -36.0F, 3.0F, 1);
		hood2.addBox(4, 0, 0.0F, -35.0F, 4.0F, 1);
		hood2.addBox(4, 0, -1.0F, -35.0F, 4.0F, 1);
		hood2.addBox(4, 0, 0.0F, -34.0F, 5.0F, 1);
		hood2.addBox(4, 0, -1.0F, -34.0F, 5.0F, 1);
		hood2.addBox(4, 0, 0.0F, -33.0F, 5.0F, 1);
		hood2.addBox(4, 0, -1.0F, -33.0F, 5.0F, 1);
		hood2.addBox(24, 24, -4.0F, -32.0F, 5.0F, 8);
		hood2.addBox(4, 0, 0.0F, -38.0F, 1.0F, 1);
		hood2.addBox(4, 0, -1.0F, -38.0F, 1.0F, 1);
	}

//@Override
//	public void render(Ghost entity, float f, float f1, float f2, float f3, float f4, float f5) {
//		root.render(f5);
//		hood.render(f5);
//		hood2.render(f5);
//	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	   
	   public void setRotationAngles(GhostEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor)

	   {

	       this.head.rotateAngleY = netHeadYaw * 0.017453292F;

	       this.head.rotateAngleX = headPitch * 0.017453292F;

	       this.rightarm.rotateAngleY = 0.0F;

	       this.leftarm.rotateAngleY = 0.0F;

	   }


	@Override
	public void render(GhostEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.rotateAngleY = netHeadYaw * 0.017453292F;

	       this.head.rotateAngleX = headPitch * 0.017453292F;

	       this.rightarm.rotateAngleY = 0.0F;

	       this.leftarm.rotateAngleY = 0.0F;
	}

	@Override
	public void render(MatrixStack arg0, IVertexBuilder arg1, int arg2, int arg3, float arg4, float arg5, float arg6,
			float arg7) {
		
		
		body.render(arg0, arg1, arg3, arg3, arg4, arg5, arg6, arg7);
		leftarm.render(arg0, arg1, arg2, arg3);
		head.render(arg0, arg1, arg2, arg3);
		rightarm.render(arg0, arg1, arg2, arg3);
		hood.render(arg0, arg1, arg2, arg3);
		hood2.render(arg0, arg1, arg2, arg3);
		root.render(arg0, arg1, arg2, arg3);
		
	}

}