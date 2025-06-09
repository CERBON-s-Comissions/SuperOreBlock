package com.cerbon.super_ore_block.item;

import com.cerbon.super_ore_block.SuperOreBlock;
import com.cerbon.super_ore_block.registry.ResourcefulRegistries;
import com.cerbon.super_ore_block.registry.ResourcefulRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

public class SOBItems {
    public static final ResourcefulRegistry<Item> ITEMS = ResourcefulRegistries.create(
            BuiltInRegistries.ITEM,
            SuperOreBlock.MOD_ID
    );

    public static void register() {
        ITEMS.register();
    }
}
