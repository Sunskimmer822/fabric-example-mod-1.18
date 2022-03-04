package net.serenas.shitmod;

import java.util.concurrent.TimeUnit;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class fragileStrengthCharm extends Item{

    public fragileStrengthCharm(Settings settings) {
        super(settings);
    }

    public int availableSlots = 1;

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity PlayerEntity, Hand Hand) {
        if (availableSlots > 0) {
            availableSlots--;
            PlayerEntity.sendMessage(new LiteralText("You have " + availableSlots + "charm notches left."), false);
            PlayerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20*1000000, 2));
            PlayerEntity.getMainHandStack().damage(50,PlayerEntity,e-> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            availableSlots++;
    
        } else if (availableSlots < 1) {
            PlayerEntity.sendMessage(new LiteralText("You don't have enough charm notches to do that!"), true);
        }

        return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, PlayerEntity.getStackInHand(Hand));
    }

}
