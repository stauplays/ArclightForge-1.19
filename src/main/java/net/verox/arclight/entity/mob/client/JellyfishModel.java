package net.verox.arclight.entity.mob.client;

import net.minecraft.resources.ResourceLocation;
import net.verox.arclight.ArclightMod;
import net.verox.arclight.entity.mob.custom.AngelEntity;
import net.verox.arclight.entity.mob.custom.JellyfishEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class JellyfishModel extends AnimatedGeoModel<JellyfishEntity> {
    @Override
    public ResourceLocation getModelResource(JellyfishEntity object) {
        return new ResourceLocation(ArclightMod.MODID, "geo/moonlight_jelly.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(JellyfishEntity object) {
        return new ResourceLocation(ArclightMod.MODID, "textures/entity/jellyfish/moonlight_jelly.png");
    }

    @Override
    public ResourceLocation getAnimationResource(JellyfishEntity animateable) {
        return new ResourceLocation(ArclightMod.MODID, "animations/moonlight_jelly.animation.json");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setLivingAnimations(JellyfishEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }

}