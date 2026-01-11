package net.dyce.overlooked.block;

import java.util.List;
import java.util.function.Supplier;

import net.dyce.overlooked.Overlooked;
import net.dyce.overlooked.block.custom.ResonatingBlock;
import net.dyce.overlooked.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Overlooked.MOD_ID);

    public static final RegistryObject<Block> RESONANT_ORE = registerBlock("resonant_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4),BlockBehaviour.Properties.of()
                     .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)) {
                @Override
                public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.overlooked.resonant_ore"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });

    public static final RegistryObject<Block> RESONANT_DEEPSLATE_ORE = registerBlock("resonant_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3,6),BlockBehaviour.Properties.of()
                     .strength(5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)) {
                @Override
                public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.overlooked.resonant_deepslate_ore"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });

    public static final RegistryObject<Block> RESONANT_BLOCK = registerBlock("resonant_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)) {
                @Override
                public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.overlooked.resonant_block"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });

    public static final RegistryObject<Block> RESONATING_BLOCK =registerBlock("resonating_block",
            () -> new ResonatingBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));








    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
