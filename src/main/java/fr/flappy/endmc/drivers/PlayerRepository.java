package fr.flappy.endmc.drivers;

import com.google.inject.Inject;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

public class PlayerRepository {
    private final JsonStorage jsonStorage;
    private final PlayerMapper playerMapper;

    @Inject
    public PlayerRepository(JsonStorage jsonStorage, PlayerMapper playerMapper) {
        this.jsonStorage = jsonStorage;
        this.playerMapper = playerMapper;
    }

    public int getPlayerMoney(UUID playerUUID) throws IOException {
        String json = jsonStorage.read();
        Map<UUID, Integer> playerData = playerMapper.toPlayer(json);
        return playerData.getOrDefault(playerUUID, 0);
    }

    public void givePlayerMoney(UUID playerUUID, int amount) throws IOException {
        String json = jsonStorage.read();
        Map<UUID, Integer> playerData = playerMapper.toPlayer(json);
        playerData.put(playerUUID, playerData.getOrDefault(playerUUID, 0) + amount);
        jsonStorage.write(playerMapper.toJson(playerData));
    }
}
