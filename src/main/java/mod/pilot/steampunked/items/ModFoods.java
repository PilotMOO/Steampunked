package mod.pilot.steampunked.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties TEST_FOOD = new FoodProperties.Builder().alwaysEat().nutrition(4).saturationMod(1f).effect(
            () -> new MobEffectInstance(MobEffects.LEVITATION, 200, 3), 0.75f).build();
}
