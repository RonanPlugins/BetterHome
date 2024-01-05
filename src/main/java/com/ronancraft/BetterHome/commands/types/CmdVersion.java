package com.ronancraft.BetterHome.commands.types;

import com.ronancraft.BetterHome.BetterHome;
import com.ronancraft.BetterHome.PermissionNode;
import com.ronancraft.BetterHome.commands.RTPCommand;
import com.ronancraft.BetterHome.commands.RTPCommandHelpable;
import com.ronancraft.BetterHome.messages.Message_RTP;
import com.ronancraft.BetterHome.messages.MessagesHelp;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CmdVersion implements RTPCommand, RTPCommandHelpable {

    public String getName() {
        return "version";
    }

    public void execute(CommandSender sendi, String label, String[] args) {
        Message_RTP.sms(sendi, "&aVersion #&e" + BetterHome.getInstance().getDescription().getVersion());
    }

    public List<String> tabComplete(CommandSender sendi, String[] args) {
        return null;
    }

    @NotNull public PermissionNode permission() {
        return PermissionNode.VERSION;
    }

    @Override
    public String getHelp() {
        return MessagesHelp.VERSION.get();
    }
}
