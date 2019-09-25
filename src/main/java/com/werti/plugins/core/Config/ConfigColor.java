package com.werti.plugins.core.Config;

import org.bukkit.Color;

public class ConfigColor extends ConfigFixture
{
  private static String name = "color";

  private Color infoColor = (Color) Values.InfoColor.defaultValue;

  ConfigColor()
  {
    super(name);
  }

  @Override
  public void load()
  {

  }


  public enum Values implements ConfigValue
  {
    InfoColor("Info-Color", Color.AQUA);

    private String name;
    private Object defaultValue;

    Values(String name, Object defaultValue)
    {
      this.name = name;
      this.defaultValue = defaultValue;
    }

    public String getName()
    {
      return name;
    }

    public Object getDefaultValue()
    {
      return defaultValue;
    }

    public String getConfigName()
    {
      return name;
    }
  }
}
