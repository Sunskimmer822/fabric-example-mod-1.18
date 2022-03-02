package net.serenas.shitmod;

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
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerentity, Hand hand) {
    boolean kingSoulActive = false;

    if (kingSoulActive == true) {
        kingSoulActive = false;
    } else if (kingSoulActive == false) {
        kingSoulActive = true;
    }
    
    return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, playerentity.getStackInHand(hand));
    
    }
    @Override
    public void 
    if (kingSoulActive == true) {
        return new kingsoulEffect();
    } 
}

