package com.werti.plugins.core.Config;

public interface ConfigValue
{

  /**
   * @return Name of the Config-Value
   */
  String getName();

  /**
   * @return Default Value, from whichever Type it might be
   */
  Object getDefaultValue();

  /**
   * @return Hardcoded Name of the Config
   */
  String getConfigName();
}
