package net.verox.arclight.entity.client.armor;

import net.minecraft.resources.ResourceLocation;
import net.verox.arclight.ArclightMod;
import net.verox.arclight.item.custom.FrozenArmorItem;
import net.verox.arclight.item.custom.ScorpionArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ScorpionArmorModel extends AnimatedGeoModel<ScorpionArmorItem> {
    @Override
    public ResourceLocation  getModelResource(ScorpionArmorItem object) {
        return new ResourceLocation(ArclightMod.MODID, "geo/scorpion_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ScorpionArmorItem object) {
        return new ResourceLocation(ArclightMod.MODID, "textures/models/armor/scorpion_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ScorpionArmorItem animatable) {
        return new ResourceLocation(ArclightMod.MODID, "animations/armor_animation.json");
    }

}
