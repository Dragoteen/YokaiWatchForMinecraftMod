package net.dragoteen.ywformc.medallium;

import net.dragoteen.ywformc.YoKaiWatchForMinecraftMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = YoKaiWatchForMinecraftMod.MODID)
public class MedalliumProgressEvents {

    private static final ResourceLocation ID =
            new ResourceLocation(YoKaiWatchForMinecraftMod.MODID, "medallium_progress");

    @SubscribeEvent
    public static void onAttachCapabilities(AttachCapabilitiesEvent<net.minecraft.world.entity.Entity> event) {
        if (event.getObject() instanceof Player) {
            MedalliumProgressProvider provider = new MedalliumProgressProvider();
            event.addCapability(ID, provider);
        }
    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        event.getOriginal().getCapability(MedalliumProgressProvider.MEDALLIUM_PROGRESS).ifPresent(oldStore -> {
            event.getEntity().getCapability(MedalliumProgressProvider.MEDALLIUM_PROGRESS).ifPresent(newStore -> {
                newStore.deserializeNBT(oldStore.serializeNBT());
            });
        });
    }

    public static IMedalliumProgress getProgress(Player player) {
        return player.getCapability(MedalliumProgressProvider.MEDALLIUM_PROGRESS)
                .orElseThrow(() -> new IllegalStateException("Medallium progress capability missing"));
    }
}