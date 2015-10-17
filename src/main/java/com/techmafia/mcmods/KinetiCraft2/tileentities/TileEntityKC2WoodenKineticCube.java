package com.techmafia.mcmods.KinetiCraft2.tileentities;

import com.techmafia.mcmods.KinetiCraft2.tileentities.base.TileEntityKC2Powered;

/**
 * Created by Meng on 10/16/2015.
 */
public class TileEntityKC2WoodenKineticCube extends TileEntityKC2Powered {
    public TileEntityKC2WoodenKineticCube() {
        super();
    }

    @Override
    public int getMaxEnergyStored() {
        return 100000;
    }
}
