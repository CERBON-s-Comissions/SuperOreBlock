package com.cerbon.super_ore_block.forge.platform;

import com.cerbon.cerbons_api.api.registry.ResourcefulRegistry;
import com.cerbon.super_ore_block.forge.registry.ForgeResourcefulRegistry;
import com.cerbon.super_ore_block.platform.services.IPlatformHelper;
import net.minecraft.core.Registry;

public class ForgePlatformHelper implements IPlatformHelper {

    @Override
    public <T> ResourcefulRegistry<T> create(Registry<T> registry, String id) {
        return new ForgeResourcefulRegistry<>(registry, id);
    }
}
