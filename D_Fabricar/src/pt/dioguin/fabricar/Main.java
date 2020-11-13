package pt.dioguin.fabricar;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import pt.dioguin.fabricar.comandos.Comandos;
import pt.dioguin.fabricar.eventos.Eventos;


public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		registro();

	}
	
	@Override
	public void onDisable() {

	}
	
	public void registro() {
		getCommand("fabricar").setExecutor(new Comandos());
	    Bukkit.getPluginManager().registerEvents(new Eventos(), this);
	}

}
