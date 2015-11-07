package com.techmafia.mcmods.KinetiCraft2.tileentities;

import com.techmafia.mcmods.KinetiCraft2.tileentities.base.TileEntityKC2Powered;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.ForgeDirection;
import org.apache.commons.compress.compressors.z.ZCompressorInputStream;

import java.util.List;

/**
 * Created by Meng on 10/25/2015.
 */
public class TileEntityKC2Treadmill extends TileEntityKC2Powered {
    private static final int powerOutputMultiplier = 1;
    private static final int acceleration = 1;
    private static final int maxSpeed = 40;
    protected int entityId;
    protected EntityLiving latchedEntity;

    int treadmillSpeed = 0;
    boolean isMounted = false;

    int ticksBetweenChecks = 3;
    int tickCount = 3;

    public boolean resync;

    public TileEntityKC2Treadmill() {
        super();
        resync = false;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);

        nbt.setInteger("treadmillSpeed", treadmillSpeed);
        nbt.setBoolean("isMounted", isMounted);
        nbt.setInteger("entityId", entityId);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);

        treadmillSpeed = nbt.getInteger("treadmillSpeed");
        isMounted = nbt.getBoolean("isMounted");
        entityId = nbt.getInteger("entityId");

        resync = true;
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        readFromNBT(pkt.func_148857_g());
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        writeToNBT(tag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, tag);
    }

    @Override
    public void updateEntity() {
        super.updateEntity();

        if(resync) {
            if(entityId != -1) {
                if(worldObj.isRemote) {
                    Entity ent = worldObj.getEntityByID(entityId);
                    if(ent != null && ent.getDistance(xCoord+0.5D, yCoord + 1D, zCoord+0.5D) < 7D) {
                        latchedEntity = (EntityLiving)ent;
                    }
                } else {
                    scanForEntity();
                }
            } else if(latchedEntity != null) {
                latchedEntity = null;
                worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
            }
        }
        resync = false;

        if (latchedEntity != null) {
            if (treadmillSpeed < maxSpeed) {
                treadmillSpeed++;
            }
            latchedEntity.setLocationAndAngles(xCoord+0.5D, yCoord+1.0D, zCoord+0.5D, -2 * 90F, 0.0F);
            latchedEntity.setAIMoveSpeed((float)(treadmillSpeed/maxSpeed));
            latchedEntity.getNavigator().clearPathEntity();

            if (treadmillSpeed > 0) {
                int powerToAdd = powerOutputMultiplier * treadmillSpeed;
                receiveEnergy(null, powerToAdd, false);

                if (getEnergyStored(null) >= getMaxEnergyStored()) {
                    launchVillager();
                }
            }
        } else {
            if (!isMounted && tickCount >= ticksBetweenChecks) {
                scanForEntity();
            }
        }
    }

    public void launchVillager() {
        latchedEntity.setVelocity(worldObj.rand.nextDouble(), worldObj.rand.nextDouble() * 3D, worldObj.rand.nextDouble());
        latchedEntity = null;
        isMounted = false;
        entityId = -1;
        resync = true;
        worldObj.spawnParticle("explosion", xCoord+0.5D, yCoord+1D, zCoord+0.5D, 0D, 0D, 0D);
    }

    public void scanForEntity() {
        AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox(xCoord - 0.175D, yCoord - 0.175D, zCoord - 0.175D, xCoord + 1.175D, yCoord + 1.175D, zCoord + 1.175D);
        List list = worldObj.getEntitiesWithinAABB(Entity.class, aabb);

        for (Object aList : list) {
            EntityLiving ent = (EntityLiving) aList;

            if (isValidForTreadmill(ent)) {
                if (ent.posX > aabb.minX && ent.posX < aabb.maxX && ent.posY > aabb.minY && ent.posY < aabb.maxY && ent.posZ > aabb.minZ && ent.posZ < aabb.maxZ) {
                    latchedEntity = ent;
                    latchedEntity.setLocationAndAngles(xCoord+0.5D, yCoord+1.0D, zCoord+0.5D, -2 * 90F, 0.0F);
                    isMounted = true;
                    entityId = latchedEntity.getEntityId();
                    worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
                    break;
                }
            }
        }
    }

    public boolean isValidForTreadmill(EntityLiving entity) {
        return entity.getClass().isAssignableFrom(EntityVillager.class);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getRenderBoundingBox() {
        return AxisAlignedBB.getBoundingBox(xCoord-2, yCoord-1, zCoord-2, xCoord+2, yCoord+1, zCoord+2);
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