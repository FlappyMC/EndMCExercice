package fr.flappy.endmc.services;

import org.bukkit.Bukkit;

import java.util.UUID;

public class DatabaseServices {
    public String getPlayerName(UUID uuid){
        return Bukkit.getOfflinePlayer(uuid).getName();
    }
}