package com.werti.plugins.core.Config;

import java.awt.*;
import java.io.IOException;

public class ConfigMiscellaneous extends ConfigFixture
{
  private static final String name = "miscellaneous";

  private char ColorChar = '&';

  public ConfigMiscellaneous()
  {
    super(name);

    set(Values.ColorChar.getName(), Values.ColorChar.getDefaultValue());

    try
    {
      save(customConfigFile);
    } catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  // Load all current values from configuration
  public void load()
  {
    ColorChar = getChar(Values.ColorChar);
  }

  public char getColorChar()
  {
    return ColorChar;
  }

  public enum Values implements ConfigValue
  {
    ColorChar("Color-Char", '&');

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
