package fr.flappy.endmc.commands;

import com.google.inject.Inject;
import org.bukkit.command.CommandExecutor;
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

    private void registerCommand(final String name, final CommandExecutor executor){
        plugin.getCommand(name).setExecutor(executor);
    }

    public void initializeCommands() {
        registerCommand("player", playerCommand);
        registerCommand("givetoplayer", giveToPlayerCommand);
    }
}