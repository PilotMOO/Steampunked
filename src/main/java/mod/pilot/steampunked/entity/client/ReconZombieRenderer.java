package mod.pilot.steampunked.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import mod.pilot.steampunked.Steampunked;
import mod.pilot.steampunked.entity.ReconZombieNoAzureEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

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
        super.render(entity, yaw, particleTicks, poseStack, buffer, packedLight);
    }
}
