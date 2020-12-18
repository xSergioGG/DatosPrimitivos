package me.zsergio.datosprimitivos;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.zsergio.datosprimitivos.listeners.onBreakAndPlace;
import me.zsergio.datosprimitivos.listeners.onJoin;
import me.zsergio.datosprimitivos.listeners.onQuit;
import me.zsergio.datosprimitivos.manage.PlayerManager;

public class Main extends JavaPlugin {
	
	private static Main instance;
	
	private PlayerManager playerManager;
	
	@Override
	public void onEnable() {
		instance = this;
		playerManager = new PlayerManager();
				
		registerEvents();
	}
	
	private void registerEvents() {
		PluginManager pm = Bukkit.getPluginManager();
		
		pm.registerEvents(new onJoin(), this);
		pm.registerEvents(new onBreakAndPlace(), this);
		pm.registerEvents(new onQuit(), this);
	}
	
	public PlayerManager getPlayerManager() {
		return playerManager;
	}
	
	public static Main getInstance() {
		return instance;
	}

}
