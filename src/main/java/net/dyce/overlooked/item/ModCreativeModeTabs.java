package net.dyce.overlooked.item;

import net.dyce.overlooked.Overlooked;
import net.dyce.overlooked.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Overlooked.MOD_ID);

    public static final RegistryObject<CreativeModeTab> RESONANT_ITEMS_TAB = CREATIVE_MODE_TABS.register("resonant_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RESONITE.get()))
                    .title(Component.translatable("creativetab.overlooked.resonant_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.RESONITE.get());
                        output.accept(ModItems.RAW_RESONITE.get());
                        output.accept(ModItems.RESONATING_APPLE.get());
                        output.accept(ModItems.RESONANT_FRAGMENT.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> RESONANT_BLOCKS_TAB = CREATIVE_MODE_TABS.register("resonant_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.RESONANT_ORE.get()))
                    .withTabsBefore(RESONANT_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.overlooked.resonant_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.RESONANT_ORE.get());
                        output.accept(ModBlocks.RESONANT_DEEPSLATE_ORE.get());
                        output.accept(ModBlocks.RESONANT_BLOCK.get());
                        output.accept(ModBlocks.RESONATING_BLOCK.get());
                        output.accept(ModBlocks.RESONATING_LAMP.get());

                    }).build());


    public static final RegistryObject<CreativeModeTab> OVERLOOKED_TOOLS_TAB = CREATIVE_MODE_TABS.register("overlooked_tools_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CHISEL.get()))
                                 .withTabsBefore(RESONANT_BLOCKS_TAB.getId())
                                 .title(Component.translatable("creativetab.overlooked.overlooked_tools"))
                                 .displayItems((itemDisplayParameters, output) -> {
                                     output.accept(ModItems.CHISEL.get());
                                     output.accept(ModItems.RESONITE_SWORD.get());
                                     output.accept(ModItems.RESONITE_PICKAXE.get());
                                     output.accept(ModItems.RESONITE_SHOVEL.get());
                                     output.accept(ModItems.RESONITE_AXE.get());
                                     output.accept(ModItems.RESONITE_HOE.get());

                                 }).build());





    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
