package com.devflask.statisticslib.lib.commands;

import com.devflask.statisticslib.lib.main.PlayerStatistics;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public record ReloadCommand(PlayerStatistics plugin) implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        commandSender.sendMessage("§d[PlayerStatisticsLib] Reloading config.yml...");
        plugin.getConfigManager().reloadConfig();
        return true;
    }
}