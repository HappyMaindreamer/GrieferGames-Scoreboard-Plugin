package de.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.earth2me.essentials.Essentials;

public class Main extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		System.out.println("[GrieferGames-Scoreboard] Das Plugin wurde erfolgreich aktiviert!");
		System.out.println("[GrieferGames-Scoreboard] Das Plugin ist von maindreamer!");
	
		if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI"))
			   Bukkit.getPluginManager().registerEvents(this, this);
			
			
		this.getServer().getPluginManager().registerEvents(this, this);
		
	}
	
	public void setScoreboard(Player p) {
		
	ScoreboardManager sm = Bukkit.getScoreboardManager();
	final Scoreboard board = sm.getNewScoreboard();
	final Objective o = board.registerNewObjective("test", "dummy");
	
	o.setDisplaySlot(DisplaySlot.SIDEBAR);
	o.setDisplayName("§6§lGrieferGames§8§l.§6§lnet");
	
	o.getScore("§a").setScore(13);
	o.getScore("§7▷ §3§lServer:").setScore(12);
	o.getScore("§fLobby").setScore(11);
	o.getScore("§b ").setScore(10);
	o.getScore("§7▷ §3§lOnline").setScore(9);
	o.getScore("§f" + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers()).setScore(8);
	o.getScore("§n").setScore(7);
	o.getScore("§7▷ §3§lKontostand").setScore(6);
	o.getScore("§f0.00$").setScore(5);
	o.getScore("§k").setScore(4);
	o.getScore("§7▷ §3Shop").setScore(3);
	o.getScore("§fGrieferGames.net").setScore(2);
	o.getScore("§5").setScore(1);
	
		
	p.setScoreboard(board);
	
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		new BukkitRunnable() {
			@Override
			public void run() {
				
				for (Player all : Bukkit.getOnlinePlayers()) {
					setScoreboard(all);
				}
				
			}
		}.runTaskLater(this, 1);
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		
		new BukkitRunnable() {	
			@Override
			public void run() {
				
				for (Player all : Bukkit.getOnlinePlayers()) {
					setScoreboard(all);
				}
				
			}
		}.runTaskLater(this, 1);
	}
	
	public void onDisable() {
		System.out.println("[GrieferGames-Scoreboard] Das Plugin wurde erfolgreich deaktiviert!");
	}

}
