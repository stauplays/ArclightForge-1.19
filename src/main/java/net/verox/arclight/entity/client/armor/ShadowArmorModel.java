package net.verox.arclight.entity.client.armor;

import net.minecraft.resources.ResourceLocation;
import net.verox.arclight.ArclightMod;
import net.verox.arclight.item.custom.ScorpionArmorItem;
import net.verox.arclight.item.custom.ShadowArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ShadowArmorModel extends AnimatedGeoModel<ShadowArmorItem> {
    @Override
    public ResourceLocation  getModelResource(ShadowArmorItem object) {
        return new ResourceLocation(ArclightMod.MODID, "geo/shadow_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ShadowArmorItem object) {
        return new ResourceLocation(ArclightMod.MODID, "textures/models/armor/shadow_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ShadowArmorItem animatable) {
        return new ResourceLocation(ArclightMod.MODID, "animations/armor_animation.json");
    }

}
