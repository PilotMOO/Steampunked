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
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import mod.pilot.steampunked.Steampunked;
import net.minecraftforge.fluids.FluidType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class ReconstructedBase extends Monster implements GeoEntity {
    //Upon-creation methods
    protected ReconstructedBase(EntityType<? extends Monster> entityType, Level level){
        super(entityType, level);
        Steampunked.allReconMobs.add(this);
        //MobClass = 0;
        //SetupPOIList(this);
    }

    /* Old
    public static void SetupPOIList(ReconstructedBase parent){
        parent.POIList = new ArrayList<>(POIListMax);
        parent.CreatePOIGoals();
    }
     */
    /**/

    //Variables (Old)
    public static int MobClass;

    public ArrayList<POI> POIList;
    public static final int POIListMax = 5;
    public static final int POIMemoryRange = 128;

    public BlockPos JuicyBlock;

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

    //Goal and POI management methods
    @Override
    protected void registerGoals() {
        //decidePOIGoal(); Old
        this.goalSelector.addGoal(1, new DelayedMovementGoal(this, 10, getNavigation().getPath()));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>
                (this, LivingEntity.class,  true,livingEntity -> { return livingEntity instanceof Player;}));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>
                (this, LivingEntity.class,  true,livingEntity -> { return !Config.SERVER.blacklisted_targets.get().contains(livingEntity.getEncodeId()) && !(livingEntity instanceof ReconstructedBase);}));
        this.targetSelector.addGoal(3, new BreakBlockGoal(this, this::TestTag));
    }

    /* Old
    protected void decidePOIGoal() {
        if (POIList != null && POIList.size() != 0){
            POIManager manager = new POIManager(this, this.POIList);
            manager.EvaluatePOIOrdering();
            manager.CleanList();
        }
        else{
            SetupPOIList(this);
        }

        if (POIList.size() > 0){
            for (POI poi : POIList){
                int GoalType = poi.Priority;

                switch (GoalType) {
                    case 0 -> this.goalSelector.addGoal(8, new unburyBuriedBlock());
                    case 1 -> this.goalSelector.addGoal(7, new mineBlock());
                    case 2 -> this.goalSelector.addGoal(6, new mineBlock());
                    case 3 -> this.targetSelector.addGoal(5, new attackTarget(this, POIList.get(0).POITarget.getClass(), true, this));
                    case 4 -> this.goalSelector.addGoal(4, new lootChest());
                    case 5 -> this.targetSelector.addGoal(3, new attackTarget(this, POIList.get(0).POITarget.getClass(), true, this));
                    case 6 -> this.targetSelector.addGoal(2, new attackTarget(this, POIList.get(0).POITarget.getClass(), true, this));
                    case 7 -> this.targetSelector.addGoal(1, new attackTarget(this, POIList.get(0).POIPlayerTarget.getClass(), true, this));
                    case 8 -> poi.Priority = -1;
                }
            }
        }
        else{
            CreatePOIGoals();
        }

        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1, false));
    }

    protected void CreatePOIGoals(){
        double searchRange = this.getAttributeBaseValue(Attributes.FOLLOW_RANGE);

        Player nearestPlayer = this.level().getNearestPlayer(this, -1);
        if (nearestPlayer != null){
            POIList.add(new POI(this, nearestPlayer));
        }
        List<LivingEntity> nearestEntities = this.level().getNearbyEntities(LivingEntity.class, TargetingConditions.forCombat(), this,
                AABB.ofSize(this.position(), searchRange, searchRange ,searchRange));
        for (LivingEntity target : nearestEntities){
            if (target != null && target.distanceTo(this) < searchRange){
                POIList.add(new POI(this, (Mob)target));
            }
        }
        if (POIList.size() != 0){
            POIManager manager = new POIManager(this, this.POIList);
            manager.EvaluatePOIOrdering();
            manager.CleanList();
        }
        else{
            POIList.add(new POI(8, -1, -1, null, null, this));
        }
    }
     */

    boolean TestTag(BlockState givenE){
        for (String tag : Config.SERVER.juicy_blocks.get()){if(givenE.is(BlockTags.create(new ResourceLocation(tag)))){ return true;}}
        return false;
    }

    //New goals
    public class DelayedMovementGoal extends Goal {
        private final ReconstructedBase parent;
        private int tickCounter = 0;
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
            tickCounter++;
            if (parent.getAIState() == ReconstructedBase.state.Running.ordinal() && tickCounter % delay <= 5){
                tickCounter++;
            }
            if (tickCounter % delay >= 5){
                if (parent.getNavigation().getPath() == null) {
                    if (oldPath != null){
                        parent.getNavigation().moveTo(oldPath, getSpeed());
                    }
                    else if (getAIState() == state.Running.ordinal()){
                        target = parent.getTarget();
                        if (target != null) {
                            parent.getNavigation().moveTo(target, 1.0D); // Move towards the target
                        }
                        else {
                            stop();
                        }
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
        private final Predicate<BlockState> targetType;


        public BreakBlockGoal(ReconstructedBase parent, Predicate<BlockState> states){
            this.parent = parent;
            breakProgress = 0;
            targetType = states;
        }
        @Override
        public boolean canUse() {
            if (parent.isAggressive()){
                return false;
            }
            if (parent.JuicyBlock == null){
                FindJuicyBlock();
            }
            return true;
        }

        @Override
        public boolean canContinueToUse() {
            if (parent.isAggressive()){
                return false;
            }
            return true;
        }

        @Override
        public void tick() {
            if (parent.JuicyBlock != null){
                AttemptToBreakBlock();
            }
            else{
                if (parent.tickCount % 20 == 0){
                    parent.JuicyBlock = FindJuicyBlock();
                }
            }
        }

        void MoveToBlock(){
            parent.getNavigation().moveTo(JuicyBlock.getX(), JuicyBlock.getY(), JuicyBlock.getZ(), parent.getSpeed());
        }

        void AttemptToBreakBlock(){
            if (parent.distanceToSqr(parent.JuicyBlock.getX(), parent.JuicyBlock.getY(), parent.JuicyBlock.getZ()) < 1){
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
            }
            else{
                MoveToBlock();
            }
        }

        public BlockPos FindJuicyBlock() {
            AABB aabb = parent.getBoundingBox().inflate(16);
            BlockPos ClosestBlock = null;
            for(BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
                BlockState state = parent.level().getBlockState(blockpos);
                double d0 = Double.MAX_VALUE;
                if (targetType.test(state)){
                    if (blockpos.distToCenterSqr(parent.position())<d0){
                        ClosestBlock = blockpos;
                        d0 = blockpos.distToCenterSqr(parent.position());
                    }
                }
            }
            return ClosestBlock;
        }
    }
    /* Old/Unused
    public class unburyBuriedBlock extends Goal{
        Vec3 poiPos = POIList.get(0).POIPos;
        @Override
        public boolean canUse() {
            return POIList.get(0).Priority == 0;
        }

        //Unbury code
    }

    public class mineBlock extends Goal{
        Vec3 poiPos = POIList.get(0).POIPos;
        @Override
        public boolean canUse() {
            return POIList.get(0).Priority == 1 || POIList.get(0).Priority == 2;
        }
        //Block breaking code
    }

    public class attackTarget extends NearestAttackableTargetGoal {
        POI givenPOI;
        ReconstructedBase parent;

        public attackTarget(Mob mob, Class mobClass, boolean mustSee, ReconstructedBase parent) {
            super(mob, mobClass, mustSee);
            givenPOI = POIList.get(0);
            this.parent = parent;
        }

        @Override
        public boolean canUse() {
            boolean superFlag = super.canUse();
            boolean flag;
            flag = POIList.get(0).Priority == 3 || POIList.get(0).Priority == 5 || POIList.get(0).Priority == 6 || POIList.get(0).Priority == 7;

            return superFlag && flag;
        }

        @Override
        public boolean canContinueToUse() {
            boolean superCCTU = super.canContinueToUse();
            POIManager manager = new POIManager(this.parent, POIList);
            manager.EvaluatePOIOrdering();
            manager.CleanList();

            return superCCTU && POIList.get(0) == givenPOI;
        }

        @Override
        public void tick() {
            super.tick();
        }

        @Override
        public void start() {
            super.start();
        }

        @Override
        public void stop() {
            super.stop();
            givenPOI.Priority = -1; //Setting it to -1 denotes it for removal next POIManager.CleanList();
        }
    }
    public class attackTargetOmniscient extends attackTarget{
        public attackTargetOmniscient(Mob mob, Class mobClass, ReconstructedBase parent) {
            super(mob, mobClass, false, parent);
        }
    }

    public class lootChest extends Goal{
        Vec3 poiPos = POIList.get(0).POIPos;
        @Override
        public boolean canUse() {
            return POIList.get(0).Priority == 4;
        }
        //Loot-stealing code
    }
     */
    /**/

    //Methods

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

    //POI management methods (These are unused but commenting them out gives an error thanks to POI requiring them)
    public POI ReapplyTargetFor(POI poi){
        if (poi.Priority == 7){
            poi.POIPlayerTarget = this.level().getNearestPlayer(this, this.getAttributeBaseValue(Attributes.FOLLOW_RANGE));
            poi.POITarget = null;
            if (poi.POIPlayerTarget != null){
                poi.POIPos = poi.POIPlayerTarget.position();
            }
            else{
                poi.Priority = -1;
            }
            poi.BlockValue = -1;
            poi.BlockDepth = -1;
        }
        if (poi.Priority == 3 || poi.Priority == 5 || poi.Priority == 6){
            Class targetClass;
            try {
                targetClass = Class.forName(poi.targetID);
            } catch (ClassNotFoundException e) {
                targetClass = LivingEntity.class;
            }
            List<LivingEntity> nearbyEntities = this.level().getNearbyEntities(targetClass, TargetingConditions.forNonCombat(), this,
                    AABB.ofSize(poi.POIPos, 2, 2, 2));

            poi.POITarget = (Mob)nearbyEntities.get(0);

            for (LivingEntity entity : nearbyEntities){
                if (entity.distanceToSqr(poi.POIPos) < poi.POITarget.distanceTo(poi.POITarget)){
                    poi.POITarget = (Mob)entity;
                }
            }

            poi.Priority = Steampunked.GetMobPriorityFor(poi.POITarget);
            poi.POIPlayerTarget = null;
            poi.POIPos = poi.POITarget.position();
            poi.BlockValue = -1;
            poi.BlockDepth = -1;
        }

        return poi;
    }

    public BlockState GetBlockStateFor(BlockPos blockPos){
        return this.level().getBlockState(blockPos);
    }
    /**/

    protected SoundEvent getStepSound(){
        return ModSounds.RECON_WALK.get();
    }
}
