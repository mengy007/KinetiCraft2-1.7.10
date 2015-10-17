package com.techmafia.mcmods.KinetiCraft2.init;

import com.techmafia.mcmods.KinetiCraft2.tileentities.TileEntityKC2StoneKineticCube;
import com.techmafia.mcmods.KinetiCraft2.tileentities.TileEntityKC2WoodenKineticCube;
import com.techmafia.mcmods.KinetiCraft2.tileentities.base.TileEntityKC2Powered;
import com.techmafia.mcmods.KinetiCraft2.utility.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by myang on 7/30/15.
 */
public class KinetiCraft2TileEntities {
    public static void init() {
        GameRegistry.registerTileEntity(TileEntityKC2WoodenKineticCube.class, "woodenKineticEnergyCube");
        GameRegistry.registerTileEntity(TileEntityKC2StoneKineticCube.class, "stoneKineticEnergyCube");

        LogHelper.info("Done registering tile entities!");
    }
}