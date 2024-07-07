package net.pilot.steampunked.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelHeightAccessor;
import org.jetbrains.annotations.Nullable;

public class BeeEntity extends Monster {
    protected BeeEntity(EntityType<? extends Monster> p_33002_, Level p_33003_) {
        super(p_33002_, p_33003_);
    }
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    @Override
    public void tick() {
        super.tick();

        if (level().isClientSide){
            SetupAnimationStates();
        }
    }

    private void SetupAnimationStates(){
        if (this.idleAnimationTimeout <= 0){
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        }
        else{
            idleAnimationTimeout--;
        }
    }

    protected void registerGoals(){
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>
                (this, LivingEntity.class,  true,livingEntity -> {return livingEntity instanceof Player;}));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>
                (this, LivingEntity.class,  true,livingEntity -> {
                    if (livingEntity instanceof BeeEntity){
                        return false;
                    }
                    return true;}));
    }

    public static AttributeSupplier.Builder createAttributes(){
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 10D)
                .add(Attributes.ARMOR, 4)
                .add(Attributes.FOLLOW_RANGE, 64)
                .add(Attributes.MOVEMENT_SPEED, 0.35D)
                .add(Attributes.ATTACK_DAMAGE, 3D)
                .add(Attributes.ATTACK_KNOCKBACK, 0.25D)
                .add(Attributes.ATTACK_SPEED, 2D);
    }

    @Override
    public boolean killedEntity(ServerLevel level, LivingEntity entity) {
        BeeEntity bee = new BeeEntity(ModEntities.BEE.get(), level);

        bee.copyPosition(this);
        bee.setBaby(this.isBaby());
        bee.setNoAi(this.isNoAi());
        if (this.hasCustomName()) {
            bee.setCustomName(this.getCustomName());
            bee.setCustomNameVisible(this.isCustomNameVisible());
        }

        if (this.isPersistenceRequired()) {
            bee.setPersistenceRequired();
        }

        this.level().addFreshEntity(bee);
        if (this.isPassenger()) {
            Entity entityRidden = this.getVehicle();
            this.stopRiding();
            bee.startRiding(entityRidden, true);
        }

        entity.discard();

        return super.killedEntity(level, entity);
    }
}
