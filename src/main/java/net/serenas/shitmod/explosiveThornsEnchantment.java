package net.serenas.shitmod;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.World.ExplosionSourceType;

public class explosiveThornsEnchantment extends Enchantment {

    protected explosiveThornsEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }


    @Override
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        World World = attacker.world;
        Vec3d pos = attacker.getPos();
        World.createExplosion(attacker, DamageSource.GENERIC, null, pos, 3 * level, false, ExplosionSourceType.NONE);
        // World.createExplosion(user, DamageSource.MAGIC, null, pos.x, pos.y, pos.z, 3 * level, false, DestructionType.NONE);
        super.onUserDamaged(user, attacker, level);
    }
}
