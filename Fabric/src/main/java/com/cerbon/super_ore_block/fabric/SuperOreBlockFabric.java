package com.cerbon.super_ore_block.fabric;

import com.cerbon.super_ore_block.SuperOreBlock;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;

public class SuperOreBlockFabric implements ModInitializer, ClientModInitializer {

    @Override
    public void onInitialize() {
        SuperOreBlock.init();
    }

    @Override
    public void onInitializeClient() {}
}