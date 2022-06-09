package net.serenas.shitmod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class potatoChips extends Item {

    public potatoChips(Settings settings) {
        super(settings);
    }
    
int potatoChipsConsumed = 0;

    @Override
    public TypedActionResult<ItemStack> use(World World, PlayerEntity PlayerEntity, Hand Hand) {
    PlayerEntity.getHungerManager().add(1, 10f);
    PlayerEntity.getStackInHand(Hand).decrement(1);
    return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, PlayerEntity.getStackInHand(Hand));
    }
}
