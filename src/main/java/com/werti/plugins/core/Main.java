package com.werti.plugins.core;

import com.werti.plugins.core.Commands.CP;
import com.werti.plugins.core.Commands.Tpall;
import com.werti.plugins.core.Eventhandlers.Connection;
import com.werti.plugins.core.Eventhandlers.SignChange;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin
{
  @Override
  public void onEnable()
  {
    getLogger().info("Core is initializing..");

    loadConfigs();

    registerEventHandlers();

    registerCommands();

    getLogger().info("Core was successfully enabled!");
  }

  @Override
  public void onDisable()
  {
    getLogger().info("Core was disabled!");
  }

  private void loadConfigs()
  {
    saveDefaultConfig();

    getLogger().info("Configs have been loaded!");
  }

  private void registerCommands()
  {
    Objects.requireNonNull(this.getCommand("tpall")).setExecutor(new Tpall());
    Objects.requireNonNull(this.getCommand("coreplayer")).setExecutor(new CP());
  }

  private void registerEventHandlers()
  {
    getServer().getPluginManager().registerEvents(new SignChange(), this);
    getServer().getPluginManager().registerEvents(new Connection(), this);

    getLogger().info("Eventhandlers were registered!");
  }
}
