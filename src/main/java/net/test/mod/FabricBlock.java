package net.test.mod;


import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class FabricBlock extends Block {

    public FabricBlock() {
        super(FabricBlockSettings.of(Material.WOOL).breakByHand(false).sounds(BlockSoundGroup.ANCIENT_DEBRIS).strength(100, 100f));
    }
    
}
