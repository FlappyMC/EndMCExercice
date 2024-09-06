package fr.flappy.endmc.commands;

import com.google.inject.Inject;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandInitializer {
    private final JavaPlugin plugin;
    private final PlayerCommand playerCommand;

    @Inject
    public CommandInitializer(JavaPlugin plugin, PlayerCommand playerCommand) {
        this.plugin = plugin;
        this.playerCommand = playerCommand;
    }

    public void initializeCommands() {
        plugin.getCommand("player").setExecutor(playerCommand);
    }
}