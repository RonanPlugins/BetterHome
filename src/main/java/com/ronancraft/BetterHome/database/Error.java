package com.ronancraft.BetterHome.database;

import com.ronancraft.BetterHome.BetterHome;

import java.util.logging.Level;

public class Error {
    public static void execute(BetterHome plugin, Exception ex){
        plugin.getLogger().log(Level.SEVERE, "Couldn't execute MySQL statement: ", ex);
    }
    public static void close(BetterHome plugin, Exception ex){
        plugin.getLogger().log(Level.SEVERE, "Failed to close MySQL connection: ", ex);
    }
}
