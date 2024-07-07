package net.pilot.steampunked.items;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.pilot.steampunked.Steampunked;
import net.pilot.steampunked.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Steampunked.MOD_ID);

    public static final RegistryObject<CreativeModeTab> STEAMPUNKED_TAB = CREATIVE_MODE_TABS.register("steampunked_tab",
            () -> new CreativeModeTab.Builder(CreativeModeTab.Row.TOP, 1).icon(() -> new ItemStack(ModItems.TESTITEM.get()))
                    .title(Component.translatable("creativetab.steampunked_tab"))
                    .displayItems((p_270258_, p_259752_) -> {
                        //Basic Items
                        p_259752_.accept(ModItems.TESTITEM.get());
                        p_259752_.accept(ModItems.TEST_FOOD_ITEM.get());
                        p_259752_.accept(ModItems.TEST_FUEL_ITEM.get());

                        p_259752_.accept(ModItems.TEST_SWORD.get());
                        p_259752_.accept(ModItems.TEST_PICKAXE.get());
                        p_259752_.accept(ModItems.TEST_AXE.get());
                        p_259752_.accept(ModItems.TEST_SHOVEL.get());
                        p_259752_.accept(ModItems.TEST_HOE.get());
                        p_259752_.accept(ModItems.TEST_HELMET.get());
                        p_259752_.accept(ModItems.TEST_CHESTPLATE.get());
                        p_259752_.accept(ModItems.TEST_LEGGINGS.get());
                        p_259752_.accept(ModItems.TEST_BOOTS.get());

                        //Advanced Items
                        p_259752_.accept(ModItems.DANGEROUS_ITEM.get());
                        p_259752_.accept(ModItems.FUCKING_CABINET.get());

                        //Basic Blocks
                        p_259752_.accept(ModBlocks.TEST_BLOCK.get());
                        p_259752_.accept(ModBlocks.TEST_BLOCK_2.get());
                        p_259752_.accept(ModBlocks.TEST_BUTTON.get());
                        p_259752_.accept(ModBlocks.TEST_DOOR.get());
                        p_259752_.accept(ModBlocks.TEST_FENCE.get());
                        p_259752_.accept(ModBlocks.TEST_SLAB.get());
                        p_259752_.accept(ModBlocks.TEST_FENCE_GATE.get());
                        p_259752_.accept(ModBlocks.TEST_PRESSURE_PLATE.get());
                        p_259752_.accept(ModBlocks.TEST_STAIRS.get());
                        p_259752_.accept(ModBlocks.TEST_TRAPDOOR.get());
                        p_259752_.accept(ModBlocks.TEST_WALL.get());

                        //Advanced Blocks
                        p_259752_.accept(ModBlocks.DANGEROUS_BLOCK.get());
                    })
                    .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
