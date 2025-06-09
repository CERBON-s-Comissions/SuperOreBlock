package com.cerbon.super_ore_block.item;

import com.cerbon.super_ore_block.SuperOreBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class SOBItemTags {
    public static final TagKey<Item> SUPER_ORE_ITEMS = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(SuperOreBlock.MOD_ID, "super_ores"));
}
