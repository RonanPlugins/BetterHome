package com.ronancraft.BetterHome.depends;

import com.ronancraft.BetterHome.BetterHome;
import me.SuperRonanCraft.BetterRTP.BetterRTP;
import me.SuperRonanCraft.BetterRTP.player.rtp.RTPSetupInformation;
import me.SuperRonanCraft.BetterRTP.references.PermissionCheck;
import me.SuperRonanCraft.BetterRTP.references.helpers.*;
import me.SuperRonanCraft.BetterRTP.references.player.HelperPlayer;
import me.SuperRonanCraft.BetterRTP.references.player.playerdata.PlayerData;
import me.SuperRonanCraft.BetterRTP.references.rtpinfo.worlds.WorldPlayer;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DepPlaceholderAPI extends PlaceholderExpansion {

    @NotNull
    @Override
    public String getIdentifier() {
        return BetterHome.getInstance().getDescription().getName().toLowerCase();
    }

    @NotNull
    @Override
    public String getAuthor() {
        return BetterHome.getInstance().getDescription().getAuthors().get(0);
    }

    @NotNull
    @Override
    public String getVersion() {
        return BetterHome.getInstance().getDescription().getVersion();
    }

    @Override
    public String onPlaceholderRequest(Player player, String request) {
        PlayerData data = HelperPlayer.getData(player);
        if (request.equalsIgnoreCase("count")) {
            return String.valueOf(data.getRtpCount());
        } else if (request.startsWith("cooldown")) {
            if (request.equalsIgnoreCase("cooldown")) {
                return cooldown(data, player.getWorld());
            } else if (request.startsWith("cooldown_")) {
                return cooldown(data, getWorld(request.replace("cooldown_", "")));
            } else if (request.equalsIgnoreCase("cooldowntime")) {
                return cooldownTime(data, player.getWorld());
            } else if (request.startsWith("cooldowntime_")) {
                return cooldownTime(data, getWorld(request.replace("cooldowntime_", "")));
            }
        } else if (request.startsWith("canrtp")) {
            if (request.equalsIgnoreCase("canrtp")) {
                return canRTPALL(player, player.getWorld());
            } else if (request.startsWith("canrtp_")) {
                return canRTPALL(player, getWorld(request.replace("canrtp_", "")));
            } else if (request.startsWith("canrtpcooldown")) {
                if (request.equalsIgnoreCase("canrtpcooldown")) {
                    return canRTP_cooldown(player, player.getWorld());
                } else if (request.startsWith("canrtpcooldown_")) {
                    return canRTP_cooldown(player, getWorld(request.replace("canrtpcooldown_", "")));
                }
            } else if (request.startsWith("canrtpprice")) {
                if (request.equalsIgnoreCase("canrtpprice")) {
                    return canRTP_price(player, player.getWorld());
                } else if (request.startsWith("canrtpprice_")) {
                    return canRTP_price(player, getWorld(request.replace("canrtpprice_", "")));
                }
            } else if (request.startsWith("canrtphunger")) {
                if (request.equalsIgnoreCase("canrtphunger")) {
                    return canRTP_hunger(player, player.getWorld());
                } else if (request.startsWith("canrtphunger_")) {
                    return canRTP_hunger(player, getWorld(request.replace("canrtphunger_", "")));
                }
            }
        } else if (request.startsWith("price")) {
            if (request.equalsIgnoreCase("price")) {
                return price(player, player.getWorld());
            } else if (request.startsWith("price_")) {
                return price(player, getWorld(request.replace("price_", "")));
            }
        }
        return null;
    }

    private String cooldown(PlayerData data, World world) {
        if (world == null) return "Invalid World";
        long lng = BetterHome.getInstance().getCooldowns().locked(data.player) ? -1L :
                HelperRTP_Check.getCooldown(data.player, HelperRTP.getPlayerWorld(new RTPSetupInformation(world, data.player, data.player, true)));
        return HelperDate.total(lng);
    }

    private String cooldownTime(PlayerData data, World world) {
        if (world == null) return "Invalid World";
        RTPSetupInformation setup_info = new RTPSetupInformation(HelperRTP.getActualWorld(data.player, world), data.player, data.player, true);
        WorldPlayer pWorld = HelperRTP.getPlayerWorld(setup_info);
        Long cooldownTime = BetterHome.getInstance().getCooldowns().locked(data.player) ? -1L :
                (HelperRTP_Check.applyCooldown(data.player) ? pWorld.getCooldown() * 1000L : 0L);
        return HelperDate.total(cooldownTime);
    }

    private String canRTPALL(Player player, World world) {
        if (world == null) return "Invalid World";
        world = BetterHome.getActualWorld(player, world);
        //Permission
        if (!PermissionCheck.getAWorld(player, world.getName()))
            return BetterHome.getInstance().getSettings().getPlaceholder_nopermission();
        RTPSetupInformation setupInformation = new RTPSetupInformation(world, player, player, true);
        WorldPlayer pWorld = BetterHome.getPlayerWorld(setupInformation);
        //Cooldown
        if (HelperRTP_Check.isCoolingDown(player, pWorld))
            return BetterHome.getInstance().getSettings().getPlaceholder_cooldown();
        //Price
        if (!BetterHome.getInstance().getEco().hasBalance(pWorld))
            return BetterHome.getInstance().getSettings().getPlaceholder_balance();
        //Hunger
        if (!BetterHome.getInstance().getEco().hasHunger(pWorld))
            return BetterHome.getInstance().getSettings().getPlaceholder_hunger();
        //True
        return BetterHome.getInstance().getSettings().getPlaceholder_true();
    }

    private String canRTP_cooldown(Player player, World world) {
        if (world == null) return "Invalid World";
        world = BetterHome.getActualWorld(player, world);

        RTPSetupInformation setupInformation = new RTPSetupInformation(world, player, player, true);
        WorldPlayer pWorld = BetterHome.getPlayerWorld(setupInformation);
        //Cooldown
        if (HelperRTP_Check.isCoolingDown(player, pWorld))
            return BetterHome.getInstance().getSettings().getPlaceholder_cooldown();
        //True
        return BetterHome.getInstance().getSettings().getPlaceholder_true();
    }

    private String canRTP_price(Player player, World world) {
        if (world == null) return "Invalid World";
        world = BetterHome.getActualWorld(player, world);

        RTPSetupInformation setupInformation = new RTPSetupInformation(world, player, player, true);
        WorldPlayer pWorld = HelperRTP.getPlayerWorld(setupInformation);
        //Price
        if (!BetterHome.getInstance().getEco().hasBalance(pWorld))
            return BetterHome.getInstance().getSettings().getPlaceholder_balance();
        //True
        return BetterHome.getInstance().getSettings().getPlaceholder_true();
    }

    private String canRTP_hunger(Player player, World world) {
        if (world == null) return "Invalid World";
        world = BetterHome.getActualWorld(player, world);

        RTPSetupInformation setupInformation = new RTPSetupInformation(world, player, player, true);
        WorldPlayer pWorld = BetterHome.getPlayerWorld(setupInformation);
        //Hunger
        if (!BetterHome.getInstance().getEco().hasHunger(pWorld))
            return BetterHome.getInstance().getSettings().getPlaceholder_hunger();
        //True
        return BetterHome.getInstance().getSettings().getPlaceholder_true();
    }

    private String price(Player player, World world) {
        if (world == null) return "Invalid World";
        world = HelperRTP.getActualWorld(player, world);
        RTPSetupInformation setupInformation = new RTPSetupInformation(world, player, player, true);
        WorldPlayer pWorld = HelperRTP.getPlayerWorld(setupInformation);
        return String.valueOf(pWorld.getPrice());
    }

    private World getWorld(String world_name) {
        World world = null;
        if (world_name.length() > 0)
            for (World _world : Bukkit.getWorlds())
                if (world_name.equalsIgnoreCase(_world.getName())) {
                    world = _world;
                    break;
                }
        return world;
    }
}
