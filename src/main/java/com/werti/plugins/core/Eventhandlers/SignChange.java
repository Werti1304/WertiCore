package com.werti.plugins.core.Eventhandlers;

import com.werti.plugins.core.Config.ConfigMiscellaneous;
import com.werti.plugins.core.Globals;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignChange implements Listener
{
  @EventHandler
  public void onSignChange(SignChangeEvent signChangeEvent)
  {
    for (int i = 0; i < 4; i++)
    {
      String line = signChangeEvent.getLine(i);
      if (line != null && !line.equals(""))
      {
        signChangeEvent.setLine(i, ChatColor.translateAlternateColorCodes(Globals.conMisc.ColorChar.getValue(), line));
      }
    }
  }
}
