package com.techmafia.mcmods.KinetiCraft2.tileentities;

import com.techmafia.mcmods.KinetiCraft2.tileentities.base.TileEntityKC2Powered;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by myang on 11/5/15.
 */
public class TileEntityKC2EnderKineticGenerator extends TileEntityKC2Powered {
    public TileEntityKC2EnderKineticGenerator() {
        super();
    }

    @Override
    public int getMaxEnergyStored() {
        return 10000000;
    }

    @Override
    public boolean canConnectEnergy(ForgeDirection from) {
        return (from != ForgeDirection.UP);
    }

    @Override
    public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {
        if(!m_ProvidesEnergy || (from == ForgeDirection.UP)) { return 0; }
        return energyStorage.extractEnergy(maxExtract, simulate);
    }
}
