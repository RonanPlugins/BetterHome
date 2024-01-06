package com.ronancraft.BetterHome;

import com.ronancraft.BetterHome.depends.SoftDepends;
import com.ronancraft.BetterHome.file.FileOther;
import lombok.Getter;

public class Settings {

    @Getter private boolean debug;
    @Getter private int delayTime;
    //Dependencies
    private final SoftDepends depends = new SoftDepends();


    public void load() { //Load Settings
        FileOther.FILETYPE config = FileOther.FILETYPE.CONFIG;
        debug = config.getBoolean("Settings.Debugger");
        delayTime = config.getInt("Settings.Delay.Time");
        depends.load();
    }

    public SoftDepends getsDepends() {
        return depends;
    }
}
