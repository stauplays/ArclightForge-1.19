package net.verox.arclight.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.verox.arclight.ArclightMod;
import net.verox.arclight.block.custom.ModRotatedPillarBlock;
import net.verox.arclight.block.custom.ModSaplingBlock;
import net.verox.arclight.block.custom.ModStairsBlock;
import net.verox.arclight.item.ModItems;
import net.verox.arclight.util.ModCreativeModeTab;
import net.verox.arclight.world.feature.tree.JadeTreeGrower;
import net.verox.arclight.world.feature.tree.MoonTreeGrower;
import net.verox.arclight.world.feature.tree.ShadowTreeGrower;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ArclightMod.MODID);

    //building

    public static final RegistryObject<Block> CLOUDSTONE = registerBlock("cloudstone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> CLOUDSTONE_BRICK = registerBlock("cloudstone_brick",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> CLOUDSTONE_COBBLED = registerBlock("cloudstone_cobbled",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> CLOUDSTONE_WALL = registerBlock("cloudstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> CLOUDSTONE_BRICK_WALL = registerBlock("cloudstone_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> CLOUDSTONE_SLAB = registerBlock("cloudstone_slab",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> CLOUDSTONE_BRICK_SLAB = registerBlock("cloudstone_brick_slab",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> CLOUDSTONE_STAIRS = registerBlock("cloudstone_stairs",
            () -> new ModStairsBlock(ModBlocks.CLOUDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> CLOUDSTONE_BRICK_STAIRS = registerBlock("cloudstone_brick_stairs",
            () -> new ModStairsBlock(ModBlocks.CLOUDSTONE_BRICK.get().defaultBlockState() ,BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> ARCLIGHT_BLOCK = registerBlock("arclight_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> MOON_LOG = registerBlock("moon_log",
            () -> new ModRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> MOON_WOOD = registerBlock("moon_wood",
            () -> new ModRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> STRIPPED_MOON_LOG = registerBlock("stripped_moon_log",
            () -> new ModRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> STRIPPED_MOON_WOOD = registerBlock("stripped_moon_wood",
            () -> new ModRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> MOON_PLANKS = registerBlock("moon_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> MOON_FENCE = registerBlock("moon_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> MOON_FENCE_GATE = registerBlock("moon_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> MOON_SLAB = registerBlock("moon_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> MOON_STAIRS = registerBlock("moon_stairs",
            () -> new ModStairsBlock(ModBlocks.MOON_PLANKS.get().defaultBlockState() ,BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> MOON_DOOR = registerBlock("moon_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(4f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> MOON_TRAPDOOR = registerBlock("moon_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(4f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> JADE_LOG = registerBlock("jade_log",
            () -> new ModRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> JADE_WOOD = registerBlock("jade_wood",
            () -> new ModRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> STRIPPED_JADE_LOG = registerBlock("stripped_jade_log",
            () -> new ModRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> STRIPPED_JADE_WOOD = registerBlock("stripped_jade_wood",
            () -> new ModRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> JADE_PLANKS = registerBlock("jade_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> JADE_FENCE = registerBlock("jade_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> JADE_FENCE_GATE = registerBlock("jade_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> JADE_SLAB = registerBlock("jade_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> JADE_STAIRS = registerBlock("jade_stairs",
            () -> new ModStairsBlock(ModBlocks.JADE_PLANKS.get().defaultBlockState() ,BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> JADE_DOOR = registerBlock("jade_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(4f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> JADE_TRAPDOOR = registerBlock("jade_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(4f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> SHADOW_LOG = registerBlock("shadow_log",
            () -> new ModRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> SHADOW_WOOD = registerBlock("shadow_wood",
            () -> new ModRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> STRIPPED_SHADOW_LOG = registerBlock("stripped_shadow_log",
            () -> new ModRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> STRIPPED_SHADOW_WOOD = registerBlock("stripped_shadow_wood",
            () -> new ModRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> SHADOW_PLANKS = registerBlock("shadow_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> SHADOW_FENCE = registerBlock("shadow_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> SHADOW_FENCE_GATE = registerBlock("shadow_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> SHADOW_SLAB = registerBlock("shadow_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> SHADOW_STAIRS = registerBlock("shadow_stairs",
            () -> new ModStairsBlock(ModBlocks.SHADOW_PLANKS.get().defaultBlockState() ,BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> SHADOW_DOOR = registerBlock("shadow_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(4f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> SHADOW_TRAPDOOR = registerBlock("shadow_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(4f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> MOON_LEAVES = registerBlock("moon_leaves",
        () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).noOcclusion()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> MOON_SAPLING = registerBlock("moon_sapling",
            () -> new ModSaplingBlock(new MoonTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> JADE_LEAVES = registerBlock("jade_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).noOcclusion()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> JADE_SAPLING = registerBlock("jade_sapling",
            () -> new ModSaplingBlock(new JadeTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> SHADOW_LEAVES = registerBlock("shadow_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).noOcclusion()), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> SHADOW_SAPLING = registerBlock("shadow_sapling",
            () -> new ModSaplingBlock(new ShadowTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.BUILDING_TAB);

    public static final RegistryObject<Block> ARCLIGHT_ORE = registerBlock("arclight_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)), ModCreativeModeTab.RESOURCES_TAB);

    public static final RegistryObject<Block> JADE_ORE = registerBlock("jade_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)), ModCreativeModeTab.RESOURCES_TAB);

    public static final RegistryObject<Block> MOONLIGHT_ORE = registerBlock("moonlight_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)), ModCreativeModeTab.RESOURCES_TAB);

    public static final RegistryObject<Block> ARMOR_FORGE = registerBlock("armor_forge",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.BUILDING_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
