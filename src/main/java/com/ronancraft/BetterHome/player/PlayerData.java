package com.ronancraft.BetterHome.player;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.sql.Date;

public class PlayerData {

    public boolean loading; //Is this players data loading?
    public final Player player;
    @Getter @Setter public Location defaultHome;
    @Getter @Setter Date lastHomeDate;

    PlayerData(Player player) {
        this.player = player;
    }

    public void load(boolean joined) {
        //Setup Defaults
        //new TaskDownloadPlayerData(this, joined).start();
    }
}
