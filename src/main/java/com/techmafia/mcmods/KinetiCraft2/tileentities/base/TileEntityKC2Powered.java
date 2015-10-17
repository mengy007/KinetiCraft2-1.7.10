package com.techmafia.mcmods.KinetiCraft2.tileentities.base;

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyHandler;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Meng on 10/16/2015.
 */
public abstract class TileEntityKC2Powered extends TileEntityKC2Base implements IEnergyHandler {
    public static float energyPerRF = 1f;

    protected boolean m_ReceivesEnergy = true;
    protected boolean m_ProvidesEnergy = true;

    // Internal power
    private EnergyStorage energyStorage;

    public TileEntityKC2Powered() {
        super();

        energyStorage = new EnergyStorage(getMaxEnergyStored());
    }

    // Internal energy methods
    /**
     * The amount of energy stored in this type of TileEntity
     * @return The amount of energy stored. 0 or more. Only called at construction time.
     */
    protected abstract int getMaxEnergyStored();

    @Override
    public boolean isActive() {
        return true;
    }

    // TileEntity overrides
    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);

        if (tag.hasKey("energyStorage")) {
            this.energyStorage.readFromNBT(tag.getCompoundTag("energyStorage"));
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        NBTTagCompound energyTag = new NBTTagCompound();
        this.energyStorage.writeToNBT(energyTag);
        tag.setTag("energyStorage", energyTag);
    }

    // TileEntity methods
    @Override
    public void updateEntity() {
        super.updateEntity();
    }

    // TileEntityKC2Base methods
    @Override
    protected void onSendUpdate(NBTTagCompound updateTag) {
        super.onSendUpdate(updateTag);
        NBTTagCompound energyTag = new NBTTagCompound();
        this.energyStorage.writeToNBT(energyTag);
        updateTag.setTag("energyStorage", energyTag);
    }

    @Override
    public void onReceiveUpdate(NBTTagCompound updateTag) {
        super.onReceiveUpdate(updateTag);
        this.energyStorage.readFromNBT(updateTag.getCompoundTag("energyStorage"));
    }

    /* IEnergyHandler */
    @Override
    public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {
        if (!m_ReceivesEnergy) { return 0; }
        return energyStorage.receiveEnergy(maxReceive, simulate);
    }

    @Override
    public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {
        if(!m_ProvidesEnergy) { return 0; }
        return energyStorage.extractEnergy(maxExtract, simulate);
    }

    @Override
    public boolean canConnectEnergy(ForgeDirection from) {
        return true;
    }

    @Override
    public int getEnergyStored(ForgeDirection from) {

        return energyStorage.getEnergyStored();
    }

    @Override
    public int getMaxEnergyStored(ForgeDirection from) {
        return energyStorage.getMaxEnergyStored();
    }
}