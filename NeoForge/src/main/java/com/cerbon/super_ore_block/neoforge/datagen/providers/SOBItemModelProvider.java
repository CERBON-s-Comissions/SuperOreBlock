package com.cerbon.super_ore_block.neoforge.datagen.providers;

import com.cerbon.super_ore_block.SuperOreBlock;
import com.cerbon.super_ore_block.block.SOBBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class SOBItemModelProvider extends ItemModelProvider {

    public SOBItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SuperOreBlock.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        SOBBlocks.BLOCKS.boundStream().forEach(this::simpleBlockItem);
    }
}
