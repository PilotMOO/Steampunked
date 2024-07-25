package mod.pilot.steampunked.dataTypes;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.registries.ForgeRegistries;
import org.antlr.v4.runtime.misc.NotNull;

public class MobConversion {
    private enum BuildType{
        Reconstructed, //0
        Rebuilt, //1
        Innovation //2
    }


    public final int Type;
    public final int BuildTime;
    public final String OriginMobID;
    public final String NewMobID;

    public MobConversion(String OriginMob, String NewMob, int buildTime, int type){
        OriginMobID = OriginMob;
        NewMobID = NewMob;
        BuildTime = buildTime;
        Type = type;
    }
    public MobConversion(LivingEntity OriginMob, LivingEntity NewMob, int buildTime, int type){
        OriginMobID = OriginMob.getEncodeId();
        NewMobID = NewMob.getEncodeId();
        BuildTime = buildTime;
        Type = type;
    }

    public EntityType<?> GetUnconverted(){
        ResourceLocation mobResource = new ResourceLocation(OriginMobID);
        return ForgeRegistries.ENTITY_TYPES.getValue(mobResource);
    }
    public EntityType<?> GetConverted(){
        ResourceLocation mobResource = new ResourceLocation(NewMobID);
        return ForgeRegistries.ENTITY_TYPES.getValue(mobResource);
    }

    public boolean UnconvertedEquals(String mobID){
        return mobID.matches(OriginMobID);
    }
    public boolean UnconvertedEquals(LivingEntity mob){
        if (mob != null && mob.getEncodeId() != null){
            return mob.getEncodeId().matches(OriginMobID);
        }
        return false;
    }
    public boolean ConvertedEquals(String mobID){
        return mobID.matches(NewMobID);
    }
    public boolean ConvertedEquals(LivingEntity mob){
        if (mob != null && mob.getEncodeId() != null){
            return mob.getEncodeId().matches(NewMobID);
        }
        return false;
    }
}
