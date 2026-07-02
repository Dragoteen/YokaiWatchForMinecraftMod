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

    public MedalliumScreen(MedalliumMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.imageWidth = 176;
        this.imageHeight = 183;
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        graphics.blit(TEXTURE, leftPos, topPos, 0, 0, imageWidth, imageHeight);

        // Bouton Révéler
        boolean complete = menu.isComplete();
        int btnColor = complete ? 0xFF00AA00 : 0xFF555555;
        graphics.fill(leftPos + BUTTON_X, topPos + BUTTON_Y,
                leftPos + BUTTON_X + BUTTON_W, topPos + BUTTON_Y + BUTTON_H, btnColor);
        graphics.drawCenteredString(font,
                Component.translatable("gui.ywformc.reveal"),
                leftPos + BUTTON_X + BUTTON_W / 2,
                topPos + BUTTON_Y + 3,
                complete ? 0xFFFFFF : 0x888888);
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(graphics);
        super.render(graphics, mouseX, mouseY, partialTick);
        this.renderTooltip(graphics, mouseX, mouseY);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (menu.isComplete()) {
            int bx = leftPos + BUTTON_X;
            int by = topPos + BUTTON_Y;
            if (mouseX >= bx && mouseX < bx + BUTTON_W && mouseY >= by && mouseY < by + BUTTON_H) {
                onRevealClicked();
                return true;
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    private void onRevealClicked() {
        // Son
        assert minecraft != null;
        minecraft.getSoundManager().play(
                SimpleSoundInstance.forUI(SoundEvents.PLAYER_LEVELUP, 1.0f));

        // Envoie un packet au serveur
        ModPackets.sendRevealPacket();
    }

    @Override
    protected void renderLabels(GuiGraphics graphics, int mouseX, int mouseY) {
        // Pas de titre affiché
    }
}