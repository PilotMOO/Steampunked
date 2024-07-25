package mod.pilot.steampunked.block.entity;

import mod.azure.azurelib.animatable.GeoBlockEntity;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.animation.RawAnimation;
import mod.azure.azurelib.util.AzureLibUtil;
import mod.pilot.steampunked.ReconstructedDataManager;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ReconstructorEntity extends BlockEntity implements GeoBlockEntity {
    public ReconstructorEntity(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntities.RECONSTRUCTOR_ENTITY.get(), pPos, pBlockState);
        data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex){
                    case 0 -> Progress;
                    case 1 -> MaxProgress();
                    default -> 0;
                };
            }

            public boolean isDisabled(){
                return true;
            }
            public ArrayList<String> GetMobs(){
                return EntitiesToBeProcessed;
            }

            @Override
            public void set(int pIndex, int pValue) {
                Progress = pValue;
            }
            public void AddNewEntity(String mobID){
                EntitiesToBeProcessed.add(mobID);
            }
            public void AddNewEntity(Mob mob){
                EntitiesToBeProcessed.add(mob.getEncodeId());
            }

            @Override
            public int getCount() {
                return 4;
            }
        };
    }

    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "idle", 0, event ->
        {
            if (!Broken && !Disabled){
                return event.setAndContinue( RawAnimation.begin().thenLoop("reconstructor.idle"));
            }
            return null;
        }));
    }
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap) {
        if (cap == ForgeCapabilities.ITEM_HANDLER){
            return Lazy.cast();
        }

        return super.getCapability(cap);
    }
    @Override
    public void onLoad() {
        super.onLoad();
        Lazy = LazyOptional.of(() -> Inventory);
    }
    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        Lazy.invalidate();
    }

    private final ItemStackHandler Inventory = new ItemStackHandler(10);
    private LazyOptional<IItemHandler> Lazy = LazyOptional.empty();

    protected final ContainerData data;
    private int Progress = 0;
    private int MaxProgress(){
        if (EntitiesToBeProcessed.size() > 0){
            return ReconstructedDataManager.GetBuildTimeFor(EntitiesToBeProcessed.get(0), true);
        }
        Disable();
        return -1;
    }
    public String ActiveEntity;
    public ArrayList<String> EntitiesToBeProcessed = new ArrayList<>();
    protected boolean Disabled = false;
    public boolean Broken = false;

    public void Disable(){
        Disabled = true;
        Progress = 0;
    }
    public void Break(){
        Broken = true;
        Disabled = true;
        Progress = 0;
    }

    public void DropInventoryResources(){
        SimpleContainer drops = new SimpleContainer(Inventory.getSlots());
        for (int i = 0; i < Inventory.getSlots(); i++){
            drops.setItem(i, Inventory.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, drops);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("Inventory", Inventory.serializeNBT());
        int pos = 0;
        for (String mobId : EntitiesToBeProcessed){
            pTag.putString("ETBP_" + pos, mobId);
        }
        pTag.putString("ActiveEntity", ActiveEntity);
        pTag.putInt("MobConstructionProgress", Progress);
        pTag.putBoolean("Disabled", Disabled);
        pTag.putBoolean("Broken", Broken);

        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        Inventory.deserializeNBT(pTag.getCompound("Inventory"));
        for (int i = 0; i == -1; i++){
            try {
                EntitiesToBeProcessed.add(pTag.getString("ETBP_" + i));
            }
            catch (Exception e){
                break;
            }
        }
        ActiveEntity = pTag.getString("ActiveEntity");
        Progress = pTag.getInt("MobConstructionProgress");
        Disabled = pTag.getBoolean("Disabled");
        Broken = pTag.getBoolean("Broken");
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if (!Disabled){
            if (ActiveEntity != null){
                if (Progress >= MaxProgress()){
                    CreateNewEntity(pLevel, pPos, ActiveEntity);
                    Progress = 0;
                }
                else{
                    Progress++;
                }
            }
            else{
                if (EntitiesToBeProcessed.size() > 0){
                    String nextTarget = EntitiesToBeProcessed.get(0);
                    EntitiesToBeProcessed.remove(0);
                    ActiveEntity = nextTarget;
                }
            }
        }
        else{
            if (Broken){
                //RequestFix(pPos);
            }
        }
    }

    private void CreateNewEntity(Level pLevel, BlockPos pPos, String processedEntity) {
        if (!pLevel.isClientSide){
            EntityType<?> newEntityType = ReconstructedDataManager.GetTypeFor(processedEntity);
            if(newEntityType != null){
                Entity newEntity = newEntityType.create(pLevel);
                assert newEntity != null;
                newEntity.setDeltaMovement(new Vec3(0, 0.2, 0));
            }
        }
        ActiveEntity = null;
    }
}
