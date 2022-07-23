package net.verox.arclight.world.feature;

import com.google.common.base.Suppliers;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.verox.arclight.ArclightMod;
import net.verox.arclight.block.ModBlocks;

import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures  {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, ArclightMod.MODID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_ARCLIGHT_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.ARCLIGHT_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> END_JADE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), ModBlocks.JADE_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_MOONLIGHT_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.MOONLIGHT_ORE.get().defaultBlockState())));


    public static final RegistryObject<ConfiguredFeature<?, ?>> OVERWORLD_ARCLIGHT_ORE = CONFIGURED_FEATURES.register("overworld_arclight_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_ARCLIGHT_ORES.get(),7)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> END_JADE_ORE = CONFIGURED_FEATURES.register("end_jade_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(END_JADE_ORES.get(), 9)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> NETHER_MOONLIGHT_ORE = CONFIGURED_FEATURES.register("nether_moonlight_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHER_MOONLIGHT_ORES.get(), 9)));

    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> MOON_TREE =
            FeatureUtils.register("moon_tree", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocks.MOON_LOG.get()),
                    new ForkingTrunkPlacer(3, 5, 4),
                    BlockStateProvider.simple(ModBlocks.MOON_LEAVES.get()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                    new TwoLayersFeatureSize(1, 0, 2)).build());

    public static final Holder<PlacedFeature> MOON_CHECKED = PlacementUtils.register("moon_checked", MOON_TREE,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.MOON_SAPLING.get()));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> MOON_SPAWN =
            FeatureUtils.register("moon_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(MOON_CHECKED,
                            0.5F)), MOON_CHECKED));

    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> JADE_TREE =
            FeatureUtils.register("jade_tree", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocks.JADE_LOG.get()),
                    new ForkingTrunkPlacer(3, 5, 4),
                    BlockStateProvider.simple(ModBlocks.JADE_LEAVES.get()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                    new TwoLayersFeatureSize(1, 0, 2)).build());

    public static final Holder<PlacedFeature> JADE_CHECKED = PlacementUtils.register("jade_checked", JADE_TREE,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.JADE_SAPLING.get()));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> JADE_SPAWN =
            FeatureUtils.register("jade_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(JADE_CHECKED,
                            0.5F)), JADE_CHECKED));

    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> SHADOW_TREE =
            FeatureUtils.register("shadow_tree", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocks.SHADOW_LOG.get()),
                    new ForkingTrunkPlacer(3, 5, 4),
                    BlockStateProvider.simple(ModBlocks.SHADOW_LEAVES.get()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                    new TwoLayersFeatureSize(1, 0, 2)).build());

    public static final Holder<PlacedFeature> SHADOW_CHECKED = PlacementUtils.register("shadow_checked", SHADOW_TREE,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.SHADOW_SAPLING.get()));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> SHADOW_SPAWN =
            FeatureUtils.register("shadow_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(SHADOW_CHECKED,
                            0.5F)), SHADOW_CHECKED));

}