package net.verox.arclight.entity.mob.client;

import net.minecraft.resources.ResourceLocation;
import net.verox.arclight.ArclightMod;
import net.verox.arclight.entity.mob.custom.AngelEntity;
import net.verox.arclight.entity.mob.custom.ScorpionEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class ScorpionModel extends AnimatedGeoModel<ScorpionEntity> {
    @Override
    public ResourceLocation getModelResource(ScorpionEntity object) {
        return new ResourceLocation(ArclightMod.MODID, "geo/scorpion.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ScorpionEntity object) {
        return new ResourceLocation(ArclightMod.MODID, "textures/entity/scorpion/scorpion.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ScorpionEntity animateable) {
        return new ResourceLocation(ArclightMod.MODID, "animations/scorpion.animation.json");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setLivingAnimations(ScorpionEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }

}