package net.serenas.shitmod;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;

public interface sheepShearCallback {
 
    Event<sheepShearCallback> EVENT = EventFactory.createArrayBacked(sheepShearCallback.class,
        (listeners) -> (player, sheep) -> {
            for (sheepShearCallback listener : listeners) {
                ActionResult result = listener.interact(player, sheep);
 
                if(result != ActionResult.PASS) {
                    return result;
                }
            }
 
        return ActionResult.PASS;
    });
 
    ActionResult interact(PlayerEntity player, SheepEntity sheep);
}