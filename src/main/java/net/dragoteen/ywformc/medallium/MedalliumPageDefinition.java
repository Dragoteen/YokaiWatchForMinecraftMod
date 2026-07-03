package net.dragoteen.ywformc.medallium;

import net.minecraft.world.item.Item;

public record MedalliumPageDefinition(String id, Item[] requiredItems, Item rewardItem) {
}
