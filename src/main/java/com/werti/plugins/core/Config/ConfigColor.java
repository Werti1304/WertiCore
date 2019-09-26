package com.werti.plugins.core.Config;

import org.bukkit.Color;

public class ConfigColor extends ConfigFixture
{
  private static String name = "color";

  ConfigColor()
  {
    super(name, Values.values());
  }

  public enum Values implements ConfigValue
  {
    InfoColor("Info-Color", Color.AQUA);

    private String name;
    private Object defaultValue;
    private Object value;

    Values(String name, Object defaultValue)
    {
      this.name = name;
      this.defaultValue = defaultValue;
    }

    public String getPath()
    {
      return name;
    }

    @Override
    public Class<?> getType()
    {
      return null;
    }

    public Object getDefaultValue()
    {
      return defaultValue;
    }

    @Override
    public Object getValue()
    {
      return value;
    }

    @Override
    public void setValue(Object value)
    {
      this.value = value;
    }

    public String getConfigName()
    {
      return name;
    }
  }
}
