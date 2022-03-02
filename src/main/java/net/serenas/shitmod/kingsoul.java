package net.serenas.shitmod;

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
    Boolean kingSoulActive = false;
    
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity PlayerEntity, Hand hand) {
    

    if (kingSoulActive == true) {
        kingSoulActive = false;
    } else if (kingSoulActive == false) {
        kingSoulActive = true;
    }
    
    return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, PlayerEntity.getStackInHand(hand));
    
    }


    
}

