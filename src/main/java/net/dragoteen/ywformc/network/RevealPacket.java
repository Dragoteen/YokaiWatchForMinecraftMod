package net.dragoteen.ywformc.network;

import net.dragoteen.ywformc.screen.MedalliumMenu;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class RevealPacket {

    public RevealPacket() {}

    public static void encode(RevealPacket packet, FriendlyByteBuf buf) {}

    public static RevealPacket decode(FriendlyByteBuf buf) {
        return new RevealPacket();
    }

    public static void handle(RevealPacket packet, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (player == null) return;
            if (!(player.containerMenu instanceof MedalliumMenu menu)) return;

            menu.reveal(); // gère déjà : vérif isComplete(), rend les 8 médaillons + la récompense, marque revealed

            player.giveExperienceLevels(5);
        });
        ctx.get().setPacketHandled(true);
    }
}