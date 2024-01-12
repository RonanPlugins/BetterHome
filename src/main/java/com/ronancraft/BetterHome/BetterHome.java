package com.ronancraft.BetterHome;

import com.ronancraft.BetterHome.async.AsyncHandler;
import com.ronancraft.BetterHome.helpers.HelperPlayer;
import com.ronancraft.BetterHome.messages.Message_RTP;
import com.ronancraft.BetterHome.player.PlayerDataManager;
import com.ronancraft.BetterHome.player.commands.Commands;
import com.ronancraft.BetterHome.database.DatabaseHandler;
import com.ronancraft.BetterHome.depends.DepEconomy;
import com.ronancraft.BetterHome.player.events.EventListener;
import com.ronancraft.BetterHome.file.Files;
import com.ronancraft.BetterHome.player.permission.Permissions;
import com.ronancraft.BetterHome.async.FoliaHandler;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class BetterHome extends JavaPlugin {

    @Getter private final Permissions perms = new Permissions();
    @Getter private final Commands cmd = new Commands();
    @Getter private final DepEconomy eco = new DepEconomy();
    private final EventListener listener = new EventListener();
    @Getter private static BetterHome instance;
    @Getter private final Files files = new Files();
    @Getter private final Settings settings = new Settings();
    @Getter private boolean PlaceholderAPI;
    @Getter private final DatabaseHandler databaseHandler = new DatabaseHandler();
    @Getter private final FoliaHandler foliaHandler = new FoliaHandler();
    @Getter private final PlayerDataManager playerDataManager = new PlayerDataManager();

    @Override
    public void onEnable() {
        instance = this;
        registerDependencies();
        listener.registerEvents(this);
        loadAll();
    }

    private void loadAll() {
        foliaHandler.load();
        playerDataManager.clear();
        files.loadAll();
        settings.load();
        //cooldowns.load();
        databaseHandler.load();
        //rtpLogger.setup(this);
        //invs.load();
        //RTP.load();
        //listener.load();
        //eco.load();
        perms.register();
        AsyncHandler.asyncLater(() -> {
            ////Wait till arenas have loaded
            //if (!systems.getArenaHandler().isLoaded())
            //    return;
            //playerLastOnline = HelperDatabase.getDatabasePlayer().getAllLastOnline();
            for (Player p : Bukkit.getOnlinePlayers())
                HelperPlayer.getData(p).load(true, false);
            //Cancel repeating task
            //this.cancel();
        }, 5);
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

    @Override
    public boolean onCommand(CommandSender sendi, Command cmd, String label, String[] args) {
        try {
            this.cmd.commandExecuted(sendi, label, args);
        } catch (NullPointerException e) {
            e.printStackTrace();
            Message_RTP.sms(sendi, "&cERROR &7Seems like your Administrator did not update their language file!");
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return this.cmd.onTabComplete(sender, label, args);
    }

    public void reload(CommandSender sendi) {
        loadAll();
    }
}
