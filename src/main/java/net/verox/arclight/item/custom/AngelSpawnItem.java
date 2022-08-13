package net.verox.arclight.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.verox.arclight.block.ModBlocks;
import net.verox.arclight.entity.mob.EntityTypes;
import net.verox.arclight.entity.mob.custom.AngelEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AngelSpawnItem extends Item {
    public AngelSpawnItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i <= positionClicked.getY() + 2; i++) {
                Block blockBelow = pContext.getLevel().getBlockState(positionClicked.below(i)).getBlock();

                if(isValuableBlock(blockBelow)) {
                    Level level = pContext.getLevel();
                    AngelEntity spawnAngel = EntityTypes.ANGEL.get().create(level);
                    spawnAngel.refreshPositionAndAngles((double)positionClicked.getX() + 0.5D, (double)positionClicked.getY()
                            + 15.05D, (double)positionClicked.getZ() + 0.5D, 0.0F, 0.0F);
                    level.addFreshEntity(spawnAngel);
                    break;
                }
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                (player) -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return super.useOn(pContext);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if(Screen.hasShiftDown()) {
            components.add(Component.literal("Right click on Boss-Spawner to summon the Boss!").withStyle(ChatFormatting.DARK_PURPLE));
        } else {
            components.add(Component.literal("Press SHIFT for more info").withStyle(ChatFormatting.DARK_GRAY));
        }

        super.appendHoverText(stack, level, components, flag);
    }

    private boolean isValuableBlock(Block block) {
        return block == ModBlocks.BOSS_SPAWNER.get();
    }
}