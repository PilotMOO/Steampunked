package net.pilot.steampunked.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;
import net.pilot.steampunked.entity.BeeEntity;
import net.pilot.steampunked.entity.animations.ModAnimationDefinitions;

public class bee<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart bee;
	private final ModelPart wingleft;
	private final ModelPart wingrgiuht;

	public bee(ModelPart root) {
		this.bee = root.getChild("bee");
		this.wingleft = bee.getChild("wingleft");
		this.wingrgiuht = bee.getChild("wingrgiuht");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bee = partdefinition.addOrReplaceChild("bee", CubeListBuilder.create().texOffs(1, 1).addBox(0.0F, -1.75F, -3.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F))
		.texOffs(1, 1).addBox(-1.0F, -1.75F, -3.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F))
		.texOffs(2, 2).addBox(-1.0F, -2.0F, -3.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 9).addBox(-0.5F, -1.5F, 1.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition annetnia_r1 = bee.addOrReplaceChild("annetnia_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-0.45F, -0.5F, -1.75F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.75F, -1.75F, -3.4F, -0.5672F, -0.3927F, 0.0F));

		PartDefinition annetnia_r2 = bee.addOrReplaceChild("annetnia_r2", CubeListBuilder.create().texOffs(0, 3).addBox(-0.55F, -0.5F, -1.75F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-0.75F, -1.75F, -3.4F, -0.5672F, 0.3927F, 0.0F));

		PartDefinition wingleft = bee.addOrReplaceChild("wingleft", CubeListBuilder.create(), PartPose.offset(0.25F, -1.75F, -1.0F));

		PartDefinition Wing_r1 = wingleft.addOrReplaceChild("Wing_r1", CubeListBuilder.create().texOffs(0, 9).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5672F, 0.829F, 0.0F));

		PartDefinition wingrgiuht = bee.addOrReplaceChild("wingrgiuht", CubeListBuilder.create(), PartPose.offset(-0.25F, -1.75F, -1.0F));

		PartDefinition wiong_r1 = wingrgiuht.addOrReplaceChild("wiong_r1", CubeListBuilder.create().texOffs(6, 0).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5672F, -0.829F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.animate(((BeeEntity) entity).idleAnimationState, ModAnimationDefinitions.FLY, ageInTicks, 1f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bee.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return bee;
	}
}