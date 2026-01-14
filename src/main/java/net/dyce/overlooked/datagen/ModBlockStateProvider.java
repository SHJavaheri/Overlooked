package net.dyce.overlooked.datagen;

import net.dyce.overlooked.Overlooked;
import net.dyce.overlooked.block.ModBlocks;
import net.dyce.overlooked.block.custom.ResonatingLampBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
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

        customLamp();
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.RESONATING_LAMP.get()).forAllStates(state -> {
            if(state.getValue(ResonatingLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("resonating_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(Overlooked.MOD_ID, "block/" + "resonating_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("resonating_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(Overlooked.MOD_ID, "block/" + "resonating_lamp_off")))};
            }
        });
        simpleBlockItem(ModBlocks.RESONATING_LAMP.get(), models().cubeAll("resonating_lamp_on",
                ResourceLocation.fromNamespaceAndPath(Overlooked.MOD_ID, "block/" + "resonating_lamp_on")));
    }
    
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
