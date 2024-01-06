package com.ronancraft.BetterHome.player.commands.other;

import com.ronancraft.BetterHome.messages.Message_RTP;
import com.ronancraft.BetterHome.player.commands.CommandHandler;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandHandler_DelHome implements CommandHandler {

    @Override
    public void commandExecuted(CommandSender sendi, String label, String[] args) {
        List<String> list = new ArrayList<>();
        list.add("&cCommand currently disabled!");
        Message_RTP.sms(sendi, list, Collections.singletonList(label));
    }

    @Override public List<String> onTabComplete(CommandSender sendi, String[] args) {
        return null;
    }
}
