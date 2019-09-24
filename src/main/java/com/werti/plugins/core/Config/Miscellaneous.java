package com.werti.plugins.core.Config;

public class Miscellaneous extends ConfigFixture
{
  private static final String name = "Miscellaneous";

  public Miscellaneous()
  {
    super(name);

    addDefault("Color-Char", '&');
  }
}
