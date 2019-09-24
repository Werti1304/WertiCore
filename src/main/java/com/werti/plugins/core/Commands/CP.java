package com.werti.plugins.core.Commands;

import com.werti.plugins.core.CorePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

import static org.bukkit.Bukkit.getServer;

public class CP implements CommandExecutor
{
  @Override
  public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args)
  {
    if(args.length == 0)
    {
      return false;
    }

    switch(args[0])
    {
      case "list": //TODO: Add StrRes for command
        listCommand(commandSender);
        return true;
    }

    CorePlayer coreCommandSender = CorePlayer.getByPlayer(commandSender);
    
    return true;
  }

  private void listCommand(CommandSender commandSender)
  {
    HashMap<Player, CorePlayer> corePlayerHashMap = CorePlayer.getCorePlayerMap();

    commandSender.sendMessage("List of all currently online players (" + corePlayerHashMap.size() + "/" + getServer().getMaxPlayers() + "):");

    for(CorePlayer corePlayer : corePlayerHashMap.values())
    {
      commandSender.sendMessage(corePlayer.getPlayer().getName());
    }
  }
}
