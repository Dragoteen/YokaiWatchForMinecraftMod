package net.dragoteen.ywformc.capability;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

public class WatchCapability {

    private ItemStack watch = ItemStack.EMPTY;

    public ItemStack getWatch() { return watch; }

    public void setWatch(ItemStack stack) { this.watch = stack == null ? ItemStack.EMPTY : stack; }

    public boolean hasWatch() { return !watch.isEmpty(); }

    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        if (!watch.isEmpty()) tag.put("watch", watch.save(new CompoundTag()));
        return tag;
    }

    public void deserializeNBT(CompoundTag tag) {
        if (tag.contains("watch")) watch = ItemStack.of(tag.getCompound("watch"));
        else watch = ItemStack.EMPTY;
    }
}