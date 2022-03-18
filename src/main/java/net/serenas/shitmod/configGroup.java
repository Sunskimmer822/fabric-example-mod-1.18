package net.serenas.shitmod;

import me.lortseam.completeconfig.api.ConfigEntry;
import me.lortseam.completeconfig.api.ConfigGroup;

public class configGroup implements ConfigGroup {
    @ConfigEntry
    private int swordFireballStrengthMultiplier = 1;
    @ConfigEntry
    private int axeFireballStrengthMultiplier = 1;
    @ConfigEntry
    private int explosionAspectStrengthMultiplier = 1;
    @ConfigEntry
    private int explosiveThornsStrengthMultiplier = 1;

    public void setSetting(int explosionAspectStrengthMultiplier) {
        this.explosionAspectStrengthMultiplier = explosionAspectStrengthMultiplier;
        
    }

}
