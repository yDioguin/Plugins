package pt.dioguin.encantar;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import pt.dioguin.encantar.comandos.Encantar;
import pt.keifuz.dioguin.eventos.Inventario;

public class Main extends JavaPlugin {
	
	public static Main instance;
	
	@Override
	public void onEnable() {
		instance = this;
		registro();
		saveDefaultConfig();
	}
	
	@Override
	public void onDisable() {
	}
	
	public void registro() {
		getCommand("encantar").setExecutor(new Encantar());
		Bukkit.getPluginManager().registerEvents(new Inventario(), this);
	}
	
	public static Main getInstance() {
		return instance;
	}

}
