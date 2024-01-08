package com.ronancraft.BetterHome.player;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.sql.Date;

public class PlayerData {

    public boolean loading; //Is this players data loading?
    public final Player player;
    @Getter @Setter @Nullable public Location defaultHome;
    @Getter @Setter @Nullable Date lastHomeDate;

    PlayerData(Player player) {
        this.player = player;
    }

    public void load(boolean joined) {
        //Setup Defaults
        //new TaskDownloadPlayerData(this, joined).start();
    }
}
