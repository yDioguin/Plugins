package pt.dioguin.fabricar.eventos;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import pt.dioguin.fabricar.utils.ItemBuilder;

public class Eventos implements Listener {
	
	@EventHandler
	public void aoInteragir(InventoryClickEvent e) {
		if (!e.getInventory().getName().equals("§7Fabricar"))
			return;       e.setCancelled(true);
	    Player p = (Player) e.getWhoClicked();
	    
	    ItemStack forca = new ItemBuilder(Material.POTION, 3, (short)8233).build();
	    ItemStack velocidade = new ItemBuilder(Material.POTION, 3, (short)8226).build();
	    
	    ItemStack i = new ItemStack(372, 1);
	    ItemStack i2 = new ItemBuilder(Material.BLAZE_POWDER, 1).build();
	    ItemStack i3 = new ItemBuilder(Material.SUGAR, 1).build();
	    ItemStack i4 = new ItemBuilder(Material.GLOWSTONE_DUST, 1).build();
	    
	    if (e.getSlot() == 11) {
	    	if (p.getInventory().contains(372) && p.getInventory().contains(Material.BLAZE_POWDER) && p.getInventory().contains(Material.GLOWSTONE_DUST)) {
	    		p.getInventory().removeItem(i);
	    		p.getInventory().removeItem(i2);
	    		p.getInventory().removeItem(i4);
	    		p.getInventory().addItem(forca);
	    		p.playSound(p.getLocation(), Sound.IRONGOLEM_DEATH, 1, 1);
	    		p.sendMessage("§aVocê fabricou as poções com sucesso!");
	    		

	    		
	    	}else {
	    		p.sendMessage("§cVocê não tem os ingredientes necessários.");
	    		p.playSound(p.getLocation(), Sound.BAT_HURT, 1, 1);
	    	}
	    	} 
	    		
	    		
	    
	    if (e.getSlot() == 15) {
	    	if (p.getInventory().contains(372) && p.getInventory().contains(Material.SUGAR) && p.getInventory().contains(Material.GLOWSTONE_DUST)) {
	    		
	    		p.getInventory().removeItem(i);
	    		p.getInventory().removeItem(i3);
	    		p.getInventory().removeItem(i4);
	    		p.getInventory().addItem(velocidade);
	    		p.playSound(p.getLocation(), Sound.IRONGOLEM_DEATH, 1, 1);
	    		p.sendMessage("§aVocê fabricou as poções com sucesso!");
	    		
	    	}else {
	    		p.sendMessage("§cVocê não tem os ingredientes necessários.");
	    		p.playSound(p.getLocation(), Sound.BAT_HURT, 1, 1);
	    	}
	    }
	}

}

