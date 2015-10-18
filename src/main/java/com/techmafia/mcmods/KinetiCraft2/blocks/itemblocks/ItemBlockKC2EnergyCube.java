package com.techmafia.mcmods.KinetiCraft2.blocks.itemblocks;

import com.techmafia.mcmods.KinetiCraft2.blocks.itemblocks.base.ItemBlockKC2Powered;
import com.techmafia.mcmods.KinetiCraft2.tileentities.base.TileEntityKC2Powered;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Meng on 10/17/2015.
 */
public class ItemBlockKC2EnergyCube extends ItemBlockKC2Powered {
    int[] capacity = new int[2];

    public ItemBlockKC2EnergyCube(Block block) {
        super(block);

        capacity[0] = 100000;
        capacity[1] = 1000000;
    }

    @Override
    public int getMaxEnergyStored(ItemStack itemStack) {
        return capacity[itemStack.getItemDamage()];
    }
}
