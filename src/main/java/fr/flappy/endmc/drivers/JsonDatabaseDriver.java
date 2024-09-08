package fr.flappy.endmc.drivers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class JsonDatabaseDriver implements DatabaseDriver {
    private final String filePath;
    private File jsonFile;

    @Inject
    public JsonDatabaseDriver(@Named("JsonFilePath") String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void connect() {
        File directory = new File(filePath).getParentFile();
        if (!directory.exists()) {
            try{
                directory.mkdirs();
                System.out.println("§aDIRECTORY CREATED"); //Log4j2 is not needed here, so I'm using System.out.println
            }catch(SecurityException e) {
                System.out.println("§cFAILED TO CREATE DIRECTORY " + e.getMessage()); //Log4j2 is not needed here, so I'm using System.out.println
            }
        }
        jsonFile = new File(filePath);
        if (!jsonFile.exists()) {
            try {
                boolean created = jsonFile.createNewFile();
                if (created) {
                    System.out.println("§aFILE CREATED");
                } else {
                    System.out.println("§eFILE ALREADY EXISTS"); // Log4j2 is not needed here, so I'm using System.out.println, could not else btw, but I know some projects want more logs than really needed
                }
            } catch (IOException e) {
                System.out.println("§cFAILED TO CREATE FILE " + e.getMessage()); //Log4j2 is not needed here, so I'm using System.out.println
            }
        }
    }

    @Override
    public void disconnect() {
        //TODO: save users information's from the cache, not the point of the exercise
    }

    @Override
    public int getPlayerMoney(UUID playerUUID) {
        try {
            String json = Files.readString(jsonFile.toPath());
            Gson gson = new Gson();
            Type type = new TypeToken<HashMap<UUID, Integer>>(){}.getType();
            Map<UUID, Integer> data = gson.fromJson(json, type);
            return data.getOrDefault(playerUUID, 0);
        } catch (IOException e) {
            System.out.println("§cFAILED TO READ FILE " + e.getMessage()); //Log4j2 is not needed here, so I'm using System.out.println
            return 0;
        }
    }

    @Override
    public void givePlayerMoney(UUID playerUUID, int amount) {
        try {
            String json = Files.readString(jsonFile.toPath());
            Gson gson = new Gson();
            Type type = new TypeToken<HashMap<UUID, Integer>>(){}.getType();
            Map<UUID, Integer> data = gson.fromJson(json, type);
            if(data == null || data.isEmpty()){
                data = new HashMap<>();
            }
            data.put(playerUUID, data.getOrDefault(playerUUID, 0) + amount);
            Files.writeString(jsonFile.toPath(), gson.toJson(data));
        } catch (IOException e) {
            System.out.println("§cFAILED TO READ FILE " + e.getMessage());
        }
    }
}
