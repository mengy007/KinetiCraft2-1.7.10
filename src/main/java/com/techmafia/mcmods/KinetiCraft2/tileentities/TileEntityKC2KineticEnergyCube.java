package com.techmafia.mcmods.KinetiCraft2.tileentities;

import com.techmafia.mcmods.KinetiCraft2.handlers.ConfigurationHandler;
import com.techmafia.mcmods.KinetiCraft2.tileentities.base.TileEntityKC2Powered;

/**
 * Created by Meng on 10/16/2015.
 */
public class TileEntityKC2KineticEnergyCube extends TileEntityKC2Powered {
    public TileEntityKC2KineticEnergyCube() {
        super();
    }

    @Override
    public int getMaxEnergyStored() {
        return ConfigurationHandler.kineticEnergyCubeMaxEnergy;//400000;
    }
}
