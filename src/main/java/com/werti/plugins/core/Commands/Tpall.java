package com.werti.plugins.core.Commands;

import com.werti.plugins.core.CorePlayer;
import jdk.internal.jline.internal.Nullable;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Tpall implements CommandExecutor
{
  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args)
  {
    if (!(commandSender instanceof Player))
    {
      commandSender.sendMessage("Only a player can run this command!");
      return true;
    }

    Location tpToLocation = null;

    if(args.length == 0)
    {
      tpToLocation = ((Player) commandSender).getLocation();
    }
    else
    {
      switch(args.length)
      {
        case 1:
          CorePlayer tmpPlayer = CorePlayer.GetByPlayerName(args[0]);
          if(tmpPlayer == null)
          {
            return false;
          }
          tpToLocation = tmpPlayer.getLocation();
          break;
        case 3:
          tpToLocation = parseLocationFromStrings(commandSender, args[0], args[1], args[2]);
          break;
        default:
          return false;
      }
    }

    if(tpToLocation == null)
    {
      return false;
    }

    for(CorePlayer cPlayer : CorePlayer.getCorePlayerMap().values())
    {
      if(cPlayer.getPlayer().getWorld() == ((Player) commandSender).getWorld())
      {
        cPlayer.getPlayer().teleport(tpToLocation);
        cPlayer.sendMessage(((Player) commandSender).getDisplayName() + " teleported you to this loaction!");
      }
    }

    commandSender.sendMessage("All players in your world were teleported to this location!");
    return true;
  }

  @Nullable
  public Location parseLocationFromStrings(CommandSender commandSender, String strX, String strY, String strZ)
  {
    double tmpX;
    double tmpY;
    double tmpZ;

    try
    {
      tmpX = Double.parseDouble(strX);
      tmpY = Double.parseDouble(strY);
      tmpZ = Double.parseDouble(strZ);
    }
    catch(NumberFormatException ex)
    {
      return null;
    }

    return new Location (((Player)commandSender).getWorld(), tmpX, tmpY, tmpZ);
  }
}
