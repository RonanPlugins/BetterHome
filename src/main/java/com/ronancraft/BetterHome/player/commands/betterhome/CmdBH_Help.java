package com.ronancraft.BetterHome.player.commands.betterhome;

import com.ronancraft.BetterHome.messages.Message_RTP;
import com.ronancraft.BetterHome.messages.MessagesHelp;
import com.ronancraft.BetterHome.player.commands.Commands;
import com.ronancraft.BetterHome.player.commands.HomeCommand;
import com.ronancraft.BetterHome.player.commands.HomeCommandHelpable;
import com.ronancraft.BetterHome.player.permission.PermissionNode;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CmdBH_Help implements HomeCommand, HomeCommandHelpable {

    @NotNull public String getName() {
        return "help";
    }

    public void execute(CommandSender sendi, String label, String[] args) {
        List<String> list = new ArrayList<>();
        list.add(MessagesHelp.PREFIX.get());
        list.add(MessagesHelp.MAIN.get());
        for (HomeCommand cmd : BH_SubCommands.values())
            if (cmd.permission().check(sendi))
                if (cmd instanceof HomeCommandHelpable) {
                    String help = ((HomeCommandHelpable) cmd).getHelp();
                    list.add(help);
                }
        Message_RTP.sms(sendi, list, Collections.singletonList(label));
    }

    public List<String> tabComplete(CommandSender sendi, String[] args) {
        return null;
    }


    @NotNull public PermissionNode permission() {
        return PermissionNode.USE;
    }

    @Override
    public String getHelp() {
        return MessagesHelp.HELP.get();
    }
}
