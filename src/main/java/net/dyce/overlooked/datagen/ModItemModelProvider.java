package net.dyce.overlooked.datagen;

import net.dyce.overlooked.Overlooked;
import net.dyce.overlooked.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Overlooked.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.RESONITE.get());
        basicItem(ModItems.RAW_RESONITE.get());

        basicItem(ModItems.CHISEL.get());
        basicItem(ModItems.RESONATING_APPLE.get());
        basicItem(ModItems.RESONANT_FRAGMENT.get());

        handheldItem(ModItems.RESONITE_SWORD);
        handheldItem(ModItems.RESONITE_PICKAXE);
        handheldItem(ModItems.RESONITE_SHOVEL);
        handheldItem(ModItems.RESONITE_AXE);
        handheldItem(ModItems.RESONITE_HOE);
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Overlooked.MOD_ID,"item/" + item.getId().getPath()));
    }
}
