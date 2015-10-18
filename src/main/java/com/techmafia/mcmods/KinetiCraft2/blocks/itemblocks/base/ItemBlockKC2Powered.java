package com.techmafia.mcmods.KinetiCraft2.blocks.itemblocks.base;

import cofh.api.energy.IEnergyContainerItem;
import com.techmafia.mcmods.KinetiCraft2.tileentities.base.TileEntityKC2Powered;
import com.techmafia.mcmods.KinetiCraft2.utility.ItemNBTHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Meng on 10/17/2015.
 */
public class ItemBlockKC2Powered extends ItemBlock {
    public ItemBlockKC2Powered(Block block) {
        super(block);
    }

    public int getEnergyStored(ItemStack itemStack) {
        if (itemStack.hasTagCompound()) {
            if (itemStack.getTagCompound().hasKey("Energy")) {
                return itemStack.getTagCompound().getInteger("Energy");
            } else {
                ItemNBTHelper.setInteger(itemStack, "Energy", 0);
            }
        }
        return 0;
    }

    public int getMaxEnergyStored(ItemStack itemStack) {
        return 0;
    }

    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean par4) {
        super.addInformation(itemStack, entityPlayer, list, par4);

        list.add(EnumChatFormatting.GREEN + "" + getEnergyStored(itemStack) + " / " + getMaxEnergyStored(itemStack) + " RF");
    }

    /**
     * Called to actually place the block, after the location is determined
     * and all permission checks have been made.
     *
     * @param stack The item stack that was used to place the block. This can be changed inside the method.
     * @param player The player who is placing the block. Can be null if the block is not being placed by a player.
     * @param side The side the player (or machine) right-clicked on.
     */
    @Override
    public boolean placeBlockAt(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
    {
        super.placeBlockAt(itemStack, entityPlayer, world, x, y, z, side, hitX, hitY, hitZ, metadata);

        TileEntity te = world.getTileEntity(x, y, z);

        if (te != null && te instanceof TileEntityKC2Powered) {
            ((TileEntityKC2Powered)te).setEnergyStored(getEnergyStored(itemStack));
        }

        return true;
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return !(getEnergyStored(stack) == getMaxEnergyStored(stack));
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack) {
        return 1D - ((double)getEnergyStored(stack) / (double)getMaxEnergyStored(stack));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return super.getUnlocalizedName(itemStack) + itemStack.getItemDamage();
    }
}
