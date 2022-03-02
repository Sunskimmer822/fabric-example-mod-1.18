package net.serenas.shitmod;

import java.io.Console;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class kingsoul extends Item {

    public kingsoul(Settings settings) {
        super(settings);

    }

    
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity PlayerEntity, Hand hand) {
    boolean kingSoulActive;

    if (kingSoulActive == true) {
        kingSoulActive = false;
    } else if (kingSoulActive == false) {
        kingSoulActive = true;
    }
    
    return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, PlayerEntity.getStackInHand(hand));
    
    }



    if (kingSoulActive == true) {
        new kingsoulEffect();
    } 
}

