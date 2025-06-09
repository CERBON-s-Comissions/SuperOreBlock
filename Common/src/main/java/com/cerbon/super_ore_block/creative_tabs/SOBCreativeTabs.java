package com.cerbon.super_ore_block.creative_tabs;

import com.cerbon.super_ore_block.SuperOreBlock;
import com.cerbon.super_ore_block.block.SOBBlocks;
import com.cerbon.super_ore_block.item.SOBItems;
import com.cerbon.super_ore_block.registry.RegistryEntry;
import com.cerbon.super_ore_block.registry.ResourcefulRegistries;
import com.cerbon.super_ore_block.registry.ResourcefulRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class SOBCreativeTabs {
    public static final ResourcefulRegistry<CreativeModeTab> CREATIVE_TABS = ResourcefulRegistries.create(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            SuperOreBlock.MOD_ID
    );

    public static final RegistryEntry<CreativeModeTab> SOB_CREATIVE_TAB = CREATIVE_TABS.register(
            "sob_creative_tab",
            () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP,6)
                    .title(Component.translatable("itemGroup.super_ore_block.items"))
                    .icon(() -> new ItemStack(SOBBlocks.SUPER_ORE_BLOCK.get()))
                    .displayItems((itemDisplayParameters, output) -> SOBItems.ITEMS.boundStream().forEach(output::accept))
                    .build()
    );

    public static void register() {
        CREATIVE_TABS.register();
    }
}
