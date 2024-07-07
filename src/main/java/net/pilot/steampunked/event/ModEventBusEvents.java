package net.pilot.steampunked.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.pilot.steampunked.Steampunked;
import net.pilot.steampunked.entity.BeeEntity;
import net.pilot.steampunked.entity.ModEntities;
import net.pilot.steampunked.entity.ReconZombieNoAzureEntity;
import net.pilot.steampunked.entity.reconstucted.ReconstructedZombieEntity;

@Mod.EventBusSubscriber(modid = Steampunked.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.BEE.get(), BeeEntity.createAttributes().build());
        event.put(ModEntities.RECON_ZOMBIE_NO_AZURE.get(), ReconZombieNoAzureEntity.createAttributes().build());
        event.put(ModEntities.RECON_ZOMBIE.get(), ReconstructedZombieEntity.createAttributes().build());
    }
}
