package pt.dioguin.token;

import org.bukkit.plugin.java.JavaPlugin;

import pt.dioguin.token.comandos.Token;
import pt.dioguin.token.utils.Conexao;

public class Main extends JavaPlugin {
	
	
	@Override
	public void onEnable() {
		Conexao.criarTabela();
		registro();
	}
	
	@Override
	public void onDisable() {
	}
	
	public void registro() {
		getCommand("token").setExecutor(new Token());
	}
	
	
	

}
