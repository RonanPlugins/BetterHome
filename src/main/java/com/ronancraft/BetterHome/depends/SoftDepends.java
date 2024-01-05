package com.ronancraft.BetterHome.depends;

import com.ronancraft.BetterHome.BetterHome;
import com.ronancraft.BetterHome.depends.regionPlugins.REGIONPLUGINS;
import com.ronancraft.BetterHome.file.FileOther;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;

import java.util.logging.Level;

public class SoftDepends {

    public void load() {
        for (REGIONPLUGINS plugin : REGIONPLUGINS.values())
            registerPlugin(plugin);
    }

    public void registerPlugin(REGIONPLUGINS pl) {
        FileOther.FILETYPE config = BetterHome.getInstance().getFiles().getType(FileOther.FILETYPE.CONFIG);
        String pre = "Settings.Respect.";
        pl.getPlugin().setRespecting(config.getBoolean(pre + pl.getSetting_name()));
        if (pl.getPlugin().isRespecting())
            pl.getPlugin().setEnabled(Bukkit.getPluginManager().isPluginEnabled(pl.getPluginyml_name()));
        if (pl.getPlugin().isRespecting())
            debug("Respecting `" + pl.getSetting_name() + "` was " + (pl.getPlugin().enabled ? "SUCCESSFULLY" : "NOT") + " registered");
    }



    @Getter @Setter static public class RegionPlugin {
        private boolean respecting;
        private boolean enabled;
    }

    private void debug(String str) {
        if (BetterHome.getInstance().getSettings().isDebug())
            BetterHome.getInstance().getLogger().log(Level.INFO, str);
    }
}
