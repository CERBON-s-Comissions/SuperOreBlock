package com.cerbon.super_ore_block.neoforge.platform;

import com.cerbon.cerbons_api.api.registry.ResourcefulRegistry;
import com.cerbon.super_ore_block.neoforge.registry.NeoForgeResourcefulRegistry;
import com.cerbon.super_ore_block.platform.services.IPlatformHelper;
import net.minecraft.core.Registry;

public class NeoForgePlatformHelper implements IPlatformHelper {

    @Override
    public <T> ResourcefulRegistry<T> create(Registry<T> registry, String id) {
        return new NeoForgeResourcefulRegistry<>(registry, id);
    }
}
