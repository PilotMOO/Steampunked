package mod.pilot.steampunked;

import com.mojang.logging.LogUtils;
import mod.pilot.steampunked.entity.ModEntities;
import mod.pilot.steampunked.entity.reconstucted.ReconstructedBase;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import mod.pilot.steampunked.block.ModBlocks;
import mod.pilot.steampunked.items.ModCreativeModeTabs;
import mod.pilot.steampunked.items.ModItems;
import mod.pilot.steampunked.loot.ModLootModifiers;
import mod.pilot.steampunked.sound.ModSounds;
import net.minecraftforge.fml.loading.FMLPaths;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Steampunked.MOD_ID)
public class Steampunked
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "steampunked";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public Steampunked()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SERVER_SPEC ,"SteampunkedConfig.toml");
        Config.loadConfig(Config.SERVER_SPEC, FMLPaths.CONFIGDIR.get().resolve("SteampunkedConfig.toml").toString());

        //Registers classes (ig)
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);
        ModLootModifiers.register(modEventBus);
        ModSounds.register(modEventBus);
        ModEntities.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SERVER_SPEC);
    }

    private static final HashMap MobTargetPriorityHashmap = new HashMap<Mob, Integer>(){

    };
    public static int GetMobPriorityFor(Mob mob){
        int priority = 0;
        try{
            priority = (int)MobTargetPriorityHashmap.get(mob);
        }
        catch (Exception e){
            priority = -1;
        }
        finally {
            return priority;
        }
    }

    private static final HashMap BlockValueHashmap = new HashMap<BlockState, Integer>(){

    };
    public static int GetBlockValueFor(BlockState block){
        int value = 0;
        try{
            value = (int)BlockValueHashmap.get(block);
        }
        catch (Exception e){
            value = -1;
        }
        finally {
            return value;
        }
    }

    public static final ArrayList<ReconstructedBase> allReconMobs = new ArrayList<ReconstructedBase>(){

    };
    public static final ArrayList<ReconstructedBase> allReconMobTypes = new ArrayList<ReconstructedBase>(){

    };
}
