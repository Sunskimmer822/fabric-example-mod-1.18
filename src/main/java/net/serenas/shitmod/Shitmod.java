package net.serenas.shitmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolItem;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class Shitmod implements ModInitializer {

  public static final ItemGroup CHARMS_GROUP = FabricItemGroupBuilder.build(
		new Identifier("shitmod", "charms"),
		() -> new ItemStack(Shitmod.KINGSOUL_CHARM));

    public static final ItemGroup GENERAL_GROUP = FabricItemGroupBuilder.build(
      new Identifier("shitmod", "general"),
      () -> new ItemStack(Shitmod.PP));

    public static final ItemGroup TOOLS_GROUP = FabricItemGroupBuilder.build(
      new Identifier("shitmod", "tools"), 
      () -> new ItemStack(Shitmod.BLAZE_METAL_SHOVEL));

    public static final Item PP = new FabricItem(new Item.Settings().group(Shitmod.GENERAL_GROUP));

    public static final Block FABRIC_BLOCK = new FabricBlock();

    public static final Item HAUSBOMMER_ITEM = new Hausbommer(new Item.Settings().group(Shitmod.GENERAL_GROUP));

    public static final StatusEffect LEAN_EFFECT = new LeanStatusEffect();

    public static final Item LEAN = new Lean(new Item.Settings().group(ItemGroup.FOOD).rarity(Rarity.UNCOMMON).food(new FoodComponent.Builder().hunger(20).saturationModifier(10f).snack().meat().alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 20*60, 5), 1f).statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 20*60, 5), 1f).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20*60), 1f).statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20*60, 2), 1f).statusEffect(new StatusEffectInstance(StatusEffects.POISON, 20*60, 5), 1f).statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 20*60), 1f).statusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 20*60, 5), 1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 20*60, 3), 1f).build()));

    public static final StatusEffect EXP = new ExpStatusEffect();
    
    public static final Item ORANGE_JUICE = new OrangeJuice(new Item.Settings().group(ItemGroup.FOOD).rarity(Rarity.EPIC).food(new FoodComponent.Builder().hunger(200).saturationModifier(10f).snack().meat().alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20*120, 5), 1f).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 20*120, 20), 1f).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20*120), 1f).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 20*120, 3), 1f).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20*120, 2), 1f).build()));
    
    public static final Item KINGSOUL_CHARM = new kingsoul(new Item.Settings().group(Shitmod.CHARMS_GROUP).maxDamage(500).fireproof());

    public static final Item STALWART_SHELL_CHARM = new stalwartShell(new Item.Settings().group(Shitmod.CHARMS_GROUP).maxDamage(500).fireproof());

    public static final Item FRAGILE_HEART_CHARM = new fragileHeartCharm(new Item.Settings().group(Shitmod.CHARMS_GROUP).maxDamage(100).fireproof());

    public static final Item UNBREAKABLE_HEART_CHARM = new unbreakableHeartCharm(new Item.Settings().group(Shitmod.CHARMS_GROUP).fireproof().maxCount(1));

    public static final Item FRAGILE_STRENGTH_CHARM =  new fragileStrengthCharm(new Item.Settings().group(Shitmod.CHARMS_GROUP).maxDamage(100).fireproof());

    public static final Item UNBREAKABLE_STRENGTH_CHARM = new unbreakableStrengthCharm(new Item.Settings().group(Shitmod.CHARMS_GROUP).fireproof().maxCount(1));
    
    public static final Item TOTEM_OF_EQUIVALENCY = new totemOfEquivalency(new Item.Settings().group(Shitmod.GENERAL_GROUP).maxCount(1));

    public static final Item ROCK_WITH_A_STRING_TIED_AROUND = new rockWithAStringAround(new Item.Settings().group(Shitmod.GENERAL_GROUP).maxCount(1));

    public static final Item KINGSOUL_LEFT = new kingsoulLeft(new Item.Settings().group(Shitmod.CHARMS_GROUP).maxCount(1));

    public static final Item KINGSOUL_RIGHT = new kingsoulRight(new Item.Settings().group(Shitmod.CHARMS_GROUP).maxCount(1));

    public static final ToolItem BLAZE_METAL_SWORD = new blazeMetalSword(blazeMetalMaterial.INSTANCE, 5, 3f, new Item.Settings().group(Shitmod.TOOLS_GROUP).maxDamage(8000));

    public static final ToolItem BLAZE_METAL_PICKAXE = new blazeMetalPickaxe(blazeMetalMaterial.INSTANCE, 1, -0.5f, new Item.Settings().group(Shitmod.TOOLS_GROUP).maxDamage(8000));

    public static final ToolItem BLAZE_METAL_AXE = new blazeMetalAxe(blazeMetalMaterial.INSTANCE, 8.0f, -1.0f, new Item.Settings().group(Shitmod.TOOLS_GROUP).maxDamage(8000));

    public static final ToolItem BLAZE_METAL_SHOVEL = new ShovelItem(blazeMetalMaterial.INSTANCE, 1f, 3.0f, new Item.Settings().group(Shitmod.TOOLS_GROUP).maxDamage(8000));

    public static final ToolItem BLAZE_METAL_HOE = new blazeMetalHoe(blazeMetalMaterial.INSTANCE, -4, 1f, new Item.Settings().group(Shitmod.TOOLS_GROUP).maxDamage(8000));

    public static final Item BLAZE_METAL_INGOT = new blazeMetalIngot(new Item.Settings().group(Shitmod.GENERAL_GROUP));

    public static final Enchantment EXPLOSION_ASPECT = new explosionAspectEnchantment();

    public static final Enchantment EXPLOSIVE_THORNS = new explosiveThornsEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.WEARABLE, new EquipmentSlot[] {EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET});

    public static final Item REINFORCED_BLAZE_METAL_INGOT = new reinforcedBlazeMetalIngot(new Item.Settings().fireproof().group(Shitmod.GENERAL_GROUP));

    public static final Item BLAZE_METAL_SWORD_CASING = new blazeMetalSwordCasing(new Item.Settings().fireproof().group(Shitmod.GENERAL_GROUP));

    public static final Item BLAZE_METAL_PICKAXE_CASING = new blazeMetalPickaxeCasing(new Item.Settings().fireproof().group(Shitmod.GENERAL_GROUP));

    public static final Item BLAZE_METAL_AXE_CASING = new blazeMetalAxeCasing(new Item.Settings().fireproof().group(Shitmod.GENERAL_GROUP));

    public static final Item BLAZE_METAL_SHOVEL_CASING = new blazeMetalShovelCasing(new Item.Settings().fireproof().group(Shitmod.GENERAL_GROUP));

    public static final Item BLAZE_METAL_HOE_CASING = new blazeMetalHoeCasing(new Item.Settings().fireproof().group(Shitmod.GENERAL_GROUP));

    public static final Item POTATO_CHIPS = new potatoChips(new Item.Settings().group(ItemGroup.FOOD).maxCount(69));

    public static final Item PULVERIZED_BLAZE_METAL = new pulverizedBlazeMetal(new Item.Settings().fireproof().group(Shitmod.GENERAL_GROUP));

    public static final Item SEARED_GOLD_INGOT = new searedGoldIngot(new Item.Settings().fireproof().group(Shitmod.GENERAL_GROUP));

    public static final Item PULVERIZED_NETHERITE = new pulverizedNetherite(new Item.Settings().fireproof().group(Shitmod.GENERAL_GROUP));

    public static final ToolItem COPPER_SWORD = new copperSword(copperMaterial.INSTANCE, 2, -2.4f, new Item.Settings().group(Shitmod.TOOLS_GROUP).maxDamage(250));

    public static final ToolItem COPPER_PICKAXE = new copperPickaxe(copperMaterial.INSTANCE, 0, -2.8f, new Item.Settings().group(Shitmod.TOOLS_GROUP).maxDamage(250));

    public static final ToolItem COPPER_AXE = new copperAxe(copperMaterial.INSTANCE, 5, -3.1f, new Item.Settings().group(Shitmod.TOOLS_GROUP).maxDamage(250));

    public static final ToolItem COPPER_SHOVEL = new copperShovel(copperMaterial.INSTANCE, 0.5f, -3f, new Item.Settings().group(Shitmod.TOOLS_GROUP).maxDamage(250));

    public static final ToolItem COPPER_HOE = new copperHoe(copperMaterial.INSTANCE, -3, -1f, new Item.Settings().group(Shitmod.TOOLS_GROUP).maxDamage(250));

    public static final Item GLOCK = new glock(new Item.Settings().group(Shitmod.TOOLS_GROUP).maxDamage(1000));
    
    public static final SoundEvent GLOCK_NOISE = new SoundEvent(new Identifier("shitmod:glock"));

    @Override
    public void onInitialize() {

        Registry.register(Registry.ITEM, new Identifier("shitmod", "pp"), PP);

        Registry.register(Registry.BLOCK, new Identifier("shitmod", "gay_block"), FABRIC_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("shitmod", "fabric_block"), new BlockItem(FABRIC_BLOCK, new FabricItemSettings().group(ItemGroup.MISC)));

        Registry.register(Registry.ITEM, new Identifier("shitmod", "hausbommer"), HAUSBOMMER_ITEM);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "lean"), LEAN);

        Registry.register(Registry.STATUS_EFFECT, new Identifier("shitmod", "exp"), EXP);

        Registry.register(Registry.STATUS_EFFECT, new Identifier("shitmod", "lean"), LEAN_EFFECT);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "orange_juice"), ORANGE_JUICE);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "kingsoul_charm"), KINGSOUL_CHARM);

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

        Registry.register(Registry.ENCHANTMENT, new Identifier("shitmod", "explosion_aspect"), EXPLOSION_ASPECT);

        Registry.register(Registry.ENCHANTMENT, new Identifier("shitmod", "explosive_thorns"), EXPLOSIVE_THORNS);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "reinforced_blaze_metal_ingot"), REINFORCED_BLAZE_METAL_INGOT);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "blaze_metal_sword_casing"), BLAZE_METAL_SWORD_CASING);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "blaze_metal_pickaxe_casing"), BLAZE_METAL_PICKAXE_CASING);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "blaze_metal_axe_casing"), BLAZE_METAL_AXE_CASING);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "blaze_metal_shovel_casing"), BLAZE_METAL_SHOVEL_CASING);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "blaze_metal_hoe_casing"), BLAZE_METAL_HOE_CASING);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "potato_chip"), POTATO_CHIPS);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "pulverized_blaze_metal"), PULVERIZED_BLAZE_METAL);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "pulverized_netherite"), PULVERIZED_NETHERITE);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "seared_gold_ingot"), SEARED_GOLD_INGOT);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "copper_sword"), COPPER_SWORD);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "copper_pickaxe"), COPPER_PICKAXE);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "copper_axe"), COPPER_AXE);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "copper_shovel"), COPPER_SHOVEL);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "copper_hoe"), COPPER_HOE);

        Registry.register(Registry.ITEM, new Identifier("shitmod", "glock"), GLOCK);

        Registry.register(Registry.SOUND_EVENT, new Identifier("shitmod", "glock_noise"), GLOCK_NOISE);
    }
  }
