package net.dragoteen.ywformc.screen;

import net.dragoteen.ywformc.medallium.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class MedalliumMenu extends AbstractContainerMenu {

    private final Player player;
    private final MedalliumSet set;
    private final int pageIndex;
    private final MedalliumPageDefinition page;
    private final IMedalliumProgress progress;
    private final MedalliumContainer container;

    public MedalliumMenu(int containerId, Inventory playerInventory, MedalliumSet set, int pageIndex) {
        super(ModMenuTypes.MEDALLIUM_MENU.get(), containerId);
        this.player = playerInventory.player;
        this.set = set;
        this.pageIndex = pageIndex;
        this.page = MedalliumPages.get(set, set.getPageId(pageIndex));
        this.progress = MedalliumProgressEvents.getProgress(player);
        this.container = new MedalliumContainer(progress, page);

        // Synchronise le flag "révélé" serveur -> client (1 seul int)
        addDataSlots(new ContainerData() {
            @Override
            public int get(int index) {
                return progress.isRevealed(page.id()) ? 1 : 0;
            }

            @Override
            public void set(int index, int value) {
                // Côté client : on reçoit la valeur synchronisée et on met à jour la copie locale
                progress.setRevealed(page.id(), value != 0);
            }

            @Override
            public int getCount() {
                return 1;
            }
        });

        int[][] slotPositions = {
                {92, 9}, {115, 23}, {115, 47}, {92, 59},
                {68, 59}, {45, 47}, {45, 23}, {68, 9}
        };

        for (int i = 0; i < 8; i++) {
            final int index = i;
            addSlot(new Slot(container, index, slotPositions[i][0], slotPositions[i][1]) {
                @Override
                public boolean mayPlace(ItemStack stack) {
                    return !isRevealed() && stack.getItem() == page.requiredItems()[index];
                }

                @Override
                public int getMaxStackSize() {
                    return 1;
                }

                @Override
                public boolean mayPickup(Player player) {
                    return !isRevealed();
                }
            });
        }

        addSlot(new Slot(container, 8, 80, 34) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return false;
            }

            @Override
            public boolean mayPickup(Player player) {
                return false; // récupéré automatiquement au reveal, pas de pickup manuel
            }
        });

        int offsetX = 0;
        int offsetY = -39;

        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 9; col++)
                addSlot(new Slot(playerInventory, col + row * 9 + 9,
                        8 + offsetX + col * 18,
                        140 + offsetY + row * 18));

        for (int col = 0; col < 9; col++)
            addSlot(new Slot(playerInventory, col,
                    8 + offsetX + col * 18,
                    198 + offsetY));
    }

    public MedalliumSet getSet() { return set; }
    public int getPageIndex() { return pageIndex; }
    public boolean hasPrevPage() { return pageIndex > 0; }
    public boolean hasNextPage() { return pageIndex < set.size() - 1; }

    public boolean isRevealed() {
        return progress.isRevealed(page.id());
    }

    public boolean isComplete() {
        if (isRevealed()) return true;
        for (int i = 0; i < 8; i++) {
            ItemStack stack = progress.getSlot(page.id(), i);
            if (stack.isEmpty() || stack.getItem() != page.requiredItems()[i]) return false;
        }
        return true;
    }

    /** Appelé côté serveur par le handler du packet de reveal. */
    public void reveal() {
        if (isRevealed() || !isComplete()) return;

        for (int i = 0; i < 8; i++) {
            ItemStack stack = progress.getSlot(page.id(), i);
            if (!stack.isEmpty()) {
                player.getInventory().placeItemBackInInventory(stack.copy());
                progress.setSlot(page.id(), i, ItemStack.EMPTY);
            }
        }

        player.getInventory().placeItemBackInInventory(new ItemStack(page.rewardItem()));
        progress.setRevealed(page.id(), true);
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        if (!player.level().isClientSide && !isRevealed()) {
            for (int i = 0; i < 8; i++) {
                ItemStack stack = progress.getSlot(page.id(), i);
                if (!stack.isEmpty()) {
                    progress.setSlot(page.id(), i, ItemStack.EMPTY);
                    player.getInventory().placeItemBackInInventory(stack);
                }
            }
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        if (isRevealed()) return ItemStack.EMPTY;

        ItemStack originalStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot != null && slot.hasItem()) {
            ItemStack stackInSlot = slot.getItem();
            originalStack = stackInSlot.copy();

            int containerSlots = 9;

            if (index < containerSlots) {
                if (!this.moveItemStackTo(stackInSlot, containerSlots, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                int targetSlot = -1;
                for (int i = 0; i < 8; i++) {
                    if (page.requiredItems()[i] == stackInSlot.getItem()
                            && progress.getSlot(page.id(), i).isEmpty()) {
                        targetSlot = i;
                        break;
                    }
                }
                if (targetSlot == -1) return ItemStack.EMPTY;
                if (!this.moveItemStackTo(stackInSlot, targetSlot, targetSlot + 1, false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (stackInSlot.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (stackInSlot.getCount() == originalStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, stackInSlot);
        }

        return originalStack;
    }
}