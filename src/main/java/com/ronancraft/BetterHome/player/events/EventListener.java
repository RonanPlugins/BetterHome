package com.ronancraft.BetterHome.player.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class EventListener implements Listener {
    private final Interact interact = new Interact();
    private final WorldLoad worldLoad = new WorldLoad();

    public void registerEvents(Plugin pl) {
        PluginManager pm = pl.getServer().getPluginManager();
        pm.registerEvents(this, pl);
    }

    public void load() {
        interact.load();
    }

    @EventHandler
    private void onLeave(PlayerQuitEvent e) {
        Leave.event(e);
    }

    @EventHandler
    private void onJoin(PlayerJoinEvent e) {
        Join.event(e);
    }

    @EventHandler
    private void onInteract(PlayerInteractEvent e) {
        interact.event(e);
    }

    @EventHandler
    private void interact(SignChangeEvent e) {
        interact.createSign(e);
    }

    @EventHandler
    private void click(InventoryClickEvent e) {
        Click.click(e);
    }

    @EventHandler
    private void teleport(PlayerTeleportEvent e) {
        Teleport.tpEvent(e);
    }

    @EventHandler
    private void worldLoad(WorldLoadEvent e) {
        worldLoad.load(e);
    }

    @EventHandler
    private void onRespawn(PlayerRespawnEvent e) {
        Death.respawnEvent(e);
    }
}