package com.techmafia.mcmods.KinetiCraft2.tileentities;

import com.techmafia.mcmods.KinetiCraft2.tileentities.base.TileEntityKC2Powered;

/**
 * Created by Meng on 10/18/2015.
 */
public class TileEntityKC2KineticGenerator extends TileEntityKC2Powered {
    public TileEntityKC2KineticGenerator() {
        super();
    }

    @Override
    public int getMaxEnergyStored() {
        return 50000;
    }
}
