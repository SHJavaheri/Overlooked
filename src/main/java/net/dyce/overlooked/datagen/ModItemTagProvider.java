package net.dyce.overlooked.datagen;

import java.util.concurrent.CompletableFuture;

import net.dyce.overlooked.Overlooked;
import net.dyce.overlooked.item.ModItems;
import net.dyce.overlooked.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture,
                              CompletableFuture<TagLookup<Block>> lookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, lookupCompletableFuture, Overlooked.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(Items.DIAMOND)
                .add(Items.DIAMOND_ORE)
                .add(Items.EMERALD)
                .add(Items.EMERALD_ORE);
    }
}
