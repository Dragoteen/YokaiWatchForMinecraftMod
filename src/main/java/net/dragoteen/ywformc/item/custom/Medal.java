package net.dragoteen.ywformc.item.custom;

import net.dragoteen.ywformc.item.WatchItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class Medal extends Item implements WatchItem {

    public enum MedalType {
        NORMAL(Rarity.COMMON),
        Z(Rarity.COMMON),
        CLASSIC(Rarity.UNCOMMON),
        U(Rarity.COMMON),
        CLASSICU(Rarity.UNCOMMON),
        MERICAN(Rarity.COMMON),
        BLASTER(Rarity.COMMON),
        DREAM(Rarity.UNCOMMON),
        TREASURE(Rarity.UNCOMMON),

        LEGENDARY(Rarity.EPIC),
        LEGENDARY_MYSTERY(Rarity.EPIC),
        MERICAIN_LEGENDARY(Rarity.EPIC),
        PIONEER(Rarity.EPIC),
        DIVINITY(Rarity.RARE),
        TREASURE_DIVINITY(Rarity.EPIC);

        private final Rarity rarity;

        MedalType(Rarity rarity) {
            this.rarity = rarity;
        }

        public Rarity getRarity() {
            return rarity;
        }
    }

    private final MedalType type;

    public Medal(MedalType type, Properties properties) {
        super(properties.stacksTo(1).rarity(type.getRarity()));
        this.type = type;
    }

    public MedalType getMedalType() {
        return type;
    }
}