package fr.mimifan.oitc.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.mimifan.oitc.Main;

public class InvClickEvent implements Listener {
	
	private Main main;
	
	public InvClickEvent(Main main) {
		this.main = main;
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if(event.getInventory().getHolder() == event.getWhoClicked()) {
			if(!event.getWhoClicked().hasPermission(main.getConfig().getString("bypass-oitc-restrictions"))) {
				event.setCancelled(true);
			} else {
				event.setCancelled(false);
			}
		}
	}
	
}
