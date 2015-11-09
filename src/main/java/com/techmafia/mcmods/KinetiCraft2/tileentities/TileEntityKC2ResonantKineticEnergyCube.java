package com.techmafia.mcmods.KinetiCraft2.tileentities;

import com.techmafia.mcmods.KinetiCraft2.handlers.ConfigurationHandler;
import com.techmafia.mcmods.KinetiCraft2.tileentities.base.TileEntityKC2Powered;

/**
 * Created by Meng on 10/18/2015.
 */
public class TileEntityKC2ResonantKineticEnergyCube extends TileEntityKC2Powered {
    public TileEntityKC2ResonantKineticEnergyCube() {
        super();
    }

    @Override
    public int getMaxEnergyStored() {
        return ConfigurationHandler.reinforcedKineticEnergyCubeMaxEnergy;//80000000;
    }
}
