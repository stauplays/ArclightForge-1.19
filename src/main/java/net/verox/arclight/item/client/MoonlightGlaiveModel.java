package net.verox.arclight.item.client;

import net.minecraft.resources.ResourceLocation;
import net.verox.arclight.ArclightMod;
import net.verox.arclight.item.custom.AngelSwordItem;
import net.verox.arclight.item.custom.MoonlightGlaiveItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MoonlightGlaiveModel extends AnimatedGeoModel<MoonlightGlaiveItem> {
    @Override
    public ResourceLocation getModelResource(MoonlightGlaiveItem object) {
        return new ResourceLocation(ArclightMod.MODID, "geo/moonlight_glaive.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MoonlightGlaiveItem object) {
        return new ResourceLocation(ArclightMod.MODID, "textures/item/moonlight_glaive.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MoonlightGlaiveItem animatable) {
        return new ResourceLocation(ArclightMod.MODID, "animations/armor_animation.json");
    }
}
