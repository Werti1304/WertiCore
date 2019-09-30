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

  private File customConfigFile;
  private ArrayList<ConfigValue> configValueList;

  private String name;

  ConfigFixture(String name)
  {
    this.name = name;

    configValueList = initializeValues();

    String fileName = this.name + ".yml";

    customConfigFile = new File(Globals.plugin.getDataFolder(), fileName);

    for(ConfigValue configValue : configValueList)
    {
      set(configValue.getPath(), configValue.getDefaultValue());
    }

    if(!customConfigFile.exists())
    {
      if(customConfigFile.getParentFile().mkdirs())
      {
        CoreLogger.info("Parent directory for Config " + fileName + " was created: " + customConfigFile.getAbsolutePath());
      }

      Globals.plugin.saveResource(fileName, false);

      save();
    }

    try
    {
      load(customConfigFile);
    } catch (IOException | InvalidConfigurationException e)
    {
      CoreLogger.ReportException("Custom Config " + this.name + " couldn't be loaded!", e);
    }

    ConfigList.add(this);
  }

  abstract ArrayList<ConfigValue> initializeValues();

  private void save()
  {
    try
    {
      save(customConfigFile);
    } catch (IOException e)
    {
      CoreLogger.ReportException("Couldn't save the config " + name + "!", e);
    }
  }

  /**
   * Loads all config-variables from the config-files
   */
  public static void loadAllConfigs()
  {
    for(ConfigFixture configFixture : ConfigList)
    {
      configFixture.loadAllValues();
    }
  }

  /**
   * Updates all value out of a Config-File
   */
  private void loadAllValues()
  {
    for(ConfigValue configValue : configValueList)
    {
      try
      {
        configValue.load();
      }
      catch (ClassCastException | NullPointerException e)
      {
        CoreLogger.ReportException("Couldn't load value for " + configValue.getPath() + " from Config " + customConfigFile.getName() + "!", e);
      }
    }
  }

  abstract public String getConfigName();

  public Object getDefaultValue(ConfigValue configValue)
  {
    return configValue.getDefaultValue();
  }

  public String getString(ConfigValue configValue)
  {
    return configValue.getPath();
  }
}
