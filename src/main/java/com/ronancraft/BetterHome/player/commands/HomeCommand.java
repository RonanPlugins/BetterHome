package com.ronancraft.BetterHome.player.commands;

import com.ronancraft.BetterHome.player.permission.PermissionCheck;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface HomeCommand {

    void execute(CommandSender sendi, String label, String[] args);

    List<String> tabComplete(CommandSender sendi, String[] args);

    @NotNull PermissionCheck permission();

    @NotNull String getName();

    default @Nullable List<String> getAlias() {
        return null;
    };
}
