package com.techmafia.mcmods.KinetiCraft2.blocks;

import cofh.core.block.BlockCoFHBase;
import cofh.core.util.CoreUtils;
import com.techmafia.mcmods.KinetiCraft2.creativetab.CreativeTabKC2;
import com.techmafia.mcmods.KinetiCraft2.reference.Reference;
import com.techmafia.mcmods.KinetiCraft2.tileentities.TileEntityKC2EnderKineticEnergyPylon;
import com.techmafia.mcmods.KinetiCraft2.tileentities.TileEntityKC2EnderKineticGenerator;
import com.techmafia.mcmods.KinetiCraft2.tileentities.base.TileEntityKC2Powered;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.ArrayList;

/**
 * Created by myang on 11/5/15.
 */
public class BlockKC2EnderKineticEnergyPylon extends BlockCoFHBase {
    IIcon iconInside;
    IIcon iconOutside;

    public BlockKC2EnderKineticEnergyPylon(Material material) {
        super(material);
        setCreativeTab(CreativeTabKC2.KC2_TAB);
        setStepSound(soundTypeMetal);
        setHardness(0.1f);
        setBlockName("kc2EnderKineticEnergyPylon");
        setBlockTextureName(Reference.MOD_NAME + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(":") + 1));
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return true;
    }

    @Override
    public IIcon getIcon(int size, int metadata) {
        return this.blockIcon;
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(Reference.MOD_NAME + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(":") + 1));
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileEntityKC2EnderKineticEnergyPylon();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            TileEntity te = world.getTileEntity(x, y, z);
            if (te != null && te instanceof TileEntityKC2EnderKineticEnergyPylon) {
                if (((TileEntityKC2EnderKineticEnergyPylon) te).generatorTileEntity != null) {
                    TileEntityKC2EnderKineticGenerator generatorTileEntity = ((TileEntityKC2EnderKineticEnergyPylon) te).generatorTileEntity;
                    entityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GREEN + "Feeding Kinetic Generator at x: " + generatorTileEntity.xCoord + " y: " + generatorTileEntity.yCoord + " z: " + generatorTileEntity.zCoord));
                } else {
                    entityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "No Ender Kinetic Generator in range."));
                }

            }
        }
        return false;
    }

    @Override
    public ArrayList<ItemStack> dismantleBlock(EntityPlayer player, NBTTagCompound blockTag, World world, int x, int y, int z, boolean returnDrops, boolean simulate) {
        ArrayList<ItemStack> stacks = new ArrayList<ItemStack>();
        int metadata = world.getBlockMetadata(x, y, z);
        stacks.add(new ItemStack(getItemDropped(metadata, world.rand, 0), 1, damageDropped(metadata)));

        if(returnDrops && !simulate)
        {
            TileEntity te = world.getTileEntity(x, y, z);

            if(te instanceof IInventory) {
                IInventory invTe = (IInventory)te;
                for(int i = 0; i < invTe.getSizeInventory(); i++) {
                    ItemStack stack = invTe.getStackInSlot(i);
                    if(stack != null) {
                        stacks.add(stack);
                        invTe.setInventorySlotContents(i, null);
                    }
                }
            }
        }

        if(!simulate) {
            world.setBlockToAir(x, y, z);

            if(!returnDrops) {
                for(ItemStack stack: stacks) {
                    CoreUtils.dropItemStackIntoWorldWithVelocity(stack, world, x, y, z);
                }
            }
        }

        return stacks;
    }

    // IInitializer (unused)
    @Override
    public boolean initialize() {
        return false;
    }

    @Override
    public boolean postInit() {
        return false;
    }
}
