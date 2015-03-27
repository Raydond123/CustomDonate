package me.raydond123.customdonate;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.logging.Logger;

public class CustomDonate extends JavaPlugin implements Listener {

    Logger logger = Logger.getLogger("Minecraft");

    public void onEnable() {

        logger.info("[CustomDonate] This plugin has been enabled!");
        saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(this, this);

    }

    public void onDisable() {

        logger.info("[CustomDonate] This plugin has been disabled!");
        saveConfig();

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getLabel().equalsIgnoreCase("donate")) {

            List<String> message = getConfig().getStringList("message");

            for(int i = 0; i <= message.size() - 1; i++) {

                String line = message.get(i);
                String newLine = line.replace("%player%", sender.getName());
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', newLine));

            }

        }

        return false;

    }

}
