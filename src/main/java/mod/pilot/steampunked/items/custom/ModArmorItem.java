package mod.pilot.steampunked.items.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import mod.pilot.steampunked.items.ModArmorMaterials;

import java.util.Map;

public class ModArmorItem extends ArmorItem {
    public ModArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }

    private static final Map<ArmorMaterial, MobEffectInstance> MATERIAL_TO_EFFECT_MAP = (new ImmutableMap.Builder<ArmorMaterial, MobEffectInstance>())
            .put(ModArmorMaterials.TEST, new MobEffectInstance(MobEffects.HUNGER, 20, 10, false, false, true)).build();

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if(!level.isClientSide()){
            if(HasFullSuitOfArmorOn(player)){
                evaluateArmorEffects(player);
            }
        }
    }

    private void evaluateArmorEffects(Player player){
        for (Map.Entry<ArmorMaterial, MobEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()){
            if (HasCorrectArmorOn(entry.getKey(), player)){
                addStatusEffectForMaterial(player, entry.getKey(), entry.getValue());
            }
        }
    }

    private void addStatusEffectForMaterial(Player player, ArmorMaterial material, MobEffectInstance effect){
        boolean PlayerHasEffect = player.hasEffect(effect.getEffect());

        if (HasCorrectArmorOn(material, player) && !PlayerHasEffect){
            player.addEffect(new MobEffectInstance(effect));
        }
    }

    private boolean HasFullSuitOfArmorOn(Player player){
        ItemStack Boots = player.getInventory().getArmor(0);
        ItemStack Leggings = player.getInventory().getArmor(1);
        ItemStack Chestplate = player.getInventory().getArmor(2);
        ItemStack Helmet = player.getInventory().getArmor(3);

        return !Boots.isEmpty() && !Leggings.isEmpty() && !Chestplate.isEmpty() && !Helmet.isEmpty();
    }

    private boolean HasCorrectArmorOn(ArmorMaterial material, Player player){
        for (ItemStack armorStack : player.getInventory().armor){
            if (!(armorStack.getItem() instanceof ArmorItem)){
                return false;
            }
        }

        ArmorItem Helmet = ((ArmorItem)player.getInventory().getArmor(3).getItem());
        ArmorItem Chestplate = ((ArmorItem)player.getInventory().getArmor(2).getItem());
        ArmorItem Leggings = ((ArmorItem)player.getInventory().getArmor(1).getItem());
        ArmorItem Boots = ((ArmorItem)player.getInventory().getArmor(0).getItem());

        return Helmet.getMaterial() == material && Chestplate.getMaterial() == material && Helmet.getMaterial() == material && Boots.getMaterial() == material;
    }
}
