package mod.pilot.steampunked.items;

import mod.pilot.steampunked.Steampunked;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import mod.pilot.steampunked.util.ModTag;

import java.util.List;

public class ModToolTiers {
    public static final Tier TEST = TierSortingRegistry.registerTier(
            new ForgeTier(-1, 3, 0.1f, 0.1f, 0,
                    ModTag.Blocks.NEEDS_TEST_TOOL, () -> Ingredient.of(ModItems.TESTITEM.get())),
            new ResourceLocation(Steampunked.MOD_ID, "test"), List.of(), List.of(Tiers.WOOD)
    );
}
