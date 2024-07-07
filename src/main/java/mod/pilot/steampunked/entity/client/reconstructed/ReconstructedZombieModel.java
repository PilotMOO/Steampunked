package mod.pilot.steampunked.entity.client.reconstructed;

import mod.azure.azurelib.model.GeoModel;
import mod.pilot.steampunked.entity.reconstucted.ReconstructedZombieEntity;
import net.minecraft.resources.ResourceLocation;

public class ReconstructedZombieModel extends GeoModel<ReconstructedZombieEntity> {
    private static final ResourceLocation model = new ResourceLocation("steampunked", "geo/entity/reconzombiemodel.geo.json");
    private static final ResourceLocation texture = new ResourceLocation("steampunked", "textures/entity/reconzombie.png");
    private static final ResourceLocation animation = new ResourceLocation("steampunked", "animations/entity/reconzombie.animation.json");
    @Override
    public ResourceLocation getModelResource(ReconstructedZombieEntity animatable) {
        return model;
    }

    @Override
    public ResourceLocation getTextureResource(ReconstructedZombieEntity animatable) {
        return texture;
    }

    @Override
    public ResourceLocation getAnimationResource(ReconstructedZombieEntity animatable) {
        return animation;
    }
}

