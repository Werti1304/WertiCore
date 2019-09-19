package com.werti.plugins.core;

import com.werti.plugins.core.commands.Tpall;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
  @Override
  public void onEnable()
  {
    getLogger().info("Core is initializing..");

    //getLogger().info("Eventhandlers were registered!");

    getCommand("tpall").setExecutor(new Tpall());
    getLogger().info("Commands were registered!");

    getLogger().info("Core was successfully enabled!");
  }

  @Override
  public void onDisable()
  {
    getLogger().info("Core was disabled!");
  }
}
