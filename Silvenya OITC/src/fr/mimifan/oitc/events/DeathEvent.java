package fr.mimifan.oitc.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import fr.mimifan.oitc.Main;

public class DeathEvent implements Listener {
	
	private Main main;
	
	public DeathEvent(Main main) {
		this.main = main;
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		Player player = event.getEntity().getPlayer();
		Player killer = player.getKiller();
		event.getDrops().clear();
		player.spigot().respawn();
        if(killer instanceof Player) {
            killer.setHealth(20);
            killer.getInventory().addItem(new ItemStack(Material.ARROW));
            event.setDeathMessage(main.getConfig().getString("killed-msg").replace("&", "§").replace("%DEAD_PLAYER%", player.getName()).replace("%KILLER%", killer.getName()));
        }
		
	}
}
