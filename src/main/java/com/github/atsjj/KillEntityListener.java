package com.github.atsjj;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class KillEntityListener implements Listener {
  @EventHandler
  public void onKillEntity(EntityDeathEvent entityDeathEvent) {
    if (!(entityDeathEvent.getEntity() instanceof Player)) {
      return;
    }

    final Player losingPlayer = (Player) entityDeathEvent.getEntity();

    if (!(losingPlayer.getKiller() instanceof Player)) {
      return;
    }

    final Player winningPlayer = (Player) losingPlayer.getKiller();
    final int losingPlayerExperience = PlayerUtils.getTotalExperience(losingPlayer);
    final String message = winningPlayer.getName() + " Owned " + losingPlayer.getName() + " for " + losingPlayerExperience + " Experience";

    losingPlayer.setExp(0);
    losingPlayer.setLevel(0);
    PlayerUtils.takeHeart(losingPlayer);

    winningPlayer.giveExp(losingPlayerExperience);
    PlayerUtils.giveHeart(winningPlayer);

    losingPlayer.sendMessage(message);
    winningPlayer.sendMessage(message);
  }
}
