package com.github.atsjj;

import io.papermc.lib.PaperLib;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class LevelHeartsPlugin extends JavaPlugin {
  @Override
  public void onEnable() {
    PaperLib.suggestPaper(this);

    getServer().getPluginManager().registerEvents(new KillEntityListener(), this);
    getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[LevelHearts]: plugin is enabled!");

    saveDefaultConfig();
  }

  @Override
  public void onDisable() {
    getServer().getConsoleSender().sendMessage(ChatColor.RED + "[LevelHearts]: plugin is disabled!");
  }
}
