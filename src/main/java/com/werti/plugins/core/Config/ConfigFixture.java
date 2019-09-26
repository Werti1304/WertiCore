package com.werti.plugins.core.Config;

import com.werti.plugins.core.Globals;
import com.werti.plugins.core.Logging.CoreLogger;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class ConfigFixture extends YamlConfiguration
{
  private static ArrayList<ConfigFixture> ConfigList = new ArrayList<>();

  File customConfigFile;
  FileConfiguration fileConfiguration;
  ArrayList<ConfigValue> configValueList;

  private String name;

  public ConfigFixture(String name, ConfigValue[] configValues)
  {
    this.name = name;

    String fileName = this.name + ".yml";

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
      CoreLogger.ReportException("Custom Config " + this.name + " couldn't be loaded!", e);
    }

    configValueList = new ArrayList<>(Arrays.asList(configValues));

    for(ConfigValue configValue : configValueList)
    {
      set(configValue.getPath(), configValue.getDefaultValue());
    }

    ConfigList.add(this);
  }

  /**
   * Updates all value out of a Config-File
   */
  public void load()
  {
    for(ConfigValue configValue : configValueList)
    {
      Object value = get(configValue);

      if(value.getClass() != configValue.getType())
      {
        CoreLogger.Warning("Couldn't load value for " + configValue.getPath() + " from Config " + configValue.getConfigName() + "!");
      }

      configValue.setValue(get(configValue));
    }
  }

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

      Globals.bukkitServer.getLogger().severe("ConfigValue for " + configValue.getPath() + " from config " + configValue.getConfigName() + " wasn't a char! RETURNING DEFAULT VALUE!");

      e.printStackTrace();
    }
    return (char) ch;
  }

  public Object get(ConfigValue configValue)
  {
    return get(configValue.getPath());
  }

  public Object getDefaultValue(ConfigValue configValue)
  {
    return configValue.getDefaultValue();
  }

  public String getString(ConfigValue configValue)
  {
    return configValue.getPath();
  }
}
