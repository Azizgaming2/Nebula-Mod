package com.gemini.aurasync.AuraSync.novamod.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityTickMixin {
    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    private void onTick(CallbackInfo ci) {
        Entity entity = (Entity) (Object) this;

        // Əgər entity canlıdırsa və oyunçudan 32 blokdan uzaqdadırsa
        if (entity instanceof LivingEntity && !entity.level().isClientSide) {
            double dist = entity.distanceToSqr(entity.level().getNearestPlayer(entity, 32) != null ?
                    entity.level().getNearestPlayer(entity, 32) : entity);

            // Hər tick hesablama, hər 5 tick-dən bir hesabla (CPU-ya 5 qat qənaət!)
            if (dist > 1024 && entity.level().getGameTime() % 5 != 0) {
                ci.cancel();
            }
        }
    }
}