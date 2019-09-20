package com.werti.plugins.core;

import com.werti.plugins.core.commands.CP;
import com.werti.plugins.core.commands.Tpall;
import com.werti.plugins.core.eventhandlers.Connection;
import com.werti.plugins.core.eventhandlers.SignChange;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
  @Override
  public void onEnable()
  {
    getLogger().info("Core is initializing..");

    getServer().getPluginManager().registerEvents(new SignChange(), this);
    getServer().getPluginManager().registerEvents(new Connection(), this);
    getLogger().info("Eventhandlers were registered!");

    getCommand("coreplayer").setExecutor(new CP());
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
