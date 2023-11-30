package fr.FrenchGuys.HealFeed;

import fr.FrenchGuys.HealFeed.Commands.Feed;
import fr.FrenchGuys.HealFeed.Commands.Heal;
import fr.FrenchGuys.HealFeed.Commands.HealFeed;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

  @Override
  public void onEnable() {

    saveDefaultConfig();

    System.out.println("------------------------------------------");
    System.out.println("[HealAndFeed] Enable");
    System.out.println("[HealAndFeed] Join my discord !");
    System.out.println("[HealAndFeed] https://discord.gg/ZjwruYffD4");
    System.out.println("------------------------------------------");

    // Commands

    getCommand("feed").setExecutor(new Feed(this));
    getCommand("heal").setExecutor(new Heal(this));
    getCommand("healfeed").setExecutor(new HealFeed(this));



  }

  @Override
  public void onDisable() {
    System.out.println("------------------------------------------");
    System.out.println("[HealAndFeed] Disable");
    System.out.println("[HealAndFeed] Join my discord !");
    System.out.println("[HealAndFeed] https://discord.gg/ZjwruYffD4");
    System.out.println("------------------------------------------");
    saveConfig();
  }

}
