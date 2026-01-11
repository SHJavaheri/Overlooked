package net.dyce.overlooked.block.custom;

import java.util.List;

import net.dyce.overlooked.block.ModBlocks;
import net.dyce.overlooked.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MinecartItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class ResonatingBlock extends Block {
    public ResonatingBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        pLevel.playSound(pPlayer,pPos, SoundEvents.AMETHYST_CLUSTER_PLACE, SoundSource.BLOCKS,1f,1f);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if (pEntity instanceof ItemEntity itemEntity) {
            if(itemEntity.getItem().getItem() == Items.BLAZE_POWDER) {
                itemEntity.setItem(new ItemStack(Items.BLAZE_ROD, itemEntity.getItem().getCount()));
            }
            if(itemEntity.getItem().getItem() == Items.COBBLESTONE) {
                itemEntity.setItem(new ItemStack(Items.STONE, itemEntity.getItem().getCount()));
            }
            if(itemEntity.getItem().getItem() == Items.POISONOUS_POTATO) {
                itemEntity.setItem(new ItemStack(Items.POTATO, itemEntity.getItem().getCount()));
            }
            if(itemEntity.getItem().getItem() == Items.GOLDEN_APPLE) {
                itemEntity.setItem(new ItemStack(ModItems.RESONATING_APPLE.get(), itemEntity.getItem().getCount()));
            }
            if(itemEntity.getItem().getItem() == Items.GLASS_BOTTLE) {
                itemEntity.setItem(new ItemStack(Items.EXPERIENCE_BOTTLE, itemEntity.getItem().getCount()));
            }



//            if(itemEntity.getItem().getItem() == ModItems.RESONATING_PICKAXE) {
//                itemEntity.setItem(new ItemStack(ModItems.RESONATING_PICKAXE.get(), itemEntity.getItem().getCount()));
//            }
//            if(itemEntity.getItem().getItem() == ModItems.RESONATING_AXE) {
//                itemEntity.setItem(new ItemStack(ModItems.RESONATING_AXE.get(), itemEntity.getItem().getCount()));
//            }
//            if(itemEntity.getItem().getItem() == ModItems.RESONATING_SWORD) {
//                itemEntity.setItem(new ItemStack(ModItems.RESONATING_SWORD.get(), itemEntity.getItem().getCount()));
//            }
//            if(itemEntity.getItem().getItem() == ModItems.RESONATING_SHOVEL) {
//                itemEntity.setItem(new ItemStack(ModItems.RESONATING_SHOVEL.get(), itemEntity.getItem().getCount()));
//            }
//            if(itemEntity.getItem().getItem() == ModItems.RESONATING_HOE) {
//                itemEntity.setItem(new ItemStack(ModItems.RESONATING_HOE.get(), itemEntity.getItem().getCount()));
//            }


        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        pTooltipComponents.add(Component.translatable("tooltip.overlooked.resonating_block.tooltip"));
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
