package com.ronancraft.BetterHome.player.events;

import com.ronancraft.BetterHome.helpers.HelperPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;

class Leave {

    static void event(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        HelperPlayer.unload(p);
    }
}
