package com.techmafia.mcmods.KinetiCraft2.items;

import cofh.api.energy.IEnergyContainerItem;
import com.techmafia.mcmods.KinetiCraft2.creativetab.CreativeTabKC2;
import com.techmafia.mcmods.KinetiCraft2.items.base.ItemKC2Base;
import com.techmafia.mcmods.KinetiCraft2.utility.ItemNBTHelper;
import com.techmafia.mcmods.KinetiCraft2.utility.NBTHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Meng on 10/17/2015.
 */
public class ItemKC2Powered extends ItemKC2Base implements IEnergyContainerItem {
    private int capacity = 0;
    private int maxReceive = 0;
    private int maxExtract = 0;

    public ItemKC2Powered() {
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabKC2.KC2_TAB);
    }

    /* Energy */
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public void setMaxReceive(int maxReceive) { this.maxReceive = maxReceive; }

    public void setMaxExtract(int maxExtract) { this.maxExtract = maxExtract; }

    public int getCapacity(ItemStack itemStack) { return capacity; }

    public int getMaxExtract(ItemStack itemStack) { return maxExtract; }

    public int getMaxReceive(ItemStack itemStack) { return maxReceive; }

    @Override
    public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {
        int energy = ItemNBTHelper.getInteger(container, "Energy", 0);
        int energyReceived = Math.min(getCapacity(container) - energy, Math.min(getMaxReceive(container), maxReceive));

        if (!simulate) {
            energy += energyReceived;
            ItemNBTHelper.setInteger(container, "Energy", energy);
        }
        return energyReceived;
    }

    @Override
    public int extractEnergy(ItemStack container, int maxExtract, boolean simulate) {

        int energy = ItemNBTHelper.getInteger(container, "Energy", 0);
        int energyExtracted = Math.min(energy, Math.min(getMaxExtract(container), maxExtract));

        if (!simulate) {
            energy -= energyExtracted;
            ItemNBTHelper.setInteger(container, "Energy", energy);
        }
        return energyExtracted;
    }

    @Override
    public int getEnergyStored(ItemStack container) {
        return ItemNBTHelper.getInteger(container, "Energy", 0);
    }

    @Override
    public int getMaxEnergyStored(ItemStack container) {
        return getCapacity(container);
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return !(getEnergyStored(stack) == getMaxEnergyStored(stack));
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack) {
        return 1D - ((double)getEnergyStored(stack) / (double)getMaxEnergyStored(stack));
    }

    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unchecked")
    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        list.add(ItemNBTHelper.setInteger(new ItemStack(item, 1, 0), "Energy", 0));
        if (capacity > 0)list.add(ItemNBTHelper.setInteger(new ItemStack(item, 1, 0), "Energy", capacity));
    }

    @Override
    public boolean getHasSubtypes() {
        return capacity > 0;
    }
}
