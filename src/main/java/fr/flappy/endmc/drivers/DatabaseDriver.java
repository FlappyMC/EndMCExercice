package fr.flappy.endmc.drivers;

import java.io.IOException;
import java.util.UUID;

public interface DatabaseDriver {
    void connect();
    void disconnect();
    int getPlayerMoney(UUID playerUUID) throws IOException;
    void givePlayerMoney(UUID playerUUID, int amount) throws IOException;
}