package fr.mimifan.oitc.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

import fr.mimifan.oitc.Main;

public class PickupEvent implements Listener {

	private Main main;
	
	public PickupEvent(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onPickup(PlayerPickupItemEvent event) {
		if(!event.getPlayer().hasPermission(main.getConfig().getString("bypass-oitc-restrictions"))) {
			event.setCancelled(true);
		} else {
			event.setCancelled(false);
		}
	}

}
