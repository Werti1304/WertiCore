package com.werti.plugins.core.Logging;

import org.bukkit.entity.Player;

public class StringHelper
{
  public static String getPlayerInfo(Player player)
  {
    String playerString = player.getName()
                        + "(" + (player.isOnline() ? "Online" : "Offline") + ")"
                        + " [UUID: " + player.getUniqueId() + "]";

    return playerString;
  }
}
