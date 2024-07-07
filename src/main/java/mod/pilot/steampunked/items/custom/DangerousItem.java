package mod.pilot.steampunked.items.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import mod.pilot.steampunked.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DangerousItem extends Item {
    public DangerousItem (Properties properties){
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interaction) {
        level.playSeededSound(null, player.getX(), player.getY(), player.getZ(),
                ModSounds.TEST_SOUND.get(), SoundSource.PLAYERS, 1f, 1f, 0);
        player.hurt(player.damageSources().explosion(player, player), 20);
        level.explode(player, player.getX(), player.getY(), player.getZ(), 2.0f, Level.ExplosionInteraction.BLOCK);
        player.getItemInHand(interaction).hurtAndBreak(1, player, Player -> player.broadcastBreakEvent(player.getUsedItemHand()));
        return InteractionResultHolder.consume(player.getItemInHand(interaction));
    }

    @Override
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> componets, TooltipFlag flag) {
        componets.add(Component.translatable("tooltips.steampunked.dangerous_item.tooltip"));
        super.appendHoverText(item, level, componets, flag);
    }
}
