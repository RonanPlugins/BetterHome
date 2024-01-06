package com.ronancraft.BetterHome.depends.regionPlugins;

import com.ronancraft.BetterHome.BetterHome;
import me.angeschossen.lands.api.LandsIntegration;
import org.bukkit.Location;

public class RTP_Lands implements RegionPluginCheck {

    // Implemented (2.14.3)
    // Tested (3.6.2)
    // Lands (v6.28.13)
    // https://www.spigotmc.org/resources/lands.53313/
    public boolean check(Location loc) {
        boolean result = true;
        if (REGIONPLUGINS.LANDS.isEnabled())
            try {
                result = LandsIntegration.of(BetterHome.getInstance()).getArea(loc) == null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        return result;
    }
}
