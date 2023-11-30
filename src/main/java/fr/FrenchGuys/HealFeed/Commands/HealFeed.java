package fr.FrenchGuys.HealFeed.Commands;

import fr.FrenchGuys.HealFeed.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealFeed implements CommandExecutor {

  private Main main;

  public HealFeed(Main main) {
    this.main = main;
  }

  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

    Player player = (Player) sender;

    if (cmd.getName().equalsIgnoreCase("healfeed")) {
      if (player.hasPermission("healfeed.cmd")) {

        if (args.length == 0) {

          player.sendMessage(main.getConfig().getString("healandfeed.playergethealfeed").replace("&", "§"));

          player.setHealth(20);
          player.setFoodLevel(20);

        } else {
          String playerName = args[0];
          Player target = Bukkit.getServer().getPlayerExact(playerName);

          if (target == null) {
            player.sendMessage(main.getConfig().getString("healandfeed.notfound"));
          } else {
            target.sendMessage(main.getConfig().getString("healandfeed.targetgethealfeed").replace("&", "§").replace("%target%", target.getName()));
            player.setHealth(20);
            player.setFoodLevel(20);
            player.sendMessage(main.getConfig().getString("healandfeed.youhealfeedtarget").replace("&", "§").replace("%target%", target.getName()));

          }
        }
      }
      return false;
    }
    return false;
  }
}
