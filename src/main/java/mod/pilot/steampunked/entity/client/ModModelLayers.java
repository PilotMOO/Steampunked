package mod.pilot.steampunked.entity.client;

import mod.pilot.steampunked.Steampunked;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation BEE_LAYER = new ModelLayerLocation(
            new ResourceLocation(Steampunked.MOD_ID, "bee"), "main");
    public static final ModelLayerLocation RECON_ZOMBIE_LAYER = new ModelLayerLocation(
            new ResourceLocation(Steampunked.MOD_ID, "recon_zombie"), "main");
    public static final ModelLayerLocation RECONSTRUCTED_ZOMBIE_LAYER = new ModelLayerLocation(
            new ResourceLocation(Steampunked.MOD_ID, "reconstructed_zombie"), "main");
}
