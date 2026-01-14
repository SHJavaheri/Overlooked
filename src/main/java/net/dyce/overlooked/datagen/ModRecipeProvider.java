package net.dyce.overlooked.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import net.dyce.overlooked.Overlooked;
import net.dyce.overlooked.block.ModBlocks;
import net.dyce.overlooked.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraft.world.item.crafting.*;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        // List of Smeltable/Blastable things
        List<ItemLike> RESONITE_SMELTABLES = List.of(
                ModItems.RAW_RESONITE.get(),
                ModBlocks.RESONANT_ORE.get(),
                ModBlocks.RESONANT_DEEPSLATE_ORE.get());
        //----------------------------------------------------------------------------//

        // Shaped Recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RESONANT_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.RESONITE.get())
                .unlockedBy(getHasName(ModItems.RESONITE.get()), has(ModItems.RESONITE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RESONITE.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.RESONANT_FRAGMENT.get())
                .unlockedBy(getHasName(ModItems.RESONANT_FRAGMENT.get()), has(ModItems.RESONANT_FRAGMENT.get()))
                           .save(pRecipeOutput, Overlooked.MOD_ID + ":resonite_from_fragments");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RESONATING_LAMP.get())
                .pattern(" A ")
                .pattern("AXA")
                .pattern(" A ")
                .define('A', ModItems.RESONANT_FRAGMENT.get())
                .define('X', Items.REDSTONE_LAMP)
                .unlockedBy(getHasName(ModItems.RESONANT_FRAGMENT.get()), has(ModItems.RESONANT_FRAGMENT.get())).save(pRecipeOutput);

        // CHISEL RECIPE //
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CHISEL.get())
                           .pattern("A")
                           .pattern("B")
                           .define('A', ModItems.RESONANT_FRAGMENT.get())
                           .define('B', Items.STICK)
                           .unlockedBy(getHasName(ModItems.RESONANT_FRAGMENT.get()), has(ModItems.RESONANT_FRAGMENT.get()))
                           .save(pRecipeOutput, Overlooked.MOD_ID + ":hisel_frag_over_stick");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CHISEL.get())
                           .pattern("A")
                           .pattern("B")
                           .define('A', Items.STICK)
                           .define('B', ModItems.RESONANT_FRAGMENT.get())
                           .unlockedBy(getHasName(ModItems.RESONANT_FRAGMENT.get()), has(ModItems.RESONANT_FRAGMENT.get()))
                           .save(pRecipeOutput, Overlooked.MOD_ID + ":chisel_stick_over_frag");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CHISEL.get())
                           .pattern("AB")
                           .define('A', ModItems.RESONANT_FRAGMENT.get())
                           .define('B', Items.STICK)
                           .unlockedBy(getHasName(ModItems.RESONANT_FRAGMENT.get()), has(ModItems.RESONANT_FRAGMENT.get()))
                           .save(pRecipeOutput, Overlooked.MOD_ID + ":chisel_frag_left_stick");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CHISEL.get())
                           .pattern("AB")
                           .define('A', Items.STICK)
                           .define('B', ModItems.RESONANT_FRAGMENT.get())
                           .unlockedBy(getHasName(ModItems.RESONANT_FRAGMENT.get()), has(ModItems.RESONANT_FRAGMENT.get()))
                           .save(pRecipeOutput, Overlooked.MOD_ID + ":chisel_stick_left_frag");



        //----------------------------------------------------------------------------//

        // Shapeless Recipes
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RESONITE.get(),9)
                .requires(ModBlocks.RESONANT_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RESONANT_BLOCK.get()), has(ModBlocks.RESONANT_BLOCK.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RESONANT_FRAGMENT.get(),9)
                .requires(ModItems.RESONITE.get())
                .unlockedBy(getHasName(ModItems.RESONITE.get()), has(ModItems.RESONITE.get())).save(pRecipeOutput);

        //----------------------------------------------------------------------------//

        // Smelting Recipes
        oreSmelting(pRecipeOutput, RESONITE_SMELTABLES, RecipeCategory.MISC, ModItems.RESONITE.get(), 1.0f, 200, "resonite");
        oreBlasting(pRecipeOutput, RESONITE_SMELTABLES, RecipeCategory.MISC, ModItems.RESONITE.get(), 1.0f, 100, "resonite");

    }
    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                                      .save(recipeOutput, Overlooked.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
