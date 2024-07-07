package mod.pilot.steampunked.util;

import mod.pilot.steampunked.Steampunked;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTag {
    public static class Blocks{
        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(Steampunked.MOD_ID, name));
        }

        public static final TagKey<Block> TEST_BLOCK_TAG = tag("test_block_tag");
        public static final TagKey<Block> NEEDS_TEST_TOOL = tag("needs_test_tool");
    }

    public static class Items{
        private static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(Steampunked.MOD_ID, name));
        }

        public static final TagKey<Item> TEST_ITEM_TAG = tag("test_item_tag");
    }
}
