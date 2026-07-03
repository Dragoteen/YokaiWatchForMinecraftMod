package net.dragoteen.ywformc.medallium;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class MedalliumContainer implements Container {

    private static final int REWARD_SLOT = 8;

    private final IMedalliumProgress progress;
    private final MedalliumPageDefinition page;

    public MedalliumContainer(IMedalliumProgress progress, MedalliumPageDefinition page) {
        this.progress = progress;
        this.page = page;
    }

    @Override
    public int getContainerSize() {
        return 9; // 8 médaillons + 1 récompense
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < getContainerSize(); i++) {
            if (!getItem(i).isEmpty()) return false;
        }
        return true;
    }

    @Override
    public ItemStack getItem(int index) {
        boolean revealed = progress.isRevealed(page.id());

        if (index == REWARD_SLOT) {
            return revealed ? new ItemStack(page.rewardItem()) : ItemStack.EMPTY;
        }
        if (revealed) {
            return new ItemStack(page.requiredItems()[index]); // affichage fantôme
        }
        return progress.getSlot(page.id(), index);
    }

    @Override
    public ItemStack removeItem(int index, int count) {
        if (index == REWARD_SLOT || progress.isRevealed(page.id())) return ItemStack.EMPTY;
        ItemStack stack = progress.getSlot(page.id(), index);
        progress.setSlot(page.id(), index, ItemStack.EMPTY);
        return stack;
    }

    @Override
    public ItemStack removeItemNoUpdate(int index) {
        return removeItem(index, 1);
    }

    @Override
    public void setItem(int index, ItemStack stack) {
        if (index == REWARD_SLOT || progress.isRevealed(page.id())) return;
        progress.setSlot(page.id(), index, stack);
    }

    @Override
    public void setChanged() {
        // rien : la donnée vit directement dans la capability
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public void clearContent() {
        for (int i = 0; i < 8; i++) progress.setSlot(page.id(), i, ItemStack.EMPTY);
    }
}