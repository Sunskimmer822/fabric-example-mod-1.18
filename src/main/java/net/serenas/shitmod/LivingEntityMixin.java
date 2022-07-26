package net.serenas.shitmod;

import java.util.Random;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;

@Mixin(LivingEntity.class) 
public class LivingEntityMixin {
    @Inject(at = @At("HEAD"), method = "modifyAppliedDamage")
private void injectMethod(DamageSource source, Float amount, CallbackInfo info) {
    Random r = new Random();
    int low = 1;
    int high = 5;
    int result = r.nextInt(high-low) + low;
    if (result == 5) {
        amount = 0f;
    }
}
}
