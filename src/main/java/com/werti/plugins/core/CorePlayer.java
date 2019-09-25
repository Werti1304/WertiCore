package com.werti.plugins.core;

import com.werti.plugins.core.Logging.CoreLogger;
import com.werti.plugins.core.Logging.StringHelper;
import com.werti.plugins.core.StringResources.StrResCorePlayer;
import jdk.internal.jline.internal.Nullable;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

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
    if(!corePlayerMap.containsKey(player))
    {
      new CorePlayer(player);

      CoreLogger.DebugLv1("Player " + StringHelper.getPlayerInfo(player) + " was added as CorePlayer.");
    }
    else
    {
      CoreLogger.Warning(StrResCorePlayer.NotFoundError(player));
    }
  }

  /**
   * Remove player from CorePlayer-List
   *
   * @param player Player to be removed.
   */
  public static void remove(Player player)
  {
    if(corePlayerMap.containsKey(player))
    {
      corePlayerMap.remove(player);

      CoreLogger.DebugLv1("Player " + StringHelper.getPlayerInfo(player) + " was removed as CorePlayer.");
    }
    else
    {
      CoreLogger.Warning(StrResCorePlayer.NotFoundError(player));
    }
  }

  public static void addAllPlayers()
  {
    for(Player player : Globals.bukkitServer.getOnlinePlayers())
    {
      add(player);
    }
  }

  /**
   * @param player Player to search for.
   * @return CorePlayer that corresponds to the player.
   */
  @NotNull
  public static CorePlayer getByPlayer(Player player)
  {
    CorePlayer corePlayer = corePlayerMap.get(player);

    return corePlayer;
  }

  @NotNull
  public static CorePlayer getByPlayer(CommandSender commandSender)
  {
    CorePlayer corePlayer = corePlayerMap.get((Player) commandSender);

    assert corePlayer != null;

    return corePlayer;
  }

  /**
   * @param name Name of the player.
   * @return CorePlayer that corresponds to the players' name.
   */
  @Nullable
  public static CorePlayer GetByPlayerName(String name)
  {
    Player player = getServer().getPlayer(name);

    return getByPlayer(player);
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
  public void teleport(@NotNull CorePlayer corePlayer)
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
