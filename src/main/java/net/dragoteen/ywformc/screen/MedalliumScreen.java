package net.dragoteen.ywformc.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.dragoteen.ywformc.YoKaiWatchForMinecraftMod;
import net.dragoteen.ywformc.network.ModPackets;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Inventory;

public class MedalliumScreen extends AbstractContainerScreen<MedalliumMenu> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(YoKaiWatchForMinecraftMod.MODID, "textures/gui/medallium_menu.png");

    private static final int BUTTON_X = 62;
    private static final int BUTTON_Y = 81;
    private static final int BUTTON_W = 52;
    private static final int BUTTON_H = 14;

    private static final int ARROW_W = 14;
    private static final int ARROW_H = 14;
    private static final int ARROW_LEFT_X = 8;
    private static final int ARROW_RIGHT_X = 176 - 8 - ARROW_W;
    private static final int ARROW_Y = 81;

    public MedalliumScreen(MedalliumMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.imageWidth = 176;
        this.imageHeight = 183;
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        graphics.blit(TEXTURE, leftPos, topPos, 0, 0, imageWidth, imageHeight);

        boolean revealed = menu.isRevealed();
        boolean complete = menu.isComplete();

        int btnColor = revealed ? 0xFF333333 : (complete ? 0xFF00AA00 : 0xFF555555);
        graphics.fill(leftPos + BUTTON_X, topPos + BUTTON_Y,
                leftPos + BUTTON_X + BUTTON_W, topPos + BUTTON_Y + BUTTON_H, btnColor);

        Component label = revealed
                ? Component.translatable("gui.ywformc.revealed")
                : Component.translatable("gui.ywformc.reveal");

        graphics.drawCenteredString(font, label,
                leftPos + BUTTON_X + BUTTON_W / 2,
                topPos + BUTTON_Y + 3,
                revealed ? 0x999999 : (complete ? 0xFFFFFF : 0x888888));

        renderArrow(graphics, ARROW_LEFT_X, ARROW_Y, "◀", menu.hasPrevPage());
        renderArrow(graphics, ARROW_RIGHT_X, ARROW_Y, "▶", menu.hasNextPage());
    }

    private void renderArrow(GuiGraphics graphics, int x, int y, String symbol, boolean enabled) {
        int color = enabled ? 0xFFFFFFFF : 0xFF555555;
        graphics.fill(leftPos + x, topPos + y, leftPos + x + ARROW_W, topPos + y + ARROW_H, 0xFF333333);
        graphics.drawCenteredString(font, symbol,
                leftPos + x + ARROW_W / 2,
                topPos + y + 3,
                color);
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(graphics);
        super.render(graphics, mouseX, mouseY, partialTick);
        this.renderTooltip(graphics, mouseX, mouseY);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (menu.isComplete() && !menu.isRevealed()) {
            int bx = leftPos + BUTTON_X;
            int by = topPos + BUTTON_Y;
            if (mouseX >= bx && mouseX < bx + BUTTON_W && mouseY >= by && mouseY < by + BUTTON_H) {
                onRevealClicked();
                return true;
            }
        }

        if (menu.hasPrevPage() && isInsideArrow(mouseX, mouseY, ARROW_LEFT_X, ARROW_Y)) {
            onChangePageClicked(-1);
            return true;
        }
        if (menu.hasNextPage() && isInsideArrow(mouseX, mouseY, ARROW_RIGHT_X, ARROW_Y)) {
            onChangePageClicked(1);
            return true;
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    private boolean isInsideArrow(double mouseX, double mouseY, int x, int y) {
        int ax = leftPos + x;
        int ay = topPos + y;
        return mouseX >= ax && mouseX < ax + ARROW_W && mouseY >= ay && mouseY < ay + ARROW_H;
    }

    private void onRevealClicked() {
        assert minecraft != null;
        minecraft.getSoundManager().play(
                SimpleSoundInstance.forUI(SoundEvents.PLAYER_LEVELUP, 1.0f));
        ModPackets.sendRevealPacket();
    }

    private void onChangePageClicked(int direction) {
        assert minecraft != null;
        minecraft.getSoundManager().play(
                SimpleSoundInstance.forUI(SoundEvents.UI_BUTTON_CLICK.value(), 1.0f));
        ModPackets.sendChangePagePacket(direction);
    }

    @Override
    protected void renderLabels(GuiGraphics graphics, int mouseX, int mouseY) {
        // Pas de titre affiché
    }
}