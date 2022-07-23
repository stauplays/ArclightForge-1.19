package net.verox.arclight.entity.client.armor;

import net.verox.arclight.item.custom.MoonlightArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class MoonlightArmorRenderer extends GeoArmorRenderer<MoonlightArmorItem> {
    public MoonlightArmorRenderer() {
        super(new MoonlightArmorModel());

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorRightLeg";
        this.leftLegBone = "armorLeftLeg";
        this.rightBootBone = "armorRightBoots";
        this.leftBootBone = "armorLeftBoots";

    }
}
