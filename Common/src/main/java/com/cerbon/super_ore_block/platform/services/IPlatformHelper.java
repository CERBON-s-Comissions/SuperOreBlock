package com.cerbon.super_ore_block.platform.services;

import com.cerbon.cerbons_api.api.registry.ResourcefulRegistry;
import net.minecraft.core.Registry;

public interface IPlatformHelper {

    <T> ResourcefulRegistry<T> create(Registry<T> registry, String id);
}
