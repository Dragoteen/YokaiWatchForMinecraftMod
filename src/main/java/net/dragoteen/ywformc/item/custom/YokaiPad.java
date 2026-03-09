package net.dragoteen.ywformc.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class YokaiPad extends Item {

    public YokaiPad(Properties pProperties) {
        super(pProperties);
    }

    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {

        player.sendSystemMessage(Component.literal("§aYo-kai Pad ouvert !"));

        return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), level.isClientSide());
    }
}
