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
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
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

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_CLOUDSTONES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.CLOUDSTONE.get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> OVERWORLD_CLOUDSTONE = CONFIGURED_FEATURES.register("overworld_cloudstone",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.CLOUDSTONE.get().defaultBlockState(),37)));


    public static final RegistryObject<ConfiguredFeature<?, ?>> OVERWORLD_ARCLIGHT_ORE = CONFIGURED_FEATURES.register("overworld_arclight_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.ARCLIGHT_ORE.get().defaultBlockState(),3)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> END_JADE_ORE = CONFIGURED_FEATURES.register("end_jade_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(new BlockMatchTest(Blocks.END_STONE), ModBlocks.JADE_ORE.get().defaultBlockState(),3)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> NETHER_MOONLIGHT_ORE = CONFIGURED_FEATURES.register("nether_moonlight_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.MOONLIGHT_ORE.get().defaultBlockState(),3)));

    public static final RegistryObject<ConfiguredFeature<?,?>> MOON_TREE = CONFIGURED_FEATURES.register("moon_tree", () -> new ConfiguredFeature<>(Feature.TREE,
            new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.MOON_LOG.get()),
                    new ForkingTrunkPlacer(5,6,3),
                    BlockStateProvider.simple(ModBlocks.MOON_LEAVES.get()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0),4),
                    new TwoLayersFeatureSize(1,0,2)).build()));

    public static final RegistryObject<ConfiguredFeature<?,?>> JADE_TREE = CONFIGURED_FEATURES.register("jade_tree", () -> new ConfiguredFeature<>(Feature.TREE,
            new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.JADE_LOG.get()),
                    new ForkingTrunkPlacer(5,6,3),
                    BlockStateProvider.simple(ModBlocks.JADE_LEAVES.get()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0),4),
                    new TwoLayersFeatureSize(1,0,2)).build()));

    public static final RegistryObject<ConfiguredFeature<?,?>> SHADOW_TREE = CONFIGURED_FEATURES.register("shadow_tree", () -> new ConfiguredFeature<>(Feature.TREE,
            new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.SHADOW_LOG.get()),
                    new ForkingTrunkPlacer(5,6,3),
                    BlockStateProvider.simple(ModBlocks.SHADOW_LEAVES.get()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0),4),
                    new TwoLayersFeatureSize(1,0,2)).build()));


    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}