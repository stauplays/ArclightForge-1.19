package net.verox.arclight.util;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.verox.arclight.block.ModBlocks;
import net.verox.arclight.item.ModItems;

public class ModCreativeModeTab {
    public static final CreativeModeTab RESOURCES_TAB = new CreativeModeTab("arclight_resources") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ARCLIGHT_GEM.get());
        }
    };

    public static final CreativeModeTab BUILDING_TAB = new CreativeModeTab("arclight_building") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.CLOUDSTONE.get());
        }
    };

    public static final CreativeModeTab MOB_TAB = new CreativeModeTab("arclight_mobs") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ANGEL_SPAWN.get());
        }
    };

    public static final CreativeModeTab ARCLIGHT_TAB = new CreativeModeTab("arclight_group") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ARCLIGHT_CORE.get());
        }
    };
}
