package mod.pilot.steampunked.entity.client.reconstructed;

import mod.azure.azurelib.renderer.GeoEntityRenderer;
import mod.pilot.steampunked.entity.reconstucted.ReconstructedZombieEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class ReconstructedZombieRenderer extends GeoEntityRenderer<ReconstructedZombieEntity> {
    public ReconstructedZombieRenderer(EntityRendererProvider.Context context) {
        super(context, new ReconstructedZombieModel());
    }

    @Override
    protected float getDeathMaxRotation(ReconstructedZombieEntity animatable) {
        return 0;
    }
}
