package net.verox.arclight.entity.mob.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.verox.arclight.ArclightMod;
import net.verox.arclight.entity.mob.custom.AngelEntity;
import net.verox.arclight.entity.mob.custom.ScorpionEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ScorpionRenderer extends GeoEntityRenderer<ScorpionEntity> {
    public ScorpionRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ScorpionModel());
        this.shadowRadius = 0.3f;
    }

    public ResourceLocation getTextureResource(ScorpionEntity instance) {
        return new ResourceLocation(ArclightMod.MODID, "extures/entity/scorpion/scorpion.png");
    }

    @Override
    public RenderType getRenderType(ScorpionEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.8F, 0.8F, 0.8F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}