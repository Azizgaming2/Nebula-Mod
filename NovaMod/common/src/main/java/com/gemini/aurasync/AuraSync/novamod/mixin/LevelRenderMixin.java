package com.gemini.aurasync.AuraSync.novamod.mixin;

import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.world.level.block.entity.BlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockEntityRenderDispatcher.class)
public class LevelRenderMixin { // Fayl adını dəyişmirsənsə bu ad qalsın

    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private <E extends BlockEntity> void nebulaBlockEntityCulling(E blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, CallbackInfo ci) {
        Minecraft mc = Minecraft.getInstance();

        // Oyunçu yoxdursa və ya blok çox yaxındırsa toxunma
        if (mc.player == null) return;

        // Sandıq, tabela və s. 32 blokdan (1024 = 32x32) uzaqdırsa renderi ləğv et!
        double distSq = blockEntity.getBlockPos().distSqr(mc.player.blockPosition());
        if (distSq > 1024.0D) {
            ci.cancel();
        }
    }
}