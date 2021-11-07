package com.devflask.statisticslib.lib.data;

import com.devflask.statisticslib.lib.main.PlayerStatistics;

import java.util.TimerTask;

public class StatisticsTimer extends TimerTask {

    private final PlayerStatistics plugin;

    public StatisticsTimer(PlayerStatistics plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        plugin.getStatisticsManager().saveStatistics(plugin.getConfigManager().clearCacheOnSave);
    }
}