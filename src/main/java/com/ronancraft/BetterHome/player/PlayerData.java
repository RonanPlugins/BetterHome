package com.ronancraft.BetterHome.player;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.sql.Date;
import java.util.HashMap;

public class PlayerData {

    public boolean loading; //Is this players data loading?
    public final Player player;
    @Getter @Setter public HashMap<String, Location> homes = new HashMap<>();
    @Getter @Setter @Nullable Date lastHomeTPTime;

    PlayerData(Player player) {
        this.player = player;
    }

    public void load(boolean joined) {
        //Setup Defaults
        //new TaskDownloadPlayerData(this, joined).start();
    }
}
