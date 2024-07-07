package mod.pilot.steampunked.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import mod.pilot.steampunked.Steampunked;
import mod.pilot.steampunked.entity.BeeEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BeeRenderer extends MobRenderer<BeeEntity, bee<BeeEntity>> {
    public BeeRenderer(EntityRendererProvider.Context context) {
        super(context, new bee<>(context.bakeLayer(ModModelLayers.BEE_LAYER)), 0.1f);
    }

    @Override
    public ResourceLocation getTextureLocation(BeeEntity p_114482_) {
        return new ResourceLocation(Steampunked.MOD_ID, "textures/entity/bee.png");
    }

    @Override
    public void render(BeeEntity entity, float yaw, float particleTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if (entity.isOnFire()){
            poseStack.scale(4f, 1f, 3f);
        }

        super.render(entity, yaw, particleTicks, poseStack, buffer, packedLight);
    }
}
