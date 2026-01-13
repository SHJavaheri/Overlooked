package net.dyce.overlooked.datagen;

import net.dyce.overlooked.Overlooked;
import net.dyce.overlooked.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Overlooked.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.RESONANT_ORE);
        blockWithItem(ModBlocks.RESONANT_DEEPSLATE_ORE);

        blockWithItem(ModBlocks.RESONANT_BLOCK);
        blockWithItem(ModBlocks.RESONATING_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
