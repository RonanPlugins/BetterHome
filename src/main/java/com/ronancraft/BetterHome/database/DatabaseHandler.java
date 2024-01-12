package com.ronancraft.BetterHome.database;

import com.ronancraft.BetterHome.BetterHome;
import com.ronancraft.BetterHome.async.AsyncHandler;
import lombok.Getter;

@Getter public class DatabaseHandler {

    private final DatabasePlayers databasePlayers = new DatabasePlayers();
    private final DatabaseCooldowns databaseCooldowns = new DatabaseCooldowns();

    public void load() {
        AsyncHandler.async(() -> {
            databasePlayers.load();
            databaseCooldowns.load();
        });
    }

    public static DatabasePlayers getPlayers() {
        return BetterHome.getInstance().getDatabaseHandler().getDatabasePlayers();
    }

    public static DatabaseCooldowns getCooldowns() {
        return BetterHome.getInstance().getDatabaseHandler().getDatabaseCooldowns();
    }
}
