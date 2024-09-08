package fr.flappy.endmc.drivers;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class JsonStorage{
    private final String filePath;
    private File jsonFile;

    @Inject
    public JsonStorage(@Named("JsonFilePath") String filePath) {
        this.filePath = filePath;
    }

    public void connect() {
        File directory = new File(filePath).getParentFile();
        if (!directory.exists()) {
            directory.mkdirs();
            System.out.println("§aDIRECTORY CREATED"); //Log4j2 is not needed here, so I'm using System.out.println
        }
        jsonFile = new File(filePath);
        if (!jsonFile.exists()) {
            try {
                jsonFile.createNewFile();
                System.out.println("§aFILE CREATED");
            } catch (IOException e) {
                System.out.println("§cFAILED TO CREATE FILE " + e.getMessage()); //Log4j2 is not needed here, so I'm using System.out.println
            }
        }
    }

    public void write(String data) throws IOException {
        Files.writeString(jsonFile.toPath(), data);
    }

    public String read() throws IOException {
        return Files.readString(jsonFile.toPath());
    }

    public void disconnect() {
    }
}
