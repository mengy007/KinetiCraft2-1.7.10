package com.techmafia.mcmods.KinetiCraft2.tileentities;

import com.techmafia.mcmods.KinetiCraft2.handlers.ConfigurationHandler;
import com.techmafia.mcmods.KinetiCraft2.tileentities.base.TileEntityKC2Powered;

/**
 * Created by Meng on 10/17/2015.
 */
public class TileEntityKC2HardenedKineticEnergyCube extends TileEntityKC2Powered {
    public TileEntityKC2HardenedKineticEnergyCube() {
        super();
    }

    @Override
    public int getMaxEnergyStored() {
        return ConfigurationHandler.hardenedKineticEnergyCubeMaxEnergy;//2000000;
    }
}