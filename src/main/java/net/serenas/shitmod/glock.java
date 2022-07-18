package net.serenas.shitmod;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class glock extends Item{

    public glock(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        ArrowEntity arro = new ArrowEntity(world, playerEntity.getX(), playerEntity.getEyeY(), playerEntity.getZ());
        arro.setVelocity(playerEntity, playerEntity.getPitch(), playerEntity.getHeadYaw(), 0f, 100, 0);
        world.spawnEntity(arro);
        playerEntity.getMainHandStack().damage(1,playerEntity,e-> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, playerEntity.getStackInHand(hand));
    }

}
