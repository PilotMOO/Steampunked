package mod.pilot.steampunked.entity.reconstucted;

import mod.azure.azurelib.animatable.GeoEntity;
import mod.pilot.steampunked.Config;
import mod.pilot.steampunked.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import mod.pilot.steampunked.Steampunked;
import net.minecraftforge.fluids.FluidType;

public abstract class ReconstructedBase extends Monster implements GeoEntity {
    //Upon-creation methods
    protected ReconstructedBase(EntityType<? extends Monster> entityType, Level level){
        super(entityType, level);
        Steampunked.allReconMobs.add(this);
    }

    public int DeathAnimationLength = 40;

    public enum state{
        Idle, //0
        Walking, //1
        Running, //2
        Mining, //3
        FeedingReconstructor, //4
        Dying //5
    }
    public static final EntityDataAccessor<Integer> AIState = SynchedEntityData.defineId(ReconstructedBase.class, EntityDataSerializers.INT);
    public int getAIState(){return entityData.get(AIState);}
    public void setAIState(Integer count){
        entityData.set(AIState, count);
    }

    public static final EntityDataAccessor<Integer> MoveDecay = SynchedEntityData.defineId(ReconstructedBase.class, EntityDataSerializers.INT);
    public int getMoveDecay(){return entityData.get(MoveDecay);}
    public void setMoveDecay(Integer count){ entityData.set(MoveDecay, count); }
    public void addMoveDecay(Integer count){ entityData.set(MoveDecay, getMoveDecay() + count); }
    protected static final int MoveDecayMax = 40;

    public boolean isMovingSmart() {
        if (getDeltaMovement().x != 0 || getDeltaMovement().z != 0) {
            setMoveDecay(0);
        }
        else if (getNavigation().getPath() == null){
            return false;
        }
        else
        {
            if (getMoveDecay() > MoveDecayMax){
                return false;
            }
        }
        return true;
    }
    /**/

    //NBT related
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("AIState",entityData.get(AIState));
        tag.putInt("MoveDecay",entityData.get(MoveDecay));
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(AIState, tag.getInt("AIState"));
        entityData.set(MoveDecay, tag.getInt("MoveDecay"));
    }
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(AIState, -1);
        this.entityData.define(MoveDecay, 0);
    }
    /**/

    //Goal methods
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new DelayedMovementGoal(this, 10, getNavigation().getPath()));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>
                (this, LivingEntity.class,  true,livingEntity -> { return livingEntity instanceof Player;}));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>
                (this, LivingEntity.class,  true,livingEntity -> { return !Config.SERVER.blacklisted_targets.get().contains(livingEntity.getEncodeId()) && !(livingEntity instanceof ReconstructedBase);}));
        this.targetSelector.addGoal(3, new BreakBlockGoal(this));
    }

    boolean TestTag(BlockState givenE){
        for (String tag : Config.SERVER.juicy_blocks.get()){if(givenE.is(BlockTags.create(new ResourceLocation(tag))) && !givenE.isAir()){ return true;}}
        return false;
    }

    //New goals
    public class DelayedMovementGoal extends Goal {
        private final ReconstructedBase parent;
        private final int delay;
        private LivingEntity target;
        float priorrot;

        public Path oldPath;

        public DelayedMovementGoal(ReconstructedBase parent, int delay, Path currentPath) {
            this.parent = parent;
            this.delay = delay;
            priorrot = parent.getYRot();
            this.oldPath = currentPath;
        }

        @Override
        public boolean canUse() {
            return parent.isMovingSmart();
        }

        @Override
        public boolean canContinueToUse() {
            return parent.isMovingSmart();
        }

        @Override
        public void tick() {
            int delayAmount;
            if (getAIState() == state.Running.ordinal()){
                delayAmount = 3;
            }
            else{
                delayAmount = 5;
            }
            if (parent.tickCount % delay >= delayAmount){
                if (parent.getNavigation().getPath() == null) {
                    if (oldPath != null){
                        parent.getNavigation().moveTo(oldPath, 1.0D);
                    }
                }
                else{
                    parent.getNavigation().tick(); // Continue along the existing path
                }
            }
            else{
                parent.setYBodyRot(priorrot);
                oldPath = parent.getNavigation().getPath();
                parent.getNavigation().stop(); // Temporarily stop navigation updates
            }

            priorrot = parent.getYRot();
        }
    }

    public class BreakBlockGoal extends Goal{
        public final ReconstructedBase parent;
        int breakProgress;
        int lastBreakProgress = -1;

        public BlockPos TargetBlock;

        public BreakBlockGoal(ReconstructedBase parent){
            this.parent = parent;
            breakProgress = 0;
            TargetBlock = FindJuicyBlock();
        }

        @Override
        public boolean canUse() {
            return !parent.isAggressive();
        }
        @Override
        public boolean canContinueToUse() {
            return !parent.isAggressive();
        }

        @Override
        public void tick() {
            if (TargetBlock != null){
                parent.addEffect(new MobEffectInstance(MobEffects.GLOWING, 1));
            }
            else{
                TargetBlock = parent.FindJuicyBlock();
            }
        }

        @Override
        public void stop() {
            TargetBlock = null;
        }

        void AttemptToBreakBlock(){

            if (parent.distanceToSqr(TargetBlock.getX(), TargetBlock.getY(), TargetBlock.getZ()) < 2){
                parent.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 1));

                /*
                breakProgress++;
                float blockHardness = parent.level().getBlockState(JuicyBlock).getDestroySpeed(parent.level(), JuicyBlock);
                int progress = (int)((float)breakProgress / blockHardness * 10.0F);
                if (progress != this.lastBreakProgress) {
                    parent.level().destroyBlockProgress(parent.getId(), JuicyBlock, progress);
                    this.lastBreakProgress = progress;
                }

                setAIState(state.Mining.ordinal());

                if (breakProgress == blockHardness) {
                    parent.level().removeBlock(JuicyBlock, false);
                    parent.level().levelEvent(1021, JuicyBlock, 0);
                    parent.level().levelEvent(2001, JuicyBlock, Block.getId(parent.level().getBlockState(JuicyBlock)));
                    setAIState(state.Idle.ordinal());
                    stop();
                }
                 */
            }
        }
    }

    //Methods
    public BlockPos FindJuicyBlock() {
        AABB aabb = getBoundingBox().inflate(16);
        BlockPos ClosestBlock = null;
        for(BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            double d0 = Double.MAX_VALUE;
            if (TestTag(level().getBlockState(blockpos))){
                if (blockpos.distToCenterSqr(position()) < d0){
                    ClosestBlock = blockpos;
                    d0 = blockpos.distToCenterSqr(position());
                }
            }
        }
        return ClosestBlock;
    }

    //Overridden general methods

    @Override
    public void tick() {
        super.tick();
        addMoveDecay(1);
        if (isMovingSmart()){
            if (isAggressive()){
                setAIState(state.Running.ordinal());
            }
            else{
                setAIState(state.Walking.ordinal());
            }
        }
        else{
            if (getNavigation().getPath() == null){
                setAIState(state.Idle.ordinal());
            }
        }
        ManageSounds();
    }

    private int MoveSoundCD = 0;
    private boolean hasPlayedDeath = false;

    public void ManageSounds(){
        if (getAIState() == state.Dying.ordinal() && !hasPlayedDeath && deathTime >= 10){
            if (level().isClientSide()){
                level().playLocalSound(
                        this.getX(), this.getY(), this.getZ(),
                        getDeathSound(),
                        SoundSource.HOSTILE, 1.0F, 1.0F, false);
            }
            hasPlayedDeath = true;
        }
        else{
            if (MoveSoundCD == 0){
                if (getAIState() == state.Walking.ordinal()){
                    if (level().isClientSide()){
                        level().playLocalSound(
                                this.getX(), this.getY(), this.getZ(),
                                getStepSound(),
                                SoundSource.HOSTILE, 0.25F, 1.0F, false);
                    }
                    MoveSoundCD = 10;
                }
                if (getAIState() == state.Running.ordinal()){
                    if (level().isClientSide()){
                        level().playLocalSound(
                                this.getX(), this.getY(), this.getZ(),
                                getStepSound(),
                                SoundSource.HOSTILE, 0.25F, 1.0F, false);
                    }
                    MoveSoundCD = 5;
                }
            }
            MoveSoundCD--;
        }
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.getDirectEntity() instanceof ReconstructedBase){
            return false;
        }

        if  (source.getDirectEntity() != null){
            //Inform the rest of the group of the target, and make a new goal of type attackTargetOmniscient();
        }

        playHurtSound(source);

        return super.hurt(source, amount);
    }

    @Override
    protected void tickDeath() {
        ++this.deathTime;
        setAIState(state.Dying.ordinal());
        if (this.deathTime >= DeathAnimationLength && !this.level().isClientSide() && !this.isRemoved()) {
            this.level().broadcastEntityEvent(this, (byte)60);
            this.remove(Entity.RemovalReason.KILLED);
            Steampunked.allReconMobs.remove(this);
        }
    }

    @Override
    protected boolean isAffectedByFluids() {
        return false;
    }
    @Override
    public boolean isPushedByFluid(FluidType type) {
        return false;
    }
    @Override
    public boolean canDrownInFluidType(FluidType type) {
        return false;
    }

    @Override
    public void travel(Vec3 pTravelVector) {
        super.travel(pTravelVector);
        if (horizontalCollision){
            if (isInFluidType()){
                self().setDeltaMovement(self().getDeltaMovement().add(0.0D, 0.1d, 0.0D));
            }
            else if(onGround()){
                jumpFromGround();
            }
        }
    }
    /**/

    protected SoundEvent getStepSound(){
        return ModSounds.RECON_WALK.get();
    }
}
