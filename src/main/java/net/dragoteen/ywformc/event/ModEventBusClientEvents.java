package net.dragoteen.ywformc.event;

import net.dragoteen.ywformc.YoKaiWatchForMinecraftMod;
import net.dragoteen.ywformc.entity.client.JibanyanModel;
import net.dragoteen.ywformc.entity.client.ModModelLayers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = YoKaiWatchForMinecraftMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)

public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.JIBANYAN_LAYER, JibanyanModel::createBodyLayer);
    }
}
