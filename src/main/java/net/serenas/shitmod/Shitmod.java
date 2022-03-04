package net.serenas.shitmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class Shitmod implements ModInitializer {

    public static final Item FABRIC_ITEM = new FabricItem(new Item.Settings().group(ItemGroup.MISC));

    public static final Block FABRIC_BLOCK = new FabricBlock();

    public static final Item HAUSBOMMER_ITEM = new Hausbommer(new Item.Settings().group(ItemGroup.MISC));

    public static final StatusEffect LEAN_EFFECT = new LeanStatusEffect();

    public static final Item LEAN = new Lean(new Item.Settings().group(ItemGroup.FOOD).rarity(Rarity.UNCOMMON).food(new FoodComponent.Builder().hunger(20).saturationModifier(10f).snack().meat().alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 20*60, 5), 1f).statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 20*60, 5), 1f).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20*60), 1f).statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20*60, 2), 1f).statusEffect(new StatusEffectInstance(StatusEffects.POISON, 20*60, 5), 1f).statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 20*60), 1f).statusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 20*60, 5), 1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 20*60, 3), 1f).build()));

    public static final StatusEffect EXP = new ExpStatusEffect();
    
    public static final Item ORANGE_JUICE = new OrangeJuice(new Item.Settings().group(ItemGroup.FOOD).rarity(Rarity.EPIC).food(new FoodComponent.Builder().hunger(200).saturationModifier(10f).snack().meat().alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20*120, 5), 1f).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 20*120, 20), 1f).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20*120), 1f).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 20*120, 3), 1f).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20*120, 2), 1f).build()));

    public static final ItemGroup CHARMS_GROUP = FabricItemGroupBuilder.build(
		new Identifier("shitmod", "charms"),
		() -> new ItemStack(Shitmod.KINGSOUL_CHARM));

    public static final ItemGroup GENERAL_GROUP = FabricItemGroupBuilder.build(
      new Identifier("shitmod", "general"),
      () -> new ItemStack(Shitmod.FABRIC_ITEM));
    
    public static final Item KINGSOUL_CHARM = new kingsoul(new Item.Settings().group(Shitmod.CHARMS_GROUP).maxDamage(500).fireproof());

    public static final StatusEffect KINGSOUL_CHARM_EFFECT = new kingsoulEffect();

    public static final Item STALWART_SHELL_CHARM = new stalwartShell(new Item.Settings().group(Shitmod.CHARMS_GROUP).maxDamage(500).fireproof());

    public static final Item FRAGILE_HEART_CHARM = new fragileHeartCharm(new Item.Settings().group(Shitmod.CHARMS_GROUP).maxDamage(100).fireproof());

    public static final Item UNBREAKABLE_HEART_CHARM = new unbreakableHeartCharm(new Item.Settings().group(Shitmod.CHARMS_GROUP).fireproof().maxCount(1));

    public static final Item FRAGILE_STRENGTH_CHARM =  new fragileStrengthCharm(new Item.Settings().group(Shitmod.CHARMS_GROUP).maxDamage(100).fireproof());

    public static final Item UNBREAKABLE_STRENGTH_CHARM = new unbreakableStrengthCharm(new Item.Settings().group(Shitmod.CHARMS_GROUP).fireproof().maxCount(1));
    
    public static final Item TOTEM_OF_EQUIVALENCY = new totemOfEquivalency(new Item.Settings().group(Shitmod.GENERAL_GROUP).maxCount(1));

    public static final Item ROCK_WITH_A_STRING_TIED_AROUND = new rockWithAStringAround(new Item.Settings().group(Shitmod.GENERAL_GROUP).maxCount(1));

    public static final Item KINGSOUL_LEFT = new kingsoulLeft(new Item.Settings().group(Shitmod.CHARMS_GROUP).maxCount(1));

    public static final Item KINGSOUL_RIGHT = new kingsoulRight(new Item.Settings().group(Shitmod.CHARMS_GROUP).maxCount(1));

    @Override
    public void onInitialize() {

        Registry.register(Registry.ITEM, new Identifier("shitmod", "fabric_item"), FABRIC_ITEM);

        Registry.register(Registry.BLOCK, new Identifier("shitmod", "fabric_block"), FABRIC_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("shitmod", "fabric_block"), new BlockItem(FABRIC_BLOCK, new FabricItemSettings().group(ItemGroup.MISC)));

        Registry.register(Registry.ITEM, new Identifier("shitmod", "hausbommer"), HAUSBOMMER_ITEM);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "lean"), LEAN);

        Registry.register(Registry.STATUS_EFFECT, new Identifier("shitmod", "exp"), EXP);

        Registry.register(Registry.STATUS_EFFECT, new Identifier("shitmod", "lean"), LEAN_EFFECT);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "orange_juice"), ORANGE_JUICE);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "kingsoul_charm"), KINGSOUL_CHARM);

        Registry.register(Registry.STATUS_EFFECT, new Identifier("shitmod", "kingsoul_charm"), KINGSOUL_CHARM_EFFECT);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "stalwart_shell_charm"), STALWART_SHELL_CHARM);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "fragile_heart_charm"), FRAGILE_HEART_CHARM);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "unbreakable_heart_charm"), UNBREAKABLE_HEART_CHARM);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "fragile_strength_charm"), FRAGILE_STRENGTH_CHARM);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "unbreakable_strength_charm"), UNBREAKABLE_STRENGTH_CHARM);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "totem_of_equivalency"), TOTEM_OF_EQUIVALENCY);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "rock_with_string"), ROCK_WITH_A_STRING_TIED_AROUND);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "kingsoul_left_fragment"), KINGSOUL_LEFT);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "kingsoul_right_fragment"), KINGSOUL_RIGHT);

        CustomPortalBuilder.beginPortal()  
.frameBlock(Blocks.DIAMOND_BLOCK)  
.lightWithItem(Items.ENDER_EYE)  
.destDimID(new Identifier("the_end"))  
.tintColor(45,65,101)  
.registerPortal();

        
    }
    
}