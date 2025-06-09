package com.cerbon.super_ore_block.block;

import com.cerbon.super_ore_block.SuperOreBlock;
import com.cerbon.super_ore_block.item.SOBItems;
import com.cerbon.super_ore_block.registry.RegistryEntry;
import com.cerbon.super_ore_block.registry.ResourcefulRegistries;
import com.cerbon.super_ore_block.registry.ResourcefulRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class SOBBlocks {
    public static final ResourcefulRegistry<Block> BLOCKS = ResourcefulRegistries.create(
            BuiltInRegistries.BLOCK,
            SuperOreBlock.MOD_ID
    );

    public static final RegistryEntry<Block> SUPER_COAL = register(Blocks.COAL_BLOCK, "super_coal_block");
    public static final RegistryEntry<Block> SUPER_COPPER = register(Blocks.COPPER_BLOCK, "super_copper_block");
    public static final RegistryEntry<Block> SUPER_DIAMOND = register(Blocks.DIAMOND_BLOCK, "super_diamond_block");
    public static final RegistryEntry<Block> SUPER_EMERALD = register(Blocks.EMERALD_BLOCK, "super_emerald_block");
    public static final RegistryEntry<Block> SUPER_GOLD = register(Blocks.GOLD_BLOCK, "super_gold_block");
    public static final RegistryEntry<Block> SUPER_IRON = register(Blocks.IRON_BLOCK, "super_iron_block");
    public static final RegistryEntry<Block> SUPER_LAPIS = register(Blocks.LAPIS_BLOCK, "super_lapis_block");
    public static final RegistryEntry<Block> SUPER_NETHERITE = register(Blocks.NETHERITE_BLOCK, "super_netherite_block");
    public static final RegistryEntry<Block> SUPER_REDSTONE = register(Blocks.REDSTONE_BLOCK, "super_redstone_block");

    public static final RegistryEntry<Block> SUPER_ORE_BLOCK = register(Blocks.NETHERITE_BLOCK, "super_ore_block");

    public static RegistryEntry<Block> register(Block toCopy, String id) {
        RegistryEntry<Block> blockEntry = BLOCKS.register(id, () -> new Block(BlockBehaviour.Properties.ofFullCopy(toCopy)));
        SOBItems.ITEMS.register(id, () -> new BlockItem(blockEntry.get(), new Item.Properties()));
        return blockEntry;
    }

    public static void register() {
        BLOCKS.register();
    }
}
