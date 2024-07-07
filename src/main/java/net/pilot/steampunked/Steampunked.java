package net.pilot.steampunked;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.pilot.steampunked.block.ModBlocks;
import net.pilot.steampunked.entity.ModEntities;
import net.pilot.steampunked.entity.client.BeeRenderer;
import net.pilot.steampunked.entity.client.ReconZombieRenderer;
import net.pilot.steampunked.entity.client.reconstructed.ReconstructedZombieRenderer;
import net.pilot.steampunked.entity.reconstucted.ReconstructedBase;
import net.pilot.steampunked.items.ModCreativeModeTabs;
import net.pilot.steampunked.items.ModItems;
import net.pilot.steampunked.loot.ModLootModifiers;
import net.pilot.steampunked.sound.ModSounds;
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

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        //Registers classes (ig)
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);
        ModLootModifiers.register(modEventBus);
        ModSounds.register(modEventBus);
        ModEntities.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(ModEntities.BEE.get(), BeeRenderer::new);
            EntityRenderers.register(ModEntities.RECON_ZOMBIE_NO_AZURE.get(), ReconZombieRenderer::new);
            EntityRenderers.register(ModEntities.RECON_ZOMBIE.get(), ReconstructedZombieRenderer::new);
        }
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
