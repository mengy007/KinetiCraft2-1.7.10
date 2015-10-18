package com.techmafia.mcmods.KinetiCraft2.init;

import com.techmafia.mcmods.KinetiCraft2.blocks.*;
import com.techmafia.mcmods.KinetiCraft2.blocks.itemblocks.ItemBlockKC2EnergyCube;
import com.techmafia.mcmods.KinetiCraft2.blocks.itemblocks.ItemBlockKC2KineticBlock;
import com.techmafia.mcmods.KinetiCraft2.blocks.itemblocks.base.ItemBlockKC2Powered;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * Created by Meng on 7/27/2015.
 */
public class KinetiCraft2Blocks {
    public static final BlockKC2KineticBlock kineticBlock = new BlockKC2KineticBlock();
    public static final BlockKC2EnergyCube kineticEnergyCube = new BlockKC2EnergyCube(Material.rock);

    public static void init() {
        /* Register Blocks */
        GameRegistry.registerBlock(kineticBlock, ItemBlockKC2KineticBlock.class, "kineticBlock");
        GameRegistry.registerBlock(kineticEnergyCube, ItemBlockKC2EnergyCube.class, "kineticEnergyCube");

        /* Crafting Recipes */
        GameRegistry.addShapelessRecipe(new ItemStack(kineticBlock, 2), new Object[]{
                Blocks.sand,
                Blocks.dirt
        });
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kineticEnergyCube, 1, 0), new Object[]{
                "CGC",
                " M ",
                "C C",
                'C', "ingotCopper",
                'M', KinetiCraft2Items.kineticFrame,
                'G', KinetiCraft2Items.kineticGear
        }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kineticEnergyCube, 1, 1), new Object[]{
                "CGC",
                " M ",
                "C C",
                'C', "ingotInvar",
                'M', KinetiCraft2Items.kineticFrame,
                'G', KinetiCraft2Items.kineticGear
        }));

        /* Register furnace smelts */
        GameRegistry.addSmelting(kineticBlock, new ItemStack(KinetiCraft2Items.kineticIngot, 1, 0), 0.1f);
    }
}
