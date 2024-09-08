package fr.flappy.endmc.commands;

import com.google.inject.Inject;
import fr.flappy.endmc.services.PlayerServices;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveToPlayerCommand implements CommandExecutor {
    private final PlayerServices playerService;

    @Inject
    public GiveToPlayerCommand(PlayerServices playerService) {
        this.playerService = playerService;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Player player = (Player) sender;

        if (args.length == 1) {
            try {
                int amount = Integer.parseInt(args[0]);
                playerService.givePlayerMoney(player, amount);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        player.sendMessage("Usage: /givetoplayer <amount>"); // or use the usage bukkit-api method but i prefer creating my own helper messages
        return false;
    }
}