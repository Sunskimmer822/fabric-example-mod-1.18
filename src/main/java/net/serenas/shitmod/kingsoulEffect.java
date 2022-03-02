package net.serenas.shitmod;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class kingsoulEffect extends StatusEffect{

    public kingsoulEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0x98D982);

    }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
    PlayerEntity playerentity;
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            playerentity.getHungerManager().add(1, 1);
        }
    }
}
