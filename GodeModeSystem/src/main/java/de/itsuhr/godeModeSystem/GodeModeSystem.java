package de.itsuhr.godeModeSystem;

import de.itsuhr.godeModeSystem.commands.GodModeCommand;
import de.itsuhr.godeModeSystem.loader.ConsoleLoader;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class GodeModeSystem extends JavaPlugin {

    private final File fileConfig = new File(this.getDataFolder(), "config.yml");

    private ConsoleLoader consoleLoader;

    @Override
    public void onEnable() {
        this.consoleLoader = new ConsoleLoader();
        this.createFile(fileConfig);
        this.getCommand("godmode").setExecutor(new GodModeCommand(this));
        getServer().getOnlinePlayers().forEach(players -> {
            players.sendMessage("§7[§b§lGodModeSystem§7] §aWurde Neugeladen!");
        });
        consoleLoader.startConsole(this.getServer().getConsoleSender());
    }

    @Override
    public void onDisable() {
        getServer().getOnlinePlayers().forEach(players -> {
            players.sendMessage("§7[§b§lGodModeSystem§7] §cWurde entladen!");
        });
        consoleLoader.stopConsole(this.getServer().getConsoleSender());
    }

    private void createFile(File file) {
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        if (!file.exists()) {
            try {
                this.saveResource("config.yml", false);
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public File getFileConfig() {
        return fileConfig;
    }
}
