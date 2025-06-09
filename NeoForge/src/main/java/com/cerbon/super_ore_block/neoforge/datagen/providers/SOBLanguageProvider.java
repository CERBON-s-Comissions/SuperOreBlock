package com.cerbon.super_ore_block.neoforge.datagen.providers;

import com.cerbon.super_ore_block.SuperOreBlock;
import com.cerbon.super_ore_block.block.SOBBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SOBLanguageProvider extends LanguageProvider {

    public SOBLanguageProvider(PackOutput output) {
        super(output, SuperOreBlock.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        SOBBlocks.BLOCKS.boundStream().forEach(this::addTranslation);

        add("itemGroup.super_ore_block.items", "Super Ore Blocks");
    }

    private void addTranslation(Block block) {
        String path = BuiltInRegistries.BLOCK.getKey(block).getPath();

        String translation = Arrays.stream(path.split("_"))
                .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1))
                .collect(Collectors.joining(" "));

        add(block, translation);
    }
}
