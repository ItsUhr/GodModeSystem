package de.itsuhr.godeModeSystem.loader;

import org.bukkit.command.ConsoleCommandSender;

public class ConsoleLoader {

    public void startConsole(ConsoleCommandSender consoleCommandSender) {
        consoleCommandSender.sendMessage("§e------------§6<< §b§lGodModeSystem §6>>§e------------");
        consoleCommandSender.sendMessage("");
        consoleCommandSender.sendMessage("§6Author: §5ItsUhr");
        consoleCommandSender.sendMessage("§eVersion: §d1.21");
        consoleCommandSender.sendMessage("§aDas Plugin wurde §2Aktiviert§a!");
        consoleCommandSender.sendMessage("");
        consoleCommandSender.sendMessage("§e------------§6<< §b§lGodModeSystem §6>>§e------------");
    }

    public void stopConsole(ConsoleCommandSender consoleCommandSender) {
        consoleCommandSender.sendMessage("§e------------§6<< §b§lGodModeSystem §6>>§e------------");
        consoleCommandSender.sendMessage("");
        consoleCommandSender.sendMessage("§6Author: §5ItsUhr");
        consoleCommandSender.sendMessage("§eVersion: §d1.21");
        consoleCommandSender.sendMessage("§cDas Plugin wurde §4Deaktiviert§c!");
        consoleCommandSender.sendMessage("");
        consoleCommandSender.sendMessage("§e------------§6<< §b§lGodModeSystem §6>>§e------------");
    }

}
