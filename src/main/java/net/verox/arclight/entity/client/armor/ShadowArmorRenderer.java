package net.verox.arclight.entity.client.armor;

import net.verox.arclight.item.custom.ScorpionArmorItem;
import net.verox.arclight.item.custom.ShadowArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class ShadowArmorRenderer extends GeoArmorRenderer<ShadowArmorItem> {
    public ShadowArmorRenderer() {
        super(new ShadowArmorModel());

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
