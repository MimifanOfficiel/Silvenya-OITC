package fr.mimifan.oitc.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import fr.mimifan.oitc.Main;

public class DropEvent implements Listener {
	
	private Main main;
	
	public DropEvent(Main main) {
		this.main = main;
	}

	@EventHandler
	public void onDrop(PlayerDropItemEvent event) {
		if(!event.getPlayer().hasPermission(main.getConfig().getString("bypass-oitc-restrictions"))) {
			event.setCancelled(true);
			event.getPlayer().sendMessage(main.getConfig().getString("no-drop-msg").replace("&", "§"));
		} else {
			event.setCancelled(false);
		}
	}
}
