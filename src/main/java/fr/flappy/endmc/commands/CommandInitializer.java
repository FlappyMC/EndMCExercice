package fr.flappy.endmc.commands;

import com.google.inject.Inject;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandInitializer {
    private final JavaPlugin plugin;
    private final PlayerCommand playerCommand;
    private final GiveToPlayerCommand giveToPlayerCommand;

    @Inject
    public CommandInitializer(JavaPlugin plugin, PlayerCommand playerCommand, GiveToPlayerCommand giveToPlayerCommand) {
        this.plugin = plugin;
        this.playerCommand = playerCommand;
        this.giveToPlayerCommand = giveToPlayerCommand;
    }

    public void initializeCommands() {
        plugin.getCommand("player").setExecutor(playerCommand);
        plugin.getCommand("givetoplayer").setExecutor(giveToPlayerCommand);
    }
}