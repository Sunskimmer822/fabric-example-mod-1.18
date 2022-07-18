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
    potatoChipsConsumed+=1;
    if (potatoChipsConsumed == 69) {
        PlayerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 20 * 15, 4));
        potatoChipsConsumed-=69;
        PlayerEntity.sendMessage(new LiteralText("I'm really fat/test"), false);
        System.out.println("I'm really fat\n/test");
    }
    return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, PlayerEntity.getStackInHand(Hand));
    }
}
