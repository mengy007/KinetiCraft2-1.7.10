package com.techmafia.mcmods.KinetiCraft2.blocks;

import com.techmafia.mcmods.KinetiCraft2.blocks.base.BlockKC2Base;
import com.techmafia.mcmods.KinetiCraft2.creativetab.CreativeTabKC2;
import com.techmafia.mcmods.KinetiCraft2.entities.EntityKC2Treadmill;
import com.techmafia.mcmods.KinetiCraft2.reference.Reference;
import com.techmafia.mcmods.KinetiCraft2.tileentities.TileEntityKC2Treadmill;
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
import net.minecraft.world.World;

/**
 * Created by Meng on 10/25/2015.
 */
public class BlockKC2Treadmill extends BlockContainer {
    public BlockKC2Treadmill() {
        super(Material.rock);
        this.setHardness(0.3f);
        this.setBlockName("kc2treadmill");
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
    }

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

        if (!world.isRemote) {
            EntityKC2Treadmill entityTreadmill = new EntityKC2Treadmill(world, x + 0.5D, y + 0.5D, z + 0.5D);
            world.spawnEntityInWorld(entityTreadmill);
            ((TileEntityKC2Treadmill) world.getTileEntity(x, y, z)).setEntityId(entityTreadmill.getEntityId());

            if (entityTreadmill != null) {
                entityTreadmill.interactFirst(entityPlayer);
            }

            return true;
        }

        /*
        if (canSit(world, x, y, z, entityPlayer, side, hitX, hitY, hitZ) && !world.isRemote) {
            EntityKC2Treadmill entityTreadmill = new EntityKC2Treadmill(world, x + 0.5D, y + 0.5D, z + 0.5D);
            world.spawnEntityInWorld(entityTreadmill);
            ((TileEntityKC2Treadmill) world.getTileEntity(x, y, z)).setEntityId(entityTreadmill.getEntityId());

            if (entityTreadmill != null) {
                entityTreadmill.interactFirst(entityPlayer);
            }

            return true;
        }
        */

        return false;
    }

    public boolean canSit(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        return true;
    }

    /*
    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        EntityKC2Treadmill e = new EntityKC2Treadmill(world, x + 0.5D, y + 0.5D, z + 0.5D);
        world.spawnEntityInWorld(e);
        ((TileEntityKC2Treadmill) world.getTileEntity(x, y, z)).setEntityId(e.getEntityId());
    }
    */
}
