package net.pilot.steampunked.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.pilot.steampunked.Steampunked;
import net.pilot.steampunked.entity.client.ModModelLayers;
import net.pilot.steampunked.entity.client.ReconZombie;
import net.pilot.steampunked.entity.client.bee;
import net.pilot.steampunked.entity.client.reconstructed.ReconstructedZombieModel;

@Mod.EventBusSubscriber(modid = Steampunked.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ModModelLayers.BEE_LAYER, bee::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.RECON_ZOMBIE_LAYER, ReconZombie::createBodyLayer);
    }
}
