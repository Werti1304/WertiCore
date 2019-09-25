package com.werti.plugins.core;

import com.werti.plugins.core.Config.ConfigMiscellaneous;
import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;


// Ready after enabling of plugin
public class Globals
{
  static public JavaPlugin plugin;

  static public Server bukkitServer;

  static public Logger logger;

  static public ConsoleHandler consoleHandler;

  static public ConfigMiscellaneous conMisc;
}
