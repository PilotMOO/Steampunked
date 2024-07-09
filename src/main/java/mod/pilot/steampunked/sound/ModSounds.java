package mod.pilot.steampunked.sound;

import mod.pilot.steampunked.Steampunked;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Steampunked.MOD_ID);

    public static final RegistryObject<SoundEvent> TEST_SOUND = registerSoundEvents("test_sound");

    public static final RegistryObject<SoundEvent> RECON_IDLE_RANDOM = registerSoundEvents("recon_idle_random");
    public static final RegistryObject<SoundEvent> RECON_ENGINE = registerSoundEvents("recon_enginesolo");
    public static final RegistryObject<SoundEvent> RECON_GEAR = registerSoundEvents("recon_gearsolo");
    public static final RegistryObject<SoundEvent> RECON_TICK = registerSoundEvents("recon_ticking");
    public static final RegistryObject<SoundEvent> RECON_WHIR = registerSoundEvents("recon_whirsolo");
    public static final RegistryObject<SoundEvent> RECON_ZOMBIE_DEATH = registerSoundEvents("recon_zombie_death");
    public static final RegistryObject<SoundEvent> RECON_WALK = registerSoundEvents("recon_walk");
    public static final RegistryObject<SoundEvent> RECON_IDLE = registerSoundEvents("recon_idle");
    public static final RegistryObject<SoundEvent> RECON_HURT = registerSoundEvents("recon_hurt");
    public static final RegistryObject<SoundEvent> RECONSTRUCTOR_WORK = registerSoundEvents("reconstructor_work");

    public static final ForgeSoundType TEST_SOUND_TYPE = new ForgeSoundType(1f, 1f,
            null, null, null, null, null); //Replace Null with actual sounds

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Steampunked.MOD_ID, name)));
    }
    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
