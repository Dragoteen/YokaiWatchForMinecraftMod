package net.dragoteen.ywformc.capability;

import net.dragoteen.ywformc.YoKaiWatchForMinecraftMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = YoKaiWatchForMinecraftMod.MODID)
public class WatchCapabilityEvents {

    // Enregistrement de la capability
    @Mod.EventBusSubscriber(modid = YoKaiWatchForMinecraftMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEvents {
        @SubscribeEvent
        public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
            event.register(WatchCapability.class);
        }
    }

    // Attache la capability à chaque joueur
    @SubscribeEvent
    public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {
            event.addCapability(
                    new ResourceLocation(YoKaiWatchForMinecraftMod.MODID, "watch"),
                    new WatchCapabilityProvider()
            );
        }
    }

    // Copie la capability quand le joueur respawn ou revient du End
    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        event.getOriginal().reviveCaps();
        event.getOriginal().getCapability(WatchCapabilityProvider.WATCH_CAP).ifPresent(oldCap -> {
            event.getEntity().getCapability(WatchCapabilityProvider.WATCH_CAP).ifPresent(newCap -> {
                newCap.setWatch(oldCap.getWatch());
            });
        });
        event.getOriginal().invalidateCaps();
    }
}