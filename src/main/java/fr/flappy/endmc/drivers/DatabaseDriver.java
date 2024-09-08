package fr.flappy.endmc.drivers;

import java.util.UUID;

public interface DatabaseDriver {
    void connect();
    void disconnect();
    int getPlayerMoney(UUID playerUUID);
    void givePlayerMoney(UUID playerUUID, int amount);
}