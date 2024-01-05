package com.ronancraft.BetterHome.commands;

import com.ronancraft.BetterHome.PermissionCheck;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface RTPCommand {

    void execute(CommandSender sendi, String label, String[] args);

    List<String> tabComplete(CommandSender sendi, String[] args);

    @NotNull PermissionCheck permission();

    String getName();

    default boolean isDebugOnly() {
        return false;
    }

    default boolean enabled() {
        return true;
    };
}
