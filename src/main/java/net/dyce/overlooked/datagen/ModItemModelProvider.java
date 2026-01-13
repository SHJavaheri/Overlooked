package net.dyce.overlooked.datagen;

import net.dyce.overlooked.Overlooked;
import net.dyce.overlooked.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

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
    }
}
