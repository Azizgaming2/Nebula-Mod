package com.gemini.aurasync.AuraSync.novamod.forge;

import com.gemini.aurasync.AuraSync.novamod.Novamod;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Novamod.MOD_ID)
public final class NovamodForge {
    public NovamodForge() {
        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(Novamod.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        // Run our common setup.
        Novamod.init();
    }
}
