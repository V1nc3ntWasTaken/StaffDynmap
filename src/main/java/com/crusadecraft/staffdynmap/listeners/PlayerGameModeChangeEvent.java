package com.crusadecraft.staffdynmap.listeners;

import com.crusadecraft.staffdynmap.StaffDynmap;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitTask;

public class PlayerGameModeChangeEvent implements Listener {

    private static StaffDynmap plugin;

    public PlayerGameModeChangeEvent(StaffDynmap plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onGamemodeChange(org.bukkit.event.player.PlayerGameModeChangeEvent event) {
        Player player = event.getPlayer();
        ConsoleCommandSender console = Bukkit.getConsoleSender();
        String commandHide = "dynmap hide " + player.getName();
        String commandShow = "dynmap show " + player.getName();

        if ((event.getNewGameMode() == GameMode.CREATIVE) || (event.getNewGameMode() == GameMode.SPECTATOR)) {
            Bukkit.dispatchCommand(console, commandHide);
        } else if (event.getNewGameMode() == GameMode.SURVIVAL) {
            Bukkit.dispatchCommand(console, commandShow);
        }

    }

}
