package com.techmafia.mcmods.KinetiCraft2.blocks.itemblocks;

import com.techmafia.mcmods.KinetiCraft2.blocks.itemblocks.base.ItemBlockKC2Powered;
import com.techmafia.mcmods.KinetiCraft2.handlers.ConfigurationHandler;
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
    int[] capacity = new int[4];

    public ItemBlockKC2EnergyCube(Block block) {
        super(block);

        capacity[0] = ConfigurationHandler.kineticEnergyCubeMaxEnergy;//400000;
        capacity[1] = ConfigurationHandler.hardenedKineticEnergyCubeMaxEnergy;//2000000;
        capacity[2] = ConfigurationHandler.reinforcedKineticEnergyCubeMaxEnergy;//20000000;
        capacity[3] = ConfigurationHandler.resonantKineticEnergyCubeMaxEnergy;//80000000;
    }

    @Override
    public int getMaxEnergyStored(ItemStack itemStack) {
        return capacity[itemStack.getItemDamage()];
    }
}
