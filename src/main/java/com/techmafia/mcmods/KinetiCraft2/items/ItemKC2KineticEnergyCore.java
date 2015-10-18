package com.techmafia.mcmods.KinetiCraft2.items;

import com.techmafia.mcmods.KinetiCraft2.items.base.ItemKC2Powered;
import com.techmafia.mcmods.KinetiCraft2.reference.Reference;
import com.techmafia.mcmods.KinetiCraft2.tileentities.base.TileEntityKC2Powered;
import com.techmafia.mcmods.KinetiCraft2.utility.ItemNBTHelper;
import com.techmafia.mcmods.KinetiCraft2.utility.NBTHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Meng on 10/17/2015.
 */
public class ItemKC2KineticEnergyCore extends ItemKC2Powered {
    private IIcon[][] icons = new IIcon[4][6];

    private int[] subItemCapacity = new int[4];
    private int[] subItemMaxTransfer = new int[4];
    private int[] energyFromUsing = new int[4];
    private int[] energyFromMoving = new int[4];
    private int[] energyFromJumping = new int[4];
    private int[] overChargeBuffer = new int[4];
    private float[] damageFromOvercharge = new float[4];
    private float prevDistanceWalkedModified = 0;

    public ItemKC2KineticEnergyCore() {
        this.setUnlocalizedName("kineticEnergyCore");
        this.setHasSubtypes(true);
        this.setMaxStackSize(1);

        subItemCapacity[0] = 1000;
        subItemCapacity[1] = 10000;
        subItemCapacity[2] = 50000;
        subItemCapacity[3] = 100000;

        subItemMaxTransfer[0] = 100;
        subItemMaxTransfer[1] = 1000;
        subItemMaxTransfer[2] = 10000;
        subItemMaxTransfer[3] = 50000;

        energyFromUsing[0] = 1;
        energyFromUsing[1] = 10;
        energyFromUsing[2] = 50;
        energyFromUsing[3] = 200;

        energyFromMoving[0] = 1;
        energyFromMoving[1] = 5;
        energyFromMoving[2] = 25;
        energyFromMoving[3] = 100;

        energyFromJumping[0] = 1;
        energyFromJumping[1] = 10;
        energyFromJumping[2] = 50;
        energyFromJumping[3] = 200;

        overChargeBuffer[0] = 2;
        overChargeBuffer[1] = 4;
        overChargeBuffer[2] = 8;
        overChargeBuffer[3] = 10;

        damageFromOvercharge[0] = 1.0f;
        damageFromOvercharge[1] = 1.5f;
        damageFromOvercharge[2] = 2.0f;
        damageFromOvercharge[3] = 4.0f;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister iconRegister) {
        for (int i = 0; i < icons.length; i++) {
            for (int j = 0; j < 6; j++) {
                icons[i][j] = iconRegister.registerIcon(Reference.MOD_NAME + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(":") + 1) + i + "." + j);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIconFromDamage(int damage) {
        return icons[damage][5];
    }

    /*
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(ItemStack itemStack, int renderPass, EntityPlayer entityPlayer, ItemStack usingItemStack, int useRemaining) {
        int level = (getEnergyStored(itemStack)) / (getMaxEnergyStored(itemStack) / 5);

        //entityPlayer.addChatComponentMessage(new ChatComponentText(getDamage(itemStack) + "." + level + ": " + icons[getDamage(itemStack)][level].toString()));

        return icons[getDamage(itemStack)][level];
    }
    */

    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unchecked")
    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        list.add(ItemNBTHelper.setInteger(new ItemStack(item, 1, 0), "Energy", 0));
        list.add(ItemNBTHelper.setInteger(new ItemStack(item, 1, 0), "Energy", 1000));

        list.add(ItemNBTHelper.setInteger(new ItemStack(item, 1, 1), "Energy", 0));
        list.add(ItemNBTHelper.setInteger(new ItemStack(item, 1, 1), "Energy", 10000));

        list.add(ItemNBTHelper.setInteger(new ItemStack(item, 1, 2), "Energy", 0));
        list.add(ItemNBTHelper.setInteger(new ItemStack(item, 1, 2), "Energy", 50000));

        list.add(ItemNBTHelper.setInteger(new ItemStack(item, 1, 3), "Energy", 0));
        list.add(ItemNBTHelper.setInteger(new ItemStack(item, 1, 3), "Energy", 100000));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return super.getUnlocalizedName(itemStack)+itemStack.getItemDamage();
    }

    @Override
    public int getCapacity(ItemStack stack) {
        return stack.getItemDamage() < subItemCapacity.length ? subItemCapacity[stack.getItemDamage()] : 0;
    }

    @Override
    public int getMaxExtract(ItemStack stack){
        return stack.getItemDamage() < subItemMaxTransfer.length ? subItemMaxTransfer[stack.getItemDamage()] : 0;
    }

    @Override
    public int getMaxReceive(ItemStack stack){
        return stack.getItemDamage() < subItemMaxTransfer.length ? subItemMaxTransfer[stack.getItemDamage()] : 0;
    }

    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity entity, int var1, boolean b) {
        super.onUpdate(itemStack, world, entity, var1, b);

        EntityPlayer ep = (EntityPlayer)entity;

        if (prevDistanceWalkedModified == 0) {
            prevDistanceWalkedModified = ep.distanceWalkedModified;
        }

        boolean isMoving = ep.getAIMoveSpeed() > 0.11f ? true : false;
        boolean isJumping = (ep.fallDistance > 0.0f) ? true : false;
        int energyStored = getEnergyStored(itemStack);
        int maxEnergy = getMaxEnergyStored(itemStack);

        if ( ! world.isRemote)
        {
            if (energyStored < maxEnergy) {
                if (isMoving) {
                    receiveEnergy(itemStack, energyFromMoving[itemStack.getItemDamage()], false);
                }

                if (isJumping) {
                    receiveEnergy(itemStack, energyFromJumping[itemStack.getItemDamage()], false);
                }
            } else {
                entity.playSound("random.orb", 1, 1);
            }
        }

        prevDistanceWalkedModified = ep.distanceWalkedModified;

        //this.setDamage(itemStack, this.maxEnergy - energyStored);

        // Set icon based on energy stored.
        /*
        if (this.hasMultipleIcons) {
            int level = (getEnergyStored(itemStack)) / (this.maxEnergy / 5);
            // this.itemIcon = level > 5 ? this.icons[5] : level < 0 ? this.icons[0] : this.icons[level];
        }
        */
    }

    @Override
    public boolean onEntitySwing(EntityLivingBase entityLivingBase, ItemStack itemStack) {
        if (getEnergyStored(itemStack) == getMaxEnergyStored(itemStack)) {
            // Handle over charging
            if ( ! NBTHelper.hasTag(itemStack, "overCharge"))
            {
                NBTHelper.setInteger(itemStack, "overCharge", 0);
            }

            int overCharge = NBTHelper.getInt(itemStack, "overCharge");

            overCharge++;

            if (overCharge >= overChargeBuffer[itemStack.getItemDamage()])
            {
                // KaBOOM!
                ((EntityPlayer)entityLivingBase).destroyCurrentEquippedItem();

                entityLivingBase.attackEntityFrom(DamageSource.generic, damageFromOvercharge[itemStack.getItemDamage()]);
                entityLivingBase.playSound("random.explode", 1, 1);
            }

            NBTHelper.setInteger(itemStack, "overCharge", overCharge);
        } else {
            int energyAdded = receiveEnergy(itemStack, energyFromUsing[itemStack.getItemDamage()], false);
        }

        return false;
    }

    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        if (!world.isRemote) {
            player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "" + getEnergyStored(itemStack) + " / " + getMaxEnergyStored(itemStack) + " RF"));

            //player.addChatMessage(new ChatComponentText("Damage: " + getDamage(itemStack)));
        }


        return itemStack;
    }

    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
        if (!world.isRemote) {
            TileEntity te = world.getTileEntity(x, y, z);

            if (te != null && te instanceof TileEntityKC2Powered) {
                int energyExtracted = ((TileEntityKC2Powered) te).receiveEnergy(null, extractEnergy(itemStack, subItemMaxTransfer[itemStack.getItemDamage()], false), false);
                world.markBlockForUpdate(x, y, z);

                entityPlayer.addChatComponentMessage(new ChatComponentText(energyExtracted + " RF extracted. " + getEnergyStored(itemStack) + " RF remains."));
            }
        }
        return false;
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean par4)
    {
        super.addInformation(itemStack, entityPlayer, list, par4);

        list.add(EnumChatFormatting.GREEN + "" + getEnergyStored(itemStack) + " / " + getMaxEnergyStored(itemStack) + " RF");
    }
}
