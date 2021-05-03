package com.crusadecraft.staffdynmap.listeners;

import com.crusadecraft.staffdynmap.StaffDynmap;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerLogListener implements Listener {

    public PlayerLogListener(StaffDynmap plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        ConsoleCommandSender console = Bukkit.getConsoleSender();
        String commandHide = "dynmap hide " + player.getName();
        String commandShow = "dynmap show " + player.getName();

        if ((player.getGameMode() == GameMode.CREATIVE) || (player.getGameMode() == GameMode.SPECTATOR) || (player.getGameMode() == GameMode.ADVENTURE)) {
            Bukkit.dispatchCommand(console, commandHide);
        } else {
            Bukkit.dispatchCommand(console, commandShow);
        }
    }
    
}
