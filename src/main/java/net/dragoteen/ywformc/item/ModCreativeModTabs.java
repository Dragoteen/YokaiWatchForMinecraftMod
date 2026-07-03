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
                        output.accept(ModItems.MEDALLIUM_Z.get());
                        output.accept(ModItems.MEDALLIUM_BLASTERS.get());
                        output.accept(ModItems.MEDALLIUM_U.get());
                        output.accept(ModItems.MEDALLIUM_BLASTERS_2.get());

                        output.accept(ModItems.YOVNIKAI_WATCH.get());
                        output.accept(ModItems.CLE_YOKAI_WORLD.get());
                        output.accept(ModItems.TELEMIR_POCHE.get());

                        output.accept(ModItems.CLEYOKANTIK.get());
                        output.accept(ModItems.CLEYOLCANIK.get());
                        output.accept(ModItems.CLEYOKANSTRALE.get());
                        output.accept(ModItems.CLEYOKOURAGE.get());
                        output.accept(ModItems.CLEYOKONNAISSANCE.get());
                        output.accept(ModItems.CLEYOFORCE.get());
                        output.accept(ModItems.CLEYOTERRE.get());
                        output.accept(ModItems.CLEYOVENT.get());

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

    public static final RegistryObject<CreativeModeTab> MEDALS_TAB = CREATIVE_MODE_TABS.register("medals_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MEDAL_JIBANYAN.get()))
                    .title(Component.translatable("creativetab.medals_tab"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModItems.MEDAL_JIBANYAN.get());
                        output.accept(ModItems.MEDAL_MOCHISMO.get());
                        output.accept(ModItems.MEDAL_TATTLETELL.get());
                        output.accept(ModItems.MEDAL_CASTELIUS_III.get());
                        output.accept(ModItems.MEDAL_DRAGGIE.get());
                        output.accept(ModItems.MEDAL_DISMARELDA.get());
                        output.accept(ModItems.MEDAL_LEADONI.get());
                        output.accept(ModItems.MEDAL_HAPPIERRE.get());
                        output.accept(ModItems.MEDAL_INSOMNI.get());
                        output.accept(ModItems.MEDAL_CADIN.get());
                        output.accept(ModItems.MEDAL_BUHU.get());
                        output.accept(ModItems.MEDAL_BAKU.get());
                        output.accept(ModItems.MEDAL_MIRAPO.get());
                        output.accept(ModItems.MEDAL_LAVA_LORD.get());
                        output.accept(ModItems.MEDAL_CASANUVA.get());
                        output.accept(ModItems.MEDAL_QUAKEN.get());
                        output.accept(ModItems.MEDAL_KOMAJIRO.get());
                        output.accept(ModItems.MEDAL_KOMANE.get());
                        output.accept(ModItems.MEDAL_BLAZION.get());
                        output.accept(ModItems.MEDAL_KYUBI.get());
                        output.accept(ModItems.MEDAL_MAD_MOUNTAIN.get());
                        output.accept(ModItems.MEDAL_TUNATIC.get());
                        output.accept(ModItems.MEDAL_ZERBERKER.get());
                        output.accept(ModItems.MEDAL_SWELTERRIER.get());
                        output.accept(ModItems.MEDAL_SIR_BERUS.get());
                        output.accept(ModItems.MEDAL_PINKIPOO.get());
                        output.accept(ModItems.MEDAL_EMENYAN.get());
                        output.accept(ModItems.MEDAL_ROBONYAN.get());
                        output.accept(ModItems.MEDAL_KOMASAN.get());
                        output.accept(ModItems.MEDAL_KOMIGER.get());

                        output.accept(ModItems.MEDAL_SHOGUNYAN.get());
                        output.accept(ModItems.MEDAL_KOMASHURA.get());
                        output.accept(ModItems.MEDAL_DANDOODLE.get());
                        output.accept(ModItems.MEDAL_ELDER_BLOOM.get());
                        output.accept(ModItems.MEDAL_GILGAROS.get());
                        output.accept(ModItems.MEDAL_SPOILERINA.get());
                        output.accept(ModItems.MEDAL_POOFESSOR.get());
                        output.accept(ModItems.MEDAL_SLURPENT.get());


                        output.accept(ModItems.MEDAL_Z_FRAZZEL.get());
                        output.accept(ModItems.MEDAL_Z_FIREWIG.get());
                        output.accept(ModItems.MEDAL_Z_HOVERNYAN.get());
                        output.accept(ModItems.MEDAL_Z_MIRADOX.get());
                        output.accept(ModItems.MEDAL_Z_LIE_IN_HEART.get());
                        output.accept(ModItems.MEDAL_Z_DRACUNYAN.get());
                        output.accept(ModItems.MEDAL_Z_ROBOKOMA.get());


                        output.accept(ModItems.MEDAL_CLASSIC_TUBLAPPA.get());
                        output.accept(ModItems.MEDAL_CLASSIC_TOADAL_DUDE.get());
                        output.accept(ModItems.MEDAL_CLASSIC_FAUX_KAPPA.get());
                        output.accept(ModItems.MEDAL_CLASSIC_SMOGMELLA.get());
                        output.accept(ModItems.MEDAL_CLASSIC_ARACHNUS.get());


                        output.accept(ModItems.MEDAL_U_WHISPER.get());
                        output.accept(ModItems.MEDAL_U_WHISPOCRATES.get());
                        output.accept(ModItems.MEDAL_U_PUSH_PUP.get());
                        output.accept(ModItems.MEDAL_U_PUPPYNYAN.get());

                        output.accept(ModItems.MEDAL_U_RE_Q_PERATE.get());
                        output.accept(ModItems.MEDAL_U_PRINCESS_PEARL.get());
                        output.accept(ModItems.MEDAL_U_ASURA.get());
                        output.accept(ModItems.MEDAL_U_WHYVERN_KING.get());


                        output.accept(ModItems.MEDAL_MERICAN_PUPPICCINO.get());
                        output.accept(ModItems.MEDAL_MERICAN_LAZY_SUNDAE.get());


                        output.accept(ModItems.MEDAL_DREAM_MOCHISMO.get());
                        output.accept(ModItems.MEDAL_DREAM_TATTLETELL.get());
                        output.accept(ModItems.MEDAL_DREAM_DRAGGIE.get());
                        output.accept(ModItems.MEDAL_DREAM_DISMARELDA.get());
                        output.accept(ModItems.MEDAL_DREAM_HAPPIERRE.get());
                        output.accept(ModItems.MEDAL_DREAM_TATTLETELL.get());
                        output.accept(ModItems.MEDAL_DREAM_MIRAPO.get());
                        output.accept(ModItems.MEDAL_DREAM_CASANUVA.get());
                        output.accept(ModItems.MEDAL_DREAM_KYUBI.get());
                        output.accept(ModItems.MEDAL_DREAM_KOMAJIRO.get());
                        output.accept(ModItems.MEDAL_DREAM_KOMAJIRO_LIVE.get());
                        output.accept(ModItems.MEDAL_DREAM_BLAZION.get());
                        output.accept(ModItems.MEDAL_DREAM_FRAZZEL.get());
                        output.accept(ModItems.MEDAL_DREAM_SWELTERRIER.get());
                        output.accept(ModItems.MEDAL_DREAM_EMENYAN.get());
                        output.accept(ModItems.MEDAL_DREAM_DRACUNYAN.get());
                        output.accept(ModItems.MEDAL_DREAM_LAZY_SUNDAE.get());
                        output.accept(ModItems.MEDAL_DREAM_KOMASAN.get());
                        output.accept(ModItems.MEDAL_DREAM_KOMASAN_LIVE.get());


                        output.accept(ModItems.MEDAL_TREASURE_TANTO.get());
                        output.accept(ModItems.MEDAL_TREASURE_NYANSES_II.get());
                        output.accept(ModItems.MEDAL_TREASURE_TANTO.get());

                        output.accept(ModItems.MEDAL_TREASURE_SILVER_NYANSES_II.get());

                        output.accept(ModItems.MEDAL_TREASURE_NYANSES_II_G.get());

                        output.accept(ModItems.MEDAL_TREASURE_SHOGUNYAN.get());
                        output.accept(ModItems.MEDAL_TREASURE_KOMASHURA.get());
                        output.accept(ModItems.MEDAL_TREASURE_DANDOODLE.get());
                        output.accept(ModItems.MEDAL_TREASURE_ELDER_BLOOM.get());
                        output.accept(ModItems.MEDAL_TREASURE_GILGAROS.get());
                        output.accept(ModItems.MEDAL_TREASURE_SPOILERINA.get());
                        output.accept(ModItems.MEDAL_TREASURE_POOFESSOR.get());
                        output.accept(ModItems.MEDAL_TREASURE_RE_Q_PERATE.get());
                        output.accept(ModItems.MEDAL_TREASURE_PRINCESS_PEARL.get());
                        output.accept(ModItems.MEDAL_TREASURE_ASURA.get());
                        output.accept(ModItems.MEDAL_TREASURE_WHYVERN_KING.get());
                        output.accept(ModItems.MEDAL_TREASURE_MORIGAMI_REX.get());
                        output.accept(ModItems.MEDAL_TREASURE_KANEKUI_HIME.get());

                        output.accept(ModItems.MEDAL_TREASURE_MEOPATRA.get());
                        output.accept(ModItems.MEDAL_TREASURE_FITWIT.get());
                        output.accept(ModItems.MEDAL_TREASURE_EL_DORAGO.get());
                        output.accept(ModItems.MEDAL_TREASURE_THE_HINIX.get());
                        output.accept(ModItems.MEDAL_TREASURE_YODELSEN.get());
                        output.accept(ModItems.MEDAL_TREASURE_NARCIS_II.get());
                        output.accept(ModItems.MEDAL_TREASURE_ZAPPADOKIA.get());
                        output.accept(ModItems.MEDAL_TREASURE_MADEMOAISELLE.get());
                        output.accept(ModItems.MEDAL_TREASURE_ROSETTA_STONE.get());
                        output.accept(ModItems.MEDAL_TREASURE_DOESCALIBUR.get());
                        output.accept(ModItems.MEDAL_TREASURE_ENCORE_DEAD.get());
                        output.accept(ModItems.MEDAL_TREASURE_ARMORTERASU.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
