package net.verox.arclight.entity.client.armor;

import net.minecraft.resources.ResourceLocation;
import net.verox.arclight.ArclightMod;
import net.verox.arclight.item.custom.AngelArmorItem;
import net.verox.arclight.item.custom.ArclightArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AngelArmorModel extends AnimatedGeoModel<AngelArmorItem> {
    @Override
    public ResourceLocation  getModelResource(AngelArmorItem object) {
        return new ResourceLocation(ArclightMod.MODID, "geo/angle_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AngelArmorItem object) {
        return new ResourceLocation(ArclightMod.MODID, "textures/models/armor/angle_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AngelArmorItem animatable) {
        return new ResourceLocation(ArclightMod.MODID, "animations/angle_armor_animation.json");
    }

}
