package net.dragoteen.ywformc.item.custom;

import net.dragoteen.ywformc.medallium.MedalliumSet;
import net.dragoteen.ywformc.screen.MedalliumMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

public class Medallium extends Item {

    private final MedalliumSet set;

    public Medallium(MedalliumSet set, Properties pProperties) {
        super(pProperties);
        this.set = set;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide()) {
            ServerPlayer serverPlayer = (ServerPlayer) player;

            MenuProvider provider = new MenuProvider() {
                @Override
                public @NotNull Component getDisplayName() {
                    return Component.translatable("gui.ywformc.medallium");
                }

                @Override
                public AbstractContainerMenu createMenu(int id, @NotNull Inventory inv, @NotNull Player p) {
                    return new MedalliumMenu(id, inv, set, 0);
                }
            };

            NetworkHooks.openScreen(serverPlayer, provider, buf -> {
                buf.writeEnum(set);
                buf.writeInt(0);
            });
        }
        return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), level.isClientSide());
    }
}