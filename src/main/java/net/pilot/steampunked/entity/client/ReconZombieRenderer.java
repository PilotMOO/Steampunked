package net.pilot.steampunked.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.pilot.steampunked.Steampunked;
import net.pilot.steampunked.entity.ReconZombieNoAzureEntity;

public class ReconZombieRenderer extends MobRenderer<ReconZombieNoAzureEntity, ReconZombie<ReconZombieNoAzureEntity>> {
    public ReconZombieRenderer(EntityRendererProvider.Context context) {
        super(context, new ReconZombie<>(context.bakeLayer(ModModelLayers.RECON_ZOMBIE_LAYER)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(ReconZombieNoAzureEntity p_114482_) {
        return new ResourceLocation(Steampunked.MOD_ID, "textures/entity/reconzombie.png");
    }

    @Override
    public void render(ReconZombieNoAzureEntity entity, float yaw, float particleTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if (entity.POIList.size() > 0){
            poseStack.scale(1f, 0.5f, 1f);
        }

        super.render(entity, yaw, particleTicks, poseStack, buffer, packedLight);
    }
}
