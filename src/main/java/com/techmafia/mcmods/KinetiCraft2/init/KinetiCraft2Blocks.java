package com.techmafia.mcmods.KinetiCraft2.init;

import com.techmafia.mcmods.KinetiCraft2.blocks.*;
import com.techmafia.mcmods.KinetiCraft2.blocks.itemblocks.ItemBlockKC2EnergyCube;
import com.techmafia.mcmods.KinetiCraft2.blocks.itemblocks.ItemBlockKC2KineticBlock;
import com.techmafia.mcmods.KinetiCraft2.blocks.itemblocks.ItemBlockKC2KineticGenerator;
import com.techmafia.mcmods.KinetiCraft2.blocks.itemblocks.ItemBlockKC2Treadmill;
import com.techmafia.mcmods.KinetiCraft2.blocks.itemblocks.base.ItemBlockKC2Powered;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * Created by Meng on 7/27/2015.
 */
public class KinetiCraft2Blocks {
    public static final BlockKC2KineticBlock kineticBlock = new BlockKC2KineticBlock();
    public static final BlockKC2EnergyCube kineticEnergyCube = new BlockKC2EnergyCube(Material.rock);
    public static final BlockKC2KineticGenerator kineticGenerator = new BlockKC2KineticGenerator(Material.rock);
    public static final BlockKC2Treadmill kc2treadmill = new BlockKC2Treadmill();

    public static void init() {
        Object ingotLead = getOreWithVanillaFallback("stone", "ingotLead");
        Object ingotInvar = getOreWithVanillaFallback("ingotIron", "ingotInvar");
        Object ingotElectrum = getOreWithVanillaFallback("ingotGold", "ingotElectrum", "ingotPhasedGold");
        Object ingotEnderium = getOreWithVanillaFallback("enderPearl", "ingotEnderium");

        /* Register Blocks */
        GameRegistry.registerBlock(kineticBlock, ItemBlockKC2KineticBlock.class, "kineticBlock");
        GameRegistry.registerBlock(kineticEnergyCube, ItemBlockKC2EnergyCube.class, "kineticEnergyCube");
        GameRegistry.registerBlock(kineticGenerator, ItemBlockKC2KineticGenerator.class, "kineticGenerator");
        //GameRegistry.registerBlock(kc2treadmill, ItemBlockKC2Treadmill.class, "kc2treadmill");

        /* Crafting Recipes */
        GameRegistry.addShapelessRecipe(new ItemStack(kineticBlock, 2), new Object[]{
                Blocks.sand,
                Blocks.dirt
        });
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kineticEnergyCube, 1, 0), new Object[]{
                "CGC",
                " M ",
                "C C",
                'C', "ingotLead",
                'M', KinetiCraft2Items.kineticFrame,
                'G', KinetiCraft2Items.kineticGear
        }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kineticEnergyCube, 1, 1), new Object[]{
                "CGC",
                " M ",
                "C C",
                'C', "ingotInvar",
                'M', new ItemStack(kineticEnergyCube, 1, 0),
                'G', KinetiCraft2Items.kineticGear
        }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kineticEnergyCube, 1, 2), new Object[]{
                "CGC",
                " M ",
                "C C",
                'C', "ingotElectrum",
                'M', new ItemStack(kineticEnergyCube, 1, 1),
                'G', KinetiCraft2Items.kineticGear
        }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kineticEnergyCube, 1, 3), new Object[]{
                " C ",
                "CMC",
                " C ",
                'C', "ingotEnderium",
                'M', new ItemStack(kineticEnergyCube, 1, 2)
        }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kineticGenerator, 1, 0), new Object[]{
                "IGI",
                "GRG",
                "IGI",
                'R', Items.redstone,
                'I', KinetiCraft2Items.kineticIngot,
                'G', KinetiCraft2Items.kineticGear
        }));

        /* Register furnace smelts */
        GameRegistry.addSmelting(kineticBlock, new ItemStack(KinetiCraft2Items.kineticIngot, 1, 0), 0.1f);
    }

    public static Object getOreWithVanillaFallback(Object vanillaFallback, String... moddedOre) {
        for (String modOre : moddedOre) {
            if (OreDictionary.getOres(modOre).size() > 0)
                return modOre;
        }

        return vanillaFallback;
    }
}
