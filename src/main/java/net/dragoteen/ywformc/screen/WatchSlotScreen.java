package net.dragoteen.ywformc.screen;

import net.dragoteen.ywformc.capability.WatchCapabilityProvider;
import net.dragoteen.ywformc.item.WatchItem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class WatchSlotScreen extends Screen {

    private static final int SLOT_X = 88;
    private static final int SLOT_Y = 88;
    private static final int WIDTH = 176;
    private static final int HEIGHT = 166;

    private final Player player;
    private int left, top;

    public WatchSlotScreen(Player player) {
        super(Component.translatable("screen.ywformc.watch_slot"));
        this.player = player;
    }

    @Override
    protected void init() {
        left = (this.width - WIDTH) / 2;
        top = (this.height - HEIGHT) / 2;
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(graphics);

        // Fond gris du slot
        graphics.fill(left + SLOT_X - 1, top + SLOT_Y - 1,
                left + SLOT_X + 17, top + SLOT_Y + 17, 0xFF8B8B8B);
        graphics.fill(left + SLOT_X, top + SLOT_Y,
                left + SLOT_X + 16, top + SLOT_Y + 16, 0xFF000000);

        // Item dans le slot
        player.getCapability(WatchCapabilityProvider.WATCH_CAP).ifPresent(cap -> {
            if (cap.hasWatch()) {
                graphics.renderItem(cap.getWatch(), left + SLOT_X, top + SLOT_Y);
            }
        });

        // Titre
        graphics.drawCenteredString(this.font,
                Component.translatable("screen.ywformc.watch_slot"),
                this.width / 2, top + 10, 0xFFFFFF);

        super.render(graphics, mouseX, mouseY, partialTick);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        int slotLeft = left + SLOT_X;
        int slotTop = top + SLOT_Y;

        if (mouseX >= slotLeft && mouseX < slotLeft + 16
                && mouseY >= slotTop && mouseY < slotTop + 16) {

            player.getCapability(WatchCapabilityProvider.WATCH_CAP).ifPresent(cap -> {
                ItemStack held = player.getInventory().getSelected();


                if (!held.isEmpty() && !cap.hasWatch() && held.getItem() instanceof WatchItem) {
                    cap.setWatch(held.copy());
                    held.shrink(1);
                } else if (cap.hasWatch()) {
                    player.getInventory().add(cap.getWatch());
                    cap.setWatch(ItemStack.EMPTY);
                }
            });
            return true;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean isPauseScreen() { return false; }
}