package fr.flappy.endmc.drivers;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerMapper {
    private final Gson gson;

    public PlayerMapper(Gson gson) {
        this.gson = gson;
    }

    public Map<UUID, Integer> toPlayer(String json){
        Type type = new TypeToken<HashMap<UUID, Integer>>(){}.getType();
        return gson.fromJson(json, type);
    }

    public String toJson(Map<UUID, Integer> playerData){
        return gson.toJson(playerData);
    }
}
