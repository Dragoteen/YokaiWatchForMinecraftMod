package net.dragoteen.ywformc.input;

import net.dragoteen.ywformc.YoKaiWatchForMinecraftMod;
import net.dragoteen.ywformc.screen.WatchSlotScreen;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = YoKaiWatchForMinecraftMod.MODID, value = Dist.CLIENT)
public class KeyInputHandler {

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) return;

        while (KeyBindings.OPEN_WATCH.consumeClick()) {
            mc.setScreen(new WatchSlotScreen(mc.player));
        }
    }
}