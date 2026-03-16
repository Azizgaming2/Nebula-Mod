package com.gemini.aurasync.AuraSync.novamod.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityRenderDispatcher.class)
public class EntityRenderMixin {

    @Inject(method = "shouldRender", at = @At("HEAD"), cancellable = true)
    private <E extends Entity> void nebulaEntityCulling(E entity, Frustum frustum, double camX, double camY, double camZ, CallbackInfoReturnable<Boolean> cir) {
        Minecraft mc = Minecraft.getInstance();

        // Oyunçu yoxdursa, heç nə etmə
        if (mc.player == null) return;

        // Əgər entity 64 blokdan (4096 = 64x64) uzaqdırsa render etmə
        if (entity.distanceToSqr(mc.player) > 4096.0D) {
            // Bossları (Əjdaha, Wither) uzaqda olsalar da render etməyə davam et ki, oyunçu söyməsin
            if (!(entity instanceof EnderDragon) && !(entity instanceof WitherBoss)) {
                cir.setReturnValue(false);
            }
        }
    }
}