package com.techmafia.mcmods.KinetiCraft2.blocks;

import com.techmafia.mcmods.KinetiCraft2.blocks.base.BlockKC2Base;
import com.techmafia.mcmods.KinetiCraft2.creativetab.CreativeTabKC2;
import com.techmafia.mcmods.KinetiCraft2.entities.EntityKC2Treadmill;
import com.techmafia.mcmods.KinetiCraft2.reference.Reference;
import com.techmafia.mcmods.KinetiCraft2.tileentities.TileEntityKC2Treadmill;
import com.techmafia.mcmods.KinetiCraft2.tileentities.base.TileEntityKC2Powered;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Created by Meng on 10/25/2015.
 */
public class BlockKC2Treadmill extends BlockContainer {
    IIcon sideIcon;
    IIcon[] topIcons = new IIcon[2];
    int topAnimationFrame = 0;

    public BlockKC2Treadmill() {
        super(Material.rock);
        this.setHardness(0.3f);
        this.setBlockName("kc2Treadmill");
        this.setCreativeTab(CreativeTabKC2.KC2_TAB);
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(Reference.MOD_NAME + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(":") + 1));
        sideIcon = iconRegister.registerIcon(Reference.MOD_NAME + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(":") + 1) + "_side");
        topIcons[0] = iconRegister.registerIcon(Reference.MOD_NAME + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(":") + 1) + "_top0");
        topIcons[1] = iconRegister.registerIcon(Reference.MOD_NAME + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(":") + 1) + "_top1");
    }

    @Override
    public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side) {
        if (side == 1) {
            TileEntity te = blockAccess.getTileEntity(x, y, z);
            if (te != null && te instanceof TileEntityKC2Treadmill) {
                if (((TileEntityKC2Treadmill)te).getTreadmillSpeed() > 0) {
                    IIcon iconToUse = topIcons[topAnimationFrame];
                    topAnimationFrame++;
                    if (topAnimationFrame >= topIcons.length) {
                        topAnimationFrame = 0;
                    }
                    return iconToUse;
                }
                return topIcons[1];
            }
        }
        return sideIcon;
    }

    /*
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
        if (side == 1) {
            return topIcon;
        } else {
            return sideIcon;
        }
    }
    */

    @Override
    public boolean hasTileEntity(int metadata) {
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileEntityKC2Treadmill();
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float hitX, float hitY, float hitZ) {
        TileEntity te = world.getTileEntity(x, y, z);
        if (te == null) {
            return false;
        } else {
            if (entityPlayer.inventory.getCurrentItem() == null) {
                // Return stored power if bare hand
                if (world.isRemote) {
                    entityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GREEN + "" + ((TileEntityKC2Powered) te).getEnergyStored(null) + " / " + ((TileEntityKC2Powered) te).getMaxEnergyStored(null) + " RF"));
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        EntityKC2Treadmill e = new EntityKC2Treadmill(world, x + 0.5D, y + 0.5D, z + 0.5D);
        world.spawnEntityInWorld(e);
        ((TileEntityKC2Treadmill) world.getTileEntity(x, y, z)).setEntityId(e.getEntityId());
    }
}
