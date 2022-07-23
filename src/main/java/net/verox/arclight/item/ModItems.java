package net.verox.arclight.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.verox.arclight.ArclightMod;
import net.verox.arclight.entity.mob.EntityTypes;
import net.verox.arclight.item.custom.*;
import net.verox.arclight.util.ModCreativeModeTab;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ArclightMod.MODID);

    public static final RegistryObject<Item> COPPER_SWORD = ITEMS.register("copper_sword",
            () -> new SwordItem(ModToolTiers.COPPER,3,-2.4f, new Item.Properties().tab(ModCreativeModeTab.ARCLIGHT_TAB)));
    public static final RegistryObject<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe",
            () -> new PickaxeItem(ModToolTiers.COPPER,1,-2.8f, new Item.Properties().tab(ModCreativeModeTab.ARCLIGHT_TAB)));
    public static final RegistryObject<Item> COPPER_AXE = ITEMS.register("copper_axe",
            () -> new AxeItem(ModToolTiers.COPPER,6,-3.1f, new Item.Properties().tab(ModCreativeModeTab.ARCLIGHT_TAB)));
    public static final RegistryObject<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel",
            () -> new ShovelItem(ModToolTiers.COPPER,1,-2.8f, new Item.Properties().tab(ModCreativeModeTab.ARCLIGHT_TAB)));
    public static final RegistryObject<Item> COPPER_HOE = ITEMS.register("copper_hoe",
            () -> new HoeItem(ModToolTiers.COPPER,-2,-1f, new Item.Properties().tab(ModCreativeModeTab.ARCLIGHT_TAB)));

    public static final RegistryObject<Item> ARCLIGHT_SWORD = ITEMS.register("arclight_sword",
            () -> new SwordItem(ModToolTiers.ARCLIGHT,2,-2.4f, new Item.Properties().tab(ModCreativeModeTab.ARCLIGHT_TAB)));
    public static final RegistryObject<Item> ARCLIGHT_PICKAXE = ITEMS.register("arclight_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ARCLIGHT,0,-2.8f, new Item.Properties().tab(ModCreativeModeTab.ARCLIGHT_TAB)));
    public static final RegistryObject<Item> ARCLIGHT_AXE = ITEMS.register("arclight_axe",
            () -> new AxeItem(ModToolTiers.ARCLIGHT,4,-3f, new Item.Properties().tab(ModCreativeModeTab.ARCLIGHT_TAB)));
    public static final RegistryObject<Item> ARCLIGHT_SHOVEL = ITEMS.register("arclight_shovel",
            () -> new ShovelItem(ModToolTiers.ARCLIGHT,0,-3f, new Item.Properties().tab(ModCreativeModeTab.ARCLIGHT_TAB)));
    public static final RegistryObject<Item> ARCLIGHT_HOE = ITEMS.register("arclight_hoe",
            () -> new HoeItem(ModToolTiers.ARCLIGHT,-4,0f, new Item.Properties().tab(ModCreativeModeTab.ARCLIGHT_TAB)));

    public static final RegistryObject<Item> JADE_SWORD = ITEMS.register("jade_sword",
            () -> new SwordItem(ModToolTiers.JADE,3,-2.4f, new Item.Properties().tab(ModCreativeModeTab.ARCLIGHT_TAB)));
    public static final RegistryObject<Item> JADE_PICKAXE = ITEMS.register("jade_pickaxe",
            () -> new PickaxeItem(ModToolTiers.JADE,1,-2.8f, new Item.Properties().tab(ModCreativeModeTab.ARCLIGHT_TAB)));
    public static final RegistryObject<Item> JADE_AXE = ITEMS.register("jade_axe",
            () -> new AxeItem(ModToolTiers.JADE,5,-3f, new Item.Properties().tab(ModCreativeModeTab.ARCLIGHT_TAB)));
    public static final RegistryObject<Item> JADE_SHOVEL = ITEMS.register("jade_shovel",
            () -> new ShovelItem(ModToolTiers.JADE,1,-3f, new Item.Properties().tab(ModCreativeModeTab.ARCLIGHT_TAB)));
    public static final RegistryObject<Item> JADE_HOE = ITEMS.register("jade_hoe",
            () -> new HoeItem(ModToolTiers.JADE,-4,0f, new Item.Properties().tab(ModCreativeModeTab.ARCLIGHT_TAB)));

    public static final RegistryObject<Item> MOONLIGHT_SWORD = ITEMS.register("moonlight_sword",
            () -> new SwordItem(ModToolTiers.MOONLIGHT,3,-2.4f, new Item.Properties().tab(ModCreativeModeTab.ARCLIGHT_TAB)));
    public static final RegistryObject<Item> MOONLIGHT_PICKAXE = ITEMS.register("moonlight_pickaxe",
            () -> new PickaxeItem(ModToolTiers.MOONLIGHT,1,-2.8f, new Item.Properties().tab(ModCreativeModeTab.ARCLIGHT_TAB)));
    public static final RegistryObject<Item> MOONLIGHT_AXE = ITEMS.register("moonlight_axe",
            () -> new AxeItem(ModToolTiers.MOONLIGHT,5,-3f, new Item.Properties().tab(ModCreativeModeTab.ARCLIGHT_TAB)));
    public static final RegistryObject<Item> MOONLIGHT_SHOVEL = ITEMS.register("moonlight_shovel",
            () -> new ShovelItem(ModToolTiers.MOONLIGHT,1,-2.8f, new Item.Properties().tab(ModCreativeModeTab.ARCLIGHT_TAB)));
    public static final RegistryObject<Item> MOONLIGHT_HOE = ITEMS.register("moonlight_hoe",
            () -> new HoeItem(ModToolTiers.MOONLIGHT,-3,0f, new Item.Properties().tab(ModCreativeModeTab.ARCLIGHT_TAB)));

    public static final RegistryObject<Item> ARCLIGHT_CORE = ITEMS.register("arclight_core",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RESOURCES_TAB)));

    public static final RegistryObject<Item> ANGEL_SPAWN = ITEMS.register("angel_spawn",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MOB_TAB)));

    public static final RegistryObject<Item> STINGER = ITEMS.register("stinger",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MOB_TAB)));

    public static final RegistryObject<Item> ARCLIGHT_GEM = ITEMS.register("arclight_gem",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RESOURCES_TAB)));

    public static final RegistryObject<Item> ARCLIGHT_INGOT = ITEMS.register("arclight_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RESOURCES_TAB)));

    public static final RegistryObject<Item> JADE_SHARD = ITEMS.register("jade_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RESOURCES_TAB)));

    public static final RegistryObject<Item> JADE_INGOT = ITEMS.register("jade_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RESOURCES_TAB)));

    public static final RegistryObject<Item> MOONLIGHT_CORE = ITEMS.register("moonlight_core",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RESOURCES_TAB)));

    public static final RegistryObject<Item> MOONLIGHT_CRYSTAL = ITEMS.register("moonlight_crystal",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RESOURCES_TAB)));

    public static final RegistryObject<Item> MOONLIGHT_INGOT = ITEMS.register("moonlight_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RESOURCES_TAB)));

    public static final RegistryObject<Item> MOONLIGHT_JELLYBALL = ITEMS.register("moonlight_jellyball",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RESOURCES_TAB)));

    public static final RegistryObject<Item> MOONLIGHT_CRYSTALIZED = ITEMS.register("moonlight_crystalized",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RESOURCES_TAB)));

    public static final RegistryObject<Item> ARCLIGHTS_HELMET = ITEMS.register("arclight_helmet",
            () -> new ArclightArmorItem(ModArmorMaterials.ARCLIGHT, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeModeTab.ARCLIGHT_TAB)));
    public static final RegistryObject<Item> ARCLIGHTS_CHESTLATE = ITEMS.register("arclight_chestplate",
            () -> new ArclightArmorItem(ModArmorMaterials.ARCLIGHT, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeModeTab.ARCLIGHT_TAB)));
    public static final RegistryObject<Item> ARCLIGHTS_LEGGINGS = ITEMS.register("arclight_leggings",
            () -> new ArclightArmorItem(ModArmorMaterials.ARCLIGHT, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeModeTab.ARCLIGHT_TAB)));
    public static final RegistryObject<Item> ARCLIGHTS_BOOTS = ITEMS.register("arclight_boots",
            () -> new ArclightArmorItem(ModArmorMaterials.ARCLIGHT, EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeModeTab.ARCLIGHT_TAB)));

    public static final RegistryObject<Item> HOLYKNIGHTS_HELMET = ITEMS.register("holyknight_helmet",
            () -> new HolyKnightArmorItem(ModArmorMaterials.HOLYKNIGHT, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeModeTab.ARCLIGHT_TAB)));
    public static final RegistryObject<Item> HOLYKNIGHTS_CHESTLATE = ITEMS.register("holyknight_chestplate",
            () -> new HolyKnightArmorItem(ModArmorMaterials.HOLYKNIGHT, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeModeTab.ARCLIGHT_TAB)));
    public static final RegistryObject<Item> HOLYKNIGHTS_LEGGINGS = ITEMS.register("holyknight_leggings",
            () -> new HolyKnightArmorItem(ModArmorMaterials.HOLYKNIGHT, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeModeTab.ARCLIGHT_TAB)));
    public static final RegistryObject<Item> HOLYKNIGHTS_BOOTS = ITEMS.register("holyknight_boots",
            () -> new HolyKnightArmorItem(ModArmorMaterials.HOLYKNIGHT, EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeModeTab.ARCLIGHT_TAB)));

    public static final RegistryObject<Item> MOONLIGHT_HELMET = ITEMS.register("moonlight_helmet",
            () -> new MoonlightArmorItem(ModArmorMaterials.MOONLIGHT, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeModeTab.ARCLIGHT_TAB)));
    public static final RegistryObject<Item> MOONLIGHT_CHESTLATE = ITEMS.register("moonlight_chestplate",
            () -> new MoonlightArmorItem(ModArmorMaterials.MOONLIGHT, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeModeTab.ARCLIGHT_TAB)));
    public static final RegistryObject<Item> MOONLIGHT_LEGGINGS = ITEMS.register("moonlight_leggings",
            () -> new MoonlightArmorItem(ModArmorMaterials.MOONLIGHT, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeModeTab.ARCLIGHT_TAB)));
    public static final RegistryObject<Item> MOONLIGHT_BOOTS = ITEMS.register("moonlight_boots",
            () -> new MoonlightArmorItem(ModArmorMaterials.MOONLIGHT, EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeModeTab.ARCLIGHT_TAB)));

    public static final RegistryObject<Item> ANGEL_SPAWN_EGG = ITEMS.register("angel_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.ANGEL, 0xE1EF05, 0x6FF2FA,new Item.Properties().tab(ModCreativeModeTab.MOB_TAB)));

    public static final RegistryObject<Item> JELLY_SPAWN_EGG = ITEMS.register("jelly_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.JELLY, 0x09B2D9, 0xD1EFF6,new Item.Properties().tab(ModCreativeModeTab.MOB_TAB)));

    public static final RegistryObject<Item> SCORPION_SPAWN_EGG = ITEMS.register("scorpion_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.SCORPION, 0x280404, 0xF89918,new Item.Properties().tab(ModCreativeModeTab.MOB_TAB)));

    public static final RegistryObject<Item> SCORPION_SCALE = ITEMS.register("scorpion_scale",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RESOURCES_TAB)));

    public static final RegistryObject<Item> ANGEL_SWORD = ITEMS.register("angel_sword",
            () -> new AngelSwordItem(ModToolTiers.ARCLIGHT, 7, -2.4f, new Item.Properties().tab(ModCreativeModeTab.MOB_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
