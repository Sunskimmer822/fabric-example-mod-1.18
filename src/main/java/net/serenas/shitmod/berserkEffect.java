package net.serenas.shitmod;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class berserkEffect extends StatusEffect{

    protected berserkEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0xa80f12);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
      // In our case, we just make it return true so that it applies the status effect every tick.
      return true;
    }
   
    // This method is called when it applies the status effect. We implement custom functionality here.
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
      if (entity instanceof PlayerEntity) {
        ((PlayerEntity) entity).damage(DamageSource.MAGIC, (0.5f));
        ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 2, amplifier*2, false, false, false));
        ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 2, amplifier*2, false, false, false));
      }
    }
    
}
