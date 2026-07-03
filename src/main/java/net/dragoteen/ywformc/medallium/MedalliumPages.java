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
}