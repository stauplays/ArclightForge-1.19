package net.verox.arclight.item.custom;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.verox.arclight.item.ModItems;

public class ModToolTiers {
    public static final ForgeTier ARCLIGHT = new ForgeTier(4, 2500, 12.0f,
            4.5f, 25, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.ARCLIGHT_INGOT.get()));

    public static final ForgeTier JADE = new ForgeTier(4, 2500, 12.0f,
            5.0f, 25, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.JADE_INGOT.get()));

    public static final ForgeTier MOONLIGHT = new ForgeTier(4, 1700, 10.0f,
            3.0f, 25, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.MOONLIGHT_INGOT.get()));

    public static final ForgeTier COPPER = new ForgeTier(2, 250, 6.0f,
            2.0f, 14, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(Items.COPPER_INGOT));
}
