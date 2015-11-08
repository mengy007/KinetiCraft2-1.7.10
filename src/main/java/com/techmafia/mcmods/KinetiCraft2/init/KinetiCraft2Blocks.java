package com.techmafia.mcmods.KinetiCraft2.init;

import com.techmafia.mcmods.KinetiCraft2.blocks.*;
import com.techmafia.mcmods.KinetiCraft2.blocks.itemblocks.*;
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
    public static final BlockKC2NetherKineticBlock netherKineticBlock = new BlockKC2NetherKineticBlock();
    public static final BlockKC2EnderKineticBlock enderKineticBlock = new BlockKC2EnderKineticBlock();

    public static final BlockKC2EnergyCube kineticEnergyCube = new BlockKC2EnergyCube(Material.rock);
    public static final BlockKC2KineticGenerator kineticGenerator = new BlockKC2KineticGenerator(Material.rock);
    public static final BlockKC2EnderKineticGenerator enderKineticGenerator = new BlockKC2EnderKineticGenerator(Material.rock);
    public static final BlockKC2ThermalKineticGenerator thermalKineticGenerator = new BlockKC2ThermalKineticGenerator(Material.rock);
    public static final BlockKC2EnderKineticEnergyPylon enderKineticEnergyPylon = new BlockKC2EnderKineticEnergyPylon(Material.rock);
    public static final BlockKC2Treadmill kc2treadmill = new BlockKC2Treadmill();

    public static void init() {
        Object ingotLead = getOreWithVanillaFallback("stone", "ingotLead");
        Object ingotInvar = getOreWithVanillaFallback("ingotIron", "ingotInvar");
        Object ingotElectrum = getOreWithVanillaFallback("ingotGold", "ingotElectrum", "ingotPhasedGold");
        Object ingotEnderium = getOreWithVanillaFallback("enderPearl", "ingotEnderium");

        /* Register Blocks */
        GameRegistry.registerBlock(kineticBlock, ItemBlockKC2KineticBlock.class, "kineticBlock");
        GameRegistry.registerBlock(netherKineticBlock, ItemBlockKC2KineticBlock.class, "netherKineticBlock");
        GameRegistry.registerBlock(enderKineticBlock, ItemBlockKC2KineticBlock.class, "enderKineticBlock");
        GameRegistry.registerBlock(kineticEnergyCube, ItemBlockKC2EnergyCube.class, "kineticEnergyCube");
        GameRegistry.registerBlock(kineticGenerator, ItemBlockKC2KineticGenerator.class, "kineticGenerator");
        GameRegistry.registerBlock(enderKineticGenerator, ItemBlockKC2EnderKineticGenerator.class, "enderKineticGenerator");
        GameRegistry.registerBlock(thermalKineticGenerator, ItemBlockKC2ThermalKineticGenerator.class, "thermalKineticGenerator");
        GameRegistry.registerBlock(enderKineticEnergyPylon, "enderKineticEnergyPylon");
        GameRegistry.registerBlock(kc2treadmill, ItemBlockKC2Treadmill.class, "kc2Treadmill");

        /* Crafting Recipes */
        GameRegistry.addShapelessRecipe(new ItemStack(kineticBlock, 2), new Object[]{
                Blocks.sand,
                Blocks.dirt
        });
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(netherKineticBlock, 4), new Object[]{
                "SDS",
                "BNB",
                "SDS",
                'S', Blocks.sand,
                'D', Blocks.dirt,
                'B', Items.blaze_powder,
                'N', Blocks.netherrack
        }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(enderKineticBlock, 4), new Object[]{
                "SDS",
                "EPE",
                "SDS",
                'S', Blocks.sand,
                'D', Blocks.dirt,
                'P', Items.ender_pearl,
                'E', Blocks.end_stone
        }));
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
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kc2treadmill, 1, 0), new Object[]{
                "IGI",
                "GEG",
                "IGI",
                'E', Items.emerald,
                'I', KinetiCraft2Items.kineticIngot,
                'G', KinetiCraft2Items.kineticGear
        }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(thermalKineticGenerator, 1, 0), new Object[]{
                "IGI",
                "GFG",
                "IGI",
                'F', KinetiCraft2Items.kineticFrame,
                'I', KinetiCraft2Items.netherKineticIngot,
                'G', KinetiCraft2Items.netherKineticGear
        }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(enderKineticGenerator, 1, 0), new Object[]{
                "IGI",
                "GFG",
                "IGI",
                'F', KinetiCraft2Items.kineticFrame,
                'I', KinetiCraft2Items.enderKineticIngot,
                'G', KinetiCraft2Items.enderKineticGear
        }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(enderKineticEnergyPylon, 1, 0), new Object[]{
                "IGI",
                "GPG",
                "IGI",
                'P', Items.ender_pearl,
                'I', KinetiCraft2Items.enderKineticIngot,
                'G', Blocks.glass_pane
        }));

        /* Register furnace smelts */
        GameRegistry.addSmelting(kineticBlock, new ItemStack(KinetiCraft2Items.kineticIngot, 1, 0), 0.1f);
        GameRegistry.addSmelting(enderKineticBlock, new ItemStack(KinetiCraft2Items.enderKineticIngot, 1, 0), 0.1f);
    }

    public static Object getOreWithVanillaFallback(Object vanillaFallback, String... moddedOre) {
        for (String modOre : moddedOre) {
            if (OreDictionary.getOres(modOre).size() > 0)
                return modOre;
        }

        return vanillaFallback;
    }
}
