package com.werti.plugins.core.Config;

public interface ConfigValue
{

  /**
   * @return Name of the Config-Value
   */
  String getPath();

  /**
   * @return Get Type of Value
   */
  Class<?> getType();

  /**
   * @return Default Value, from whichever Type it might be
   */
  Object getDefaultValue();

  /**
   * @return Value of config, is default value until the config is loaded
   */
  Object getValue();

  /**
   * @param value Set value (should only used when (re)loading the config)
   */
  void setValue(Object value);
}
