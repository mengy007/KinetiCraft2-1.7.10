package com.techmafia.mcmods.KinetiCraft2.tileentities;

import com.techmafia.mcmods.KinetiCraft2.tileentities.base.TileEntityKC2Powered;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by myang on 11/5/15.
 */
public class TileEntityKC2EnderKineticEnergyPylon extends TileEntityKC2Powered {
    public TileEntityKC2EnderKineticEnergyPylon() {
        super();
    }
    int searchRadius = 4;
    int energyNetworkUpdateTickInterval = 3;
    int networkUpdateTickCount = 3;
    public TileEntityKC2EnderKineticGenerator generatorTileEntity;

    @Override
    public int getMaxEnergyStored() {
        return 1000;
    }

    @Override
    public boolean canConnectEnergy(ForgeDirection from) {
        return false;
    }

    @Override
    public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {
        return 0;
    }

    @Override
    public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {
        return 0;
    }

    @Override
    public void updateEntity() {
        if (generatorTileEntity != null) {
            generatorTileEntity.receiveEnergy(null, getMaxEnergyStored(), false);
        }

        //if (generatorTileEntity == null && networkUpdateTickCount >= energyNetworkUpdateTickInterval) {
            generatorSearch:
            for (int x = (xCoord - searchRadius); x < (xCoord + searchRadius); x++) {
                for (int z = (zCoord - searchRadius); z < (zCoord + searchRadius); z++) {
                    TileEntity te = worldObj.getTileEntity(x, yCoord, z);

                    if (te != null && te instanceof TileEntityKC2EnderKineticGenerator) {
                        generatorTileEntity = (TileEntityKC2EnderKineticGenerator) te;
                        break generatorSearch;
                    }
                }
            }
            //networkUpdateTickCount = 0;
        //}

        //networkUpdateTickCount++;
    }
}
