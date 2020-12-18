package me.zsergio.datosprimitivos.manage;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.zsergio.datosprimitivos.Main;

public class CustomPlayer {
	
	private static Main plugin = Main.getInstance();
	private static File cfile;
	private static FileConfiguration config;
	private String name;
	private int balance;
	private boolean vanished;
	
	public CustomPlayer(Player player) {
		this.name = player.getName();
		this.balance = 0;
		this.vanished = false;
		
		getDefaultConfig();
		checkConfig();
	}
	
	public int getBalance() {
		return balance;
	}
	
	public boolean isVanished() {
		return vanished;
	}
	
	private void getDefaultConfig() {
		cfile = new File(plugin.getDataFolder()+"//playerdata", this.name+".yml");
		
		if(!cfile.exists()) {
			try {
				cfile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		config = YamlConfiguration.loadConfiguration(cfile);
	}
	
	public void reloadConfig() {
		config = YamlConfiguration.loadConfiguration(cfile);
	}
	
	public void saveConfig() {
		try {
			config.save(cfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void checkConfig() {
		if(config.contains("balance")) {
			this.balance = config.getInt("balance");
		} if(config.contains("vanished")) {
			this.vanished = config.getBoolean("vanished");
		}
		
		config.set("balance", this.balance);
		config.set("vanished", this.vanished);
		
		saveConfig();
	}

}
