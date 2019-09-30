package com.werti.plugins.core;

import com.werti.plugins.core.Commands.CP;
import com.werti.plugins.core.Commands.Tpall;
import com.werti.plugins.core.Config.ConfigColor;
import com.werti.plugins.core.Config.ConfigFixture;
import com.werti.plugins.core.Config.ConfigMiscellaneous;
import com.werti.plugins.core.Eventhandlers.Connection;
import com.werti.plugins.core.Eventhandlers.SignChange;
import com.werti.plugins.core.Logging.CoreLogger;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.logging.Level;

public class Main extends JavaPlugin
{
  @Override
  public void onEnable()
  {
    getLogger().info("Core is initializing..");

    initGlobals();

    loadConfigs();

    registerEventHandlers();

    registerCommands();

    reloadSafe();

    getLogger().info("Core was successfully enabled!");
  }

  private void initGlobals()
  {
    Globals.plugin = this;

    Globals.bukkitServer = this.getServer();

    Globals.logger = this.getLogger();

    //Globals.consoleHandler = new ConsoleHandler();
    //Globals.logger.addHandler(Globals.consoleHandler);

    CoreLogger.setLoggerLevel(Level.INFO);
  }

  @Override
  public void onDisable()
  {
    getLogger().info("Core was disabled!");
  }

  private void loadConfigs()
  {
    saveDefaultConfig();

    Globals.conMisc = new ConfigMiscellaneous();

    Globals.conColor = new ConfigColor();

    ConfigFixture.loadAllConfigs();

    CoreLogger.info("Color-Char: " + Globals.conMisc.ColorChar.getValue());

    CoreLogger.info("Configs have been loaded!");
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

  private void reloadSafe()
  {
    CorePlayer.addAllPlayers();

    CoreLogger.info("All already online players were added as CorePlayers!");
  }
}
