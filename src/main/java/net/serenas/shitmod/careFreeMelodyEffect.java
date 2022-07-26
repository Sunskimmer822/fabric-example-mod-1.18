package net.serenas.shitmod;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class careFreeMelodyEffect extends StatusEffect {

    protected careFreeMelodyEffect(StatusEffectCategory category, int color) {
        super(
            StatusEffectCategory.BENEFICIAL, // whether beneficial or harmful for entities
            0x98D982);
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
    float damage = entity.getDamageTracker().getMostRecentDamage().getDamage();
    float health = entity.getDamageTracker().getMostRecentDamage().getEntityHealth();
    DamageSource source = entity.getDamageTracker().getMostRecentDamage().getDamageSource();
    entity.getDamageTracker().onDamage(source, health, damage);
    
}

}
