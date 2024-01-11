package com.ronancraft.BetterHome.player.commands.other;

import com.ronancraft.BetterHome.helpers.HelperPlayer;
import com.ronancraft.BetterHome.messages.Message_RTP;
import com.ronancraft.BetterHome.messages.MessagesCore;
import com.ronancraft.BetterHome.player.PlayerData;
import com.ronancraft.BetterHome.player.commands.CommandHandler;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommandHandler_Home implements CommandHandler {

    @Override
    public void commandExecuted(CommandSender sendi, String label, String[] args) {
        Player player = (Player) sendi;
        PlayerData data = HelperPlayer.getData(player);
        if (!data.getHomes().isEmpty()) {
            Location loc = data.getHomes().get(null).clone().setDirection(player.getLocation().getDirection());
            loc.setPitch(player.getLocation().getPitch());
            player.teleport(loc);
            Message_RTP.sms(sendi, MessagesCore.HOME_SUCCESS.get(sendi, "Home"));
        } else {
            Message_RTP.sms(sendi, MessagesCore.HOME_NONE.get(sendi, null));
        }
    }

    @Override public List<String> onTabComplete(CommandSender sendi, String[] args) {
        List<String> list = new ArrayList<>();
        if (args.length == 1 && sendi instanceof Player) {
            PlayerData data = HelperPlayer.getData((Player) sendi);
            for (Map.Entry<String, Location> set : data.getHomes().entrySet()) {
                if (set.getKey().toLowerCase().startsWith(args[0].toLowerCase())) {
                    list.add(set.getKey());
                }
            }
        }

        return list;
    }
}
