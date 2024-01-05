package com.ronancraft.BetterHome.depends.regionPlugins;

import net.crashcraft.crashclaim.CrashClaim;
import org.bukkit.Location;

public class RTP_CrashClaim implements RegionPluginCheck {

    // NOT TESTED (3.6.9)
    // CrashClaim (1.0.39)
    // https://www.spigotmc.org/resources/crashclaim-claiming-plugin.94037/
    public boolean check(Location loc) {
        boolean result = true;
        if (REGIONPLUGINS.CRASH_CLAIM.isEnabled())
            try {
                result = CrashClaim.getPlugin().getApi().getClaim(loc) == null; // no claim = valid
            } catch (Exception e) {
                e.printStackTrace();
            }
        return result;
    }
}
