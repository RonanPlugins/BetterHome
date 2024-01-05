package com.ronancraft.BetterHome.messages.placeholder;

import com.ronancraft.BetterHome.BetterHome;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlaceholderAnalyzer {

    public static String applyPlaceholders(CommandSender p, String str, Object info) {
        if (info instanceof String)
            str = string(str, (String) info);
        if (info instanceof Player)
            str = player(str, (Player) info);
        if (p instanceof Player)
            str = papi((Player) p, str);
        return str;
    }

    private static String string(String str, String info) {
        if (str.contains(Placeholders.COMMAND.name))
            str = str.replace(Placeholders.COMMAND.name, info);
        if (str.contains(Placeholders.PLAYER_NAME.name))
            str = str.replaceAll(Placeholders.PLAYER_NAME.name, info);
        if (str.contains(Placeholders.WORLD.name))
            str = str.replaceAll(Placeholders.WORLD.name, info);
        if (str.contains(Placeholders.COOLDOWN.name))
            str = str.replaceAll(Placeholders.COOLDOWN.name, info);
        return str;
    }

    private static String player(String str, Player player) {
        if (str.contains(Placeholders.PLAYER_NAME.name))
            str = str.replace(Placeholders.PLAYER_NAME.name, player.getName());
        return str;
    }

    private static String papi(Player player, String str) {
        //Papi
        if (BetterHome.getInstance().isPlaceholderAPI())
            try {
                str = PlaceholderAPI.setPlaceholders(player, str);
            } catch (Exception e) {
                //Something went wrong with PAPI
            }
        return str;
    }
}
