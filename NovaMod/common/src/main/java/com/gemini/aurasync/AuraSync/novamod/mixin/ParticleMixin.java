package com.gemini.aurasync.AuraSync.novamod.mixin;

import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleEngine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Particle.class)
public abstract class ParticleMixin {
    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    private void nebulaParticleTickCulling(CallbackInfo ci) {
        // Hissəciklərin ömrünü və hərəkətini optimizasiya etmək üçün bura məntiq əlavə edilə bilər
        // Bu hissə sadəcə struktur üçündür, əsl FPS artımı render tərəfində olur
    }
}