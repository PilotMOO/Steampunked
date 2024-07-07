package mod.pilot.steampunked.entity.reconstucted;

import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.animation.RawAnimation;
import mod.azure.azurelib.util.AzureLibUtil;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import mod.pilot.steampunked.sound.ModSounds;

public class ReconstructedZombieEntity extends ReconstructedBase {
    public ReconstructedZombieEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    //AzureLib Animation stuff
    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "Walk/Idle", 2, event ->
        {
            if (event.isMoving()){
                return event.setAndContinue(RawAnimation.begin().thenLoop("Run"));
            }
            return event.setAndContinue(RawAnimation.begin().thenLoop("Idle2"));

        })
                .setSoundKeyframeHandler(event -> {
                    if (event.getKeyframeData().getSound().matches("reconstructedstep"))
                        if (level().isClientSide())
                            level().playLocalSound(
                                    this.getX(), this.getY(), this.getZ(),
                                    ModSounds.RECON_STEP.get(),
                                    SoundSource.HOSTILE, 0.25F, 1.0F, false);
                    if (event.getKeyframeData().getSound().matches("piston_retract"))
                        if (level().isClientSide())
                            level().playLocalSound(
                                    this.getX(), this.getY(), this.getZ(),
                                    SoundEvents.PISTON_CONTRACT,
                                    SoundSource.HOSTILE, 0.25F, 1.0F, false);
                    if (event.getKeyframeData().getSound().matches("piston_extend"))
                        if (level().isClientSide())
                            level().playLocalSound(
                                    this.getX(), this.getY(), this.getZ(),
                                    SoundEvents.PISTON_EXTEND,
                                    SoundSource.HOSTILE, 0.25F, 1.0F, false);
                }));
        controllers.add(new AnimationController<>(this, "Death", 10, event ->
            {
                if (this.dead){
                    return event.setAndContinue(RawAnimation.begin().thenPlayAndHold("Death"));
                }
                else{
                    return null;
                }
            }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
    /**/

    public static AttributeSupplier.Builder createAttributes(){
        return ReconstructedBase.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20D)
                .add(Attributes.ARMOR, 4)
                .add(Attributes.FOLLOW_RANGE, 64)
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.ATTACK_DAMAGE, 6D)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5D)
                .add(Attributes.ATTACK_SPEED, 2D);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.RECON_ZOMBIE_DEATH.get();
    }
}
