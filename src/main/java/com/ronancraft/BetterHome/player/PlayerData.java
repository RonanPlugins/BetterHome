package com.ronancraft.BetterHome.player;

import com.ronancraft.BetterHome.BetterHome;
import com.ronancraft.BetterHome.async.AsyncHandler;
import com.ronancraft.BetterHome.database.DatabaseHandler;
import com.ronancraft.BetterHome.player.tasks.TaskDownloadPlayerData;
import lombok.Getter;
import lombok.Setter;
import me.RonanCraft.Pueblos.resources.tools.HelperDate;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.sql.Date;
import java.util.HashMap;

public class PlayerData {

    @Getter @Setter boolean loading; //Is this players data loading?
    @Getter final Player player;
    @Getter @Setter HashMap<String, Location> homes = new HashMap<>();
    @Getter @Setter @Nullable Date lastHomeTPTime;

    PlayerData(Player player) {
        this.player = player;
    }

    public void load(boolean forced, boolean joined) {
        //Setup Defaults
        if (this.homes.isEmpty() || forced)
            new TaskDownloadPlayerData(this, joined).start();
    }

    public void save() {
        AsyncHandler.async(() -> DatabaseHandler.getPlayers().setData(this));
    }
}
