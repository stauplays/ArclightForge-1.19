package net.verox.arclight.entity.mob.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.verox.arclight.ArclightMod;
import net.verox.arclight.entity.mob.custom.AngelEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class AngelRenderer extends GeoEntityRenderer<AngelEntity> {
    public AngelRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AngelModel());
        this.shadowRadius = 0.3f;
    }

    public ResourceLocation getTextureResource(AngelEntity instance) {
        return new ResourceLocation(ArclightMod.MODID, "textures/entity/angel/angel.png");
    }

    @Override
    public RenderType getRenderType(AngelEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.8F, 0.8F, 0.8F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}