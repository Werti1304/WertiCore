package com.werti.plugins.core;

import jdk.internal.jline.internal.Nullable;
import org.apache.commons.lang.exception.ExceptionUtils;

public class CoreLogger
{
  public static void ReportException(@Nullable String msg, Exception e)
  {
    String stackTrace = ExceptionUtils.getStackTrace(e);

    if(msg != null)
    {
      Globals.logger.severe(msg);
    }
    Globals.logger.severe(stackTrace);
  }

  public static void Info(String msg)
  {
    Globals.logger.info(msg);
  }
}
