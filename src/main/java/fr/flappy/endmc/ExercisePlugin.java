package fr.flappy.endmc;

import com.google.inject.Guice;
import com.google.inject.Injector;
import fr.flappy.endmc.commands.CommandInitializer;
import fr.flappy.endmc.guice.ExerciseModule;
import org.bukkit.plugin.java.JavaPlugin;

public class ExercisePlugin extends JavaPlugin {

    @Override
    public void onEnable(){
        Injector injector = Guice.createInjector(new ExerciseModule());
        CommandInitializer commandInitializer = injector.getInstance(CommandInitializer.class);
        commandInitializer.initializeCommands();
    }

    @Override
    public void onDisable(){
        //TODO: Plugin shutdown logic
    }
}
