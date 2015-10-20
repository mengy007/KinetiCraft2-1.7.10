package com.techmafia.mcmods.KinetiCraft2.init;

import com.techmafia.mcmods.KinetiCraft2.items.ItemKC2KineticEnergyCore;
import com.techmafia.mcmods.KinetiCraft2.items.ItemKC2KineticIronPickaxe;
import com.techmafia.mcmods.KinetiCraft2.items.ItemKC2KineticStonePickaxe;
import com.techmafia.mcmods.KinetiCraft2.items.base.ItemKC2Base;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * Created by Meng on 7/27/2015.
 */
public class KinetiCraft2Items {
    public static final ItemKC2Base kineticDust                         = new ItemKC2Base("kineticDust", 64, false);
    public static final ItemKC2Base kineticIngot                        = new ItemKC2Base("kineticIngot", 64, false);
    public static final ItemKC2Base kineticGear                         = new ItemKC2Base("kineticGear", 64, false);
    public static final ItemKC2Base kineticFrame                        = new ItemKC2Base("kineticFrame", 64, false);
    public static final ItemKC2KineticEnergyCore kineticEnergyCore      = new ItemKC2KineticEnergyCore();
    public static final ItemKC2KineticStonePickaxe kineticStonePickaxe  = new ItemKC2KineticStonePickaxe();
    public static final ItemKC2KineticIronPickaxe kineticIronPickaxe    = new ItemKC2KineticIronPickaxe();

    public static void init() {
        /* Register Items */
        GameRegistry.registerItem(kineticDust, "kineticDust");
        GameRegistry.registerItem(kineticIngot, "kineticIngot");
        GameRegistry.registerItem(kineticGear, "kineticGear");
        GameRegistry.registerItem(kineticFrame, "kineticFrame");

        GameRegistry.registerItem(kineticEnergyCore, "kineticEnergyCore");

        GameRegistry.registerItem(kineticStonePickaxe, "kineticStonePickaxe");
        GameRegistry.registerItem(kineticIronPickaxe, "kineticIronPickaxe");


        /* Empty Energy Cores */
        ItemStack woodenCoreEmpty = new ItemStack(kineticEnergyCore, 1, 0);
        ItemStack stoneCoreEmpty = new ItemStack(kineticEnergyCore, 1, 1);
        ItemStack ironCoreEmpty = new ItemStack(kineticEnergyCore, 1, 2);
        ItemStack goldCoreEmpty = new ItemStack(kineticEnergyCore, 1, 3);
        ItemStack diamondCoreEmpty = new ItemStack(kineticEnergyCore, 1, 4);
        ItemStack enderCoreEmpty = new ItemStack(kineticEnergyCore, 1, 5);

        /* Register furnace smelts */
        GameRegistry.addSmelting(kineticDust, new ItemStack(kineticIngot, 1, 0), 0.1f);

        /* Register Item Recipes */
        GameRegistry.addRecipe(new ItemStack(kineticGear, 1), new Object[]{
                " K ",
                "KKK",
                " K ",
                'K', KinetiCraft2Items.kineticIngot
        });
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kineticFrame, 1), new Object[]{
                "CKC",
                "K K",
                "CKC",
                'K', KinetiCraft2Items.kineticIngot,
                'C', Blocks.cobblestone
        }));
        GameRegistry.addRecipe(woodenCoreEmpty, new Object[]{
                "WWW",
                "WGW",
                "WWW",
                'W', Blocks.planks,
                'G', kineticGear
        });
        GameRegistry.addRecipe(stoneCoreEmpty, new Object[]{
                "SSS",
                "SGS",
                "SSS",
                'S', Blocks.stone,
                'G', kineticGear
        });
        GameRegistry.addRecipe(ironCoreEmpty, new Object[]{
                "III",
                "IGI",
                "III",
                'I', Items.iron_ingot,
                'G', kineticGear
        });
        GameRegistry.addRecipe(goldCoreEmpty, new Object[]{
                "GGG",
                "RKR",
                "GGG",
                'G', Items.gold_ingot,
                'R', Items.redstone,
                'K', kineticGear
        });
        GameRegistry.addRecipe(diamondCoreEmpty, new Object[]{
                "DRD",
                "RGR",
                "DRD",
                'D', Items.diamond,
                'R', Items.redstone,
                'G', kineticGear
        });
        GameRegistry.addRecipe(enderCoreEmpty, new Object[]{
                "ERE",
                "RGR",
                "ERE",
                'E', Items.ender_pearl,
                'R', Items.redstone,
                'G', kineticGear
        });

        // Tools
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kineticStonePickaxe, 1), new Object[]{
                "IGI",
                "GTG",
                "IGI",
                'G', kineticGear,
                'I', kineticIngot,
                'T', Items.stone_pickaxe
        }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kineticIronPickaxe, 1), new Object[]{
                "IGI",
                "GTG",
                "IGI",
                'G', kineticGear,
                'I', kineticIngot,
                'T', Items.iron_pickaxe
        }));
    }
}