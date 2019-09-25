package com.werti.plugins.core.StringResources;

import com.werti.plugins.core.Logging.StringHelper;
import org.bukkit.entity.Player;

public class StrResCorePlayer
{
  public static String NotFoundError(Player player)
  {
    return Errors.NotFound.getMessage() + StringHelper.getPlayerInfo(player);
  }

  public enum Errors
  {
    NotFound("Coreplayer not found: ");

    String message;

    Errors(String message)
    {
      this.message = message;
    }

    public String getMessage()
    {
      return  message;
    }
  }
}
