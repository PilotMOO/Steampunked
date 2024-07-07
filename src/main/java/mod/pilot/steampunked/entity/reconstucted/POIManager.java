package mod.pilot.steampunked.entity.reconstucted;

import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;

public class POIManager {
    private enum MobClass{
        Basic
    }

    private ReconstructedBase entity;
    private ArrayList<POI> POIList;

    /**The POIManager is the go-to method to handle POIs, feed it the entity and their POIList and you get access to a range of methods to handle
     * POILists and their contents!*/
    public POIManager(ReconstructedBase entity, ArrayList<POI> POIList){
        this.entity = entity;
        this.POIList = POIList;
    }

    /**Used to sort the given POIList of this POIManager according to the entity's "MobClass", so higher priority and closer POIs are sorted closer to index 0,
     * with lower priority and farther POIs higher in the index, closer to POIListMax.*/
    public void EvaluatePOIOrdering(){
        if (POIList != null && POIList.size() > 0){
            switch (entity.MobClass){
                case 0:
                    POIList.sort(POIManager::BasicPOISort);
                    break;
                default:
                    POIList.sort(POIManager::BasicPOISort);
            }

            entity.POIList = this.POIList;
        }
    }

    /**Used to clean out the list, removing any empty POIs, POIs that are too far, and any excess POIs that exceed the POIListMax.
     * Make sure to call AFTER EvaluatePOIOrdering() is called to ensure the removed POIs are of lower priority!*/
    public void CleanList(){
        if (POIList != null && POIList.size() > 0){
            for (POI poi : POIList){
                if (poi.Priority == -1){
                    POIList.remove(poi);
                    continue;
                }
                else if (poi.Priority == 7 && poi.POIPlayerTarget == null){
                    poi = entity.ReapplyTargetFor(poi);
                }
                else if ((poi.Priority == 3 || poi.Priority == 5 || poi.Priority == 6) && poi.POITarget == null){
                    poi = entity.ReapplyTargetFor(poi);
                }
                if (poi.POIPos.distanceTo(poi.parent.position()) > poi.parent.POIMemoryRange){
                    POIList.remove(poi);
                }
                if (poi.parent == null){
                    poi.parent = entity;
                }
            }
            if (POIList.size() > entity.POIListMax){
                for (int i = POIList.size() - 1; i <= entity.POIListMax; i--){
                    POIList.remove(i);
                }
            }

            entity.POIList = this.POIList;
        }
    }

    /**Sorts the POIs according to their default priority, higher priorities get sorted first, lower ones last. If two POIs have the same priority,
     * evaluates the distance between them and the entity's position, and sorts the closer one first*/
    public static int BasicPOISort(POI poi1, POI poi2){
        int poi1Priority = poi1.Priority;
        int poi2Priority = poi2.Priority;

        if(poi1 == null){
            return 0;
        }
        if(poi2 == null){
            return 1;
        }

        if(poi1Priority == poi2Priority){
            if (poi1Priority != 0){
                Vec3 poi1pos = poi1.POIPos;
                Vec3 poi2pos = poi2.POIPos;
                Vec3 entityPos = poi1.parent.position();

                double poi2toEntity = poi2pos.distanceTo(entityPos);

                if (poi1pos.closerThan(poi2pos, poi2toEntity)){
                    return 1;
                }
                else{
                    return 0;
                }
            }
            else if (poi1Priority == 1){
                return 1; //Add Priority for base griefing
            }
            else{
                return 1; //Add PoLR for buried block
            }
        }
        else{
            if (poi1Priority > poi2Priority){
                return 1;
            }
            else{
                return 0;
            }
        }
    }
}
