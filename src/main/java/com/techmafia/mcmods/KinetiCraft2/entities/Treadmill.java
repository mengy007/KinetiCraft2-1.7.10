package com.techmafia.mcmods.KinetiCraft2.entities;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

/**
 * Created by Meng on 10/21/2015.
 */
public abstract class Treadmill extends Entity {
    float treadmillSpeed = 0.0f;

    public Treadmill(World world) {
        worldObj = world;
    }

    @Override
    public void entityInit() { }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbt) {
        nbt.setFloat("treadmillSpeed", treadmillSpeed);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbt) {
        treadmillSpeed = nbt.getFloat("treadmillSpeed");
    }

    public boolean canBeRidden() {
        return true;
    }

    @Override
    public boolean canRiderInteract() {
        return true;
    }
}
