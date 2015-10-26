package com.techmafia.mcmods.KinetiCraft2.tileentities;

import com.techmafia.mcmods.KinetiCraft2.tileentities.base.TileEntityKC2Powered;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by myang on 10/24/15.
 */
public class TileEntityKC2Treadmill extends TileEntityKC2Powered {
    private static final int basePowerOutput = 2;
    float treadmillSpeed = 0.0f;
    boolean playerMounted = false;
    EntityPlayer mountedEntity;

    public TileEntityKC2Treadmill() {
        super();
    }

    @Override
    public void updateEntity() {

    }

    @Override
    public int getMaxEnergyStored() {
        return 10000;
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);

        nbt.setFloat("treadmillSpeed", treadmillSpeed);
        nbt.setBoolean("playerMounted", playerMounted);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);

        treadmillSpeed = nbt.getFloat("treadmillSpeed");
        playerMounted = nbt.getBoolean("playerMounted");
    }


}
