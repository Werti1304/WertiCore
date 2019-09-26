package com.werti.plugins.core.Config;

public class ConfigMiscellaneous extends ConfigFixture
{
  private static final String name = "miscellaneous";

  public ConfigMiscellaneous()
  {
    super(name, Values.values());
  }

  public enum Values implements ConfigValue
  {
    ColorChar("Color-Char", Character.class, '&');

    private String name;
    private Class<?> type;
    private Object defaultValue;
    private Object value;

    Values(String name, Class<?> type, Object defaultValue)
    {
      this.name = name;
      this.type = type;
      this.defaultValue = defaultValue;
      this.value = defaultValue;
    }

    @Override
    public String getPath()
    {
      return name;
    }

    @Override
    public Class<?> getType()
    {
      return type;
    }

    @Override
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

    @Override
    public String getConfigName()
    {
      return name;
    }
  }
}
