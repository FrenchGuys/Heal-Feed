package fr.FrenchGuys.HealFeed.Commands;

import fr.FrenchGuys.HealFeed.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Feed implements CommandExecutor {

  private Main main;

  public Feed(Main main) {
    this.main = main;
  }

  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

    Player player = (Player) sender;

    if (cmd.getName().equalsIgnoreCase("feed")) {
      if (player.hasPermission("feed.cmd")) {

        if (args.length == 0) {

          player.sendMessage(main.getConfig().getString("feed.playergetfeed").replace("&", "§"));

          player.setFoodLevel(20);

        } else {
          String playerName = args[0];
          Player target = Bukkit.getServer().getPlayerExact(playerName);

          if (target == null) {
            player.sendMessage(main.getConfig().getString("feed.notfound").replace("&", "§"));
          } else {
            target.sendMessage(main.getConfig().getString("feed.targetgetfeed").replace("&", "§").replace("%target%", target.getName()));
            target.setFoodLevel(20);
            player.sendMessage(main.getConfig().getString("feed.youfeedtarget").replace("&", "§").replace("%target%", target.getName()));

          }
        }
      }
      return false;
    }
    return false;
  }
}
