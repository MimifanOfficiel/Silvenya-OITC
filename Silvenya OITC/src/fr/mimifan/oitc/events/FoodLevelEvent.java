package fr.mimifan.oitc.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLevelEvent implements Listener {
	
	@EventHandler
	public void onFoodLevelChange(FoodLevelChangeEvent event) {
		event.setFoodLevel(20);
	}
	
}
