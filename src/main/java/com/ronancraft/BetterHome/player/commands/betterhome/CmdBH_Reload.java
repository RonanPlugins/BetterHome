package com.ronancraft.BetterHome.player.commands.betterhome;

import com.ronancraft.BetterHome.BetterHome;
import com.ronancraft.BetterHome.messages.MessagesHelp;
import com.ronancraft.BetterHome.player.commands.HomeCommand;
import com.ronancraft.BetterHome.player.commands.HomeCommandHelpable;
import com.ronancraft.BetterHome.player.permission.PermissionNode;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CmdBH_Reload implements HomeCommand, HomeCommandHelpable {

    @NotNull public String getName() {
        return "reload";
    }

    public void execute(CommandSender sendi, String label, String[] args) {
        BetterHome.getInstance().reload(sendi);
    }

    public List<String> tabComplete(CommandSender sendi, String[] args) {
        return null;
    }

    @NotNull public PermissionNode permission() {
        return PermissionNode.RELOAD;
    }

    @Override
    public String getHelp() {
        return MessagesHelp.RELOAD.get();
    }
}
