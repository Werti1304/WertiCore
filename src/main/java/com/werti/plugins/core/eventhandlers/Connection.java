package com.werti.plugins.core.eventhandlers;

import com.werti.plugins.core.CorePlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Connection implements Listener
{
  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent playerJoinEvent)
  {
    CorePlayer.add(playerJoinEvent.getPlayer());
  }

  @EventHandler
  public void onPlayerQuit(PlayerQuitEvent playerQuitEvent)
  {
    CorePlayer.remove(playerQuitEvent.getPlayer());
  }
}
