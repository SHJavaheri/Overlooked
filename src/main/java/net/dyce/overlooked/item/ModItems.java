package net.dyce.overlooked.item;

import java.util.List;

import net.dyce.overlooked.Overlooked;
import net.dyce.overlooked.item.custom.ChiselItem;
import net.dyce.overlooked.item.custom.FuelItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Overlooked.MOD_ID);


    // Standard Items
    public static final RegistryObject<Item> RESONITE = ITEMS.register("resonite",
            () -> new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.overlooked.resonite"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });

    public static final RegistryObject<Item> RAW_RESONITE = ITEMS.register("raw_resonite",
            () -> new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.overlooked.raw_resonite"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });

    public static final RegistryObject<Item> RESONATING_APPLE = ITEMS.register("resonating_apple",
            () -> new Item(new Item.Properties().food(ModFoodProperties.RESONATING_APPLE)) {
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.overlooked.resonating_apple"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });


    // Custom Items (Items with abilities
    public static final RegistryObject<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));


    // Fuel Items
    public static final RegistryObject<Item> RESONANT_FRAGMENT = ITEMS.register("resonant_fragment",
                () -> new FuelItem(new Item.Properties(), 5000) {
                    @Override
                    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                        pTooltipComponents.add(Component.translatable("tooltip.overlooked.resonant_fragment"));
                        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                    }
                });

    // Custom Tools
    public static final RegistryObject<Item> RESONITE_SWORD = ITEMS.register("resonite_sword",
            () -> new SwordItem(ModToolTiers.RESONITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.RESONITE, 3, -2.4f))));
    public static final RegistryObject<Item> RESONITE_PICKAXE = ITEMS.register("resonite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.RESONITE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.RESONITE, 1, -2.8f))));
    public static final RegistryObject<Item> RESONITE_SHOVEL = ITEMS.register("resonite_shovel",
            () -> new ShovelItem(ModToolTiers.RESONITE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.RESONITE, 1.5f, -3.0f))));
    public static final RegistryObject<Item> RESONITE_AXE = ITEMS.register("resonite_axe",
            () -> new AxeItem(ModToolTiers.RESONITE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.RESONITE, 6, -3.2f))));
    public static final RegistryObject<Item> RESONITE_HOE = ITEMS.register("resonite_hoe",
            () -> new HoeItem(ModToolTiers.RESONITE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.RESONITE, 0, -3.0f))));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
