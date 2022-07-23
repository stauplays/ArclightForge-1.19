package net.verox.arclight.entity.client.armor;

import net.minecraft.resources.ResourceLocation;
import net.verox.arclight.ArclightMod;
import net.verox.arclight.item.custom.MoonlightArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MoonlightArmorModel extends AnimatedGeoModel<MoonlightArmorItem> {
    @Override
    public ResourceLocation getModelResource(MoonlightArmorItem object) {
        return new ResourceLocation(ArclightMod.MODID, "geo/moonlight_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MoonlightArmorItem object) {
        return new ResourceLocation(ArclightMod.MODID, "textures/models/armor/moonlight_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MoonlightArmorItem animatable) {
        return new ResourceLocation(ArclightMod.MODID, "animations/armor_animation.json");
    }
}
