package com.techmafia.mcmods.KinetiCraft2.tileentities;

import com.techmafia.mcmods.KinetiCraft2.tileentities.base.TileEntityKC2Powered;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Random;

/**
 * Created by myang on 11/5/15.
 */
public class TileEntityKC2ThermalKineticGenerator extends TileEntityKC2Powered {
    int ticksBetweenChecks = 3;
    int tickCount = 3;
    int powerOutputMultiplier = 0;
    int powerOutputBase = 25;
    int lavaRadius = 4;

    public TileEntityKC2ThermalKineticGenerator() {
        super();
    }

    @Override
    public int getMaxEnergyStored() {
        return 1000000;
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

    @Override
    public void updateEntity() {
        if (tickCount >= ticksBetweenChecks) {
            checkForLavaBlocks();
        }

        if (powerOutputMultiplier > 0) {
            receiveEnergy(null, powerOutputBase*powerOutputMultiplier, false);
            if (worldObj.isRemote) {
                Random randomGen = new Random();
                worldObj.spawnParticle(
                        "smoke",
                        (xCoord+0.5F)+((randomGen.nextFloat() * 0.5F) - 0.25F),
                        yCoord+0.9F,
                        (zCoord+0.5F)+((randomGen.nextFloat() * 0.5F) - 0.25F),
                        0.0D,
                        (randomGen.nextDouble()/128.0D)+(powerOutputMultiplier/64.0D),
                        0.0D);
            }
        }
    }

    public void checkForLavaBlocks() {
        powerOutputMultiplier = 0;
        for (int x = (xCoord-lavaRadius); x <= (xCoord+lavaRadius); x++) {
            for (int z = (zCoord-lavaRadius); z <= (zCoord+lavaRadius); z++) {
                if (worldObj.getBlock(x, yCoord, z).equals(Blocks.lava) && worldObj.getBlockMetadata(x, yCoord, z) == 0) {
                    powerOutputMultiplier++;
                }
            }
        }
    }
}
