package com.werti.plugins.core;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
  @Override
  public void onEnable()
  {
    getLogger().info("Core was enabled!");
  }

  @Override
  public void onDisable()
  {
    getLogger().info("Core was disabled!");
  }
}
