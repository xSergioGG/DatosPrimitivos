package me.zsergio.datosprimitivos.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.zsergio.datosprimitivos.Main;
import me.zsergio.datosprimitivos.manage.PlayerManager;

public class onQuit implements Listener {
	
	private static Main plugin = Main.getInstance();
	private static PlayerManager playerManager = plugin.getPlayerManager();
	
	@EventHandler
	public void onEvent(PlayerQuitEvent event) {
		playerManager.resetBlocks();
	}

}
