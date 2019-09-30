package com.werti.plugins.core.Config;

import com.werti.plugins.core.Globals;
import com.werti.plugins.core.Logging.CoreLogger;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class ConfigValue<T>
{
  enum Type
  {
    Character,
    Color
  }

  public ConfigValue(String path, Type type, T defaultValue)
  {
    this.path = path;
    this.type = type;
    this.defaultValue = defaultValue;
  }

  public void load()
  {
    Object obj;

    switch (type)
    {
      case Character:
        obj = Globals.conMisc.getString(path).charAt(0);
        break;
      case Color:
        obj = Globals.conMisc.getColor(path);
        break;
      default:
        obj = Globals.conMisc.get(path);
    }

    setValue((T)obj);
  }

  private String path;
  private Type type;
  private T defaultValue;
  private T value;

  public void setValue(T value)
  {
    this.value = value;
  }

  public String getPath()
  {
    return path;
  }

  public Type getType()
  {
    return type;
  }

  public T getDefaultValue()
  {
    return defaultValue;
  }

  public T getValue()
  {
    return value;
  }

  public static <T> T convertInstanceOfObject(Object o, Class<T> cls)
  {
    try
    {
      return cls.cast(o);
    } catch (ClassCastException e)
    {
      return null;
    }
  }
}
