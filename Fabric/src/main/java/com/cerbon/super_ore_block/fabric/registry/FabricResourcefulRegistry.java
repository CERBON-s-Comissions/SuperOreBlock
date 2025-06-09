package com.cerbon.super_ore_block.fabric.registry;

import com.cerbon.cerbons_api.api.registry.RegistryEntries;
import com.cerbon.cerbons_api.api.registry.RegistryEntry;
import com.cerbon.cerbons_api.api.registry.ResourcefulRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

import java.util.Collection;
import java.util.function.Supplier;

public class FabricResourcefulRegistry<T> implements ResourcefulRegistry<T> {
    private final RegistryEntries<T> entries = new RegistryEntries<>();
    private final Registry<T> registry;
    private final String id;

    public FabricResourcefulRegistry(Registry<T> registry, String id) {
        this.registry = registry;
        this.id = id;
    }

    @Override
    public <I extends T> RegistryEntry<I> register(String id, Supplier<I> supplier) {
        return entries.add(FabricRegistryEntry.of(this.registry, ResourceLocation.fromNamespaceAndPath(this.id, id), supplier));
    }

    @Override
    public Collection<RegistryEntry<T>> getEntries() {
        return this.entries.getEntries();
    }

    @Override
    public void register() {
        // NO-OP
    }
}
