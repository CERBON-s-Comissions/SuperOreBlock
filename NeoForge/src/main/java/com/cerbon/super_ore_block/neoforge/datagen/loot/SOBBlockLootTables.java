package com.cerbon.super_ore_block.neoforge.datagen.loot;

import com.cerbon.super_ore_block.block.SOBBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class SOBBlockLootTables extends BlockLootSubProvider {

    public SOBBlockLootTables(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        SOBBlocks.BLOCKS.boundStream().forEach(block -> {
            if (block != SOBBlocks.SUPER_ORE_BLOCK.get())
                this.dropSelf(block);

            else {
                this.add(SOBBlocks.SUPER_ORE_BLOCK.get(), b -> {
                    LootTable.Builder table = LootTable.lootTable();

                    ItemLike[] drops = {
                            SOBBlocks.SUPER_COAL.get(),
                            SOBBlocks.SUPER_COPPER.get(),
                            SOBBlocks.SUPER_IRON.get(),
                            SOBBlocks.SUPER_GOLD.get(),
                            SOBBlocks.SUPER_LAPIS.get(),
                            SOBBlocks.SUPER_REDSTONE.get(),
                            SOBBlocks.SUPER_DIAMOND.get(),
                            SOBBlocks.SUPER_EMERALD.get(),
                            SOBBlocks.SUPER_NETHERITE.get()
                    };

                    for (ItemLike item : drops) {
                        table.withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1))
                                        .add(this.applyExplosionDecay(block, LootItem.lootTableItem(item)))
                        );
                    }
                    return table;
                });
            }
        });
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return SOBBlocks.BLOCKS.boundStream()::iterator;
    }
}
