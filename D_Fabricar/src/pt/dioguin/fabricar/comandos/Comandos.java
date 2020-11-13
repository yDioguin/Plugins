package pt.dioguin.fabricar.comandos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import pt.dioguin.fabricar.utils.ItemBuilder;

public class Comandos implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
		
		Player p = (Player) s;
		
		Inventory inv = Bukkit.createInventory(null, 3*9, "§7Fabricar");
		ItemStack i = new ItemBuilder(Material.POTION, 3, (short)8233)
				.setDisplayName("§cPoção de Força")
				.setLore("", "§7Clique aqui para fabricar as poções", "§7Ingredientes:", "", "§71x Fungo do Nether", "§71x Pó de Blaze", "§71x Glowstone")
				.build();
		ItemStack i2 = new ItemBuilder(Material.POTION, 3, (short)8226)
				.setDisplayName("§cPoção de Velocidade")
				.setLore("", "§7Clique aqui para fabricar as poções", "§7Ingredientes:", "", "§71x Fungo do Nether", "§71x Açucar", "§71x Glowstone")
				.build();
		
		inv.setItem(11, i);
		inv.setItem(15, i2);
		
		if (!(s instanceof Player))
		      return false;

			if (c.getName().equalsIgnoreCase("fabricar") && p.hasPermission("fabricar.usar"))  {
				p.openInventory(inv);
		}
		
	
			


		return false;
	}
}
	


