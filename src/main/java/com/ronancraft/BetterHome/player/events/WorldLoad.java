package com.ronancraft.BetterHome.player.events;

import com.ronancraft.BetterHome.BetterHome;
import com.ronancraft.BetterHome.async.AsyncHandler;
import com.tcoded.folialib.wrapper.WrappedTask;
import org.bukkit.event.world.WorldLoadEvent;

public class WorldLoad {

    WrappedTask loader;

    void load(WorldLoadEvent e) {
        //BetterRTP.getInstance().getLogger().info("NEW WORLD!");
        if (loader != null)
            loader.cancel();
        loader = AsyncHandler.syncLater(() -> {
            BetterHome.debug("WorldLoad event detected. Reloading Databases!");
            //BetterHome.getInstance().getDatabaseHandler().load();
        }, 20L * 5);
    }
}
