package com.crusadecraft.staffdynmap;

import com.crusadecraft.staffdynmap.listeners.PlayerLogListener;
import com.crusadecraft.staffdynmap.listeners.PlayerGameModeChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class StaffDynmap extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        new PlayerLogListener(this);
        new PlayerGameModeChangeEvent(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
