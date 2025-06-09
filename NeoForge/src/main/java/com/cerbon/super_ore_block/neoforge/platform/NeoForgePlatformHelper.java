package com.cerbon.super_ore_block.neoforge.platform;

import com.cerbon.super_ore_block.neoforge.registry.NeoForgeResourcefulRegistry;
import com.cerbon.super_ore_block.platform.services.IPlatformHelper;
import com.cerbon.super_ore_block.registry.ResourcefulRegistry;
import net.minecraft.core.Registry;

public class NeoForgePlatformHelper implements IPlatformHelper {

    @Override
    public <T> ResourcefulRegistry<T> create(Registry<T> registry, String id) {
        return new NeoForgeResourcefulRegistry<>(registry, id);
    }
}
