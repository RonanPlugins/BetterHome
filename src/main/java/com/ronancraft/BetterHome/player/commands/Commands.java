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
            if (label.equalsIgnoreCase(route.getRouteName())) {
                List<String> list2 = route.getHandler().onTabComplete(sendi, args);
                if (list2 != null)
                    list.addAll(list2);
            }
        }
        return list;
    }
}
