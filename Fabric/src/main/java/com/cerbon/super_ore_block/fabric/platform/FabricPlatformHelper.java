package com.cerbon.super_ore_block.fabric.platform;

import com.cerbon.cerbons_api.api.registry.ResourcefulRegistry;
import com.cerbon.super_ore_block.fabric.registry.FabricResourcefulRegistry;
import com.cerbon.super_ore_block.platform.services.IPlatformHelper;
import net.minecraft.core.Registry;

public class FabricPlatformHelper implements IPlatformHelper {

    @Override
    public <T> ResourcefulRegistry<T> create(Registry<T> registry, String id) {
        return new FabricResourcefulRegistry<>(registry, id);
    }
}
