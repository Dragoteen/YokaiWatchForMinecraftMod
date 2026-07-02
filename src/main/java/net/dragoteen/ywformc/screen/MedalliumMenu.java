package net.dragoteen.ywformc.screen;

import net.dragoteen.ywformc.item.ModItems;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraft.world.entity.player.Player;

public class MedalliumMenu extends AbstractContainerMenu {

    private final ItemStackHandler itemHandler;

    // Les 8 items requis dans l'ordre des slots (à personnaliser)
    public static final net.minecraft.world.item.Item[] REQUIRED_ITEMS = {
            ModItems.MEDAL_TREASURE_EL_DORAGO.get(),
            ModItems.MEDAL_TREASURE_MADEMOAISELLE.get(),
            ModItems.MEDAL_TREASURE_ZAPPADOKIA.get(),
            ModItems.MEDAL_TREASURE_MEOPATRA.get(),
            ModItems.MEDAL_TREASURE_ROSETTA_STONE.get(),
            ModItems.MEDAL_TREASURE_DOESCALIBUR.get(),
            ModItems.MEDAL_TREASURE_NARCIS_II.get(), // exemple - à remplacer
            ModItems.MEDAL_TREASURE_FITWIT.get()  // exemple - à remplacer
    };

    // Item récompense dans le slot central
    public static final net.minecraft.world.item.Item REWARD_ITEM = ModItems.MEDAL_TREASURE_YODELSEN.get(); // à remplacer

    public MedalliumMenu(int containerId, Inventory playerInventory) {
        this(containerId, playerInventory, new ItemStackHandler(9)); // 8 slots + 1 central
    }

    public MedalliumMenu(int containerId, Inventory playerInventory, ItemStackHandler handler) {
        super(ModMenuTypes.MEDALLIUM_MENU.get(), containerId);
        this.itemHandler = handler;

        // Positions en cercle (x, y relatifs au centre de l'écran 176x166)
        int[][] slotPositions = {
                {92, 9},   // haut-droite
                {115, 23},  // milieu-haut-droite
                {115, 47},  // milieu-bas-droite
                {92, 59},  // bas-droite
                {68, 59},  // bas-gauche
                {45, 47},   // milieu-bas-gauche
                {45, 23},   // milieu-haut-gauche
                {68, 9}    // haut-gauche
        };

        // 8 slots en cercle
        for (int i = 0; i < 8; i++) {
            final int index = i;
            addSlot(new SlotItemHandler(itemHandler, i, slotPositions[i][0], slotPositions[i][1]) {
                @Override
                public boolean mayPlace(ItemStack stack) {
                    return stack.getItem() == REQUIRED_ITEMS[index];
                }
                @Override
                public int getMaxStackSize() { return 1; }
            });
        }

        // Slot central (slot 8) - lecture seule sauf pour récupérer
        addSlot(new SlotItemHandler(itemHandler, 8, 80, 34) {
            @Override
            public boolean mayPlace(ItemStack stack) { return false; }
        });

        // Au début de ta méthode
        int offsetX = 0;  // Décalage horizontal
        int offsetY = -39;  // Décalage vertical

         // Inventaire
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 9; col++)
                addSlot(new Slot(playerInventory, col + row * 9 + 9,
                        8 + offsetX + col * 18,
                        140 + offsetY + row * 18));

        // Hotbar
        for (int col = 0; col < 9; col++)
            addSlot(new Slot(playerInventory, col,
                    8 + offsetX + col * 18,
                    198 + offsetY));
    }

    public boolean isComplete() {
        for (int i = 0; i < 8; i++) {
            ItemStack stack = itemHandler.getStackInSlot(i);
            if (stack.isEmpty() || stack.getItem() != REQUIRED_ITEMS[i]) return false;
        }
        return true;
    }

    public ItemStackHandler getItemHandler() { return itemHandler; }

    @Override
    public void removed(Player player) {
        super.removed(player);
        if (!player.level().isClientSide) {
            for (int i = 0; i < itemHandler.getSlots(); i++) {
                ItemStack stack = itemHandler.getStackInSlot(i);
                if (!stack.isEmpty()) {
                    itemHandler.setStackInSlot(i, ItemStack.EMPTY);
                    player.getInventory().placeItemBackInInventory(stack);
                }
            }
        }
    }

    @Override
    public boolean stillValid(Player player) { return true; }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack originalStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot != null && slot.hasItem()) {
            ItemStack stackInSlot = slot.getItem();
            originalStack = stackInSlot.copy();

            int containerSlots = 9; // 8 slots de médaillon + 1 slot central

            if (index < containerSlots) {
                // Shift-click depuis le Medallium -> vers l'inventaire du joueur
                if (!this.moveItemStackTo(stackInSlot, containerSlots, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                // Shift-click depuis l'inventaire du joueur -> vers le bon slot du Medallium
                int targetSlot = -1;
                for (int i = 0; i < 8; i++) {
                    if (REQUIRED_ITEMS[i] == stackInSlot.getItem()
                            && itemHandler.getStackInSlot(i).isEmpty()) {
                        targetSlot = i;
                        break;
                    }
                }

                if (targetSlot == -1) {
                    return ItemStack.EMPTY; // Pas d'emplacement correspondant libre
                }

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