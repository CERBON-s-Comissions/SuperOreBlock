package com.cerbon.super_ore_block.platform;

import com.cerbon.super_ore_block.SuperOreBlock;

import java.util.ServiceLoader;

public class Services {

    public static <T> T load(Class<T> clazz) {
        final T loadedService = ServiceLoader.load(clazz)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
        SuperOreBlock.LOGGER.debug("Loaded {} for service {}", loadedService, clazz);
        return loadedService;
    }
}
