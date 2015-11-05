package com.techmafia.mcmods.KinetiCraft2.entities;

import com.techmafia.mcmods.KinetiCraft2.blocks.BlockKC2Treadmill;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

/**
 * Created by myang on 10/26/15.
 */
public class EntityKC2Treadmill extends Entity {
    public EntityKC2Treadmill(World world) {
        super(world);
        this.noClip = true;
        this.preventEntitySpawning = true;
        this.setSize(0.0F, 0.0F);
    }

    public EntityKC2Treadmill(World world, double x, double y, double z) {
        this(world);
        this.setPosition(x, y, z);
    }

    @Override
    public void entityInit() {

    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbt) {
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbt) {
    }

    @Override
    public boolean interactFirst(EntityPlayer p) {
        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.riddenByEntity != p) {
            return true;
        } else {
            if (!this.worldObj.isRemote) {
                p.mountEntity(this);
            }
            return true;
        }
    }


    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!(this.worldObj.getBlock(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) instanceof BlockKC2Treadmill)) this.kill();
    }

    @Override
    public void onEntityUpdate() {
        if (this.riddenByEntity == null || this.riddenByEntity.isDead) this.setDead();
        super.onEntityUpdate();
    }

    @Override
    public boolean canRiderInteract()
    {
        return false;
    }

    @Override
    public boolean shouldRiderSit()
    {
        return false;
    }

    @Override
    public double getMountedYOffset() {
        return 0.5D;
    }
}
