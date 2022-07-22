package com.github.atsjj;

import org.bukkit.entity.Player;

public class PlayerUtils {
  public static int getTotalExperience(Player player) {
    final int levelR = player.getLevel();
    final int levelS = levelR * levelR;

    if (levelR <= 16) {
      return levelS + 6 * levelR;
    } else if (levelR >= 17 && levelR <= 31) {
      final Long value = Math.round(2.5 * levelS - 40.5 * levelR + 360);

      return value.intValue();
    } else {
      final Long value = Math.round(4.5 * levelS - 162.5 * levelR + 2200);

      return value.intValue();
    }
  }
}
