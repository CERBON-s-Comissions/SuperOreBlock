package com.cerbon.super_ore_block.neoforge.datagen.providers;

import com.cerbon.super_ore_block.SuperOreBlock;
import com.cerbon.super_ore_block.item.SOBItemTags;
import com.cerbon.super_ore_block.item.SOBItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SOBItemTagProvider extends ItemTagsProvider {

    public SOBItemTagProvider(PackOutput arg, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(arg, provider, blockTags, SuperOreBlock.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        SOBItems.ITEMS.boundStream().forEach(item -> tag(SOBItemTags.SUPER_ORE_ITEMS).add(item));
    }
}
