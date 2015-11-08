package com.techmafia.mcmods.KinetiCraft2.handlers;

import com.techmafia.mcmods.KinetiCraft2.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by Meng on 7/27/2015.
 */
public class ConfigurationHandler {
    public static Configuration configuration;

    public static int kineticEnergyCubeMaxEnergy = 400000;
    public static int hardenedKineticEnergyCubeMaxEnergy = 2000000;

    public static void init(File configFile) {
        /* Create the config file if it does not exist */
        if (configuration == null) {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    public static void loadConfiguration() {
        /* Energy Cubes */
        kineticEnergyCubeMaxEnergy = configuration.getInt(
                "kineticEnergyCubeMaxEnergy",
                Configuration.CATEGORY_GENERAL,
                400000,
                1,
                2000000000,
                "Kinetic Energy Cube Max Energy"
        );
        hardenedKineticEnergyCubeMaxEnergy = configuration.getInt(
                "hardenedKineticEnergyCubeMaxEnergy",
                Configuration.CATEGORY_GENERAL,
                2000000,
                1,
                2000000000,
                "Hardened Kinetic Energy Cube Max Energy"
        );

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID)) {
            this.loadConfiguration();
        }
    }
}
