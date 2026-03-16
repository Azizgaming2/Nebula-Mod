package com.gemini.aurasync.AuraSync.novamod.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyboardHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(KeyboardHandler.class)
public class KeyInputMixin {

    @Inject(method = "keyPress", at = @At("HEAD"))
    private void onNebulaKeyPress(long windowPointer, int key, int scanCode, int action, int modifiers, CallbackInfo ci) {
        Minecraft mc = Minecraft.getInstance();

        // Oyunçu hələ dünyaya girməyibsə kod işləməsin
        if (mc.level == null || mc.player == null) return;

        // action == 1 (düyməyə basıldısa) və key == 79 (O düyməsidirsə)
        if (action == 1 && key == 79) {
            // Oyunçuya çata mesaj göndəririk
            mc.player.sendSystemMessage(net.minecraft.network.chat.Component.literal("NEBULA MOD Activated"));

            // Gələcəkdə bura bir boolean əlavə edib Entity Culling-i açıb/bağlayan məntiq qura bilərik.
        }
    }
}