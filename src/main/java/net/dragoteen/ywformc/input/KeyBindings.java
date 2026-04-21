package net.dragoteen.ywformc.input;

import com.mojang.blaze3d.platform.InputConstants;
import net.dragoteen.ywformc.YoKaiWatchForMinecraftMod;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;
import net.minecraft.client.KeyMapping;

@Mod.EventBusSubscriber(modid = YoKaiWatchForMinecraftMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class KeyBindings {

    public static final KeyMapping OPEN_WATCH = new KeyMapping(
            "key.ywformc.open_watch",
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_Y,
            "key.categories.ywformc"
    );

    @SubscribeEvent
    public static void onRegisterKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(OPEN_WATCH);
    }
}