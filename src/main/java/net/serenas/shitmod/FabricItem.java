package net.serenas.shitmod;

import net.minecraft.entity.TntEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class FabricItem extends Item {

    public FabricItem(Settings settings) {
        super(settings);

    }
    
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity PlayerEntity, Hand hand) {
        PlayerEntity.playSound(SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, 1.0F, 1.0F);
        for (int i = 0; i < 10; i++) {
            world.spawnEntity(new TntEntity(world, PlayerEntity.getX(), PlayerEntity.getY(), PlayerEntity.getZ(), PlayerEntity));
          }
        return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, PlayerEntity.getStackInHand(hand));
    }
    

}
