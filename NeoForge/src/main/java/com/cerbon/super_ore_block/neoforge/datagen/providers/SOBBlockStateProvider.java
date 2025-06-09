package com.cerbon.super_ore_block.neoforge.datagen.providers;


import com.cerbon.super_ore_block.SuperOreBlock;
import com.cerbon.super_ore_block.block.SOBBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class SOBBlockStateProvider extends BlockStateProvider {

    public SOBBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SuperOreBlock.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        SOBBlocks.BLOCKS.boundStream().forEach(this::simpleBlock);
    }
}
