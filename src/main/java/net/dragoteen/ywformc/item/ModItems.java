package net.dragoteen.ywformc.item;

import net.dragoteen.ywformc.YoKaiWatchForMinecraftMod;
import net.dragoteen.ywformc.entity.ModEntities;
import net.dragoteen.ywformc.item.custom.YokaiPad;
import net.dragoteen.ywformc.item.custom.YokaiWatch;
import net.dragoteen.ywformc.sound.ModSounds;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, YoKaiWatchForMinecraftMod.MODID);


    public static final RegistryObject<Item> YOKAI_WATCH = ITEMS.register("yokai_watch",
            () -> new YokaiWatch(new Item.Properties()));
    public static final RegistryObject<Item> YOKAI_WATCH_POCHE = ITEMS.register("yokai_watch_poche",
            () -> new YokaiWatch(new Item.Properties()));
    public static final RegistryObject<Item> YOKAI_WATCH_ZERO = ITEMS.register("yokai_watch_zero",
            () -> new YokaiWatch(new Item.Properties()));
    public static final RegistryObject<Item> YOKAI_WATCH_PROTOTYPE_U = ITEMS.register("yokai_watch_prototype_u",
            () -> new YokaiWatch(new Item.Properties()));
    public static final RegistryObject<Item> YOKAI_WATCH_U1 = ITEMS.register("yokai_watch_u1",
            () -> new YokaiWatch(new Item.Properties()));
    public static final RegistryObject<Item> YOKAI_WATCH_U2 = ITEMS.register("yokai_watch_u2",
            () -> new YokaiWatch(new Item.Properties()));
    public static final RegistryObject<Item> YOKAI_WATCH_UE = ITEMS.register("yokai_watch_ue",
            () -> new YokaiWatch(new Item.Properties()));
    public static final RegistryObject<Item> YOKAI_WATCH_REVE = ITEMS.register("yokai_watch_reve",
            () -> new YokaiWatch(new Item.Properties()));
    public static final RegistryObject<Item> TREASURE_WATCH = ITEMS.register("treasure_watch",
            () -> new YokaiWatch(new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_WATCH = ITEMS.register("crystal_watch",
            () -> new YokaiWatch(new Item.Properties()));

    public static final RegistryObject<Item> YOKAI_WATCH_ANCESTRALE = ITEMS.register("yokai_watch_ancestrale",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> YOKAI_WATCH_ANCESTRALE_N = ITEMS.register("yokai_watch_ancestrale_n",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> YOKAI_WATCH_ANCESTRALE_ZERO = ITEMS.register("yokai_watch_ancestrale_zero",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> YOKAI_WATCH_ANCESTRALE_GOD = ITEMS.register("yokai_watch_ancestrale_god",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> YOKAI_WATCH_OGRE = ITEMS.register("yokai_watch_ogre",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> YOKAI_WATCH_ANIMUS = ITEMS.register("yokai_watch_animus",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> YOKAI_PAD= ITEMS.register("yokai_pad",
            () -> new YokaiPad(new Item.Properties()));

    public static final RegistryObject<Item> BLASTER_YOKAI = ITEMS.register("blaster_yokai",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FOREUSE_YOKAI = ITEMS.register("foreuse_yokai",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ASPIRATEUR_YOKAI = ITEMS.register("aspirateur_yokai",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> YOKAI_BAZOOKA = ITEMS.register("yokai_bazooka",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ENMA_BLADE = ITEMS.register("enma_blade",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ENCHANTED_FLUTE = ITEMS.register("enchanted_flute",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BOOSTOKAI = ITEMS.register("boostokai",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PISTOKIT = ITEMS.register("pistokit",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SABROKIT = ITEMS.register("sabrokit",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CARAKIT = ITEMS.register("carakit",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HUEDROID = ITEMS.register("huedroid",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FRAGMENT_DE_YOKAI = ITEMS.register("fragment_de_yokai",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> VIEIL_ENGRENAGE = ITEMS.register("vieil_engrenage",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GRELOT_FELIN = ITEMS.register("grelot_felin",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MONTRE_DE_LUXE = ITEMS.register("montre_de_luxe",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILLE_MYSTERIEUSE = ITEMS.register("bille_mysterieuse",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PLAQUE_DAMULETTE = ITEMS.register("plaque_damulette",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AMULETTE_FORME_DE_U = ITEMS.register("amulette_forme_de_u",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AMULETTE_COLOREE = ITEMS.register("amulette_coloree",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> U_UPDATE = ITEMS.register("u_update",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Y9_PROCESSOR_CHIP = ITEMS.register("y9_processor_chip",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EXTREME_LAPIS = ITEMS.register("extreme_lapis",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EXTREME_GOLD = ITEMS.register("extreme_gold",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MEDALLIUM = ITEMS.register("medallium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> YOVNIKAI_WATCH = ITEMS.register("yovnikai_watch",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CLE_YOKAI_WORLD = ITEMS.register("cle_yokai_world",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TELEMIR_POCHE = ITEMS.register("telemir_poche",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CLEYOKANTIK = ITEMS.register("cleyokantik",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CLEYOLCANIK = ITEMS.register("cleyolcanik",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CLEYOKANSTRALE = ITEMS.register("cleyokanstrale",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CLEYOKOURAGE = ITEMS.register("cleyokourage",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CLEYOKONNAISSANCE = ITEMS.register("cleyokonnaissance",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CLEYOFORCE = ITEMS.register("cleyoforce",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CLEYOTERRE = ITEMS.register("cleyoterre",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CLEYOVENT = ITEMS.register("cleyovent",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> UPTOWN_SPRINGDALE_THEME_DISC = ITEMS.register("uptown_springdale_theme_disc",
            () -> new RecordItem(6,
                    ModSounds.UPTOWN_SPRINGDALE_THEME,
                    new  Item.Properties()
                            .stacksTo(1)
                            .rarity(Rarity.RARE),
                    2200));
    public static final RegistryObject<Item> MOUNT_WILDWOOD_THEME_DISC = ITEMS.register("mount_wildwood_theme_disc",
            () -> new RecordItem(6,
                    ModSounds.MOUNT_WILDWOOD_THEME,
                    new  Item.Properties()
                            .stacksTo(1)
                            .rarity(Rarity.RARE),
                    2740));
    public static final RegistryObject<Item> BLOSSOM_HEIGHTS_THEME_DISC = ITEMS.register("blossom_heights_theme_disc",
            () -> new RecordItem(6,
                    ModSounds.BLOSSOM_HEIGHTS_THEME,
                    new  Item.Properties()
                            .stacksTo(1)
                            .rarity(Rarity.RARE),
                    2640));
    public static final RegistryObject<Item> SHOPPERS_ROW_THEME_DISC = ITEMS.register("shoppers_row_theme_disc",
            () -> new RecordItem(6,
                    ModSounds.SHOPPERS_ROW_THEME,
                    new  Item.Properties()
                            .stacksTo(1)
                            .rarity(Rarity.RARE),
                    2420));
    public static final RegistryObject<Item> DOWNTOWN_SPRINGDALE_THEME_DISC = ITEMS.register("downtown_springdale_theme_disc",
            () -> new RecordItem(6,
                    ModSounds.DOWNTOWN_SPRINGDALE_THEME,
                    new  Item.Properties()
                            .stacksTo(1)
                            .rarity(Rarity.RARE),
                    2240));
    public static final RegistryObject<Item> BREEZY_HILLS_THEME_DISC = ITEMS.register("breezy_hills_theme_disc",
            () -> new RecordItem(6,
                    ModSounds.BREEZY_HILLS_THEME,
                    new  Item.Properties()
                            .stacksTo(1)
                            .rarity(Rarity.RARE),
                    2740));
    public static final RegistryObject<Item> EXCELLENT_TOWER_THEME_DISC = ITEMS.register("excellent_tower_theme_disc",
            () -> new RecordItem(6,
                    ModSounds.EXCELLENT_TOWER_THEME,
                    new  Item.Properties()
                            .stacksTo(1)
                            .rarity(Rarity.RARE),
                    1600));
    public static final RegistryObject<Item> SPARKOPOLIS_THEME_DISC = ITEMS.register("sparkopolis_theme_disc",
            () -> new RecordItem(6,
                    ModSounds.SPARKOPOLIS_THEME,
                    new  Item.Properties()
                            .stacksTo(1)
                            .rarity(Rarity.RARE),
                    1900));
    public static final RegistryObject<Item> YOKAI_WORLD_THEME_DISC = ITEMS.register("yokai_world_theme_disc",
            () -> new RecordItem(6,
                    ModSounds.YOKAI_WORLD_THEME,
                    new  Item.Properties()
                            .stacksTo(1)
                            .rarity(Rarity.RARE),
                    1180));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
