package com.ronancraft.BetterHome.player.commands.types;

import com.ronancraft.BetterHome.BetterHome;
import com.ronancraft.BetterHome.player.permission.PermissionNode;
import com.ronancraft.BetterHome.player.commands.RTPCommand;
import com.ronancraft.BetterHome.player.commands.RTPCommandHelpable;
import com.ronancraft.BetterHome.messages.MessagesHelp;
import me.SuperRonanCraft.BetterRTP.BetterRTP;
import me.SuperRonanCraft.BetterRTP.player.commands.RTPCommand;
import me.SuperRonanCraft.BetterRTP.player.commands.RTPCommandHelpable;
import me.SuperRonanCraft.BetterRTP.references.PermissionNode;
import me.SuperRonanCraft.BetterRTP.references.messages.MessagesHelp;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CmdReload implements RTPCommand, RTPCommandHelpable {

    public String getName() {
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
