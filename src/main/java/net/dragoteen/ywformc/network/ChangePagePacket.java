package net.dragoteen.ywformc.network;

import net.dragoteen.ywformc.medallium.MedalliumSet;
import net.dragoteen.ywformc.screen.MedalliumMenu;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkHooks;

import java.util.function.Supplier;

public class ChangePagePacket {

    private final int direction; // -1 ou +1

    public ChangePagePacket(int direction) {
        this.direction = direction;
    }

    public static void encode(ChangePagePacket packet, FriendlyByteBuf buf) {
        buf.writeInt(packet.direction);
    }

    public static ChangePagePacket decode(FriendlyByteBuf buf) {
        return new ChangePagePacket(buf.readInt());
    }

    public static void handle(ChangePagePacket packet, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (player == null) return;
            if (!(player.containerMenu instanceof MedalliumMenu menu)) return;

            MedalliumSet set = menu.getSet();
            int newIndex = menu.getPageIndex() + packet.direction;
            if (newIndex < 0 || newIndex >= set.size()) return;

            NetworkHooks.openScreen(player,
                    new SimpleMenuProvider(
                            (id, inv, p) -> new MedalliumMenu(id, inv, set, newIndex),
                            Component.translatable("gui.ywformc.medallium")
                    ),
                    buf -> {
                        buf.writeEnum(set);
                        buf.writeInt(newIndex);
                    });
        });
        ctx.get().setPacketHandled(true);
    }
}