package mod.pilot.steampunked.block;

import mod.pilot.steampunked.Steampunked;
import mod.pilot.steampunked.block.custom.DangerousBlock;
import mod.pilot.steampunked.block.entity.ReconstructorEntity;
import mod.pilot.steampunked.items.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Steampunked.MOD_ID);

    public static RegistryObject<Block> TEST_BLOCK = registryBlock("test_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK).requiresCorrectToolForDrops()
    ));
    public static RegistryObject<Block> TEST_BLOCK_2 = registryBlock("test_block_2",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK)
            ));
    public static RegistryObject<Block> TEST_STAIRS = registryBlock("test_stairs",
            () -> new StairBlock(() -> ModBlocks.TEST_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK).requiresCorrectToolForDrops()));
    public static RegistryObject<Block> TEST_SLAB = registryBlock("test_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK).requiresCorrectToolForDrops()));

    public static RegistryObject<Block> TEST_BUTTON = registryBlock("test_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).requiresCorrectToolForDrops(),
                    BlockSetType.OAK, 200, true));
    public static RegistryObject<Block> TEST_PRESSURE_PLATE = registryBlock("test_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK)
                    .requiresCorrectToolForDrops(), BlockSetType.OAK));

    public static RegistryObject<Block> TEST_FENCE = registryBlock("test_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK).requiresCorrectToolForDrops()));
    public static RegistryObject<Block> TEST_FENCE_GATE = registryBlock("test_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK).requiresCorrectToolForDrops(), SoundEvents.ANVIL_LAND, SoundEvents.WARDEN_EMERGE));
    public static RegistryObject<Block> TEST_WALL = registryBlock("test_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK).requiresCorrectToolForDrops()));

    public static RegistryObject<Block> TEST_DOOR = registryBlock("test_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK).requiresCorrectToolForDrops(), BlockSetType.OAK));
    public static RegistryObject<Block> TEST_TRAPDOOR = registryBlock("test_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK).requiresCorrectToolForDrops(), BlockSetType.OAK));

    public static RegistryObject<Block> DANGEROUS_BLOCK = registryBlock("dangerous_block",
            () -> new DangerousBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).explosionResistance(1)));

    private static <T extends Block>RegistryObject<T> registryBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        RegisterBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> RegisterBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}
