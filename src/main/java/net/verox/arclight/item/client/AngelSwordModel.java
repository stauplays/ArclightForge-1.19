package net.verox.arclight.item.client;

import net.minecraft.resources.ResourceLocation;
import net.verox.arclight.ArclightMod;
import net.verox.arclight.item.custom.AngelSwordItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AngelSwordModel  extends AnimatedGeoModel<AngelSwordItem> {
    @Override
    public ResourceLocation getModelResource(AngelSwordItem object) {
        return new ResourceLocation(ArclightMod.MODID, "geo/angel_sword.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AngelSwordItem object) {
        return new ResourceLocation(ArclightMod.MODID, "textures/item/angel_sword.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AngelSwordItem animatable) {
        return new ResourceLocation(ArclightMod.MODID, "animations/armor_animation.json");
    }
}
