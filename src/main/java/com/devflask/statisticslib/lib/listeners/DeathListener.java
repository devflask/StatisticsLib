package com.devflask.statisticslib.lib.listeners;

import com.devflask.statisticslib.lib.enums.Statistic;
import com.devflask.statisticslib.lib.main.PlayerStatistics;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public record DeathListener(PlayerStatistics plugin) implements Listener {

    @EventHandler
    public void onEntityDeath(final EntityDeathEvent event) {
        if (event.getEntity() instanceof Player)
            plugin.getStatisticsManager().addStatistic((Player) event.getEntity(), Statistic.DEATHS, 1);

        if (event.getEntity().getKiller() != null) {
            plugin.getStatisticsManager().addStatistic(event.getEntity().getKiller(), (event.getEntity() instanceof Player ? Statistic.PLAYER_KILLS : Statistic.MOB_KILLS), (event.getEntity() instanceof Player ? null : event.getEntityType()), 1);
        }


    }


}