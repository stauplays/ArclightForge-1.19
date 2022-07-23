package net.verox.arclight.entity.client.armor;


import net.minecraft.resources.ResourceLocation;
import net.verox.arclight.ArclightMod;
import net.verox.arclight.item.custom.HolyKnightArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HolyKnightArmorModel extends AnimatedGeoModel<HolyKnightArmorItem> {
    @Override
    public ResourceLocation getModelResource(HolyKnightArmorItem object) {
        return new ResourceLocation(ArclightMod.MODID, "geo/holyknight_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HolyKnightArmorItem object) {
        return new ResourceLocation(ArclightMod.MODID, "textures/models/armor/holyknight_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HolyKnightArmorItem animatable) {
        return new ResourceLocation(ArclightMod.MODID, "animations/armor_animation.json");
    }
}