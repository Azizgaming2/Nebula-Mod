package com.gemini.aurasync.AuraSync.novamod.mixin;

import net.minecraft.client.gui.components.DebugScreenOverlay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(DebugScreenOverlay.class)
public class DebugScreenOverlayMixin {

    @Inject(method = "getGameInformation", at = @At("RETURN"), cancellable = true)
    private void nebulaF3Info(CallbackInfoReturnable<List<String>> cir) {
        List<String> infoList = cir.getReturnValue();

        // F3 ekranına NebulaMod məlumatlarını basırıq!
        infoList.add("");
        infoList.add("§b[NebulaMod] §fRenderer: §aNebula Quantum Engine");
        infoList.add("§b[NebulaMod] §fEntity Culling:Baking Mod.");
        infoList.add("§b[NebulaMod] 2.0.0");
    }
}