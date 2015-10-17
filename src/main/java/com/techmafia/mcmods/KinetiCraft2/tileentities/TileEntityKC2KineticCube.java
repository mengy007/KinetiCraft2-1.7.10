package com.techmafia.mcmods.KinetiCraft2.tileentities;

import com.techmafia.mcmods.KinetiCraft2.tileentities.base.TileEntityKC2Powered;

/**
 * Created by Meng on 10/16/2015.
 */
public class TileEntityKC2KineticCube extends TileEntityKC2Powered {
    public TileEntityKC2KineticCube() {
        super();

    }

    @Override
    public int getMaxEnergyStored() {
        return 100000;
    }
}
