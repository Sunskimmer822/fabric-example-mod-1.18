package net.serenas.shitmod;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class unbreakableHeartCharm extends Item {

    public unbreakableHeartCharm(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity Playerentity, Hand Hand) {
        Playerentity.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 20*1000000, 4));
        return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, Playerentity.getStackInHand(Hand));
    }
}