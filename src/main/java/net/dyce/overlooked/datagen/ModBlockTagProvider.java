package net.dyce.overlooked.datagen;

import java.util.concurrent.CompletableFuture;

import net.dyce.overlooked.Overlooked;
import net.dyce.overlooked.block.ModBlocks;
import net.dyce.overlooked.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Overlooked.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.RESONANT_BLOCK.get())
                .add(ModBlocks.RESONANT_ORE.get())
                .add(ModBlocks.RESONANT_DEEPSLATE_ORE.get())
                .add(ModBlocks.RESONATING_BLOCK.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.RESONANT_BLOCK.get())
                .add(ModBlocks.RESONANT_ORE.get())
                .add(ModBlocks.RESONANT_DEEPSLATE_ORE.get())
                .add(ModBlocks.RESONATING_BLOCK.get());


        tag(ModTags.Blocks.NEEDS_RESONITE_TOOL)
                .add(ModBlocks.RESONANT_BLOCK.get())
                .add(ModBlocks.RESONANT_ORE.get())
                .add(ModBlocks.RESONANT_DEEPSLATE_ORE.get())
                .add(ModBlocks.RESONATING_BLOCK.get())
                .add(Blocks.OBSIDIAN)
                .add(Blocks.CRYING_OBSIDIAN)
                .addTags(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_RESONITE_TOOL)
                .addTags(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .remove(ModTags.Blocks.NEEDS_RESONITE_TOOL);
    }
}
