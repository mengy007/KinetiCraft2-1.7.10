package com.techmafia.mcmods.KinetiCraft2.tileentities;

import com.techmafia.mcmods.KinetiCraft2.tileentities.base.TileEntityKC2Powered;

/**
 * Created by Meng on 10/17/2015.
 */
public class TileEntityKC2StoneKineticCube  extends TileEntityKC2Powered {
    public TileEntityKC2StoneKineticCube() {
        super();
    }

    @Override
    public int getMaxEnergyStored() {
        return 1000000;
    }
}