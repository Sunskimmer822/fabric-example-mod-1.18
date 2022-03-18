package net.serenas.shitmod;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class explosionAspectEnchantment extends Enchantment {

    protected explosionAspectEnchantment() {
        super(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});

    }
    
    @Override
    public int getMinPower(int level) {
        return 100;
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, net.minecraft.entity.Entity target, int level) {
        World world = user.world;
        if (target instanceof LivingEntity) {
            Vec3d pos = target.getPos();
            world.createExplosion(user, pos.x, pos.y, pos.z, level * 4.0F, Explosion.DestructionType.BREAK);
        }
        super.onTargetDamaged(user, target, level);
    }
    
}