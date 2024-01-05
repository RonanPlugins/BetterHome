package com.ronancraft.BetterHome.depends.regionPlugins;

import com.massivecraft.factions.Board;
import com.massivecraft.factions.FLocation;
import com.massivecraft.factions.Faction;
import org.bukkit.Location;

public class RTP_FactionsUUID implements RegionPluginCheck {

    // NOT TESTED (2.13.2)
    // FactionsUUID (v1.6.9.5-U0.5.16)
    // https://www.spigotmc.org/resources/factionsuuid.1035/
    public boolean check(Location loc) {
        boolean result = true;
        if (REGIONPLUGINS.FACTIONSUUID.isEnabled())
            try {
                Faction faction = Board.getInstance().getFactionAt(new FLocation(loc));
                result = faction.isWilderness() || faction.isSafeZone();
            } catch (Exception e) {
                e.printStackTrace();
            }
        return result;
    }
}
