package com.ronancraft.BetterHome.player.commands;

import com.ronancraft.BetterHome.player.commands.betterhome.CommandHandler_BetterHome;
import com.ronancraft.BetterHome.player.commands.other.*;
import lombok.Getter;

@Getter public enum CommandRoute {
    BETTERHOME("betterhome", new CommandHandler_BetterHome()),
    SETHOME("sethome", new CommandHandler_SetHome()),
    DELHOME("delhome", new CommandHandler_DelHome()),
    HOME("home", new CommandHandler_Home()),
    ;

    private final String routeName;
    private final CommandHandler handler;

    CommandRoute(String route, CommandHandler handler) {
        this.routeName = route;
        this.handler = handler;
    }
}
