package mod.pilot.steampunked.event;

import mod.pilot.steampunked.entity.BeeEntity;
import mod.pilot.steampunked.entity.ModEntities;
import mod.pilot.steampunked.entity.ReconZombieNoAzureEntity;
import mod.pilot.steampunked.entity.reconstucted.ReconstructedZombieEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import mod.pilot.steampunked.Steampunked;

@Mod.EventBusSubscriber(modid = Steampunked.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.BEE.get(), BeeEntity.createAttributes().build());
        event.put(ModEntities.RECON_ZOMBIE_NO_AZURE.get(), ReconZombieNoAzureEntity.createAttributes().build());
        event.put(ModEntities.RECON_ZOMBIE.get(), ReconstructedZombieEntity.createAttributes().build());
    }
}
