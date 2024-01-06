package com.ronancraft.BetterHome.helpers;

import com.ronancraft.BetterHome.BetterHome;
import com.ronancraft.BetterHome.player.PlayerData;
import org.bukkit.entity.Player;

public class HelperPlayer {

    public static PlayerData getData(Player p) {
        return getPl().getPlayerDataManager().getData(p);
    }

    public static void unload(Player p) {
        getPl().getPlayerDataManager().clear(p);
    }

    private static BetterHome getPl() {
        return BetterHome.getInstance();
    }
}
