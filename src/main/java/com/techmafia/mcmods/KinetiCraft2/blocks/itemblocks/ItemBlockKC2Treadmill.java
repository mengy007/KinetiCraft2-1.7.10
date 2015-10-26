package com.techmafia.mcmods.KinetiCraft2.blocks.itemblocks;

import com.techmafia.mcmods.KinetiCraft2.blocks.itemblocks.base.ItemBlockKC2Powered;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

/**
 * Created by Meng on 10/25/2015.
 */
public class ItemBlockKC2Treadmill extends ItemBlockKC2Powered {
    int capacity = 10000;

    public ItemBlockKC2Treadmill(Block block) {
        super(block);
    }

    @Override
    public int getMaxEnergyStored(ItemStack itemStack) {
        return capacity;
    }
}
