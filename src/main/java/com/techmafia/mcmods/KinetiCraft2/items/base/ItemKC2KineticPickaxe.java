package com.techmafia.mcmods.KinetiCraft2.items.base;

import cofh.api.energy.IEnergyContainerItem;
import com.google.common.collect.Sets;
import com.techmafia.mcmods.KinetiCraft2.creativetab.CreativeTabKC2;
import com.techmafia.mcmods.KinetiCraft2.reference.Reference;
import com.techmafia.mcmods.KinetiCraft2.tileentities.base.TileEntityKC2Powered;
import com.techmafia.mcmods.KinetiCraft2.utility.ItemNBTHelper;
import com.techmafia.mcmods.KinetiCraft2.utility.NBTHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;
import java.util.Set;

/**
 * Created by myang on 10/20/15.
 */
public class ItemKC2KineticPickaxe extends ItemPickaxe implements IEnergyContainerItem {
    protected int capacity = 10000;
    protected int maxReceive = 1000;
    protected int maxExtract = 1000;
    protected int energyFromUsing = 10;
    protected int overChargeBuffer = 4;
    protected float overChargeDamage = 1.5f;

    public ItemKC2KineticPickaxe(ToolMaterial toolMaterial) {
        super(toolMaterial);
        setUnlocalizedName("kc2KineticPickaxe");
        setTextureName("kc2KineticPickaxe");
        setCreativeTab(CreativeTabKC2.KC2_TAB);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(Reference.MOD_NAME + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(":") + 1));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int par1) {
        return this.itemIcon;
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

    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "" + getEnergyStored(itemStack) + " / " + getMaxEnergyStored(itemStack) + " RF"));
        }
        return itemStack;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase entityLivingBase) {
        if (getEnergyStored(itemStack) == getMaxEnergyStored(itemStack)) {
            // Handle over charging
            if ( ! NBTHelper.hasTag(itemStack, "overCharge"))
            {
                NBTHelper.setInteger(itemStack, "overCharge", 0);
            }

            int overCharge = NBTHelper.getInt(itemStack, "overCharge");

            overCharge++;

            if (overCharge >= overChargeBuffer)
            {
                // KaBOOM!
                //((EntityPlayer)entityLivingBase).destroyCurrentEquippedItem();

                entityLivingBase.attackEntityFrom(DamageSource.generic, overChargeDamage);
                //entityLivingBase.playSound("random.explode", 1, 1);
            }

            NBTHelper.setInteger(itemStack, "overCharge", overCharge);
        } else {
            receiveEnergy(itemStack, energyFromUsing, false);
        }

        return super.onBlockDestroyed(itemStack, world, block, x, y, z, entityLivingBase);
    }

    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
        if (!world.isRemote) {
            TileEntity te = world.getTileEntity(x, y, z);

            if (te != null && te instanceof TileEntityKC2Powered) {
                int energyExtracted = ((TileEntityKC2Powered) te).receiveEnergy(null, extractEnergy(itemStack, maxExtract, true), false);
                extractEnergy(itemStack, energyExtracted, false);
                world.markBlockForUpdate(x, y, z);

                entityPlayer.addChatComponentMessage(new ChatComponentText(energyExtracted + " KE extracted. " + getEnergyStored(itemStack) + " KE remains."));
            }
        }

        return true;
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean par4) {
        super.addInformation(itemStack, entityPlayer, list, par4);

        list.add(EnumChatFormatting.GREEN + "" + getEnergyStored(itemStack) + " / " + getMaxEnergyStored(itemStack) + " KE");
    }
}
