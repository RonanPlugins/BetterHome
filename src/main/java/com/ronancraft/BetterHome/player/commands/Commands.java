package com.ronancraft.BetterHome.player.commands;

import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class Commands {

    public void commandExecuted(CommandSender sendi, String label, String[] args) {
        for (CommandRoute route : CommandRoute.values()) {
            if (label.equalsIgnoreCase(route.getRouteName()))
                route.getHandler().commandExecuted(sendi, label, args);
        }
    }

    public List<String> onTabComplete(CommandSender sendi, String label, String[] args) {
        List<String> list = new ArrayList<>();
        for (CommandRoute route : CommandRoute.values()) {
            if (label.equalsIgnoreCase(route.getRouteName()))
                list.addAll(route.getHandler().onTabComplete(sendi, args));
        }
        return list;
    }
}
