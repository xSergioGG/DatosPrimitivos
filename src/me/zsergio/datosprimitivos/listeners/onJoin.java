package me.zsergio.datosprimitivos.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.zsergio.datosprimitivos.Main;
import me.zsergio.datosprimitivos.manage.PlayerManager;

public class onJoin implements Listener {
	
	private static Main plugin = Main.getInstance();
	private static PlayerManager playerManager = plugin.getPlayerManager();
	
	@EventHandler
	public void onEvent(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		
		playerManager.joinPlayer(player);
		player.sendMessage("§aBienvenido! Tu suelto actúal es: "+playerManager.getPlayer(player).getBalance()+"$");
	}

}
