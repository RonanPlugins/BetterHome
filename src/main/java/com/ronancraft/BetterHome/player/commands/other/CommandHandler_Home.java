package com.ronancraft.BetterHome.player.commands.other;

import com.ronancraft.BetterHome.helpers.HelperPlayer;
import com.ronancraft.BetterHome.messages.Message;
import com.ronancraft.BetterHome.messages.Message_RTP;
import com.ronancraft.BetterHome.messages.MessagesCore;
import com.ronancraft.BetterHome.messages.MessagesHelp;
import com.ronancraft.BetterHome.player.PlayerData;
import com.ronancraft.BetterHome.player.commands.CommandHandler;
import com.ronancraft.BetterHome.player.commands.HomeCommand;
import com.ronancraft.BetterHome.player.commands.HomeCommandHelpable;
import com.ronancraft.BetterHome.player.commands.betterhome.BH_SubCommands;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandHandler_Home implements CommandHandler {

    @Override
    public void commandExecuted(CommandSender sendi, String label, String[] args) {
        Player player = (Player) sendi;
        PlayerData data = HelperPlayer.getData(player);
        if (data.getDefaultHome() != null) {
            Location loc = data.getDefaultHome().clone().setDirection(player.getLocation().getDirection());
            loc.setPitch(player.getLocation().getPitch());
            player.teleport(loc);
            Message_RTP.sms(sendi, MessagesCore.HOME_SUCCESS.get(sendi, "Home"));
        } else {
            Message_RTP.sms(sendi, MessagesCore.HOME_NONE.get(sendi, null));
        }
    }

    @Override public List<String> onTabComplete(CommandSender sendi, String[] args) {
        return null;
    }
}
