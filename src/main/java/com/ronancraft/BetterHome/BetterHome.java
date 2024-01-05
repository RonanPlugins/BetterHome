package com.ronancraft.BetterHome;

import com.ronancraft.BetterHome.commands.Commands;
import com.ronancraft.BetterHome.database.DatabaseHandler;
import com.ronancraft.BetterHome.depends.DepEconomy;
import com.ronancraft.BetterHome.events.EventListener;
import com.ronancraft.BetterHome.file.Files;
import com.ronancraft.BetterHome.versions.FoliaHandler;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class BetterHome extends JavaPlugin {

    @Getter private final Permissions perms = new Permissions();
    @Getter private final Commands cmd = new Commands(this);
    @Getter private final DepEconomy eco = new DepEconomy();
    private final EventListener listener = new EventListener();
    @Getter private static BetterHome instance;
    @Getter private final Files files = new Files();
    @Getter private final Settings settings = new Settings();
    @Getter private boolean PlaceholderAPI;
    @Getter private final DatabaseHandler databaseHandler = new DatabaseHandler();
    @Getter private final FoliaHandler foliaHandler = new FoliaHandler();

    @Override
    public void onEnable() {
        instance = this;
        registerDependencies();
        listener.registerEvents(this);
        loadAll();
    }

    private void loadAll() {
        foliaHandler.load();
        //playerDataManager.clear();
        files.loadAll();
        settings.load();
        //cooldowns.load();
        databaseHandler.load();
        //rtpLogger.setup(this);
        //invs.load();
        //RTP.load();
        cmd.load();
        listener.load();
        eco.load();
        perms.register();
    }

    private void registerDependencies() {
        PlaceholderAPI = Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static void debug(String str) {
        getInstance().getLogger().info(str);
    }
}
