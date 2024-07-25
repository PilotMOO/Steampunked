package mod.pilot.steampunked.block.client;

import mod.azure.azurelib.renderer.GeoBlockRenderer;
import mod.pilot.steampunked.block.entity.ReconstructorEntity;

public class ReconstructorRenderer extends GeoBlockRenderer<ReconstructorEntity> {
    public ReconstructorRenderer() {
        super(new ReconstructorModel());
    }
}
