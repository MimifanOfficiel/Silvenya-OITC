package fr.mimifan.oitc.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.mimifan.oitc.Main;

public class RespawnEvent implements Listener {
	
	private Main main;
	
	public RespawnEvent(Main main) {
		this.main = main;
	}

	@EventHandler
	public void onRespawn(PlayerRespawnEvent event) {
		Player player = event.getPlayer();
		
		ItemStack sword = new ItemStack(Material.WOOD_SWORD, 1);
		ItemMeta swordM = sword.getItemMeta();
		swordM.spigot().setUnbreakable(true);
		sword.setItemMeta(swordM);
		
		ItemStack bow = new ItemStack(Material.BOW, 1);
		ItemMeta bowM = bow.getItemMeta();
		bowM.spigot().setUnbreakable(true);
		bow.setItemMeta(bowM);
		
		ItemStack arrow = new ItemStack(Material.ARROW, 1);
		
		player.getInventory().clear();
		try {
			Thread.sleep(200);
			player.getInventory().setItem(0, sword);
			player.getInventory().setItem(1, bow);
			player.getInventory().setItem(2, arrow);
			
			World world = Bukkit.getWorld(main.getConfig().getString("spawn.world"));
			int x = main.getConfig().getInt("spawn.x");
			int y = main.getConfig().getInt("spawn.y");
			int z = main.getConfig().getInt("spawn.z");
			
			Location loc = new Location(world, x, y, z);
			player.teleport(loc);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}
