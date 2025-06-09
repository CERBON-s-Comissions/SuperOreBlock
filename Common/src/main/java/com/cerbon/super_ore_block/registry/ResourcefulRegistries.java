package com.cerbon.super_ore_block.registry;

import com.cerbon.cerbons_api.api.registry.ResourcefulRegistry;
import com.cerbon.super_ore_block.platform.Services;
import net.minecraft.core.Registry;

public class ResourcefulRegistries {

    public static <T> ResourcefulRegistry<T> create(Registry<T> registry, String id) {
        return Services.PLATFORM.create(registry, id);
    }
}
