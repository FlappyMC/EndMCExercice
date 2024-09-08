package fr.flappy.endmc.drivers;

import com.google.inject.Inject;

import java.io.IOException;
import java.util.UUID;

public class JsonDatabaseDriver implements DatabaseDriver {
    private final PlayerRepository playerRepository;
    private final JsonStorage storageGateway;

    @Inject
    public JsonDatabaseDriver(PlayerRepository playerRepository, JsonStorage storageGateway) {
        this.playerRepository = playerRepository;
        this.storageGateway = storageGateway;
    }

    @Override
    public void connect() {
        storageGateway.connect();
    }

    @Override
    public void disconnect() {
        storageGateway.disconnect();
    }

    @Override
    public int getPlayerMoney(UUID playerUUID) throws IOException {
        return playerRepository.getPlayerMoney(playerUUID);
    }

    @Override
    public void givePlayerMoney(UUID playerUUID, int amount) throws IOException {
        playerRepository.givePlayerMoney(playerUUID, amount);
    }
}