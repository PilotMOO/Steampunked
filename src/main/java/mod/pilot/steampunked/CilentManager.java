package mod.pilot.steampunked;

import mod.pilot.steampunked.entity.ModEntities;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import mod.pilot.steampunked.entity.client.BeeRenderer;
import mod.pilot.steampunked.entity.client.ReconZombieRenderer;
import mod.pilot.steampunked.entity.client.reconstructed.ReconstructedZombieRenderer;

@Mod.EventBusSubscriber(modid = Steampunked.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CilentManager {
    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(ModEntities.RECON_ZOMBIE.get(), ReconstructedZombieRenderer::new);
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event)
    {
        EntityRenderers.register(ModEntities.BEE.get(), BeeRenderer::new);
        EntityRenderers.register(ModEntities.RECON_ZOMBIE_NO_AZURE.get(), ReconZombieRenderer::new);
    }
}
