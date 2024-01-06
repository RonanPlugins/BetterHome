package com.ronancraft.BetterHome.depends;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;

public class DepEconomy {
    private Economy e;
    private int hunger = 0;
    private boolean checked = false;

    /*public boolean charge(CommandSender sendi, Player player) {
        check(false);
        //Hunger Stuff
        boolean took_food = false;
        if (hunger != 0
                && !PermissionNode.BYPASS_HUNGER.check(player)
                && (player.getGameMode() == GameMode.SURVIVAL || player.getGameMode() == GameMode.ADVENTURE)) {
            boolean has_hunger = player.getFoodLevel() >= hunger;
            if (!has_hunger) {
                MessagesCore.FAILED_HUNGER.send(sendi);
                return false;
            } else {
                player.setFoodLevel(player.getFoodLevel() - hunger);
                took_food = true;
            }
        }
        //Economy Stuff
        if (e != null
                && !PermissionNode.BYPASS_ECONOMY.check(player)) {
            try {
                EconomyResponse r = e.withdrawPlayer(player, pWorld.getPrice());
                boolean passed_economy = r.transactionSuccess();
                if (!passed_economy) {
                    MessagesCore.FAILED_PRICE.send(sendi, pWorld.getPrice());
                    if (took_food)
                        player.setFoodLevel(player.getFoodLevel() + hunger);
                } //else
                    //pWorld.eco_money_taken = true;
                return passed_economy;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //Default value
        return true;
    }

    public boolean hasBalance(Player player) {
        check(false);
        //Economy Stuff
        int price = pWorld.getPrice();
        if (e != null && price != 0 && !PermissionNode.BYPASS_ECONOMY.check(pWorld.getPlayer())) {
            try {
                return e.getBalance(pWorld.getPlayer()) >= price;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //Default value
        return true;
    }

    public boolean hasHunger(WorldPlayer pWorld) {
        check(false);
        Player player = pWorld.getPlayer();
        //Hunger Stuff
        if (hunger != 0
                && !PermissionNode.BYPASS_HUNGER.check(player)
                && (player.getGameMode() == GameMode.SURVIVAL || player.getGameMode() == GameMode.ADVENTURE)) {
            return player.getFoodLevel() >= hunger;
        }
        //Default value
        return true;
    }


    public void load() {
        check(true);
    }

    private void check(boolean force) {
        if (!checked || force)
            registerEconomy();
        if (BetterRTP.getInstance().getFiles().getType(FileOther.FILETYPE.ECO).getBoolean("Hunger.Enabled"))
            hunger = BetterRTP.getInstance().getFiles().getType(FileOther.FILETYPE.ECO).getInt("Hunger.Honches");
        else
            hunger = 0;
    }

    private void registerEconomy() {
        try {
            if (BetterRTP.getInstance().getFiles().getType(FileOther.FILETYPE.ECO).getBoolean("Economy.Enabled"))
                if (BetterRTP.getInstance().getServer().getPluginManager().isPluginEnabled("Vault")) {
                    RegisteredServiceProvider<Economy> rsp = BetterRTP.getInstance().getServer().getServicesManager().getRegistration(Economy.class);
                    e = rsp.getProvider();
                }
        } catch (NullPointerException e) {
            //
        }
        checked = true;
    }*/
}
