package com.techmafia.mcmods.KinetiCraft2.blocks.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

/**
 * Created by Meng on 11/4/2015.
 */
public class ItemBlockKC2EnderKineticBlock extends ItemBlock {
    public ItemBlockKC2EnderKineticBlock(Block block) {
        super(block);
    }

    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean par4) {
        super.addInformation(itemStack, entityPlayer, list, par4);
        list.add(EnumChatFormatting.GREEN + "Place down and jump on.");
    }
}
