package net.serenas.shitmod;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

public class blazeMetalHoe extends HoeItem {

    public blazeMetalHoe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        stack.addEnchantment(Enchantments.FIRE_ASPECT, 2);
    }
    
}
