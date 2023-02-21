package net.serenas.shitmod;

import java.lang.reflect.Array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
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
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class Shitmod implements ModInitializer {

  public static final Logger LOGGER = LoggerFactory.getLogger("shitmod");

  public Integer a;
  public Integer b;
  public Integer c;
  public Integer d;

    public static final ItemGroup CHARMS_GROUP = FabricItemGroup.builder(
    new Identifier("shitmod", "charms"))
		.icon(() -> new ItemStack(Shitmod.KINGSOUL_CHARM))
    .build();

    public static final ItemGroup GENERAL_GROUP = FabricItemGroup.builder(
    new Identifier("shitmod", "general"))
    .icon(() -> new ItemStack(Shitmod.PP))
    .build();

    public static final ItemGroup TOOLS_GROUP = FabricItemGroup.builder(
      new Identifier("shitmod", "tools"))
      .icon(() -> new ItemStack(Shitmod.BLAZE_METAL_SHOVEL))
      .build();

    public static final Item PP = new FabricItem(new FabricItemSettings());

    public static final Block FABRIC_BLOCK = new FabricBlock();

    public static final Item HAUSBOMMER_ITEM = new Hausbommer(new Item.Settings());

    public static final StatusEffect LEAN_EFFECT = new LeanStatusEffect();

    public static final Item LEAN = new Lean(new Item.Settings().rarity(Rarity.UNCOMMON).food(new FoodComponent.Builder().hunger(20).saturationModifier(10f).snack().meat().alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 20*60, 5), 1f).statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 20*60, 5), 1f).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20*60), 1f).statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20*60, 2), 1f).statusEffect(new StatusEffectInstance(StatusEffects.POISON, 20*60, 5), 1f).statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 20*60), 1f).statusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 20*60, 5), 1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 20*60, 3), 1f).build()));

    public static final StatusEffect EXP = new ExpStatusEffect();
    
    public static final Item ORANGE_JUICE = new OrangeJuice(new Item.Settings().rarity(Rarity.EPIC).food(new FoodComponent.Builder().hunger(200).saturationModifier(10f).snack().meat().alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20*120, 5), 1f).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 20*120, 20), 1f).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20*120), 1f).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 20*120, 3), 1f).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20*120, 2), 1f).build()));
    
    public static final Item KINGSOUL_CHARM = new kingsoul(new Item.Settings().maxDamage(500).fireproof());

    public static final Item STALWART_SHELL_CHARM = new stalwartShell(new Item.Settings().maxDamage(500).fireproof());

    public static final Item FRAGILE_HEART_CHARM = new fragileHeartCharm(new Item.Settings().maxDamage(100).fireproof());

    public static final Item UNBREAKABLE_HEART_CHARM = new unbreakableHeartCharm(new Item.Settings().fireproof().maxCount(1));

    public static final Item FRAGILE_STRENGTH_CHARM =  new fragileStrengthCharm(new Item.Settings().maxDamage(100).fireproof());

    public static final Item UNBREAKABLE_STRENGTH_CHARM = new unbreakableStrengthCharm(new Item.Settings().fireproof().maxCount(1));
    
    public static final Item TOTEM_OF_EQUIVALENCY = new totemOfEquivalency(new Item.Settings().maxCount(1));

    public static final Item ROCK_WITH_A_STRING_TIED_AROUND = new rockWithAStringAround(new Item.Settings().maxCount(1));

    public static final Item KINGSOUL_LEFT = new kingsoulLeft(new Item.Settings().maxCount(1));

    public static final Item KINGSOUL_RIGHT = new kingsoulRight(new Item.Settings().maxCount(1));

    public static final ToolItem BLAZE_METAL_SWORD = new blazeMetalSword(blazeMetalMaterial.INSTANCE, 5, 3f, new Item.Settings().maxDamage(8000));

    public static final ToolItem BLAZE_METAL_PICKAXE = new blazeMetalPickaxe(blazeMetalMaterial.INSTANCE, 1, -0.5f, new Item.Settings().maxDamage(8000));

    public static final ToolItem BLAZE_METAL_AXE = new blazeMetalAxe(blazeMetalMaterial.INSTANCE, 8.0f, -1.0f, new Item.Settings().maxDamage(8000));

    public static final ToolItem BLAZE_METAL_SHOVEL = new ShovelItem(blazeMetalMaterial.INSTANCE, 1f, 3.0f, new Item.Settings().maxDamage(8000));

    public static final ToolItem BLAZE_METAL_HOE = new blazeMetalHoe(blazeMetalMaterial.INSTANCE, -4, 1f, new Item.Settings().maxDamage(8000));

    public static final Item BLAZE_METAL_INGOT = new blazeMetalIngot(new Item.Settings());

    public static final Enchantment EXPLOSION_ASPECT = new explosionAspectEnchantment();

    public static final Enchantment EXPLOSIVE_THORNS = new explosiveThornsEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.WEARABLE, new EquipmentSlot[] {EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET});

    public static final Item REINFORCED_BLAZE_METAL_INGOT = new reinforcedBlazeMetalIngot(new Item.Settings().fireproof());

    public static final Item BLAZE_METAL_SWORD_CASING = new blazeMetalSwordCasing(new Item.Settings().fireproof());

    public static final Item BLAZE_METAL_PICKAXE_CASING = new blazeMetalPickaxeCasing(new Item.Settings().fireproof());

    public static final Item BLAZE_METAL_AXE_CASING = new blazeMetalAxeCasing(new Item.Settings().fireproof());

    public static final Item BLAZE_METAL_SHOVEL_CASING = new blazeMetalShovelCasing(new Item.Settings().fireproof());

    public static final Item BLAZE_METAL_HOE_CASING = new blazeMetalHoeCasing(new Item.Settings().fireproof());

    public static final Item POTATO_CHIPS = new potatoChips(new Item.Settings().maxCount(69));

    public static final Item PULVERIZED_BLAZE_METAL = new pulverizedBlazeMetal(new Item.Settings().fireproof());

    public static final Item SEARED_GOLD_INGOT = new searedGoldIngot(new Item.Settings().fireproof());

    public static final Item PULVERIZED_NETHERITE = new pulverizedNetherite(new Item.Settings().fireproof());

    public static final ToolItem COPPER_SWORD = new copperSword(copperMaterial.INSTANCE, 2, -2.4f, new Item.Settings().maxDamage(250));

    public static final ToolItem COPPER_PICKAXE = new copperPickaxe(copperMaterial.INSTANCE, 0, -2.8f, new Item.Settings().maxDamage(250));

    public static final ToolItem COPPER_AXE = new copperAxe(copperMaterial.INSTANCE, 5, -3.1f, new Item.Settings().maxDamage(250));

    public static final ToolItem COPPER_SHOVEL = new copperShovel(copperMaterial.INSTANCE, 0.5f, -3f, new Item.Settings().maxDamage(250));

    public static final ToolItem COPPER_HOE = new copperHoe(copperMaterial.INSTANCE, -3, -1f, new Item.Settings().maxDamage(250));

    public static final Item GLOCK = new glock(new FabricItemSettings().maxDamage(1000).rarity(Rarity.EPIC));
    
    public static final Identifier GLOCK_NOISE_ID = new Identifier("shitmod:glock_noise");

    public static final SoundEvent GLOCK_NOISE_EVENT = SoundEvent.of(GLOCK_NOISE_ID);

    public static final Enchantment LIFESTEAL = new lifeStealEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});

    public static final PickaxeItem HAMMER = new testHammer(ToolMaterials.NETHERITE, 3, -1, new Item.Settings().fireproof().maxDamage(2031));

    public static final StatusEffect BERSERK = new berserkEffect();

    public static final Item BERSERKER_TOTEM = new berserkerTotem(new FabricItemSettings().maxDamage(512).rarity(Rarity.EPIC));

    @Override
    public void onInitialize() {

      LOGGER.info("Shitmod has been initialized.");

      ItemStack[] generalItems =  {Shitmod.PP.getDefaultStack(),Shitmod.HAUSBOMMER_ITEM.getDefaultStack(),Shitmod.TOTEM_OF_EQUIVALENCY.getDefaultStack(),Shitmod.ROCK_WITH_A_STRING_TIED_AROUND.getDefaultStack(),Shitmod.REINFORCED_BLAZE_METAL_INGOT.getDefaultStack(),Shitmod.BLAZE_METAL_SWORD_CASING.getDefaultStack(),Shitmod.BLAZE_METAL_PICKAXE_CASING.getDefaultStack(),Shitmod.BLAZE_METAL_AXE_CASING.getDefaultStack(),Shitmod.BLAZE_METAL_SHOVEL_CASING.getDefaultStack(),Shitmod.BLAZE_METAL_HOE_CASING.getDefaultStack(),Shitmod.PULVERIZED_BLAZE_METAL.getDefaultStack(),Shitmod.SEARED_GOLD_INGOT.getDefaultStack(),Shitmod.PULVERIZED_NETHERITE.getDefaultStack(),Shitmod.BERSERKER_TOTEM.getDefaultStack()};
      
      ItemStack[] foodItems = {Shitmod.LEAN.getDefaultStack(),Shitmod.ORANGE_JUICE.getDefaultStack(),Shitmod.POTATO_CHIPS.getDefaultStack()};

      ItemStack[] charmItems = {Shitmod.KINGSOUL_CHARM.getDefaultStack(),Shitmod.KINGSOUL_LEFT.getDefaultStack(),Shitmod.KINGSOUL_RIGHT.getDefaultStack(),Shitmod.STALWART_SHELL_CHARM.getDefaultStack(),Shitmod.FRAGILE_HEART_CHARM.getDefaultStack(),Shitmod.UNBREAKABLE_HEART_CHARM.getDefaultStack(),Shitmod.FRAGILE_STRENGTH_CHARM.getDefaultStack(),Shitmod.UNBREAKABLE_STRENGTH_CHARM.getDefaultStack()};

      ItemStack[] toolItems = {Shitmod.BLAZE_METAL_SWORD.getDefaultStack(),Shitmod.BLAZE_METAL_PICKAXE.getDefaultStack(),Shitmod.BLAZE_METAL_AXE.getDefaultStack(),Shitmod.BLAZE_METAL_SHOVEL.getDefaultStack(),Shitmod.BLAZE_METAL_HOE.getDefaultStack(),Shitmod.COPPER_SWORD.getDefaultStack(),Shitmod.COPPER_PICKAXE.getDefaultStack(),Shitmod.COPPER_AXE.getDefaultStack(),Shitmod.COPPER_SHOVEL.getDefaultStack(),Shitmod.COPPER_HOE.getDefaultStack(),Shitmod.GLOCK.getDefaultStack(),Shitmod.HAMMER.getDefaultStack()};
      
      ItemGroupEvents.modifyEntriesEvent(Shitmod.GENERAL_GROUP).register(content -> {
        for (a = 0;a<Array.getLength(generalItems);a++) {
          content.add((ItemStack) Array.get(generalItems,a));
        }
      });

      ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
        for (b = 0;b<Array.getLength(foodItems);b++) {
          content.add((ItemStack) Array.get(foodItems,b));
        }
      });

      ItemGroupEvents.modifyEntriesEvent(Shitmod.CHARMS_GROUP).register(content -> {
        for (c = 0;c<Array.getLength(charmItems);c++) {
          content.add((ItemStack) Array.get(charmItems,c));
        }
      });

      ItemGroupEvents.modifyEntriesEvent(Shitmod.TOOLS_GROUP).register(content -> {
        for (d = 0;d<Array.getLength(toolItems);d++) {
          content.add((ItemStack) Array.get(toolItems,d));
        }
      });

        Registry.register(Registries.ITEM, new Identifier("shitmod", "pp"), PP);

        Registry.register(Registries.BLOCK, new Identifier("shitmod", "gay_block"), FABRIC_BLOCK);
        Registry.register(Registries.ITEM, new Identifier("shitmod", "fabric_block"), new BlockItem(FABRIC_BLOCK, new FabricItemSettings()));

        Registry.register(Registries.ITEM, new Identifier("shitmod", "hausbommer"), HAUSBOMMER_ITEM);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "lean"), LEAN);

        Registry.register(Registries.STATUS_EFFECT, new Identifier("shitmod", "exp"), EXP);

        Registry.register(Registries.STATUS_EFFECT, new Identifier("shitmod", "lean"), LEAN_EFFECT);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "orange_juice"), ORANGE_JUICE);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "kingsoul_charm"), KINGSOUL_CHARM);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "stalwart_shell_charm"), STALWART_SHELL_CHARM);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "fragile_heart_charm"), FRAGILE_HEART_CHARM);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "unbreakable_heart_charm"), UNBREAKABLE_HEART_CHARM);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "fragile_strength_charm"), FRAGILE_STRENGTH_CHARM);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "unbreakable_strength_charm"), UNBREAKABLE_STRENGTH_CHARM);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "totem_of_equivalency"), TOTEM_OF_EQUIVALENCY);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "rock_with_string"), ROCK_WITH_A_STRING_TIED_AROUND);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "kingsoul_left_fragment"), KINGSOUL_LEFT);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "kingsoul_right_fragment"), KINGSOUL_RIGHT);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "blaze_metal_sword"), BLAZE_METAL_SWORD);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "blaze_metal_pickaxe"), BLAZE_METAL_PICKAXE);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "blaze_metal_axe"), BLAZE_METAL_AXE);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "blaze_metal_shovel"), BLAZE_METAL_SHOVEL);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "blaze_metal_hoe"), BLAZE_METAL_HOE);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "blaze_metal_ingot"), BLAZE_METAL_INGOT);

        Registry.register(Registries.ENCHANTMENT, new Identifier("shitmod", "explosion_aspect"), EXPLOSION_ASPECT);

        Registry.register(Registries.ENCHANTMENT, new Identifier("shitmod", "explosive_thorns"), EXPLOSIVE_THORNS);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "reinforced_blaze_metal_ingot"), REINFORCED_BLAZE_METAL_INGOT);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "blaze_metal_sword_casing"), BLAZE_METAL_SWORD_CASING);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "blaze_metal_pickaxe_casing"), BLAZE_METAL_PICKAXE_CASING);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "blaze_metal_axe_casing"), BLAZE_METAL_AXE_CASING);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "blaze_metal_shovel_casing"), BLAZE_METAL_SHOVEL_CASING);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "blaze_metal_hoe_casing"), BLAZE_METAL_HOE_CASING);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "potato_chip"), POTATO_CHIPS);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "pulverized_blaze_metal"), PULVERIZED_BLAZE_METAL);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "pulverized_netherite"), PULVERIZED_NETHERITE);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "seared_gold_ingot"), SEARED_GOLD_INGOT);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "copper_sword"), COPPER_SWORD);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "copper_pickaxe"), COPPER_PICKAXE);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "copper_axe"), COPPER_AXE);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "copper_shovel"), COPPER_SHOVEL);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "copper_hoe"), COPPER_HOE);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "glock"), GLOCK);

        Registry.register(Registries.SOUND_EVENT, Shitmod.GLOCK_NOISE_ID, GLOCK_NOISE_EVENT);

        Registry.register(Registries.ENCHANTMENT, new Identifier("shitmod", "lifesteal"), LIFESTEAL);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "hammer"), HAMMER);

        Registry.register(Registries.STATUS_EFFECT, new Identifier("shitmod", "berserk"), BERSERK);

        Registry.register(Registries.ITEM, new Identifier("shitmod", "berserker_totem"), BERSERKER_TOTEM);

        LOGGER.info("Shitmod items have been registered.");
    }
  }
