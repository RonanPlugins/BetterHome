package com.ronancraft.BetterHome.player.commands;


import com.ronancraft.BetterHome.player.commands.types.*;

public enum RTPCommandType {
    HELP(new CmdHelp()),
    RELOAD(new CmdReload()),
    VERSION(new CmdVersion()),
    ;

    private final RTPCommand cmd;
    private boolean debugOnly = false;

    RTPCommandType(RTPCommand cmd) {
        this.cmd = cmd;
    }

    RTPCommandType(RTPCommand cmd, boolean debugOnly) {
        this.cmd = cmd;
        this.debugOnly = debugOnly;
    }

    public boolean isDebugOnly() {
        return debugOnly;
    }

    public RTPCommand getCmd() {
        return cmd;
    }
}
