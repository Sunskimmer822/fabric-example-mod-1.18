package net.serenas.shitmod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.Util;
import net.minecraft.world.World;

public class Hausbommer extends Item{
    public Hausbommer(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerentity, Hand hand) {
        double x = playerentity.getX();
        double y = playerentity.getY();
        double z = playerentity.getZ();
        double xRound = Math.round(x);
        double yRound = Math.round(y);
        double zRound = Math.round(z);
        String Xmessage = String.valueOf(xRound);
        String Ymessage = String.valueOf(yRound);
        String Zmessage = String.valueOf(zRound);
        String fullMessage = "X: " + Xmessage + " Y: " + Ymessage + " Z: " + Zmessage;
        playerentity.sendSystemMessage(new LiteralText(fullMessage), Util.NIL_UUID);
        return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, playerentity.getStackInHand(hand));
    }
}
