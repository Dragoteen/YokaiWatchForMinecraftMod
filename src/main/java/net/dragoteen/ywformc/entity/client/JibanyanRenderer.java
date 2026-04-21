package net.dragoteen.ywformc.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.dragoteen.ywformc.YoKaiWatchForMinecraftMod;
import net.dragoteen.ywformc.entity.custom.JibanyanEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class JibanyanRenderer extends MobRenderer<JibanyanEntity, JibanyanModel<JibanyanEntity>> {
    public JibanyanRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new JibanyanModel<>(pContext.bakeLayer(ModModelLayers.JIBANYAN_LAYER)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(JibanyanEntity jibanyanEntity) {
        return new ResourceLocation(YoKaiWatchForMinecraftMod.MODID, "textures/entity/jibanyan.png");
    }

    @Override
    public void render(JibanyanEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {

        if(pEntity.isBaby()) {
            pPoseStack.scale(0.5f,0.5f,0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
