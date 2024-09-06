package fr.flappy.endmc.services;

import com.google.inject.Inject;
import org.bukkit.entity.Player;

public class PlayerServices {
    private final DatabaseServices databaseService;

    @Inject
    public PlayerServices(DatabaseServices databaseService) {
        this.databaseService = databaseService;
    }

    public String getPlayerInfo(Player player) {
        return "Player Info: " + databaseService.getPlayerName(player.getUniqueId());
    }
}