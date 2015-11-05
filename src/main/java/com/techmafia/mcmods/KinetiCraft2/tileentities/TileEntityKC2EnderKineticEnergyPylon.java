package com.techmafia.mcmods.KinetiCraft2.tileentities;

import com.techmafia.mcmods.KinetiCraft2.tileentities.base.TileEntityKC2Powered;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Random;

/**
 * Created by myang on 11/5/15.
 */
public class TileEntityKC2EnderKineticEnergyPylon extends TileEntityKC2Powered {
    public TileEntityKC2EnderKineticEnergyPylon() {
        super();
    }
    int searchRadius = 4;
    int spawnRadius = 3;
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
            if (!generatorTileEntity.isFull()) {
                generatorTileEntity.receiveEnergy(null, getMaxEnergyStored(), false);
                Random randomGen = new Random();

                if (worldObj.isRemote) {
                    if (randomGen.nextInt(100) < 25) {
                        worldObj.spawnParticle("portal", xCoord + 0.5f, yCoord + 0.5f, zCoord + 0.5f, (randomGen.nextDouble() * 2.0D - 1.0D), (randomGen.nextDouble() * 2.0D - 1.0D), (randomGen.nextDouble() * 2.0D - 1.0D));
                    }

                    double motionX = (randomGen.nextDouble() * 2.0D) - 1.0D;
                    double motionY = -0.5D;
                    double motionZ = (randomGen.nextDouble() * 2.0D) - 1.0D;

                    if (generatorTileEntity.xCoord > xCoord) {
                        motionX -= (generatorTileEntity.xCoord - xCoord);
                    } else if (generatorTileEntity.xCoord < xCoord) {
                        motionX += ((xCoord - generatorTileEntity.xCoord));
                    }

                    if (generatorTileEntity.zCoord > zCoord) {
                        motionZ -= (generatorTileEntity.zCoord - zCoord);
                    } else if (generatorTileEntity.zCoord < zCoord) {
                        motionZ += (zCoord - generatorTileEntity.zCoord);
                    }

                    worldObj.spawnParticle(
                            "portal",
                            generatorTileEntity.xCoord + 0.5f,
                            generatorTileEntity.yCoord + 0.5f,
                            generatorTileEntity.zCoord + 0.5f,
                            motionX,
                            motionY,
                            motionZ
                    );
                } else {
                    if ((randomGen.nextDouble() * 100.0D) < 0.5D) {
                        Entity enderman = new EntityEnderman(worldObj);
                        enderman.setPosition(xCoord + (randomGen.nextInt(spawnRadius * 2) - spawnRadius), yCoord + 1, zCoord + (randomGen.nextInt(spawnRadius * 2) - spawnRadius));
                        worldObj.spawnEntityInWorld(enderman);
                    }
                }
            }
        }

        if (networkUpdateTickCount >= energyNetworkUpdateTickInterval) {
            if (generatorTileEntity == null) {
                generatorSearch:
                for (int x = (xCoord - searchRadius); x <= (xCoord + searchRadius); x++) {
                    for (int z = (zCoord - searchRadius); z <= (zCoord + searchRadius); z++) {
                        TileEntity te = worldObj.getTileEntity(x, yCoord, z);

                        if (te != null && te instanceof TileEntityKC2EnderKineticGenerator) {
                            generatorTileEntity = (TileEntityKC2EnderKineticGenerator) te;
                            break generatorSearch;
                        }
                    }
                }
            } else {
                TileEntity te = worldObj.getTileEntity(generatorTileEntity.xCoord, generatorTileEntity.yCoord, generatorTileEntity.zCoord);
                if (te == null) {
                    generatorTileEntity = null;
                }
            }
            networkUpdateTickCount = 0;
        }

        networkUpdateTickCount++;
    }
}
