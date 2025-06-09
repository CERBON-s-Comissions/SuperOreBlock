package com.cerbon.super_ore_block.neoforge.datagen.providers;

import com.cerbon.super_ore_block.SuperOreBlock;
import com.cerbon.super_ore_block.block.SOBBlocks;
import com.cerbon.super_ore_block.item.SOBItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.packs.VanillaRecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class SOBRecipeProvider extends VanillaRecipeProvider {

    public SOBRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        addRecipe(SOBBlocks.SUPER_COAL.get(), Items.COAL_BLOCK, recipeOutput);
        addRecipe(SOBBlocks.SUPER_COPPER.get(), Items.COPPER_BLOCK, recipeOutput);
        addRecipe(SOBBlocks.SUPER_DIAMOND.get(), Items.DIAMOND_BLOCK, recipeOutput);
        addRecipe(SOBBlocks.SUPER_EMERALD.get(), Items.EMERALD_BLOCK, recipeOutput);
        addRecipe(SOBBlocks.SUPER_GOLD.get(), Items.GOLD_BLOCK, recipeOutput);
        addRecipe(SOBBlocks.SUPER_IRON.get(), Items.IRON_BLOCK, recipeOutput);
        addRecipe(SOBBlocks.SUPER_LAPIS.get(), Items.LAPIS_BLOCK, recipeOutput);
        addRecipe(SOBBlocks.SUPER_NETHERITE.get(), Items.NETHERITE_BLOCK, recipeOutput);
        addRecipe(SOBBlocks.SUPER_REDSTONE.get(), Items.REDSTONE_BLOCK, recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, () -> SOBBlocks.SUPER_ORE_BLOCK.get().asItem())
                .group("normal_ore_blocks")
                .unlockedBy("hasAny", has(SOBItemTags.SUPER_ORE_ITEMS))
                .requires(SOBBlocks.SUPER_COAL.get())
                .requires(SOBBlocks.SUPER_COPPER.get())
                .requires(SOBBlocks.SUPER_DIAMOND.get())
                .requires(SOBBlocks.SUPER_EMERALD.get())
                .requires(SOBBlocks.SUPER_GOLD.get())
                .requires(SOBBlocks.SUPER_IRON.get())
                .requires(SOBBlocks.SUPER_LAPIS.get())
                .requires(SOBBlocks.SUPER_NETHERITE.get())
                .requires(SOBBlocks.SUPER_REDSTONE.get())
                .save(recipeOutput);
    }

    public static void addRecipe(Block superBlock, Item toUnlock, RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, () -> new ItemStack(superBlock).getItem())
                .group("super_ore_blocks")
                .pattern("##")
                .pattern("##")
                .define('#', toUnlock)
                .unlockedBy("has_item", has(toUnlock))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, () -> toUnlock, 4)
                .group("normal_ore_blocks")
                .unlockedBy("has_item", has(superBlock))
                .requires(superBlock)
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(SuperOreBlock.MOD_ID, "super_to_" + BuiltInRegistries.ITEM.getKey(toUnlock).getPath()));
    }
}
