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

    /**
     * Required override
     **/
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
        if (te != null && !world.isRemote) {
            EntityKC2Treadmill treadmillEntity = new EntityKC2Treadmill(world);
            treadmillEntity.setPosition(x+0.5f, y, z+0.5f);
            world.spawnEntityInWorld(treadmillEntity);
            entityPlayer.mountEntity(treadmillEntity);
        }

        return false;
    }
}
