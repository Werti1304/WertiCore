package com.werti.plugins.core.Logging;

import com.werti.plugins.core.Globals;
import jdk.internal.jline.internal.Nullable;
import org.apache.commons.lang.exception.ExceptionUtils;

import java.util.logging.Level;

public class CoreLogger
{
  public static void setLoggerLevel(Level level)
  {
    Globals.logger.setLevel(Level.FINEST);
    Globals.consoleHandler.setLevel(Level.FINEST);
  }

  public static void ReportException(@Nullable String msg, Exception e)
  {
    String stackTrace = ExceptionUtils.getStackTrace(e);

    if(msg != null)
    {
      Globals.logger.severe(msg);
    }
    Globals.logger.severe(stackTrace);
  }

  public static void Warning(String msg)
  {
    Globals.logger.warning(msg);
  }

  public static void Info(String msg)
  {
    Globals.logger.info(msg);
  }

  public static void DebugLv1(String msg)
  {
    Globals.logger.fine(msg);
  }

  public static void DebugLv2(String msg)
  {
    Globals.logger.finer(msg);
  }

  public static void DebugLv3(String msg)
  {
    Globals.logger.finest(msg);
  }
}
