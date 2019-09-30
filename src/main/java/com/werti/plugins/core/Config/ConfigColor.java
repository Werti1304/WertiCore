package com.werti.plugins.core.Config;

import org.bukkit.ChatColor;
import org.bukkit.Color;

import java.util.ArrayList;

public class ConfigColor extends ConfigFixture
{
  public static String name = "color";

  public ConfigValue<Color> InfoColor;

  public ConfigColor()
  {
    super(name);
  }

  @Override
  ArrayList<ConfigValue> initializeValues()
  {
    ArrayList<ConfigValue> configValueList = new ArrayList<>();

    InfoColor = new ConfigValue<Color>("Info-Color", ConfigValue.Type.Color, Color.AQUA);
    configValueList.add(InfoColor);

    return configValueList;
  }

  public String getConfigName()
  {
    return name;
  }
}
