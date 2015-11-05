package com.techmafia.mcmods.KinetiCraft2.init;

import com.techmafia.mcmods.KinetiCraft2.tileentities.*;
import com.techmafia.mcmods.KinetiCraft2.utility.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by myang on 7/30/15.
 */
public class KinetiCraft2TileEntities {
    public static void init() {
        GameRegistry.registerTileEntity(TileEntityKC2KineticEnergyCube.class, "leadstoneKineticEnergyCube");
        GameRegistry.registerTileEntity(TileEntityKC2HardenedKineticEnergyCube.class, "hardenedKineticEnergyCube");
        GameRegistry.registerTileEntity(TileEntityKC2ReinforcedKineticEnergyCube.class, "reinforcedKineticEnergyCube");
        GameRegistry.registerTileEntity(TileEntityKC2ResonantKineticEnergyCube.class, "resonantKineticEnergyCube");
        GameRegistry.registerTileEntity(TileEntityKC2KineticGenerator.class, "kineticGenerator");
        //GameRegistry.registerTileEntity(TileEntityKC2Treadmill.class, "kc2treadmill");

        LogHelper.info("Done registering tile entities!");
    }
}