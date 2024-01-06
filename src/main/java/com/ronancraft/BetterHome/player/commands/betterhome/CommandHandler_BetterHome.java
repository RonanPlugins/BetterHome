package com.ronancraft.BetterHome.player.commands.betterhome;

import com.ronancraft.BetterHome.BetterHome;
import com.ronancraft.BetterHome.messages.MessagesCore;
import com.ronancraft.BetterHome.player.commands.CommandHandler;
import com.ronancraft.BetterHome.player.commands.HomeCommand;
import com.ronancraft.BetterHome.player.permission.PermissionNode;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class CommandHandler_BetterHome implements CommandHandler {

    public void commandExecuted(CommandSender sendi, String label, String[] args) {
        if (PermissionNode.USE.check(sendi)) {
            if (args != null && args.length > 0) {
                for (HomeCommand cmd : BH_SubCommands.values()) {
                    if (cmd.getName().equalsIgnoreCase(args[0])) {
                        if (cmd.permission().check(sendi)) {
                            BetterHome.debug(sendi.getName() + " executed: /" + label + " " + String.join(" ", args));
                            cmd.execute(sendi, label, args);
                        } else
                            MessagesCore.NOPERMISSION.send(sendi, cmd);
                        return;
                    }
                }
                MessagesCore.INVALID.send(sendi, label);
            } else {
                //
            }
        } else
            MessagesCore.NOPERMISSION.send(sendi, PermissionNode.USE);
    }

    public List<String> onTabComplete(CommandSender sendi, String[] args) {
        List<String> list = new ArrayList<>();
        if (args.length == 1) {
            for (HomeCommand cmd : BH_SubCommands.values()) {
                if (cmd.getName().toLowerCase().startsWith(args[0].toLowerCase()))
                    if (cmd.permission().check(sendi))
                        list.add(cmd.getName().toLowerCase());
            }
        } else if (args.length > 1) {
            for (HomeCommand cmd : BH_SubCommands.values()) {
                if (cmd.getName().equalsIgnoreCase(args[0]))
                    if (cmd.permission().check(sendi)) {
                        List<String> _cmdlist = cmd.tabComplete(sendi, args);
                        if (_cmdlist != null)
                            list.addAll(_cmdlist);
                    }
                }
        }
        return list;
    }
}
