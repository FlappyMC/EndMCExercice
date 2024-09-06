package fr.flappy.endmc.commands;

import com.google.inject.Inject;
import fr.flappy.endmc.services.PlayerServices;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerCommand implements CommandExecutor {
    private final PlayerServices playerService;

    @Inject
    public PlayerCommand(PlayerServices playerService) {
        this.playerService = playerService;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            String info = playerService.getPlayerInfo(player);
            player.sendMessage(info);
            return true;
        }
        return false;
    }
}