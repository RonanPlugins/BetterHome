package com.ronancraft.BetterHome.web;

import com.ronancraft.BetterHome.BetterHome;
import com.ronancraft.BetterHome.async.AsyncHandler;
import org.bukkit.Bukkit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Updater {

    public static String updatedVersion = BetterHome.getInstance().getDescription().getVersion();

    public Updater(BetterHome pl) {
        AsyncHandler.async(() -> {
            try {
                URLConnection con = new URL(getUrl() + project()).openConnection();
                updatedVersion = new BufferedReader(new InputStreamReader(con.getInputStream())).readLine();
            } catch (Exception ex) {
                Bukkit.getConsoleSender().sendMessage("[BetterRTP] Failed to check for an update on spigot");
                updatedVersion = pl.getDescription().getVersion();
            }
        });
    }

    private String getUrl() {
        return "https://api.spigotmc.org/legacy/update.php?resource=";
    }

    private String project() {
        return "36081";
    }
}
