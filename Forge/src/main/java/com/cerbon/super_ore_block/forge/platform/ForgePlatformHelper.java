package com.cerbon.super_ore_block.forge.platform;

import com.cerbon.super_ore_block.forge.registry.ForgeResourcefulRegistry;
import com.cerbon.super_ore_block.platform.services.IPlatformHelper;
import com.cerbon.super_ore_block.registry.ResourcefulRegistry;
import net.minecraft.core.Registry;

public class ForgePlatformHelper implements IPlatformHelper {

    @Override
    public <T> ResourcefulRegistry<T> create(Registry<T> registry, String id) {
        return new ForgeResourcefulRegistry<>(registry, id);
    }
}
