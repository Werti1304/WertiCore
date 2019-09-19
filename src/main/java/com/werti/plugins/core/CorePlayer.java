package com.werti.plugins.core;

import jdk.internal.jline.internal.Nullable;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;

import static org.bukkit.Bukkit.getServer;

public class CorePlayer
{
  private static HashMap<Player, CorePlayer> corePlayerMap = new HashMap<>();
  private final Player player;

  /**
   * Add Player as CorePlayer (only in OnJoin-Event needed!).
   *
   * @param player Player to be added.
   */
  public CorePlayer(Player player)
  {
    this.player = player;

    corePlayerMap.put(player, this);
  }

  /**
   * Add Player as CorePlayer (only in OnJoin-Event needed!).
   *
   * @param player Player to be added.
   */
  public static void add(Player player)
  {
    new CorePlayer(player);
  }

  /**
   * Remove player from CorePlayer-List
   *
   * @param player Player to be removed.
   */
  public static void remove(Player player)
  {
    corePlayerMap.remove(player);
  }

  /**
   * @param player Player to search for.
   * @return CorePlayer that corresponds to the player.
   */
  @Nullable
  public static CorePlayer GetByPlayer(Player player)
  {
    return corePlayerMap.get(player);
  }

  /**
   * @param name Name of the player.
   * @return CorePlayer that corresponds to the players' name.
   */
  @Nullable
  public static CorePlayer GetByPlayerName(String name)
  {
    Player player = getServer().getPlayer(name);

    if (player == null)
    {
      return null;
    }

    return GetByPlayer(player);
  }

  /**
   * @return CorePlayerMap containing all currently online players.
   */
  public static HashMap<Player, CorePlayer> getCorePlayerMap()
  {
    return corePlayerMap;
  }

  /**
   * Remove player from CorePlayer-List
   */
  public void remove()
  {
    corePlayerMap.remove(this);
  }

  /**
   * @return Player-Object
   */
  public Player getPlayer()
  {
    return player;
  }

  ////////////////////////////////////////
  // Implementation of Player-Functions //
  ////////////////////////////////////////

  /**
   * Teleports a CorePlayer to another CorePlayer.
   *
   * @param corePlayer CorePlayer to be teleported to.
   */
  public void teleport(CorePlayer corePlayer)
  {
    player.teleport(corePlayer.getPlayer());
  }

  /**
   * Send a message to a CorePlayer.
   *
   * @param string Message to be sent.
   */
  public void sendMessage(String string)
  {
    player.sendMessage(string);
  }

  /**
   * Get the location of a CorePlayer.
   *
   * @return Location of the player.
   */
  public Location getLocation()
  {
    return player.getLocation();
  }
}
