package net.serenas.shitmod;

import java.util.concurrent.TimeUnit;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class kingsoul extends Item {

    public kingsoul(Settings settings) {
        super(settings);

    }
    
    public int availableSlots = 10;

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity PlayerEntity, Hand hand) {
    if (availableSlots > 0) {
        availableSlots--;
        PlayerEntity.getHungerManager().add(1, 1);
        PlayerEntity.getMainHandStack().damage(1,PlayerEntity,e-> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        availableSlots++;

    } else if (availableSlots < 1) {
        PlayerEntity.sendMessage(new LiteralText("You don't have enough charm notches to do that!"), true);
    }
        
    return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, PlayerEntity.getStackInHand(hand));
    
    }


    
}

