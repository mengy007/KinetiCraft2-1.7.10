package com.techmafia.mcmods.KinetiCraft2.tileentities;

import com.techmafia.mcmods.KinetiCraft2.tileentities.base.TileEntityKC2Powered;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Meng on 10/25/2015.
 */
public class TileEntityKC2Treadmill extends TileEntityKC2Powered {
    private static final int powerOutputMultiplier = 2;
    private static final int acceleration = 1;
    private static final int maxSpeed = 20;

    int treadmillSpeed = 0;
    boolean isMounted = false;

    public TileEntityKC2Treadmill() {
        super();
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);

        nbt.setInteger("treadmillSpeed", treadmillSpeed);
        nbt.setBoolean("isMounted", isMounted);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);

        treadmillSpeed = nbt.getInteger("treadmillSpeed");
        isMounted = nbt.getBoolean("isMounted");
    }

    @Override
    public void updateEntity() {
        super.updateEntity();

        if (treadmillSpeed > 0) {
            int powerToAdd = powerOutputMultiplier * treadmillSpeed;
            receiveEnergy(null, powerToAdd, false);
        }
    }

    @Override
    public boolean canTransmitPower(ForgeDirection dir) {
        return dir != ForgeDirection.UP;
    }

    @Override
    public int getMaxEnergyStored() {
        return 10000;
    }
}
