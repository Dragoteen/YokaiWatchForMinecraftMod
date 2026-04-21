package net.dragoteen.ywformc.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.dragoteen.ywformc.YoKaiWatchForMinecraftMod;
import net.dragoteen.ywformc.block.ModBlocks;
import net.dragoteen.ywformc.item.ModItems;
import net.dragoteen.ywformc.villager.ModVillagers;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = YoKaiWatchForMinecraftMod.MODID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {

        if(event.getType() == VillagerProfession.CLERIC) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            // LEVEL 1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.AMULETTE_COLOREE.get(), 1),
                    100, 5, 0.02f
            ));

            // LEVEL 3
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModBlocks.BLOC_DE_MAGNETITE.get(), 10),
                    new ItemStack(ModItems.YOKAI_PAD.get(), 1),
                    2, 20, 0f
            ));

        }


        if(event.getType() == ModVillagers.WATCHMAKER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            // LEVEL 1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 3),
                    new ItemStack(Items.CLOCK, 1),
                    30, 2, 0.01f
            ));

            // LEVEL 5
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.NETHERITE_INGOT, 5),
                    new ItemStack(ModItems.YOKAI_WATCH.get(), 1),
                    1, 50, 0f
            ));

        }
    }
}
