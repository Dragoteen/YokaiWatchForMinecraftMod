package net.dragoteen.ywformc.medallium;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.item.ItemStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MedalliumProgress implements IMedalliumProgress {

    private final Map<String, Boolean> revealed = new HashMap<>();
    private final Map<String, ItemStack[]> slots = new HashMap<>();

    private ItemStack[] slotsFor(String pageId) {
        return slots.computeIfAbsent(pageId, id -> {
            ItemStack[] arr = new ItemStack[8];
            Arrays.fill(arr, ItemStack.EMPTY);
            return arr;
        });
    }

    @Override
    public boolean isRevealed(String pageId) {
        return revealed.getOrDefault(pageId, false);
    }

    @Override
    public void setRevealed(String pageId, boolean value) {
        revealed.put(pageId, value);
    }

    @Override
    public ItemStack getSlot(String pageId, int slotIndex) {
        return slotsFor(pageId)[slotIndex];
    }

    @Override
    public void setSlot(String pageId, int slotIndex, ItemStack stack) {
        slotsFor(pageId)[slotIndex] = stack;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag root = new CompoundTag();

        CompoundTag revealedTag = new CompoundTag();
        for (Map.Entry<String, Boolean> e : revealed.entrySet()) {
            revealedTag.putBoolean(e.getKey(), e.getValue());
        }
        root.put("Revealed", revealedTag);

        CompoundTag slotsTag = new CompoundTag();
        for (Map.Entry<String, ItemStack[]> e : slots.entrySet()) {
            ListTag list = new ListTag();
            for (ItemStack stack : e.getValue()) {
                list.add(stack.save(new CompoundTag()));
            }
            slotsTag.put(e.getKey(), list);
        }
        root.put("Slots", slotsTag);
        return root;
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        revealed.clear();
        slots.clear();

        CompoundTag revealedTag = tag.getCompound("Revealed");
        for (String key : revealedTag.getAllKeys()) {
            revealed.put(key, revealedTag.getBoolean(key));
        }

        CompoundTag slotsTag = tag.getCompound("Slots");
        for (String key : slotsTag.getAllKeys()) {
            ListTag list = slotsTag.getList(key, 10); // 10 = id NBT des CompoundTag
            ItemStack[] arr = new ItemStack[8];
            for (int i = 0; i < 8; i++) {
                arr[i] = i < list.size() ? ItemStack.of(list.getCompound(i)) : ItemStack.EMPTY;
            }
            slots.put(key, arr);
        }
    }
}