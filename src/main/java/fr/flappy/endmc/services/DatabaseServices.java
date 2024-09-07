package fr.flappy.endmc.services;

import com.google.inject.Inject;
import fr.flappy.endmc.drivers.DatabaseDriver;

import java.util.UUID;

public class DatabaseServices {
    private final DatabaseDriver driver;

    @Inject
    public DatabaseServices(DatabaseDriver driver) {
        this.driver = driver;
    }

    public int getPlayerMoney(UUID playerUUID) {
        driver.connect();
        int data = driver.getPlayerMoney(playerUUID);
        driver.disconnect();
        return data;
    }
}