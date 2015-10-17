package com.techmafia.mcmods.KinetiCraft2.tileentities.base;

import cofh.core.block.TileCoFHBase;
import com.techmafia.mcmods.KinetiCraft2.net.CommonPacketHandler;
import com.techmafia.mcmods.KinetiCraft2.net.messages.DeviceUpdateMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;

import javax.xml.stream.events.EntityReference;

/**
 * Created by Meng on 10/16/2015.
 */
public abstract class TileEntityKC2Base extends TileCoFHBase {
    public TileEntityKC2Base() {
        super();
    }

    // Save/Load
    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
    }

    // Network Communication
    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tagCompound = new NBTTagCompound();
        this.writeToNBT(tagCompound);

        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, tagCompound);
    }

    @Override
    public void onDataPacket(NetworkManager network, S35PacketUpdateTileEntity packet) {
        this.readFromNBT(packet.func_148857_g());
    }

    @Override
    public void updateEntity() {
        super.updateEntity();
    }

    // Return true if machine is active
    public abstract boolean isActive();

    protected IMessage getUpdatePacket() {
        NBTTagCompound childData = new NBTTagCompound();
        onSendUpdate(childData);

        return new DeviceUpdateMessage(xCoord, yCoord, zCoord, childData);
    }

    private void sendUpdatePacketToClient(EntityPlayer recipient) {
        if (this.worldObj.isRemote) { return; }

        CommonPacketHandler.INSTANCE.sendTo(getUpdatePacket(), (EntityPlayerMP)recipient);
    }

    protected void onSendUpdate(NBTTagCompound updateTag) {}

    protected void onReceiveUpdate(NBTTagCompound updateTag) {}

    // Stuff from TileCoFHBase
    public String getName() {
        return this.getBlockType().getUnlocalizedName();
    }

    public int getType() {
        return getBlockMetadata();
    }
}
