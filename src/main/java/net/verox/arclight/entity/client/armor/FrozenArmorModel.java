package net.verox.arclight.entity.client.armor;

import net.minecraft.resources.ResourceLocation;
import net.verox.arclight.ArclightMod;
import net.verox.arclight.item.custom.ArclightArmorItem;
import net.verox.arclight.item.custom.FrozenArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FrozenArmorModel extends AnimatedGeoModel<FrozenArmorItem> {
    @Override
    public ResourceLocation  getModelResource(FrozenArmorItem object) {
        return new ResourceLocation(ArclightMod.MODID, "geo/frosted_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FrozenArmorItem object) {
        return new ResourceLocation(ArclightMod.MODID, "textures/models/armor/frosted_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FrozenArmorItem animatable) {
        return new ResourceLocation(ArclightMod.MODID, "animations/armor_animation.json");
    }

}
