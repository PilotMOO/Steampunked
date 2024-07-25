package mod.pilot.steampunked;

import mod.pilot.steampunked.dataTypes.MobConversion;
import mod.pilot.steampunked.entity.reconstucted.ReconstructedBase;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.HashMap;

public class ReconstructedDataManager {
    private static final HashMap MobTargetPriorityHashmap = new HashMap<Mob, Integer>(){

    };
    public static int GetMobPriorityFor(Mob mob){
        int priority = 0;
        try{
            priority = (int)MobTargetPriorityHashmap.get(mob);
        }
        catch (Exception e){
            priority = -1;
        }
        finally {
            return priority;
        }
    }

    private static final HashMap BlockValueHashmap = new HashMap<BlockState, Integer>(){

    };
    public static int GetBlockValueFor(BlockState block){
        int value = 0;
        try{
            value = (int)BlockValueHashmap.get(block);
        }
        catch (Exception e){
            value = -1;
        }
        finally {
            return value;
        }
    }

    public static final ArrayList<ReconstructedBase> allReconMobs = new ArrayList<ReconstructedBase>(){

    };
    public static final ArrayList<ReconstructedBase> allReconMobTypes = new ArrayList<ReconstructedBase>(){

    };

    public static final ArrayList<MobConversion> MobConversions = new ArrayList<MobConversion>(){

    };
    public static void EstablishConfiguredBuildTimes(){
        for (String ConfiguredConversion : Config.SERVER.mob_build_times.get()){
            String[] Split = ConfiguredConversion.split("|", 4);
            MobConversion newConverted = new MobConversion(Split[0], Split[1], Integer.parseInt(Split[2]), Integer.parseInt(Split[3]));
            MobConversions.add(newConverted);
        }
    }
    public static int GetBuildTimeFor(String mobID, boolean unconverted){
        int buildTime = -1;
        for (MobConversion conversion : MobConversions){
            if (unconverted){
                if (conversion.UnconvertedEquals(mobID)){
                    buildTime = conversion.BuildTime;
                    break;
                }
            }
            else{
                if (conversion.ConvertedEquals(mobID)){
                    buildTime = conversion.BuildTime;
                    break;
                }
            }
        }

        return buildTime;
    }
    public static int GetBuildTimeFor(Mob mob, boolean unconverted){
        int buildTime = -1;
        for (MobConversion conversion : MobConversions){
            if (unconverted){
                if (conversion.UnconvertedEquals(mob)){
                    buildTime = conversion.BuildTime;
                    break;
                }
            }
            else{
                if (conversion.ConvertedEquals(mob)){
                    buildTime = conversion.BuildTime;
                    break;
                }
            }
        }

        return buildTime;
    }
    public static EntityType<?> GetTypeFor(String mobID){
        EntityType<?> Type = null;
        for (MobConversion conversion : MobConversions){
            if (conversion.UnconvertedEquals(mobID)){
                Type = conversion.GetConverted();
                break;
            }
        }
        return Type;
    }
    public static EntityType<?> GetTypeFor(Mob mob){
        EntityType<?> Type = null;
        for (MobConversion conversion : MobConversions){
            if (conversion.UnconvertedEquals(mob)){
                Type = conversion.GetConverted();
                break;
            }
        }
        return Type;
    }
}
