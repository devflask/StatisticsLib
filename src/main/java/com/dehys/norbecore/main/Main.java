package com.dehys.norbecore.main;

import com.dehys.norbecore.data.ConfigManager;
import com.dehys.norbecore.data.SQL;
import com.dehys.norbecore.data.StatisticsManager;
import com.dehys.norbecore.data.UserData;
import com.dehys.norbecore.listeners.BlockBreakListener;
import com.dehys.norbecore.listeners.JoinListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;
    private UserData userData;
    private ConfigManager configManager;
    private StatisticsManager statisticsManager;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        super.onEnable();
        instance = this;
        if (!SQL.connect()) return;
        SQL.setupTables();
        userData = UserData.retrieveData();
        configManager = new ConfigManager(this);
        statisticsManager = new StatisticsManager();
        setupListeners();


    }

    @Override
    public void onDisable() {
        super.onDisable();
        userData.saveData();
    }


    public UserData getUserData() {
        return userData;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    private void setupListeners() {
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
    }

    public StatisticsManager getStatisticsManager() {
        return statisticsManager;
    }
}