package com.cerbon.super_ore_block.neoforge.datagen.providers;

import com.cerbon.super_ore_block.SuperOreBlock;
import com.cerbon.super_ore_block.block.SOBBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SOBBlockTagProvider extends BlockTagsProvider {

    public SOBBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SuperOreBlock.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        SOBBlocks.BLOCKS.boundStream().forEach(block -> tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block));

        tag(BlockTags.NEEDS_STONE_TOOL).add(SOBBlocks.SUPER_COPPER.get(), SOBBlocks.SUPER_IRON.get(), SOBBlocks.SUPER_LAPIS.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(SOBBlocks.SUPER_GOLD.get(), SOBBlocks.SUPER_REDSTONE.get(), SOBBlocks.SUPER_DIAMOND.get(), SOBBlocks.SUPER_EMERALD.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL).add(SOBBlocks.SUPER_NETHERITE.get(), SOBBlocks.SUPER_ORE_BLOCK.get());
    }
}
