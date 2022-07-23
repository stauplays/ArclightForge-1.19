package net.verox.arclight.entity.client.armor;

import net.verox.arclight.item.custom.ArclightArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class ArclightArmorRenderer extends GeoArmorRenderer<ArclightArmorItem> {
    public ArclightArmorRenderer() {
        super(new ArclightArmorModel());

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorLeftArm";
        this.leftArmBone = "armorRightArm";
        this.rightLegBone = "armorLeftLeg";
        this.leftLegBone = "armorRightLeg";
        this.rightBootBone = "armorLeftBoots";
        this.leftBootBone = "armorRightBoots";

    }
}
