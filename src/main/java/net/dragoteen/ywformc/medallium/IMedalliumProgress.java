package net.dragoteen.ywformc.medallium;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.AutoRegisterCapability;

@AutoRegisterCapability
public interface IMedalliumProgress {

    boolean isRevealed(String pageId);
    void setRevealed(String pageId, boolean revealed);

    ItemStack getSlot(String pageId, int slotIndex);
    void setSlot(String pageId, int slotIndex, ItemStack stack);

    CompoundTag serializeNBT();
    void deserializeNBT(CompoundTag tag);
}