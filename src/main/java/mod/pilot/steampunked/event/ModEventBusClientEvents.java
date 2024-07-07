package mod.pilot.steampunked.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import mod.pilot.steampunked.Steampunked;
import mod.pilot.steampunked.entity.client.ModModelLayers;
import mod.pilot.steampunked.entity.client.ReconZombie;
import mod.pilot.steampunked.entity.client.bee;

@Mod.EventBusSubscriber(modid = Steampunked.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ModModelLayers.BEE_LAYER, bee::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.RECON_ZOMBIE_LAYER, ReconZombie::createBodyLayer);
    }
}
