package pt.dioguin.encantar.comandos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import pt.dioguin.encantar.Main;
import pt.dioguin.encantar.utils.ItemBuilder;

public class Encantar implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
		
		if (s instanceof Player) {
			Player p = (Player) s;
			
			if (c.getName().equalsIgnoreCase("encantar")) {
				
				for (String key : Main.getInstance().getConfig().getConfigurationSection("Encantar").getKeys(false)) {
					
					Inventory inv = Bukkit.createInventory(null, 9 * Main.getInstance().getConfig().getInt("Encantar.Inventario.Size"), Main.getInstance().getConfig().getString("Encantar.Inventario.Nome").replace("&", "§"));
					
					ItemStack item = new ItemBuilder(Material.getMaterial(Main.getInstance().getConfig().getInt("Encantar.Item." + key + ".ID")))
							.setDisplayName(Main.getInstance().getConfig().getString("Encantar.Item." + key + ".Nome").replace("&", "§"))
							.setLore(Main.getInstance().getConfig().getStringList("Encantar.Item." + key + ".Lore"))
							.build();
					
					inv.setItem(Main.getInstance().getConfig().getInt("Encantar.Item." + key + ".Slot"), item);
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
					p.openInventory(inv);
					
				}
				
			}
		}else {
			s.sendMessage(Main.getInstance().getConfig().getString("SemPermissao").replace("&", "§"));
		}
		
		return false;
	}

}
