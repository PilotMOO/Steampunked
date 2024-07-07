package net.pilot.steampunked.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.Properties;

public class DangerousBlock extends Block {
    public DangerousBlock(Properties properties){
        super(properties);
    }

    @Override
    public void onCaughtFire(BlockState state, Level level, BlockPos pos, @Nullable Direction direction, @Nullable LivingEntity igniter) {
        ExplodeUp(pos, level);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState state2, boolean p_60519_) {
        ExplodeUp(pos, level);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        ExplodeUp(pos, level);
    }

    public static void ExplodeUp(BlockPos pos, Level level){
        for (int i = 0; i < 64; i++){
            level.explode(null, pos.getX(), pos.getY() + i, pos.getZ(), 2, Level.ExplosionInteraction.BLOCK);
        }
        level.removeBlock(pos, false);
    }
}
