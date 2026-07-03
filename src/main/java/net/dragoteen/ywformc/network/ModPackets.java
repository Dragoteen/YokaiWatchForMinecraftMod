package net.dragoteen.ywformc.network;

import net.dragoteen.ywformc.YoKaiWatchForMinecraftMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModPackets {

    private static final String PROTOCOL = "1";
    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(YoKaiWatchForMinecraftMod.MODID, "main"),
            () -> PROTOCOL,
            PROTOCOL::equals,
            PROTOCOL::equals
    );

    private static int id = 0;

    public static void register() {
        CHANNEL.registerMessage(id++, RevealPacket.class,
                RevealPacket::encode,
                RevealPacket::decode,
                RevealPacket::handle);

        CHANNEL.registerMessage(id++, ChangePagePacket.class,
                ChangePagePacket::encode,
                ChangePagePacket::decode,
                ChangePagePacket::handle);
    }

    public static void sendRevealPacket() {
        CHANNEL.sendToServer(new RevealPacket());
    }

    public static void sendChangePagePacket(int direction) {
        CHANNEL.sendToServer(new ChangePagePacket(direction));
    }
}