package com.cerbon.super_ore_block;

import com.cerbon.super_ore_block.block.SOBBlocks;
import com.cerbon.super_ore_block.creative_tabs.SOBCreativeTabs;
import com.cerbon.super_ore_block.item.SOBItems;
import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

public class SuperOreBlock {
	public static final String MOD_ID = "super_ore_block";
	public static final String MOD_NAME = "SuperOreBlock";

	public static final Logger LOGGER = LogUtils.getLogger();

	public static void init() {
		SOBBlocks.register();
		SOBItems.register();
		SOBCreativeTabs.register();
	}
}
