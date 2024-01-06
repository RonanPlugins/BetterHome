package com.ronancraft.BetterHome.player.events;

import com.ronancraft.BetterHome.BetterHome;
import com.ronancraft.BetterHome.file.FileOther;
import com.ronancraft.BetterHome.messages.Message_RTP;
import com.ronancraft.BetterHome.player.permission.PermissionNode;
import com.ronancraft.BetterHome.web.Updater;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join {

    static void event(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        updater(p);
        /*AsyncHandler.async(() -> {
                //getPl().getCooldowns().loadPlayer(p);
            });
        //rtpOnFirstJoin(p);*/
    }

    //Updater
    private static void updater(Player p) {
        if (!getPl().getFiles().getType(FileOther.FILETYPE.CONFIG).getBoolean("Settings.DisableUpdater") && PermissionNode.UPDATER.check(p))
            if (!getPl().getDescription().getVersion().equals(Updater.updatedVersion))
                Message_RTP.sms(p, "&7There is currently an update for &6BetterRTP &7version &e#" +
                        Updater.updatedVersion + " &7you have version &e#" + getPl().getDescription().getVersion());
    }

    private static BetterHome getPl() {
        return BetterHome.getInstance();
    }
}
