package com.cerbon.super_ore_block.neoforge.event;

import com.cerbon.super_ore_block.SuperOreBlock;
import com.cerbon.super_ore_block.neoforge.datagen.providers.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = SuperOreBlock.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class SOBEventsNeo {

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), SOBLootTableProvider.create(packOutput, lookupProvider));
        SOBBlockTagProvider blockTagProvider = generator.addProvider(event.includeServer(), new SOBBlockTagProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new SOBItemTagProvider(packOutput, lookupProvider, blockTagProvider.contentsGetter(), existingFileHelper));
        generator.addProvider(event.includeServer(), new SOBRecipeProvider(packOutput, lookupProvider));

        generator.addProvider(event.includeClient(), new SOBBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new SOBItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new SOBLanguageProvider(packOutput));
    }
}
