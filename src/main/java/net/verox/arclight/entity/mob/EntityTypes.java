package net.verox.arclight.entity.mob;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.verox.arclight.ArclightMod;
import net.verox.arclight.entity.mob.custom.AngelEntity;
import net.verox.arclight.entity.mob.custom.JellyfishEntity;
import net.verox.arclight.entity.mob.custom.ScorpionEntity;

public class EntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ArclightMod.MODID);

    public static final RegistryObject<EntityType<AngelEntity>> ANGEL =
            ENTITY_TYPES.register("angel",
                    () -> EntityType.Builder.of(AngelEntity::new, MobCategory.CREATURE)
                            .sized(1.0f, 2.0f)
                            .build(new ResourceLocation(ArclightMod.MODID, "raccoon").toString()));

    public static final RegistryObject<EntityType<JellyfishEntity>> JELLY =
            ENTITY_TYPES.register("jelly",
                    () -> EntityType.Builder.of(JellyfishEntity::new, MobCategory.CREATURE)
                            .sized(0.5f, 1.0f)
                            .build(new ResourceLocation(ArclightMod.MODID, "jelly").toString()));

    public static final RegistryObject<EntityType<ScorpionEntity>> SCORPION =
            ENTITY_TYPES.register("scorpion",
                    () -> EntityType.Builder.of(ScorpionEntity::new, MobCategory.CREATURE)
                            .sized(3.0f, 2.5f)
                            .build(new ResourceLocation(ArclightMod.MODID, "scorpion").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }


}