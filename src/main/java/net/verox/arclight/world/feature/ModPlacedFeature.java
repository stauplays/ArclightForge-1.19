package net.verox.arclight.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.verox.arclight.ArclightMod;

import java.util.List;

public class ModPlacedFeature {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, ArclightMod.MODID);

    public static final RegistryObject<PlacedFeature> MOON_PLACED = PLACED_FEATURES.register("moon_placed",
            () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>) (Holder<? extends ConfiguredFeature<?,?>>)
            ModConfiguredFeatures.MOON_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(3, 0.1f, 2))));

    public static final RegistryObject<PlacedFeature> JADE_PLACED = PLACED_FEATURES.register("jade_placed",
            () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>) (Holder<? extends ConfiguredFeature<?,?>>)
                    ModConfiguredFeatures.JADE_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(3, 0.1f, 2))));

    public static final RegistryObject<PlacedFeature> SHADOW_PLACED = PLACED_FEATURES.register("shadow_placed",
            () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>) (Holder<? extends ConfiguredFeature<?,?>>)
                    ModConfiguredFeatures.SHADOW_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(3, 0.1f, 2))));



    public static final RegistryObject<PlacedFeature> ARCLIGHT_ORE_PLACED = PLACED_FEATURES.register("arclight_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.OVERWORLD_ARCLIGHT_ORE.getHolder().get(),
                    commonOrePlacement(3, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(74), VerticalAnchor.aboveBottom(94)))));

    public static final RegistryObject<PlacedFeature> JADE_ORE_PLACED = PLACED_FEATURES.register("jade_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.END_JADE_ORE.getHolder().get(), commonOrePlacement(3, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(10), VerticalAnchor.aboveBottom(40)))));

    public static final RegistryObject<PlacedFeature> MOONLIGHT_ORE_PLACED = PLACED_FEATURES.register("moonlight_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.NETHER_MOONLIGHT_ORE.getHolder().get(), commonOrePlacement(3, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(40), VerticalAnchor.aboveBottom(120)))));


    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }


    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}