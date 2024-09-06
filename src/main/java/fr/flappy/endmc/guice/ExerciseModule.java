package fr.flappy.endmc.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import fr.flappy.endmc.services.DatabaseServices;
import fr.flappy.endmc.services.PlayerServices;
import org.bukkit.plugin.java.JavaPlugin;

public class ExerciseModule extends AbstractModule {
    private JavaPlugin plugin;

    @Override
    protected void configure(){
        bind(JavaPlugin.class).toInstance(plugin);
        bind(PlayerServices.class).in(Singleton.class);
        bind(DatabaseServices.class).in(Singleton.class);
    }
}
