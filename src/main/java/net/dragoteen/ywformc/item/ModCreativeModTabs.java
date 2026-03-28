package net.dragoteen.ywformc.item;

import net.dragoteen.ywformc.YoKaiWatchForMinecraftMod;
import net.dragoteen.ywformc.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, YoKaiWatchForMinecraftMod.MODID);

    public static final RegistryObject<CreativeModeTab> YO_KAI_WATCH_FOR_MINECRAFT_MOD_TAB = CREATIVE_MODE_TABS.register("ywformc_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.YOKAI_WATCH.get()))
                    .title(Component.translatable("creativetab.ywformc_tab"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModItems.YOKAI_WATCH.get());
                        output.accept(ModItems.YOKAI_WATCH_POCHE.get());
                        output.accept(ModItems.YOKAI_WATCH_ZERO.get());
                        output.accept(ModItems.YOKAI_WATCH_PROTOTYPE_U.get());
                        output.accept(ModItems.YOKAI_WATCH_U1.get());
                        output.accept(ModItems.YOKAI_WATCH_U2.get());
                        output.accept(ModItems.YOKAI_WATCH_UE.get());
                        output.accept(ModItems.YOKAI_WATCH_REVE.get());
                        output.accept(ModItems.TREASURE_WATCH.get());
                        output.accept(ModItems.CRYSTAL_WATCH.get());

                        output.accept(ModItems.YOKAI_WATCH_ANCESTRALE.get());
                        output.accept(ModItems.YOKAI_WATCH_ANCESTRALE_N.get());
                        output.accept(ModItems.YOKAI_WATCH_ANCESTRALE_ZERO.get());
                        output.accept(ModItems.YOKAI_WATCH_ANCESTRALE_GOD.get());
                        output.accept(ModItems.YOKAI_WATCH_OGRE.get());
                        output.accept(ModItems.YOKAI_WATCH_ANIMUS.get());

                        output.accept(ModItems.YOKAI_PAD.get());

                        output.accept(ModItems.BLASTER_YOKAI.get());
                        output.accept(ModItems.FOREUSE_YOKAI.get());
                        output.accept(ModItems.ASPIRATEUR_YOKAI.get());
                        output.accept(ModItems.YOKAI_BAZOOKA.get());
                        output.accept(ModItems.ENMA_BLADE.get());
                        output.accept(ModItems.ENCHANTED_FLUTE.get());

                        output.accept(ModItems.BOOSTOKAI.get());
                        output.accept(ModItems.PISTOKIT.get());
                        output.accept(ModItems.SABROKIT.get());
                        output.accept(ModItems.CARAKIT.get());
                        output.accept(ModItems.HUEDROID.get());

                        output.accept(ModItems.FRAGMENT_DE_YOKAI.get());
                        output.accept(ModItems.VIEIL_ENGRENAGE.get());
                        output.accept(ModItems.GRELOT_FELIN.get());
                        output.accept(ModItems.MONTRE_DE_LUXE.get());
                        output.accept(ModItems.BILLE_MYSTERIEUSE.get());

                        output.accept(ModItems.PLAQUE_DAMULETTE.get());
                        output.accept(ModItems.AMULETTE_FORME_DE_U.get());
                        output.accept(ModItems.AMULETTE_COLOREE.get());

                        output.accept(ModItems.U_UPDATE.get());
                        output.accept(ModItems.Y9_PROCESSOR_CHIP.get());
                        output.accept(ModItems.EXTREME_LAPIS.get());
                        output.accept(ModItems.EXTREME_GOLD.get());

                        output.accept(ModItems.MEDALLIUM.get());
                        output.accept(ModItems.YOVNIKAI_WATCH.get());
                        output.accept(ModItems.CLE_YOKAI_WORLD.get());
                        output.accept(ModItems.TELEMIR_POCHE.get());

                        output.accept(ModItems.CLEYOKANTIK.get());
                        output.accept(ModItems.CLEYOLCANIK.get());
                        output.accept(ModItems.CLEYOKANSTRALE.get());
                        output.accept(ModItems.CLEYOKOURAGE.get());
                        output.accept(ModItems.CLEYOKONNAISSANCE.get());
                        output.accept(ModItems.CLEYOFORCE.get());

                        output.accept(ModItems.UPTOWN_SPRINGDALE_THEME_DISC.get());
                        output.accept(ModItems.MOUNT_WILDWOOD_THEME_DISC.get());
                        output.accept(ModItems.BLOSSOM_HEIGHTS_THEME_DISC.get());
                        output.accept(ModItems.SHOPPERS_ROW_THEME_DISC.get());
                        output.accept(ModItems.DOWNTOWN_SPRINGDALE_THEME_DISC.get());
                        output.accept(ModItems.BREEZY_HILLS_THEME_DISC.get());
                        output.accept(ModItems.EXCELLENT_TOWER_THEME_DISC.get());
                        output.accept(ModItems.SPARKOPOLIS_THEME_DISC.get());
                        output.accept(ModItems.YOKAI_WORLD_THEME_DISC.get());


                        output.accept(ModBlocks.BLOC_DE_MAGNETITE.get());
                        output.accept(ModBlocks.WATCHMAKERS_WORKBENCH.get());
                        output.accept(ModBlocks.ASCANIK_ISLAND_LOCK.get());
                        output.accept(ModBlocks.ASCANIK_ISLAND_DOOR.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
