package com.cerbon.super_ore_block.forge;

import com.cerbon.super_ore_block.SuperOreBlock;
import net.minecraftforge.fml.common.Mod;

@Mod(SuperOreBlock.MOD_ID)
public class SuperOreBlockForge {

    public SuperOreBlockForge() {
        SuperOreBlock.init();
    }
}