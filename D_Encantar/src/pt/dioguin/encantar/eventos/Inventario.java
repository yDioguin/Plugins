package pt.dioguin.eventos;

import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import pt.dioguin.encantar.Main;

public class Inventario implements Listener {
	
	@EventHandler
	public void aoClicar(InventoryClickEvent e) {
		if (!e.getInventory().getName().equals(Main.getInstance().getConfig().getString("Encantar.Inventario.Nome").replace("&", "§"))) return;
		e.setCancelled(true);
		Player p = (Player) e.getWhoClicked();
		ItemStack pitem = p.getItemInHand();
		
		for (String key : Main.getInstance().getConfig().getConfigurationSection("Encantar").getKeys(false)) {
			
			if (e.getSlot() == Main.getInstance().getConfig().getInt("Encantar.Item." + key + ".Slot")) {
				
				if (p.getLevel() >= Main.getInstance().getConfig().getInt("Encantar.Item." + key + ".XP")) {
					
					p.giveExpLevels(- Main.getInstance().getConfig().getInt("Encantar.Item." + key + ".XP"));
					pitem.addUnsafeEnchantment(Enchantment.getByName(Main.getInstance().getConfig().getString("Encantar.Item." + key + ".Encantamento")), Main.getInstance().getConfig().getInt("Encantar.Item." + key + ".EncantamentoNivel"));
					p.sendMessage(Main.getInstance().getConfig().getString("EncantarSucesso").replace("&", "§"));
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
					p.closeInventory();
					
				}else {
					p.sendMessage(Main.getInstance().getConfig().getString("SemXP").replace("&", "§"));
					p.closeInventory();
				}
				
			}
			
		}
	}

}
