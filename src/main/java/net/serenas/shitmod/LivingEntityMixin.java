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
    @Inject(at = @At("HEAD"), method = "Lnet/minecraft/entity/LivingEntity;modifyAppliedDamage(Lnet/minecraft/entity/damage/DamageSource;F)F")
private void injectMethod(DamageSource source, Float amount, CallbackInfo info) {
    int rand = new Random().nextInt(5);
    if (rand == 4) {
        amount = 0f;
    }
}
}
