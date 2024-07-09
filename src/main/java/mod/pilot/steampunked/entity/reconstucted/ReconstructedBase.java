package mod.pilot.steampunked.entity.reconstucted;

import mod.azure.azurelib.animatable.GeoEntity;
import mod.pilot.steampunked.Config;
import mod.pilot.steampunked.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import mod.pilot.steampunked.Steampunked;
import net.minecraftforge.fluids.FluidType;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

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

    public int DeathAnimationLength = 40;

    protected enum state{
        Idle, //0
        Walking, //1
        Running, //2
        Mining, //3
        FeedingReconstructor, //4
        Dying //5
    }
    public int AIState = -1;

    protected int MoveDecay = 0;
    protected static final int MoveDecayMax = 20;
    public boolean isMovingSmart() {
        if (getDeltaMovement().x != 0 || getDeltaMovement().z != 0) {
            MoveDecay = 0;
        }
        else if (getNavigation().getPath() == null){
            return false;
        }
        else
        {
            if (MoveDecay > MoveDecayMax){
                return false;
            }
        }
        return true;
    }
    /**/

    //NBT related
    /* Uses old stuff
    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        int index = 0;
        if (POIList != null && POIList.size() > 0){
            POIManager manager = new POIManager(this, POIList);
            manager.EvaluatePOIOrdering();
            manager.CleanList();
            for (POI poi : POIList){
                tag.putIntArray("POI_" + index + "_Values_Array", new int[]{ poi.Priority, poi.BlockValue, poi.BlockDepth});
                if (poi.POITarget != null){
                    tag.putString("POI_" + "_Target_ID", poi.POITarget.toString());
                }
                tag.putDouble("POI_" + index + "_Pos_X", poi.POIPos.x);
                tag.putDouble("POI_" + index + "_Pos_Y", poi.POIPos.y);
                tag.putDouble("POI_" + index + "_Pos_Z", poi.POIPos.z);
            }
        }
    }
    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (POIList != null && POIList.size() > 0){
            for (int i = 0; i == POIListMax; i++){
                int[] values = tag.getIntArray("POI_" + i + "_Values_Array");
                String targetID = tag.getString("POI_" + i + "_Target_ID");
                int priority = -1;
                int blockValue = -1;
                int blockDepth = -1;
                if (values.length > 0){
                    priority = values[0];
                    blockValue = values[1];
                    blockDepth = values[2];
                }
                Vec3 poiPos = new Vec3(tag.getDouble("POI_" + i + "_Pos_X"), tag.getDouble("POI_" + i + "_Pos_Y"),
                        tag.getDouble("POI_" + i + "_Pos_Z"));
                if (POIList.size() < i){
                    this.POIList.add(i, new POI(priority, blockValue, blockDepth, poiPos, targetID, this));
                }
                else{
                    this.POIList.set(i, new POI(priority, blockValue, blockDepth, poiPos, targetID, this));
                }
            }
        }
    }
     */
    /**/

    //Goal and POI management methods
    @Override
    protected void registerGoals() {
        //decidePOIGoal(); Old
        this.goalSelector.addGoal(1, new DelayedMovementGoal(this, 10));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>
                (this, LivingEntity.class,  true,livingEntity -> { return livingEntity instanceof Player;}));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>
                (this, LivingEntity.class,  true,livingEntity -> { return !Config.SERVER.blacklisted_targets.get().contains(livingEntity.getEncodeId()) && !(livingEntity instanceof ReconstructedBase);}));
    }

    public class DelayedMovementGoal extends Goal {
        private final Mob mob;
        private int tickCounter = 0;
        private final int delay;
        private LivingEntity target;
        float priorrot;

        public DelayedMovementGoal(Mob mob, int delay) {
            this.mob = mob;
            this.delay = delay;
            priorrot = mob.getYRot();
        }

        @Override
        public boolean canUse() {
            return mob.getTarget() != null; // This goal should activate if there is a target
        }

        @Override
        public boolean canContinueToUse() {
            return mob.getTarget() != null; // This goal should continue as long as there is a target
        }

        @Override
        public void tick() {
            tickCounter++;
            if (tickCounter % delay >= 5) {
                if (mob.getNavigation().getPath() == null) {
                    target = mob.getTarget();
                    if (target != null) {
                        mob.getNavigation().moveTo(target, 1.0D); // Move towards the target
                    }
                    else {
                        stop();
                    }
                } else {
                    mob.getNavigation().tick(); // Continue along the existing path
                }
            } else {
                mob.setYBodyRot(priorrot);
                mob.getNavigation().stop(); // Temporarily stop navigation updates
            }

            priorrot = mob.getYRot();
        }

        @Override
        public void stop() {
            tickCounter = 0;
        }
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

    //New goals
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

    //Overridden general methods

    @Override
    public void tick() {
        super.tick();
        MoveDecay++;
        if (isMovingSmart()){
            if (isAggressive()){
                AIState = state.Running.ordinal();
            }
            else{
                AIState = state.Walking.ordinal();
            }
        }
        if (getNavigation().getPath() == null){
            AIState = state.Idle.ordinal();
        }
        ManageSounds();
    }

    private int MoveSoundCD = 0;
    private boolean hasPlayedDeath = false;

    public void ManageSounds(){
        if (AIState == state.Dying.ordinal() && !hasPlayedDeath){
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
                if (AIState == state.Walking.ordinal()){
                    if (level().isClientSide()){
                        level().playLocalSound(
                                this.getX(), this.getY(), this.getZ(),
                                getStepSound(),
                                SoundSource.HOSTILE, 0.25F, 1.0F, false);
                    }
                    MoveSoundCD = 10;
                }
                if (AIState == state.Running.ordinal()){
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
        AIState = state.Dying.ordinal();
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
        if (isInWater() && horizontalCollision){
            self().setDeltaMovement(self().getDeltaMovement().add(0.0D, 0.1d, 0.0D));
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
