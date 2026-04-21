package net.dragoteen.ywformc.entity.client;// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class JibanyanModel<T extends Entity> extends EntityModel<T> {
	private final ModelPart tail_l;
	private final ModelPart tail_r;
	private final ModelPart bb_main;

	public JibanyanModel(ModelPart root) {
		this.tail_l = root.getChild("tail_l");
		this.tail_r = root.getChild("tail_r");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition tail_l = partdefinition.addOrReplaceChild("tail_l", CubeListBuilder.create().texOffs(16, 30).addBox(0.0F, -2.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(28, 30).addBox(0.0F, -3.0F, 0.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 0).addBox(1.0F, -6.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 10).addBox(2.0F, -5.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 21.0F, 3.0F));

		PartDefinition tail_r = partdefinition.addOrReplaceChild("tail_r", CubeListBuilder.create().texOffs(22, 30).addBox(0.0F, -2.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(32, 4).addBox(-2.0F, -3.0F, 0.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 6).addBox(-1.0F, -6.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 13).addBox(-2.0F, -5.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 21.0F, 3.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 30).addBox(-4.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(8, 30).addBox(2.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 16).addBox(-5.0F, -13.0F, -2.0F, 10.0F, 10.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.0F, -21.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(28, 16).addBox(5.0F, -12.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(28, 23).addBox(-7.0F, -12.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(28, 32).addBox(2.0F, -23.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(32, 32).addBox(-4.0F, -23.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		tail_l.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail_r.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}