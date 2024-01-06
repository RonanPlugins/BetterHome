package com.ronancraft.BetterHome.depends;

import com.ronancraft.BetterHome.BetterHome;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.RegisteredServiceProvider;

public class DepPerms {
    public Permission p = null;

    public boolean hasPerm(String perm, CommandSender sendi) {
        //sendi.sendMessage(perm);
        if (p != null)
            return p.has(sendi, perm);
        return sendi.hasPermission(perm);
    }

    public void register() {
        try {
            if (BetterHome.getInstance().getServer().getPluginManager().isPluginEnabled("Vault")) {
                RegisteredServiceProvider<Permission> permissionProvider = BetterHome.getInstance().getServer()
                        .getServicesManager().getRegistration(Permission.class);
                p = permissionProvider.getProvider();
            } else
                p = null;
        } catch (NullPointerException e) {
            //Vault but no Perms
        }
    }
}
