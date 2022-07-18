package net.serenas.shitmod;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.util.Hand;


public class stalwartShell extends Item{
    public stalwartShell(Settings settings) {
        super(settings);
    }

    public int availableSlots = 8;

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity PlayerEntity, Hand hand) {
            PlayerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 20, 5));
            PlayerEntity.getMainHandStack().damage(1,PlayerEntity,e-> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, PlayerEntity.getStackInHand(hand));
    }


}
