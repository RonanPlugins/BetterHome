package com.ronancraft.BetterHome.player.commands;

import com.ronancraft.BetterHome.player.permission.PermissionCheck;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface CommandHandler {

    void commandExecuted(CommandSender sendi, String label, String[] args);

    List<String> onTabComplete(CommandSender sendi, String[] args);
}
