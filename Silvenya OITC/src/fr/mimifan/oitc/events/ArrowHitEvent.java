package fr.mimifan.oitc.events;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;


public class ArrowHitEvent implements Listener {
	

	public ArrowHitEvent() {
		
	}

	@EventHandler
    public void onHit(EntityDamageByEntityEvent event) {
        if(event.getDamager() instanceof Projectile) {
        	Projectile p = (Projectile) event.getDamager();
        	if(p.getType() == EntityType.ARROW) {
        		if(p.getShooter() instanceof Player) {
                    if(event.getEntity() instanceof Player) {
                        event.setDamage(event.getDamage() * 100);
                    }
                }
            }
        }
    }
}
