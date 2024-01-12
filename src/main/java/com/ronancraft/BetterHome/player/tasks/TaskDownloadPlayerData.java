package com.ronancraft.BetterHome.player.tasks;

import com.ronancraft.BetterHome.BetterHome;
import com.ronancraft.BetterHome.async.AsyncHandler;
import com.ronancraft.BetterHome.database.DatabaseHandler;
import com.ronancraft.BetterHome.player.PlayerData;

public class TaskDownloadPlayerData {

    //When called, this task will download a players gear asynchronously

    int tries = 0;
    private final BetterHome pl = BetterHome.getInstance();
    private final PlayerData pd;
    private final boolean joined;

    public TaskDownloadPlayerData(PlayerData p, boolean joined) {
        this.pd = p;
        this.joined = joined;
    }

    private void downloadTask() {
        AsyncHandler.async(() -> {
            //Player
            DatabaseHandler.getPlayers().setupData(pd);
            pd.setLoading(false);
        });
    }

    public static void resetPlayer(PlayerData pd) {
        AsyncHandler.async(() -> {
            //Player
            DatabaseHandler.getPlayers().deletePlayer(pd.getPlayer());
            //pd.beginTimedTask();
            pd.load(true, false);
        });
    }

    //MUST CALL THIS TO START TASK
    public void start() {
        //HelperLogger.info("Starting to download gear for " + pd.player.getName());
        pd.setLoading(true);
        if (DatabaseHandler.getPlayers().isLoaded())
            downloadTask();
        else
            AsyncHandler.asyncLater(() -> {
                if (tries < 10) {
                    start();
                    tries++;
                } else {
                    BetterHome.debug("Something is not allowing the database to load within a reasonable time. Causing the player "
                            + pd.getPlayer().getName() + " not to be loaded into memory!");
                }
            }, 20);
    }
}
