package mod.pilot.steampunked.items;

import mod.pilot.steampunked.Steampunked;
import mod.pilot.steampunked.items.custom.DangerousItem;
import mod.pilot.steampunked.items.custom.FuelItem;
import mod.pilot.steampunked.items.custom.ModArmorItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Steampunked.MOD_ID);

    public static final RegistryObject<Item> TESTITEM = ITEMS.register("testitem",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TEST_FOOD_ITEM = ITEMS.register("test_food_item",
            () -> new Item(new Item.Properties().food(ModFoods.TEST_FOOD)));
    public static final RegistryObject<Item> TEST_FUEL_ITEM = ITEMS.register("test_fuel_item",
            () -> new FuelItem(new Item.Properties(), 10));
    public static final RegistryObject<Item> DANGEROUS_ITEM = ITEMS.register("dangerous_item",
            () -> new DangerousItem(new Item.Properties()));
    public static final RegistryObject<Item> FUCKING_CABINET = ITEMS.register("fucking_cabinet",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> TEST_SWORD = ITEMS.register("test_sword",
            () -> new SwordItem(ModToolTiers.TEST, -1, 0.1f, new Item.Properties()));
    public static final RegistryObject<Item> TEST_PICKAXE = ITEMS.register("test_pickaxe",
            () -> new PickaxeItem(ModToolTiers.TEST, -1, 0.1f, new Item.Properties()));
    public static final RegistryObject<Item> TEST_AXE = ITEMS.register("test_axe",
            () -> new AxeItem(ModToolTiers.TEST, -1, 0.1f, new Item.Properties()));
    public static final RegistryObject<Item> TEST_SHOVEL = ITEMS.register("test_shovel",
            () -> new ShovelItem(ModToolTiers.TEST, -1, 0.1f, new Item.Properties()));
    public static final RegistryObject<Item> TEST_HOE = ITEMS.register("test_hoe",
            () -> new HoeItem(ModToolTiers.TEST, -1, 0.1f, new Item.Properties()));

    public static final RegistryObject<Item> TEST_HELMET = ITEMS.register("test_helmet",
            () -> new ModArmorItem(ModArmorMaterials.TEST, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> TEST_CHESTPLATE = ITEMS.register("test_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.TEST, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> TEST_LEGGINGS = ITEMS.register("test_leggings",
            () -> new ModArmorItem(ModArmorMaterials.TEST, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> TEST_BOOTS = ITEMS.register("test_boots",
            () -> new ModArmorItem(ModArmorMaterials.TEST, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
