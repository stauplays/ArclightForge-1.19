package net.verox.arclight.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.verox.arclight.ArclightMod;
import net.verox.arclight.entity.client.armor.ArclightArmorRenderer;
import net.verox.arclight.entity.client.armor.HolyKnightArmorRenderer;
import net.verox.arclight.entity.client.armor.MoonlightArmorRenderer;
import net.verox.arclight.entity.mob.EntityTypes;
import net.verox.arclight.entity.mob.custom.AngelEntity;
import net.verox.arclight.item.custom.ArclightArmorItem;
import net.verox.arclight.item.custom.HolyKnightArmorItem;
import net.verox.arclight.item.custom.MoonlightArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

@Mod.EventBusSubscriber(modid = ArclightMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {
    @SubscribeEvent
    public static void registerArmorRenderers(final EntityRenderersEvent.AddLayers event) {
        GeoArmorRenderer.registerArmorRenderer(ArclightArmorItem.class, new ArclightArmorRenderer());
        GeoArmorRenderer.registerArmorRenderer(HolyKnightArmorItem.class, new HolyKnightArmorRenderer());
        GeoArmorRenderer.registerArmorRenderer(MoonlightArmorItem.class, new MoonlightArmorRenderer());
    }

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(EntityTypes.ANGEL.get(), AngelEntity.setAttributes());
    }
}
