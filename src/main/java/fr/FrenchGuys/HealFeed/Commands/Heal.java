package fr.FrenchGuys.HealFeed.Commands;

import fr.FrenchGuys.HealFeed.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {

  private Main main;

  public Heal(Main main) {
    this.main = main;
  }

  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

    Player player = (Player) sender;

    if (cmd.getName().equalsIgnoreCase("heal")) {
      if (player.hasPermission("heal.cmd")) {

        if (args.length == 0) {

          player.sendMessage(main.getConfig().getString("heal.playergetheal").replace("&", "§"));

          player.setHealth(20);

        } else {
          String playerName = args[0];
          Player target = Bukkit.getServer().getPlayerExact(playerName);

          if (target == null) {
            player.sendMessage(main.getConfig().getString("heal.notfound"));
          } else {
            target.sendMessage(main.getConfig().getString("heal.targetgetheal").replace("&", "§").replace("%target%", target.getName()));
            player.setHealth(20);
            player.sendMessage(main.getConfig().getString("heal.youhealtarget").replace("&", "§").replace("%target%", target.getName()));

          }
        }
      }
      return false;
    }
    return false;
  }
}
