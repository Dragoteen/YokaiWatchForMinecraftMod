package net.dragoteen.ywformc.medallium;

import net.dragoteen.ywformc.item.ModItems;
import net.minecraft.world.item.Item;

import java.util.LinkedHashMap;
import java.util.Map;

public class MedalliumPages {

    private static final Map<String, MedalliumPageDefinition> PAGES = new LinkedHashMap<>();

    private static String key(MedalliumSet set, String yokaiId) {
        return set.name().toLowerCase() + ":" + yokaiId;
    }

    public static MedalliumPageDefinition register(MedalliumSet set, String yokaiId, Item[] required, Item reward) {
        MedalliumPageDefinition def = new MedalliumPageDefinition(key(set, yokaiId), required, reward);
        PAGES.put(def.id(), def);
        return def;
    }

    public static MedalliumPageDefinition get(MedalliumSet set, String yokaiId) {
        return PAGES.get(key(set, yokaiId));
    }

    // --- Médallium Normal ---
    public static final MedalliumPageDefinition NORMAL_SHOGUNYAN = register(MedalliumSet.NORMAL, "shogunyan",
            new Item[] {
                    ModItems.MEDAL_MOCHISMO.get(),
                    ModItems.MEDAL_TATTLETELL.get(),
                    ModItems.MEDAL_CASTELIUS_III.get(),
                    ModItems.MEDAL_JIBANYAN.get(),
                    ModItems.MEDAL_DRAGGIE.get(),
                    ModItems.MEDAL_DISMARELDA.get(),
                    ModItems.MEDAL_LEADONI.get(),
                    ModItems.MEDAL_HAPPIERRE.get()
            },
            ModItems.MEDAL_SHOGUNYAN.get());

    public static final MedalliumPageDefinition NORMAL_KOMASHURA = register(MedalliumSet.NORMAL, "komashura",
            new Item[] {
                    ModItems.MEDAL_LAVA_LORD.get(),
                    ModItems.MEDAL_CASANUVA.get(),
                    ModItems.MEDAL_QUAKEN.get(),
                    ModItems.MEDAL_KOMAJIRO.get(),
                    ModItems.MEDAL_KOMANE.get(),
                    ModItems.MEDAL_BLAZION.get(),
                    ModItems.MEDAL_KYUBI.get(),
                    ModItems.MEDAL_MAD_MOUNTAIN.get()
            },
            ModItems.MEDAL_KOMASHURA.get());

    public static final MedalliumPageDefinition NORMAL_CABOTIN = register(MedalliumSet.NORMAL, "cabotin",
            new Item[] {
                    ModItems.MEDAL_MANJIMUTT.get(),
                    ModItems.MEDAL_CUTTINCHEEZ.get(),
                    ModItems.MEDAL_DRIZZLE.get(),
                    ModItems.MEDAL_EVERFORE.get(),
                    ModItems.MEDAL_INSOMNI.get(),
                    ModItems.MEDAL_SKREEK.get(),
                    ModItems.MEDAL_COMPUNZEL.get(),
                    ModItems.MEDAL_NAGATHA.get()
            },
            ModItems.MEDAL_DANDOODLE.get());

    // --- Médallium Z ---
    public static final MedalliumPageDefinition Z_SHOGUNYAN = register(MedalliumSet.Z, "shogunyan",
            new Item[] {
                    ModItems.MEDAL_INSOMNI.get(),
                    ModItems.MEDAL_CADIN.get(),
                    ModItems.MEDAL_BUHU.get(),
                    ModItems.MEDAL_BAKU.get(),
                    ModItems.MEDAL_MIRAPO.get(),
                    ModItems.MEDAL_DRAGGIE.get(),
                    ModItems.MEDAL_DISMARELDA.get(),
                    ModItems.MEDAL_JIBANYAN.get()
            },
            ModItems.MEDAL_SHOGUNYAN.get());

    public static final MedalliumPageDefinition Z_KOMASHURA = register(MedalliumSet.Z, "komashura",
            new Item[] {
                    ModItems.MEDAL_LAVA_LORD.get(),
                    ModItems.MEDAL_TUNATIC.get(),
                    ModItems.MEDAL_ZERBERKER.get(),
                    ModItems.MEDAL_Z_FRAZZEL.get(),
                    ModItems.MEDAL_Z_FIREWIG.get(),
                    ModItems.MEDAL_BLAZION.get(),
                    ModItems.MEDAL_SWELTERRIER.get(),
                    ModItems.MEDAL_CLASSIC_TUBLAPPA.get()
            },
            ModItems.MEDAL_KOMASHURA.get());

    public static final MedalliumPageDefinition Z_CABOTIN = register(MedalliumSet.Z, "cabotin",
            new Item[] {
                    ModItems.MEDAL_MULTIMUTT.get(),
                    ModItems.MEDAL_Z_LIE_IN_HEART.get(),
                    ModItems.MEDAL_BADUDE.get(),
                    ModItems.MEDAL_SHMOOPIE.get(),
                    ModItems.MEDAL_TATTLECAST.get(),
                    ModItems.MEDAL_CASANUVA.get(),
                    ModItems.MEDAL_SKREEK.get(),
                    ModItems.MEDAL_Z_RAY_O_LIGHT.get()
            },
            ModItems.MEDAL_DANDOODLE.get());

    // --- Médallium U ---
    public static final MedalliumPageDefinition U_SHOGUNYAN = register(MedalliumSet.U, "shogunyan",
            new Item[] {
                    ModItems.MEDAL_INSOMNI.get(),
                    ModItems.MEDAL_CADIN.get(),
                    ModItems.MEDAL_BUHU.get(),
                    ModItems.MEDAL_BAKU.get(),
                    ModItems.MEDAL_MIRAPO.get(),
                    ModItems.MEDAL_DRAGGIE.get(),
                    ModItems.MEDAL_DISMARELDA.get(),
                    ModItems.MEDAL_JIBANYAN.get()
            },
            ModItems.MEDAL_SHOGUNYAN.get());

    public static final MedalliumPageDefinition U_KOMASHURA = register(MedalliumSet.U, "komashura",
            new Item[] {
                    ModItems.MEDAL_MERICAN_PUPPICCINO.get(),
                    ModItems.MEDAL_U_PUSH_PUP.get(),
                    ModItems.MEDAL_SIR_BERUS.get(),
                    ModItems.MEDAL_KOMANE.get(),
                    ModItems.MEDAL_PINKIPOO.get(),
                    ModItems.MEDAL_SWELTERRIER.get(),
                    ModItems.MEDAL_Z_LIE_IN_HEART.get(),
                    ModItems.MEDAL_U_PUPPYNYAN.get()
            },
            ModItems.MEDAL_KOMASHURA.get());

    public static final MedalliumPageDefinition U_CABOTIN = register(MedalliumSet.U, "cabotin",
            new Item[] {
                    ModItems.MEDAL_CASANUVA.get(),
                    ModItems.MEDAL_Z_RAY_O_LIGHT.get(),
                    ModItems.MEDAL_Z_CARNIBOY.get(),
                    ModItems.MEDAL_U_LAPPINITUP.get(),
                    ModItems.MEDAL_CLASSIC_U_WHIRLWEASEL.get(),
                    ModItems.MEDAL_CLASSIC_U_TENGURIGINAL.get(),
                    ModItems.MEDAL_CLASSIC_U_THURSTON.get(),
                    ModItems.MEDAL_KYUBI.get()
            },
            ModItems.MEDAL_DANDOODLE.get());

    // --- Médallium Blasters 2 ---
    public static final MedalliumPageDefinition BLASTERS2_SHOGUNYAN = register(MedalliumSet.BLASTERS2, "shogunyan",
            new Item[] {
                    ModItems.MEDAL_EMENYAN.get(),
                    ModItems.MEDAL_ROBONYAN.get(),
                    ModItems.MEDAL_Z_HOVERNYAN.get(),
                    ModItems.MEDAL_TREASURE_TORANKA.get(),
                    ModItems.MEDAL_BLAZION.get(),
                    ModItems.MEDAL_Z_DRACUNYAN.get(),
                    ModItems.MEDAL_TREASURE_NYANSES_II.get(),
                    ModItems.MEDAL_JIBANYAN.get()
            },
            ModItems.MEDAL_SHOGUNYAN.get());

    public static final MedalliumPageDefinition BLASTERS2_KOMASHURA = register(MedalliumSet.BLASTERS2, "komashura",
            new Item[] {
                    ModItems.MEDAL_SIR_BERUS.get(),
                    ModItems.MEDAL_SWELTERRIER.get(),
                    ModItems.MEDAL_MERICAN_LAZY_SUNDAE.get(),
                    ModItems.MEDAL_TREASURE_TANTO.get(),
                    ModItems.MEDAL_KOMASAN.get(),
                    ModItems.MEDAL_KOMANE.get(),
                    ModItems.MEDAL_ROBONYAN.get(),
                    ModItems.MEDAL_KOMIGER.get()
            },
            ModItems.MEDAL_KOMASHURA.get());

    public static final MedalliumPageDefinition BLASTERS2_CABOTIN = register(MedalliumSet.BLASTERS2, "cabotin",
            new Item[] {
                    ModItems.MEDAL_U_KJ.get(),
                    ModItems.MEDAL_Z_RAY_O_LIGHT.get(),
                    ModItems.MEDAL_Z_CARNIBOY.get(),
                    ModItems.MEDAL_U_LAPPINITUP.get(),
                    ModItems.MEDAL_CLASSIC_U_WHIRLWEASEL.get(),
                    ModItems.MEDAL_CLASSIC_U_TENGURIGINAL.get(),
                    ModItems.MEDAL_TREASURE_DANDORY.get(),
                    ModItems.MEDAL_KYUBI.get()
            },
            ModItems.MEDAL_DANDOODLE.get());
}