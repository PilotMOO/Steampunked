package mod.pilot.steampunked.block.entity;

import mod.pilot.steampunked.Steampunked;
import mod.pilot.steampunked.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Steampunked.MOD_ID);

    public static final RegistryObject<BlockEntityType<ReconstructorEntity>> RECONSTRUCTOR_ENTITY =
            BLOCK_ENTITIES.register("reconstructor_entity", () -> BlockEntityType.Builder.of(ReconstructorEntity::new, ModBlocks.RECONSTRUCTOR.get())
                    .build(null));

    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}
