package net.verox.arclight;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.verox.arclight.block.ModBlocks;
import net.verox.arclight.entity.mob.EntityTypes;
import net.verox.arclight.entity.mob.client.AngelRenderer;
import net.verox.arclight.item.ModItems;
import net.verox.arclight.world.biomemods.ModBiomeModifiers;
import net.verox.arclight.world.feature.ModConfiguredFeatures;
import net.verox.arclight.world.feature.ModPlacedFeature;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

@Mod(ArclightMod.MODID)
public class ArclightMod
{
    public static final String MODID = "arclight";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ArclightMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModBiomeModifiers.register(modEventBus);
        ModPlacedFeature.register(modEventBus);

        EntityTypes.register(modEventBus);

        GeckoLib.initialize();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(EntityTypes.ANGEL.get(), AngelRenderer::new);
        }
    }
}