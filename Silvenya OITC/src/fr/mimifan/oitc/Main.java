package fr.mimifan.oitc;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.mimifan.oitc.events.ArrowHitEvent;
import fr.mimifan.oitc.events.DeathEvent;
import fr.mimifan.oitc.events.DropEvent;
import fr.mimifan.oitc.events.FoodLevelEvent;
import fr.mimifan.oitc.events.InvClickEvent;
import fr.mimifan.oitc.events.JoinEvent;
import fr.mimifan.oitc.events.PickupEvent;
import fr.mimifan.oitc.events.RespawnEvent;



public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		System.out.println("One In The Chamber allumé");
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new JoinEvent(this), this);
		pm.registerEvents(new InvClickEvent(this), this);
		pm.registerEvents(new DropEvent(this), this);
		pm.registerEvents(new ArrowHitEvent(), this);
		pm.registerEvents(new DeathEvent(this), this);
		pm.registerEvents(new RespawnEvent(this), this);
		pm.registerEvents(new PickupEvent(this), this);
		pm.registerEvents(new FoodLevelEvent(), this);
	}
	
	@Override
	public void onDisable() {
		System.out.println("One In The Chamber éteint");
	}
	
}
