package me.zsergio.datosprimitivos.manage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class PlayerManager {
	
	private HashMap<UUID, CustomPlayer> players = new HashMap<>();
	private ArrayList<Location> blocks = new ArrayList<>();
	
	public void joinPlayer(Player player) {
		if(!players.containsKey(player.getUniqueId())) {
			players.put(player.getUniqueId(), new CustomPlayer(player));
		}
	}
	
	public void addBlock(Location loc) {
		if(!blocks.contains(loc)) {
			blocks.add(loc);
		}
	}
	
	public void removeBlock(Location loc) {
		if(blocks.contains(loc)) {
			blocks.remove(loc);
		}
	}
	
	public void resetBlocks() {
		for(Location loc : blocks) {
			loc.getBlock().setType(Material.AIR);
		}
	}
	
	public CustomPlayer getPlayer(Player player) {
		return players.get(player.getUniqueId());
	}
	
	public HashMap<UUID, CustomPlayer> getPlayers() {
		return players;
	}
	
	public ArrayList<Location> getBlocks() {
		return blocks;
	}

}
