package com.gemini.aurasync.AuraSync.novamod.fabric;

import com.gemini.aurasync.AuraSync.novamod.Novamod;
import net.fabricmc.api.ModInitializer;

public final class NovamodFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        Novamod.init();
    }
}
