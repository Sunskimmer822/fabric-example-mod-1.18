package net.serenas.shitmod;

import java.util.concurrent.TimeUnit;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class totemOfEquivalency extends Item {

    public totemOfEquivalency(Settings settings) {
        super(settings);
    }


    @Override
    public TypedActionResult<ItemStack> use(World World, PlayerEntity PlayerEntity, Hand Hand) {
        PlayerEntity.kill();
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, PlayerEntity.getStackInHand(Hand));
    }
}
