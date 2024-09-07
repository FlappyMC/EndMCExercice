package fr.flappy.endmc.guice;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import fr.flappy.endmc.drivers.DatabaseDriver;
import fr.flappy.endmc.drivers.JsonDatabaseDriver;
import org.bukkit.plugin.java.JavaPlugin;


public class ExerciseModule extends AbstractModule {
    private final JavaPlugin plugin;

    public ExerciseModule(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    protected void configure() {
        bind(JavaPlugin.class).toInstance(plugin);
        bind(DatabaseDriver.class).to(JsonDatabaseDriver.class);
        bind(String.class).annotatedWith(Names.named("JsonFilePath")).toInstance("plugins/EndMcExercise/users.json"); //could do one file for each player, but it's not the point of the exercise, I know it's better for large community
    }
}