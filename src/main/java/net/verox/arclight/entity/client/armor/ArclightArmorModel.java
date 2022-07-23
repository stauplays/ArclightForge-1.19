package net.verox.arclight.entity.client.armor;

import net.minecraft.resources.ResourceLocation;
import net.verox.arclight.ArclightMod;
import net.verox.arclight.item.custom.ArclightArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ArclightArmorModel extends AnimatedGeoModel<ArclightArmorItem> {
    @Override
    public ResourceLocation  getModelResource(ArclightArmorItem object) {
        return new ResourceLocation(ArclightMod.MODID, "geo/arclight_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ArclightArmorItem object) {
        return new ResourceLocation(ArclightMod.MODID, "textures/models/armor/arclight_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ArclightArmorItem animatable) {
        return new ResourceLocation(ArclightMod.MODID, "animations/armor_animation.json");
    }

}
