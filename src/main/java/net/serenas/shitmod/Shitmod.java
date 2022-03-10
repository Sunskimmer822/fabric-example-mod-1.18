package net.serenas.shitmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Block;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
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

    public static final ItemGroup TOOLS_GROUP = FabricItemGroupBuilder.build(
      new Identifier("shitmod", "tools"), 
      () -> new ItemStack(Shitmod.BLAZE_METAL_SHOVEL));
    
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

    public static final ToolItem BLAZE_METAL_SWORD = new SwordItem(blazeMetalMaterial.INSTANCE, 5, 3f, new Item.Settings().group(Shitmod.TOOLS_GROUP));

    public static final ToolItem BLAZE_METAL_PICKAXE = new blazeMetalPickaxe(blazeMetalMaterial.INSTANCE, 1, -0.5f, new Item.Settings().group(Shitmod.TOOLS_GROUP));

    public static final ToolItem BLAZE_METAL_AXE = new blazeMetalAxe(blazeMetalMaterial.INSTANCE, 8.0f, -1.0f, new Item.Settings().group(Shitmod.TOOLS_GROUP));

    public static final ToolItem BLAZE_METAL_SHOVEL = new ShovelItem(blazeMetalMaterial.INSTANCE, 1f, 3.0f, new Item.Settings().group(Shitmod.TOOLS_GROUP));

    public static final ToolItem BLAZE_METAL_HOE = new blazeMetalHoe(blazeMetalMaterial.INSTANCE, new Item.Settings().group(Shitmod.TOOLS_GROUP));

    public static final Item BLAZE_METAL_INGOT = new blazeMetalIngot(new Item.Settings().group(Shitmod.GENERAL_GROUP));

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

        Registry.register(Registry.ITEM, new Identifier("shitmod", "blaze_metal_sword"), BLAZE_METAL_SWORD);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "blaze_metal_pickaxe"), BLAZE_METAL_PICKAXE);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "blaze_metal_axe"), BLAZE_METAL_AXE);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "blaze_metal_shovel"), BLAZE_METAL_SHOVEL);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "blaze_metal_hoe"), BLAZE_METAL_HOE);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "blaze_metal_ingot"), BLAZE_METAL_INGOT);

        CustomPortalBuilder.beginPortal()  
.frameBlock(Shitmod.FABRIC_BLOCK)  
.lightWithItem(Shitmod.BLAZE_METAL_INGOT)  
.destDimID(new Identifier("the_end"))  
.tintColor(45,65,101)  
.registerPortal();

        
    }
    
}