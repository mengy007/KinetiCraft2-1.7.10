package com.techmafia.mcmods.KinetiCraft2.blocks.itemblocks;

import com.techmafia.mcmods.KinetiCraft2.blocks.itemblocks.base.ItemBlockKC2Powered;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

/**
 * Created by myang on 11/5/15.
 */
public class ItemBlockKC2EnderKineticGenerator extends ItemBlockKC2Powered {
    int capacity = 10000000;

    public ItemBlockKC2EnderKineticGenerator(Block block) {
        super(block);
    }

    @Override
    public int getMaxEnergyStored(ItemStack itemStack) {
        return capacity;
    }
}
