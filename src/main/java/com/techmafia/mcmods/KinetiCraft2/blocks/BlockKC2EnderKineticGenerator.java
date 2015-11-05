package com.techmafia.mcmods.KinetiCraft2.blocks;

import cofh.core.block.BlockCoFHBase;
import cofh.core.util.CoreUtils;
import com.techmafia.mcmods.KinetiCraft2.creativetab.CreativeTabKC2;
import com.techmafia.mcmods.KinetiCraft2.reference.Reference;
import com.techmafia.mcmods.KinetiCraft2.tileentities.TileEntityKC2EnderKineticGenerator;
import com.techmafia.mcmods.KinetiCraft2.tileentities.TileEntityKC2KineticGenerator;
import com.techmafia.mcmods.KinetiCraft2.tileentities.base.TileEntityKC2Powered;
import com.techmafia.mcmods.KinetiCraft2.utility.ItemNBTHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by myang on 11/5/15.
 */
public class BlockKC2EnderKineticGenerator extends BlockCoFHBase {
    IIcon sideIcon;
    IIcon topIcon;

    public BlockKC2EnderKineticGenerator(Material material) {
        super(material);
        setCreativeTab(CreativeTabKC2.KC2_TAB);
        setStepSound(soundTypeMetal);
        setHardness(0.1f);
        setBlockName("kc2EnderKineticGenerator");
        setBlockTextureName(Reference.MOD_NAME + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(":") + 1));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon(Reference.MOD_NAME + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(":") + 1));
        this.sideIcon = par1IconRegister.registerIcon(Reference.MOD_NAME + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(":") + 1) + "_side");
        this.topIcon = par1IconRegister.registerIcon(Reference.MOD_NAME + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(":") + 1) + "_top");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
        if (side == 1) {
            return topIcon;
        } else {
            return sideIcon;
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileEntityKC2EnderKineticGenerator();
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list) {
        list.add(ItemNBTHelper.setInteger(new ItemStack(item, 1, 0), "Energy", 0));
        list.add(ItemNBTHelper.setInteger(new ItemStack(item, 1, 0), "Energy", 10000000));
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

    // Copy energy level when broken
    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        ArrayList<ItemStack> itemStacks = new ArrayList<ItemStack>();
        TileEntity te = world.getTileEntity(x, y, z);
        ItemStack stack = new ItemStack(world.getBlock(x, y, z),1 , metadata);

        if (te != null && te instanceof TileEntityKC2Powered) {
            if (!stack.hasTagCompound()) {
                stack.setTagCompound(new NBTTagCompound());
            }
            stack.getTagCompound().setInteger("Energy", ((TileEntityKC2Powered)te).getEnergyStored(null));
            itemStacks.add(stack);
        }

        return itemStacks;
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
