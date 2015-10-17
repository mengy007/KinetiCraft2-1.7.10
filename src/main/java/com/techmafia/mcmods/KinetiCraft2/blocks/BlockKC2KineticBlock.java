package com.techmafia.mcmods.KinetiCraft2.blocks;

import com.techmafia.mcmods.KinetiCraft2.creativetab.CreativeTabKC2;
import com.techmafia.mcmods.KinetiCraft2.init.KinetiCraft2Items;
import com.techmafia.mcmods.KinetiCraft2.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

/**
 * Created by Meng on 10/16/2015.
 */
public class BlockKC2KineticBlock extends Block {
    private IIcon iconKineticBlock;

    public BlockKC2KineticBlock() {
        super(Material.ground);
        this.setCreativeTab(CreativeTabKC2.KC2_TAB);
        this.setBlockName("kineticBlock");
        this.setBlockTextureName(Reference.TEXTURE_NAME_PREFIX + "kineticBlock");
        this.setHardness(0.5f);
        this.setStepSound(Block.soundTypeGravel);
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List par3List) {
        par3List.add(new ItemStack(item, 1, 0));
    }

    //
    // Icon stuff
    //
    @Override
    public IIcon getIcon(int size, int metadata) {
        return this.iconKineticBlock;
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.iconKineticBlock = iconRegister.registerIcon(Reference.TEXTURE_NAME_PREFIX + "kineticBlock");
    }

    //
    // Interaction stuff
    //
    /**
     * This makes simply breaking the block drop 1 dust
     * @param metadata
     * @param random
     * @param fortune
     * @return
     */
    @Override
    public Item getItemDropped(int metadata, Random random, int fortune) {
        return KinetiCraft2Items.kineticDust;
    }

    /**
     * Called whenever an entity is walking on top of this block. Args: world, x, y, z, entity
     */
    public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
        if ( ! world.isRemote && entity instanceof EntityPlayerMP) {
            this.makeKineticDust(world, x, y, z, 2);
        }
    }

    /**
     * Block's chance to react to an entity falling on it.
     */
    public void onFallenUpon(World world, int x, int y, int z, Entity entity, float speed) {
        if ( ! world.isRemote && entity instanceof EntityPlayerMP) {
            this.makeKineticDust(world, x, y, z, 2);
        }
    }

    /**
     * Drop some kinetic dust in the world
     * @param world
     * @param x
     * @param y
     * @param z
     * @param amount
     */
    public void makeKineticDust(World world, int x, int y, int z, int amount) {
        world.func_147480_a(x, y, z, false); // Destroy block
        world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(KinetiCraft2Items.kineticDust, amount)));
    }
}