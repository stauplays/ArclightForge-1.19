package net.verox.arclight.event;

import java.util.List;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.verox.arclight.item.ModItems;

@EventBusSubscriber
public class DragonEvent {
    @SubscribeEvent
    public void mobItemDrop(LivingDropsEvent e) {
        Entity entity = e.getEntity();
        Level world = entity.getCommandSenderWorld();
        if (world.isClientSide) {
            return;
        }

        if (entity instanceof EnderDragon == false) {
            return;
        }

        Player player = null;
        BlockPos epos = entity.blockPosition();
        Entity source = e.getSource().getEntity();

        if (source == null) {
            List<Entity> entitiesaround = world.getEntities(entity, new AABB(epos.getX()-30, epos.getY()-30,
                    epos.getZ()-30, epos.getX()+30, epos.getY()+30, epos.getZ()+30));
            for (Entity ea : entitiesaround) {
                if (ea instanceof Player) {
                    player = (Player)ea;
                    break;
                }
            }
        }
        else if (source instanceof Player) {
            player = (Player)source;
        }

        ItemStack scaleStack = new ItemStack(ModItems.SCORPION_SCALE.get(), 4);
        ItemStack heartStack = new ItemStack(ModItems.HEART.get(), 1);
        if (player == null) {
            e.getDrops().add(new ItemEntity(world, epos.getX(), epos.getY()+1, epos.getZ(), scaleStack));
            e.getDrops().add(new ItemEntity(world, epos.getX(), epos.getY()+1, epos.getZ(), heartStack));
        }
        else {
            BlockPos pos = player.blockPosition();
            ItemEntity scale = new ItemEntity(world, pos.getX(), pos.getY()+1, pos.getZ(), scaleStack);
            ItemEntity heart = new ItemEntity(world, pos.getX(), pos.getY()+1, pos.getZ(), heartStack);
            world.addFreshEntity(scale);
            world.addFreshEntity(heart);

        }
    }
}