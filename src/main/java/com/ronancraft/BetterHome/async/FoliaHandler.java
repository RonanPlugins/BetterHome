package com.ronancraft.BetterHome.async;

import com.ronancraft.BetterHome.BetterHome;
import com.tcoded.folialib.FoliaLib;
import com.tcoded.folialib.impl.ServerImplementation;

public class FoliaHandler {

    private ServerImplementation SERVER_IMPLEMENTATION;

    public void load() {
        this.SERVER_IMPLEMENTATION = new FoliaLib(BetterHome.getInstance()).getImpl();
    }

    public ServerImplementation get() {
        return SERVER_IMPLEMENTATION;
    }

}
