package com.werti.plugins.core.Config;

import com.werti.plugins.core.Globals;
import com.werti.plugins.core.Logging.CoreLogger;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public abstract class ConfigFixture extends YamlConfiguration
{
  private static ArrayList<ConfigFixture> ConfigList = new ArrayList<>();

  File customConfigFile;
  FileConfiguration fileConfiguration;

  public ConfigFixture(String name)
  {
    String fileName = name + ".yml";

    customConfigFile = new File(Globals.plugin.getDataFolder(), fileName);

    if(!customConfigFile.exists())
    {
      if(customConfigFile.getParentFile().mkdirs())
      {
        CoreLogger.Info("Parent directory for Config " + fileName + " was created: " + customConfigFile.getAbsolutePath());
      }

      Globals.plugin.saveResource(fileName, false);
    }

    try
    {
      load(customConfigFile);
    } catch (IOException | InvalidConfigurationException e)
    {
      CoreLogger.ReportException("Custom Config " + name + " couldn't be loaded!", e);
    }

    ConfigList.add(this);
  }

  public abstract void load();

  /**
   * Loads all config-variables from the config-files
   */
  public static void loadAll()
  {
    for(ConfigFixture configFixture : ConfigList)
    {
      configFixture.load();
    }
  }

  public char getChar(ConfigValue configValue)
  {
    char ch;

    try
    {
      ch = (char) get(configValue);
    }
    catch(ClassCastException e)
    {
      ch = (char) configValue.getDefaultValue();

      Globals.bukkitServer.getLogger().severe("ConfigValue for " + configValue.getName() + " from config " + configValue.getConfigName() + " wasn't a char! RETURNING DEFAULT VALUE!");

      e.printStackTrace();
    }
    return (char) ch;
  }

  public Object get(ConfigValue configValue)
  {
    return get(configValue.getName());
  }

  public Object getDefaultValue(ConfigValue configValue)
  {
    return configValue.getDefaultValue();
  }

  public String getString(ConfigValue configValue)
  {
    return configValue.getName();
  }
}
