package de.editsign.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		
		getCommand("editsign").setExecutor(new EditSign());
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("========== EditSign ==========");
		System.out.println(" ");
		System.out.println("Author: GibMirRechte");
		System.out.println("Version: " + Bukkit.getPluginManager().getPlugin("EditSign").getDescription().getVersion());
		System.out.println("Discord: yhBX6KT");
		System.out.println(" ");
		System.out.println("========== EditSign ==========");
	}
}