package pt.dioguin.token.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.bukkit.Bukkit;


public class Conexao {
	
	public static void criarTabela() {
		
		try {
			
			Connection con = abrirConexao();
			PreparedStatement stm = con.prepareStatement("CREATE TABLE TOKEN(JOGADOR VARCHAR(45),QUANTIA DOUBLE);");
			stm.executeUpdate();
			Bukkit.getConsoleSender().sendMessage("§aTabela criada com sucesso.");
			
		} catch (Exception e) {
			Bukkit.getConsoleSender().sendMessage("§cOcorreu um erro ao criar a tabela.");
		}
	}
	
	
	
	public static Connection abrirConexao() {
		
		try {
			
			String password = "6a9de52c59";
			String user = "rh7284";
			String host = "170.81.41.76";
			String port = "3306";
			String db = "rh7284";
			String type = "jdbc:mysql://"; 
			String url = type+host+":"+port+"/"+db;
			
			return DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			Bukkit.getConsoleSender().sendMessage("§cOcorreu um erro ao abrir a conexão.");
		}
		return null;
	}
	
	public static void addJogador(String player) {
		
		try {
			
			Connection con = abrirConexao();
			PreparedStatement stm = con.prepareStatement("INSERT INTO TOKEN VALUES (?,0)");
			stm.setString(1, player.toLowerCase());
			stm.executeUpdate();
			con.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void setJogador(String player, Double quantia) {
		
		if (hasJogador(player)) {
			
		
		try {
			
			Connection con = abrirConexao();
			PreparedStatement stm = con.prepareStatement("UPDATE TOKEN SET QUANTIA = ? WHERE JOGADOR = ?");
			stm.setString(2, player.toLowerCase());
			stm.setDouble(1, quantia);
			stm.executeUpdate();
			con.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		}else {
			addJogador(player);
		}
	}
	
	public static double getJogador(String player) {
		
		try {
			
			Connection con = abrirConexao();
			PreparedStatement stm = con.prepareStatement("SELECT * FROM TOKEN WHERE JOGADOR = ?");
			stm.setString(1, player.toLowerCase());
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				return rs.getDouble("QUANTIA");
			}
			return 0.0;

		} catch (Exception e) {
			return 0.0;
		}
		
	}
	
	

	
	public static boolean hasJogador(String player) {

		
		try {
			
			Connection con = abrirConexao();
			PreparedStatement stm = con.prepareStatement("SELECT QUANTIA FROM TOKEN WHERE JOGADOR = ?");
			stm.setString(1, player.toLowerCase());
			ResultSet rs = stm.executeQuery();
			boolean result = rs.next();
			con.close();
			return result;
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;

	}
	
	public static void addToken(String player, Double quantia) {
		
		if (hasJogador(player)) {
			setJogador(player, getJogador(player) + quantia);
		}
		
		
	}
	
	public static void removeToken(String player, Double quantia) {
		if (hasJogador(player)) {
			setJogador(player, getJogador(player) - quantia);
		}else {
			setJogador(player, 0.0);
		}
	}
	
	public static void removeJogador(String player) {
		if (hasJogador(player)) {
			
			PreparedStatement stm = null;
			Connection con = abrirConexao();
			
			try {
				
				stm = con.prepareStatement("DELETE FROM TOKEN WHERE JOGADOR = ?");
				stm.setString(1, player.toLowerCase());
				stm.executeUpdate();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	
	
	
	
		
}
