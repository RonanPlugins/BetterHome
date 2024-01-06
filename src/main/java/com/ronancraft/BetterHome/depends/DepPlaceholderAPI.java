package com.ronancraft.BetterHome.depends;

import com.ronancraft.BetterHome.BetterHome;
import com.ronancraft.BetterHome.helpers.HelperPlayer;
import com.ronancraft.BetterHome.player.PlayerData;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DepPlaceholderAPI extends PlaceholderExpansion {

    @NotNull
    @Override
    public String getIdentifier() {
        return BetterHome.getInstance().getDescription().getName().toLowerCase();
    }

    @NotNull
    @Override
    public String getAuthor() {
        return BetterHome.getInstance().getDescription().getAuthors().get(0);
    }

    @NotNull
    @Override
    public String getVersion() {
        return BetterHome.getInstance().getDescription().getVersion();
    }

    @Override
    public String onPlaceholderRequest(Player player, String request) {
        PlayerData data = HelperPlayer.getData(player);
        if (request.equalsIgnoreCase("home")) {
            return String.valueOf(data.getDefaultHome());
        }
        return null;
    }
}
