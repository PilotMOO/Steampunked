package net.pilot.steampunked.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pilot.steampunked.Steampunked;
import net.pilot.steampunked.entity.reconstucted.ReconstructedZombieEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Steampunked.MOD_ID);

    public static final RegistryObject<EntityType<BeeEntity>> BEE =
            ENTITY_TYPES.register("bee", () -> EntityType.Builder.of(BeeEntity::new, MobCategory.AMBIENT)
                    .sized(0.5f, 0.2f).build("bee"));
    public static final RegistryObject<EntityType<ReconZombieNoAzureEntity>> RECON_ZOMBIE_NO_AZURE =
            ENTITY_TYPES.register("recon_zombie_no_azure", () -> EntityType.Builder.of(ReconZombieNoAzureEntity::new, MobCategory.MONSTER)
                    .sized(0.75f, 2f).build("recon_zombie_no_azure"));
    public static final RegistryObject<EntityType<ReconstructedZombieEntity>> RECON_ZOMBIE =
            ENTITY_TYPES.register("reconstructed_zombie", () -> EntityType.Builder.of(ReconstructedZombieEntity::new, MobCategory.MONSTER)
                    .sized(0.75f, 2f).build("reconstructed_zombie"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
