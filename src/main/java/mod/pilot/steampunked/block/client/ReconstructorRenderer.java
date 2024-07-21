package mod.pilot.steampunked.block.client;

import mod.azure.azurelib.model.GeoModel;
import mod.azure.azurelib.renderer.GeoBlockRenderer;

public class ReconstructorRenderer extends GeoBlockRenderer<ReconstructorModel> {
    public ReconstructorRenderer(GeoModel model) {
        super(new ReconstructorModel());
    }
}
