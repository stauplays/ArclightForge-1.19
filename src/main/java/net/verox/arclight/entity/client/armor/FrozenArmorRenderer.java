package net.verox.arclight.entity.client.armor;

import net.verox.arclight.item.custom.ArclightArmorItem;
import net.verox.arclight.item.custom.FrozenArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class FrozenArmorRenderer extends GeoArmorRenderer<FrozenArmorItem> {
    public FrozenArmorRenderer() {
        super(new FrozenArmorModel());

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
