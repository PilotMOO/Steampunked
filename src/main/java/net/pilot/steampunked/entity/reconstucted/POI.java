package net.pilot.steampunked.entity.reconstucted;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.pilot.steampunked.Steampunked;

import javax.annotation.Nullable;

public class POI {
    private enum POIDetails{
        BlockBuried, //0
        GriefBase, //1
        BlockUncovered, //2
        EntityLowPriority, //3
        CheckChest, //4
        EntityMidPriority, //5
        EntityHighPriority, //6
        PlayerTarget //7
    }

    public POI(ReconstructedBase parent, BlockPos block){
        this.parent = parent;
        BlockState blockState = parent.GetBlockStateFor(block);
        this.BlockValue = Steampunked.GetBlockValueFor(blockState);
        //Set up fucking... Block depth thingy
        this.POIPos = block.getCenter();
    }
    public POI(ReconstructedBase parent, Mob target){
        int priorityCheck = (int)Steampunked.GetMobPriorityFor(target);
        if (priorityCheck == 1){
            this.Priority = 3;
        }
        else if (priorityCheck == 2){
            this.Priority = 5;
        }
        else if (priorityCheck == 3){
            this.Priority = 6;
        }
        else{
            this.Priority = -1;
        }
        this.POIPos = target.getPosition(1);
        this.POITarget = target;
        this.parent = parent;

        this.BlockDepth = -1;
        this.BlockValue = -1;
    }
    public POI(ReconstructedBase parent, Player player){
        this.Priority = 7;
        this.BlockValue = -1;
        this.BlockDepth = -1;
        this.POIPos = player.position();
        this.POITarget = null;
        this.POIPlayerTarget = player;
        this.parent = parent;
    }
    public POI(int priority, int blockValue, int blockDepth, Vec3 poiPos, String targetID, ReconstructedBase parent){
        this.Priority = priority;
        this.BlockValue = blockValue;
        this.BlockDepth = blockDepth;
        this.POIPos = poiPos;
        this.targetID = targetID;
        this.parent = parent;
    }

    public int Priority;
    public int BlockValue;
    public int BlockDepth;
    public Vec3 POIPos;
    public Mob POITarget;
    public Player POIPlayerTarget;
    public String targetID;
    public ReconstructedBase parent;
}
