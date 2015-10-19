package com.techmafia.mcmods.KinetiCraft2.blocks.itemblocks;

import com.techmafia.mcmods.KinetiCraft2.blocks.itemblocks.base.ItemBlockKC2Powered;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Created by Meng on 10/18/2015.
 */
public class ItemBlockKC2KineticGenerator extends ItemBlockKC2Powered {
    int capacity = 50000;

    public ItemBlockKC2KineticGenerator(Block block) {
        super(block);
    }

    @Override
    public int getMaxEnergyStored(ItemStack itemStack) {
        return capacity;
    }
}
