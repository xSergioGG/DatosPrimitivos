package me.zsergio.datosprimitivos.listeners;

import org.bukkit.event.EventHandler;

import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import me.zsergio.datosprimitivos.Main;
import me.zsergio.datosprimitivos.manage.PlayerManager;

public class onBreakAndPlace implements Listener {
	
	private static Main plugin = Main.getInstance();
	private static PlayerManager playerManager = plugin.getPlayerManager();
	
	@EventHandler
	public void onPlace(BlockPlaceEvent event) {
		
		playerManager.addBlock(event.getBlock().getLocation());
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent event) {
		
		playerManager.removeBlock(event.getBlock().getLocation());
		
	}

}
