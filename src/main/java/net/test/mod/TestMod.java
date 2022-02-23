package net.test.mod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TestMod implements ModInitializer {

    public static final Item FABRIC_ITEM = new FabricItem(new Item.Settings().group(ItemGroup.MISC));

    public static final Block FABRIC_BLOCK = new FabricBlock();


    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("testmod", "fabric_item"), FABRIC_ITEM);
        Registry.register(Registry.BLOCK, new Identifier("testmod", "fabric_block"), FABRIC_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("testmod", "fabric_block"), new BlockItem(FABRIC_BLOCK, new FabricItemSettings().group(ItemGroup.MISC)));
        
    }

}