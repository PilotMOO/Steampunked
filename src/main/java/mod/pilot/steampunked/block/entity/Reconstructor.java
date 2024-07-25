package mod.pilot.steampunked.block.entity;

import mod.azure.azurelib.animatable.GeoBlockEntity;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.util.AzureLibUtil;
import mod.pilot.steampunked.block.ModBlocks;
import mod.pilot.steampunked.items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class Reconstructor extends BaseEntityBlock{
    public Reconstructor(Properties pProperties) {
        super(pProperties);
    }

    public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 20, 16);
    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new ReconstructorEntity(pPos, pState);
    }
    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston) {
        if (pState.getBlock() != pNewState.getBlock()){
            BlockEntity BEntity = pLevel.getBlockEntity(pPos);
            if (BEntity instanceof ReconstructorEntity){
                ((ReconstructorEntity)BEntity).DropInventoryResources();
            }
        }

        super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(CanDisableWithItem(pPlayer.getItemInHand(pHand))){
            BlockEntity BEntity = pLevel.getBlockEntity(pPos);
            if (BEntity instanceof ReconstructorEntity){
                ((ReconstructorEntity)BEntity).Break();
                pLevel.explode(pPlayer, pPos.getCenter().x, pPos.getCenter().y, pPos.getCenter().z, 3f, Level.ExplosionInteraction.BLOCK); //Temporary
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.FAIL;
    }

    private boolean CanDisableWithItem(ItemStack item){
        if (item.is(ModItems.TESTITEM.get())){
            return true;
        }
        return false;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        if (pLevel.isClientSide){
            return null;
        }

        return createTickerHelper(pBlockEntityType, BlockEntities.RECONSTRUCTOR_ENTITY.get(),
                (pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1, pPos, pState1));
    }
}
