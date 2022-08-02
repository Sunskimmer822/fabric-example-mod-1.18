package net.serenas.shitmod;

import java.util.Random;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class berserkerTotem extends Item{

    public berserkerTotem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        int rand = new Random().nextInt(5);
        if (rand == 0) {
            rand++;
            playerEntity.addStatusEffect(new StatusEffectInstance(Shitmod.BERSERK, 400, rand));
            return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, playerEntity.getStackInHand(hand));
        }
        playerEntity.addStatusEffect(new StatusEffectInstance(Shitmod.BERSERK, 400, rand));


        return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, playerEntity.getStackInHand(hand));
    }
    
}
