package net.verox.arclight.item.client;

import net.verox.arclight.item.custom.AngelSwordItem;
import net.verox.arclight.item.custom.MoonlightGlaiveItem;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class MoonlightGlaiveRenderer extends GeoItemRenderer<MoonlightGlaiveItem> {
    public MoonlightGlaiveRenderer() {
        super(new MoonlightGlaiveModel());
    }
}
