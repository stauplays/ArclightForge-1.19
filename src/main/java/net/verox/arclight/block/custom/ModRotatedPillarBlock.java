package net.verox.arclight.block.custom;

import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.verox.arclight.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

public class ModRotatedPillarBlock extends RotatedPillarBlock {
    public ModRotatedPillarBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 5;
    }


    @Nullable
    public BlockState getToolModifiedState(BlockState state, Level level, BlockPos pos, Player player,
                                           ItemStack stack, ToolAction toolAction) {
        if(stack.getItem() instanceof AxeItem) {
            if(state.is(ModBlocks.MOON_LOG.get())) {
                return ModBlocks.STRIPPED_MOON_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(ModBlocks.MOON_WOOD.get())) {
                return ModBlocks.STRIPPED_MOON_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(ModBlocks.JADE_LOG.get())) {
                return ModBlocks.STRIPPED_JADE_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(ModBlocks.JADE_WOOD.get())) {
                return ModBlocks.STRIPPED_JADE_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(ModBlocks.SHADOW_LOG.get())) {
                return ModBlocks.STRIPPED_SHADOW_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(ModBlocks.SHADOW_WOOD.get())) {
                return ModBlocks.STRIPPED_SHADOW_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }

        return getToolModifiedState(state, level, pos, player, stack, toolAction);
    }
}