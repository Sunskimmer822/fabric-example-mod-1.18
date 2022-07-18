package net.serenas.shitmod;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class blazeMetalMaterial implements ToolMaterial {

    public static final blazeMetalMaterial INSTANCE = new blazeMetalMaterial();

    @Override
    public int getDurability() {
        return 500;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 12.0f;
    }

    @Override
    public float getAttackDamage() {
        return 4.0f;
    }

    @Override
    public int getMiningLevel() {
        return 7;
    }

    @Override
    public int getEnchantability() {
        return 40;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.BLAZE_ROD);
    }
    
}
