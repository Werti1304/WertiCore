package com.werti.plugins.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Tpall implements CommandExecutor
{
  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings)
  {
    if (!(commandSender instanceof Player))
    {
      commandSender.sendMessage("Only a player can run this command!");
      return true;
    }

    // TODO: Lukas add functionality
    commandSender.sendMessage("Lol");

    return false;
  }
}
