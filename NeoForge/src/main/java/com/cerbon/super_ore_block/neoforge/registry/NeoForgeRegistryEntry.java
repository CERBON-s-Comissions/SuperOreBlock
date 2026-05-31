package com.cerbon.super_ore_block.neoforge.registry;

import com.cerbon.super_ore_block.registry.RegistryEntry;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.registries.DeferredHolder;

public class NeoForgeRegistryEntry<R, T extends R> implements RegistryEntry<T> {
    private final DeferredHolder<R, T> object;

    public NeoForgeRegistryEntry(DeferredHolder<R, T> object) {
        this.object = object;
    }

    @Override
    public T get() {
        return object.get();
    }

    @Override
    public Identifier getId() {
        return object.getId();
    }
}