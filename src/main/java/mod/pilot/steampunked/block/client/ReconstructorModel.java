package mod.pilot.steampunked.block.client;

import mod.azure.azurelib.model.GeoModel;
import mod.pilot.steampunked.block.entity.ReconstructorEntity;
import net.minecraft.resources.ResourceLocation;

public class ReconstructorModel extends GeoModel<ReconstructorEntity> {
    private static final ResourceLocation model = new ResourceLocation("steampunked", "geo/block/reconstructor.geo.json");
    private static final ResourceLocation texture = new ResourceLocation("steampunked", "textures/block/reconstructor_texture.png");
    private static final ResourceLocation animation = new ResourceLocation("steampunked", "animations/block/reconstructor.animation.json");

    @Override
    public ResourceLocation getModelResource(ReconstructorEntity animatable) {
        return model;
    }

    @Override
    public ResourceLocation getTextureResource(ReconstructorEntity animatable) {
        return texture;
    }

    @Override
    public ResourceLocation getAnimationResource(ReconstructorEntity animatable) {
        return animation;
    }
}
