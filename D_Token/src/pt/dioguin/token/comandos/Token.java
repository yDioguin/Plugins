package pt.dioguin.token.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pt.dioguin.token.utils.Conexao;

public class Token extends Conexao implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
		
		if (s instanceof Player) {
			Player p = (Player) s;
			
			if (c.getName().equalsIgnoreCase("token")) {
				if (args.length == 0) {
					if (s instanceof Player) {
					p.sendMessage("§eVocê possui§f " + getJogador(p.getName()) + " §etokens." );
					return true;
					}else {
						s.sendMessage("§cApenas para jogadores!");
					}
				}
				
				if (args.length >= 1) {
					if (args[0].equalsIgnoreCase("set")) {
						if (p.hasPermission("cash.admin")) {
						if (args.length < 3) {
						p.sendMessage("§cDigite /token set (jogador) (quantia)");
						return true;
					}
					
					String target = String.valueOf(args[1]);
					Double quantia;
					try {
						
						quantia = Double.parseDouble(args[2]);
						
					} catch (NumberFormatException e) {
						p.sendMessage("§cDigite um número válido.");
						return true;
					}
					
					setJogador(target, quantia);
					p.sendMessage("§eVocê setou§f " + quantia + " §etoken para§f " + target);
					return true;
						}else {
							p.sendMessage("§cVocê não tem permissão para executar este comando.");
						}
					}
				
				}
				
				
				String target = String.valueOf(args[0]);
				if (!hasJogador(target)) {
					p.sendMessage("§cEste jogador nunca entrou no servidor!");
					return true;
				}
				
				p.sendMessage("§eO jogador §f" + target + " §epossui §f" + getJogador(target) + " §etokens.");
				
				
			}
			
		}

		return false; 
	}
}