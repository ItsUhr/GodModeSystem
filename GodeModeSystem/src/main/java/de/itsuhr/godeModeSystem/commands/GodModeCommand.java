package de.itsuhr.godeModeSystem.commands;

import de.itsuhr.godeModeSystem.GodeModeSystem;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

public class GodModeCommand implements CommandExecutor, TabCompleter {

    private final GodeModeSystem system;

    public GodModeCommand(GodeModeSystem system) {
        this.system = system;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        FileConfiguration config = YamlConfiguration.loadConfiguration(system.getFileConfig());
        if (!(sender instanceof Player player)) {
            sender.sendMessage(setMessage(config.getString("messages.not_a_player")));
            return true;
        }

        String permission = config.getString("permissions.use_godmode");
        if (permission != null && !player.hasPermission(permission)) {
            player.sendMessage(setMessage(config.getString("messages.no_permission")));
            return true;
        }

        if (args.length > 1) {
            player.sendMessage(setMessage(config.getString("messages.wrong_usage")));
            return true;
        }

        if (args.length == 0) {
            if (player.isInvulnerable()) {
                player.setInvulnerable(false);
                player.sendMessage(setMessage(config.getString("messages.godmode_disabled_self")));
                return true;
            }
            player.setInvulnerable(true);
            player.setHealth(20.0);
            player.setFoodLevel(20);
            player.sendMessage(setMessage(config.getString("messages.godmode_enabled_self")));
            return true;
        }

        Player target = system.getServer().getPlayer(args[0]);

        if (target == null) {
            player.sendMessage(setMessage(config.getString("messages.player_not_found").replace("%target%", args[0])));
            return true;
        }

        if (target.isInvulnerable()) {
            target.setInvulnerable(false);
            target.sendMessage(setMessage(config.getString("messages.target_godmode_disabled")));
            player.sendMessage(setMessage(config.getString("messages.godmode_disabled_other").replace("%target%", args[0])));
            return true;
        }
        target.setInvulnerable(true);
        target.setHealth(20.0);
        target.setFoodLevel(20);
        target.sendMessage(setMessage(config.getString("messages.target_godmode_enabled")));
        player.sendMessage(setMessage(config.getString("messages.godmode_enabled_other").replace("%target%", args[0])));
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            if (args.length == 1) {
                return system.getServer().getOnlinePlayers().stream().map(Player::getName).toList();
            }
        }
        return Collections.emptyList();
    }

    private String setMessage(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
