package com.ronancraft.BetterHome.player.commands.other;

import com.ronancraft.BetterHome.helpers.HelperPlayer;
import com.ronancraft.BetterHome.messages.Message_RTP;
import com.ronancraft.BetterHome.messages.MessagesCore;
import com.ronancraft.BetterHome.player.PlayerData;
import com.ronancraft.BetterHome.player.commands.CommandHandler;
import com.ronancraft.BetterHome.player.commands.HomeCommand;
import com.ronancraft.BetterHome.player.commands.HomeCommandHelpable;
import com.ronancraft.BetterHome.player.commands.betterhome.BH_SubCommands;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandHandler_SetHome implements CommandHandler {

    @Override
    public void commandExecuted(CommandSender sendi, String label, String[] args) {
        Player player = (Player) sendi;
        PlayerData data = HelperPlayer.getData(player);
        if (args.length > 0 && data.getHomes().containsKey(null)) {
            String homeName = args[0];
            data.getHomes().put(homeName, player.getLocation());
            Message_RTP.sms(sendi, MessagesCore.SETHOME_SUCCESS_CUSTOM.get(sendi, player.getLocation()).replace("{0}", homeName));
        } else {
            data.getHomes().put(null, player.getLocation());
            Message_RTP.sms(sendi, MessagesCore.SETHOME_SUCCESS.get(sendi, player.getLocation()));
        }
        data.save();
    }

    @Override public List<String> onTabComplete(CommandSender sendi, String[] args) {
        return null;
    }
}
