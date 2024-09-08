package fr.flappy.endmc;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import fr.flappy.endmc.commands.CommandInitializer;
import fr.flappy.endmc.utils.ExerciseModule;
import org.bukkit.plugin.java.JavaPlugin;

public class ExercisePlugin extends JavaPlugin {
    private Injector injector;

    @Inject
    private CommandInitializer commandInitializer;

    @Override
    public void onEnable() {
        injector = Guice.createInjector(new ExerciseModule(this));
        commandInitializer.initializeCommands();
    }

    @Override
    public void onDisable(){
        //TODO: Plugin shutdown logic, like saving players data
    }
}
