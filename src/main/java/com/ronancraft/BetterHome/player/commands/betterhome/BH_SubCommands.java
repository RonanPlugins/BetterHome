package com.ronancraft.BetterHome.player.commands.betterhome;


import com.ronancraft.BetterHome.player.commands.HomeCommand;
import com.ronancraft.BetterHome.player.permission.PermissionCheck;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public enum BH_SubCommands implements HomeCommand {
    HELP(new CmdBH_Help()),
    RELOAD(new CmdBH_Reload()),
    VERSION(new CmdBH_Version()),
    ;

    private final HomeCommand cmd;

    BH_SubCommands(HomeCommand cmd) {
        this.cmd = cmd;
    }

    @Override public void execute(CommandSender sendi, String label, String[] args) {
        cmd.execute(sendi, label, args);
    }

    @Override public List<String> tabComplete(CommandSender sendi, String[] args) {
        return cmd.tabComplete(sendi, args);
    }

    @NotNull @Override public PermissionCheck permission() {
        return cmd.permission();
    }

    @NotNull @Override public String getName() {
        return cmd.getName();
    }

    @Nullable @Override public List<String> getAlias() {
        return cmd.getAlias();
    }
}
