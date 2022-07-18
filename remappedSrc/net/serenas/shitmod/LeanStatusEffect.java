package net.serenas.shitmod;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class LeanStatusEffect extends StatusEffect{
    public LeanStatusEffect() {
        super(
          StatusEffectCategory.HARMFUL, // whether beneficial or harmful for entities
          0x98D982); // color in RGB
      }
     
      // This method is called every tick to check whether it should apply the status effect or not
      @Override
      public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // In our case, we just make it return true so that it applies the status effect every tick.
        return true;
      }
     
      // This method is called when it applies the status effect. We implement custom functionality here.
      @Override
      public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
          ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 1, amplifier));
          ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 1, amplifier));
          ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 1, amplifier));
          ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 1, amplifier));
          ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 1, amplifier));
          ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 1, amplifier));
          ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 1, amplifier));
        }
      }
}


