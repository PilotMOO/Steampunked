package net.pilot.steampunked.entity.client.reconstructed;

import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.pilot.steampunked.entity.reconstucted.ReconstructedZombieEntity;

public class ReconstructedZombieRenderer extends GeoEntityRenderer<ReconstructedZombieEntity> {
    public ReconstructedZombieRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ReconstructedZombieModel());
    }
}
