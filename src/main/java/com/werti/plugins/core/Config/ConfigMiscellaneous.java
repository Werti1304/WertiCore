package com.werti.plugins.core.Config;

import java.util.ArrayList;

public class ConfigMiscellaneous extends ConfigFixture
{
  private static final String name = "miscellaneous";

  public ConfigValue<Character> ColorChar;

  public ConfigMiscellaneous()
  {
    super(name);
  }

  @Override
  ArrayList<ConfigValue> initializeValues()
  {
    ArrayList<ConfigValue> configValueList = new ArrayList<>();

    ColorChar = new ConfigValue<Character>("Color-Char", ConfigValue.Type.Character, '&');
    configValueList.add(ColorChar);

    return configValueList;
  }

  @Override
  public String getConfigName()
  {
    return name;
  }
}
