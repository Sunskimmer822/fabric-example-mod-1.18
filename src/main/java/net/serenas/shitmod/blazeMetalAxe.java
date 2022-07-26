package net.serenas.shitmod;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class blazeMetalAxe extends AxeItem {
    public blazeMetalAxe(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
    
    @Override
    public TypedActionResult<ItemStack> use(World World, PlayerEntity PlayerEntity, Hand Hand) {
        Vec3d looking = PlayerEntity.getRotationVector();
    World.spawnEntity(new FireballEntity(World, PlayerEntity, looking.x, looking.y, looking.z, 6));
    PlayerEntity.getStackInHand(Hand).damage(100,PlayerEntity,e-> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
    PlayerEntity.getItemCooldownManager().set(this, 40);
    return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, PlayerEntity.getStackInHand(Hand));
    }

    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        stack.addEnchantment(Enchantments.FIRE_ASPECT, 2);
    }


}
