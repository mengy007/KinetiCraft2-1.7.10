package com.techmafia.mcmods.KinetiCraft2.handlers;

import com.techmafia.mcmods.KinetiCraft2.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
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
    public static int reinforcedKineticEnergyCubeMaxEnergy = 20000000;
    public static int resonantKineticEnergyCubeMaxEnergy = 80000000;

    public static void loadConfig(File configFile) {
        configuration = new Configuration(configFile);

        configuration.load();
        load();

        FMLCommonHandler.instance().bus().register(new ChangeListener());
    }

    public static void load() {
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
        reinforcedKineticEnergyCubeMaxEnergy = configuration.getInt(
                "reinforcedKineticEnergyCubeMaxEnergy",
                Configuration.CATEGORY_GENERAL,
                20000000,
                1,
                2000000000,
                "Reinforced Kinetic Energy Cube Max Energy"
        );
        resonantKineticEnergyCubeMaxEnergy = configuration.getInt(
                "resonantKineticEnergyCubeMaxEnergy",
                Configuration.CATEGORY_GENERAL,
                80000000,
                1,
                2000000000,
                "Resonant Kinetic Energy Cube Max Energy"
        );

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }

    public static class ChangeListener {

        @SubscribeEvent
        public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
            if(eventArgs.modID.equals(Reference.MOD_ID))
                load();
        }

    }
}
