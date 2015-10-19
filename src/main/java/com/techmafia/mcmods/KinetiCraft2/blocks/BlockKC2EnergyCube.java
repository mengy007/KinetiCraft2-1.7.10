package com.techmafia.mcmods.KinetiCraft2.blocks;

import cofh.api.block.IDismantleable;
import cofh.core.block.BlockCoFHBase;
import cofh.core.util.CoreUtils;
import com.techmafia.mcmods.KinetiCraft2.creativetab.CreativeTabKC2;
import com.techmafia.mcmods.KinetiCraft2.reference.Reference;
import com.techmafia.mcmods.KinetiCraft2.tileentities.TileEntityKC2HardenedKineticEnergyCube;
import com.techmafia.mcmods.KinetiCraft2.tileentities.TileEntityKC2KineticEnergyCube;
import com.techmafia.mcmods.KinetiCraft2.tileentities.TileEntityKC2ReinforcedKineticEnergyCube;
import com.techmafia.mcmods.KinetiCraft2.tileentities.TileEntityKC2ResonantKineticEnergyCube;
import com.techmafia.mcmods.KinetiCraft2.tileentities.base.TileEntityKC2Base;
import com.techmafia.mcmods.KinetiCraft2.tileentities.base.TileEntityKC2Powered;
import com.techmafia.mcmods.KinetiCraft2.utility.ItemNBTHelper;
import com.techmafia.mcmods.KinetiCraft2.utility.LogHelper;
import com.techmafia.mcmods.KinetiCraft2.utility.StaticUtils;
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
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Meng on 7/31/2015.
 */
public class BlockKC2EnergyCube extends BlockCoFHBase implements IDismantleable {
    public static final String[] _subBlocks = {
            "kineticEnergyCube",
            "hardenedKineticEnergyCube",
            "reinforcedKineticEnergyCube",
            "resonantKineticEnergyCube"
    };

    private IIcon[] _icons = new IIcon[_subBlocks.length];
    private IIcon[] _activeIcons = new IIcon[_subBlocks.length];

    public BlockKC2EnergyCube(Material material) {
        super(material);

        setStepSound(soundTypeMetal);
        setHardness(0.1f);
        setBlockName("kc2EnergyCube");
        setBlockTextureName(Reference.MOD_NAME + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(":") + 1));
        this.setCreativeTab(CreativeTabKC2.KC2_TAB);
    }

    public static final int SIDE_FRONT = ForgeDirection.NORTH.ordinal();

    private IIcon safeGetIcon(IIcon[] list, int idx, int x, int y, int z) {
        if(idx < 0 || idx >= list.length) {
            LogHelper.error("Invalid metadata (" + idx + ") for block at " + x + "," + y + "," + z);
            return blockIcon;
        }
        else {
            return list[idx];
        }
    }

    public IIcon getIconFromTileEntity(TileEntity te, int metadata, int side) {
        if(metadata < 0) { return blockIcon; }

        // Tracks the actual index of the current side, after rotation
        int front = -1;

        if(side == front) {
            if(te instanceof TileEntityKC2Base) {
                TileEntityKC2Base KC2Te = (TileEntityKC2Base)te;
                if(KC2Te.isActive()) {
                    return safeGetIcon(_activeIcons, metadata, te.xCoord, te.yCoord, te.zCoord);
                }
            }
            return safeGetIcon(_icons, metadata, te.xCoord, te.yCoord, te.zCoord);
        }

        //return blockIcon;
        return this._icons[metadata];
    }

    @Override
    public int getRenderType() {
        return 0;
    }

    @Override
    public int damageDropped(int metadata) {
        return metadata;
    }

    @Override
    public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side) {
        TileEntity te = blockAccess.getTileEntity(x, y, z);
        int metadata = blockAccess.getBlockMetadata(x, y, z);
        return this.getIconFromTileEntity(te, metadata, side);
    }

    @Override
    public IIcon getIcon(int side, int metadata) {
        /*
        // This is used when rendering in-inventory. 4 == front here.
        if(side == 4) {
            return _icons[metadata];
        }
        */
        //return this.blockIcon;
        return this._icons[metadata];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon(Reference.MOD_NAME + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(":") + 1));

        for(int i = 0; i < _subBlocks.length; ++i) {
            _icons[i] = par1IconRegister.registerIcon(Reference.MOD_NAME + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(":") + 1) + "." + _subBlocks[i]);
            _activeIcons[i] = par1IconRegister.registerIcon(Reference.MOD_NAME + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(":") + 1) + "." + _subBlocks[i] + ".active");
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        switch(metadata) {
            case 0:
                return new TileEntityKC2KineticEnergyCube();
            case 1:
                return new TileEntityKC2HardenedKineticEnergyCube();
            case 2:
                return new TileEntityKC2ReinforcedKineticEnergyCube();
            case 3:
                return new TileEntityKC2ResonantKineticEnergyCube();
            default:
                throw new IllegalArgumentException("Unknown metadata for tile entity");
        }
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list) {
        list.add(ItemNBTHelper.setInteger(new ItemStack(item, 1, 0), "Energy", 0));
        list.add(ItemNBTHelper.setInteger(new ItemStack(item, 1, 0), "Energy", 400000));

        list.add(ItemNBTHelper.setInteger(new ItemStack(item, 1, 1), "Energy", 0));
        list.add(ItemNBTHelper.setInteger(new ItemStack(item, 1, 1), "Energy", 2000000));

        list.add(ItemNBTHelper.setInteger(new ItemStack(item, 1, 2), "Energy", 0));
        list.add(ItemNBTHelper.setInteger(new ItemStack(item, 1, 2), "Energy", 20000000));

        list.add(ItemNBTHelper.setInteger(new ItemStack(item, 1, 3), "Energy", 0));
        list.add(ItemNBTHelper.setInteger(new ItemStack(item, 1, 3), "Energy", 80000000));
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float hitX, float hitY, float hitZ) {
        TileEntity te = world.getTileEntity(x, y, z);
        if (te == null) {
            return false;
        } else {
            world.markBlockForUpdate(x, y, z);

            if (entityPlayer.isSneaking()) {
                // Wrench + Sneak = Dismantle
                if (StaticUtils.Inventory.isPlayerHoldingWrench(entityPlayer)) {
                    // Pass simulate == true on the client to prevent creation of "ghost" item stacks
                    dismantleBlock(entityPlayer, null, world, x, y, z, false, world.isRemote);
                    return true;
                }
                return false;
            }

            if (entityPlayer.inventory.getCurrentItem() == null) {
                // Return stored power if bare hand
                if (world.isRemote) {
                    entityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GREEN + "" + ((TileEntityKC2Powered) te).getEnergyStored(null) + " / " + ((TileEntityKC2Powered)te).getMaxEnergyStored(null) + " RF"));
                    return true;
                }
                return false;
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
    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata) {
        TileEntity te = world.getTileEntity(x, y, z);

        if (te != null && te instanceof TileEntityKC2Powered) {

        }

        return metadata;
    }

    // IDismantleable
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
