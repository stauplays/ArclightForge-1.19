package net.verox.arclight.entity.client.armor;

import net.minecraft.resources.ResourceLocation;
import net.verox.arclight.ArclightMod;
import net.verox.arclight.item.custom.ShadowArmorItem;
import net.verox.arclight.item.custom.SteelArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SteelArmorModel extends AnimatedGeoModel<SteelArmorItem> {
    @Override
    public ResourceLocation  getModelResource(SteelArmorItem object) {
        return new ResourceLocation(ArclightMod.MODID, "geo/steel_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SteelArmorItem object) {
        return new ResourceLocation(ArclightMod.MODID, "textures/models/armor/steel_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SteelArmorItem animatable) {
        return new ResourceLocation(ArclightMod.MODID, "animations/armor_animation.json");
    }

}
