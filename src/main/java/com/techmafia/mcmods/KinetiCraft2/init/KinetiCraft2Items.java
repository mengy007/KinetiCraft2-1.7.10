package com.techmafia.mcmods.KinetiCraft2.init;

import com.techmafia.mcmods.KinetiCraft2.items.*;
import com.techmafia.mcmods.KinetiCraft2.items.base.ItemKC2Base;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * Created by Meng on 7/27/2015.
 */
public class KinetiCraft2Items {
    public static final ItemKC2Base kineticDust                             = new ItemKC2Base("kineticDust", 64, false);
    public static final ItemKC2Base kineticIngot                            = new ItemKC2Base("kineticIngot", 64, false);
    public static final ItemKC2Base kineticGear                             = new ItemKC2Base("kineticGear", 64, false);
    public static final ItemKC2Base kineticFrame                            = new ItemKC2Base("kineticFrame", 64, false);

    public static final ItemKC2KineticEnergyCore kineticEnergyCore          = new ItemKC2KineticEnergyCore();

    public static final ItemKC2KineticWoodenPickaxe kineticWoodenPickaxe    = new ItemKC2KineticWoodenPickaxe();
    public static final ItemKC2KineticStonePickaxe kineticStonePickaxe      = new ItemKC2KineticStonePickaxe();
    public static final ItemKC2KineticIronPickaxe kineticIronPickaxe        = new ItemKC2KineticIronPickaxe();
    public static final ItemKC2KineticGoldenPickaxe kineticGoldenPickaxe    = new ItemKC2KineticGoldenPickaxe();
    public static final ItemKC2KineticDiamondPickaxe kineticDiamondPickaxe  = new ItemKC2KineticDiamondPickaxe();

    public static final ItemKC2KineticWoodenSword kineticWoodenSword        = new ItemKC2KineticWoodenSword();
    public static final ItemKC2KineticStoneSword kineticStoneSword          = new ItemKC2KineticStoneSword();
    public static final ItemKC2KineticIronSword kineticIronSword            = new ItemKC2KineticIronSword();
    public static final ItemKC2KineticGoldenSword kineticGoldenSword        = new ItemKC2KineticGoldenSword();
    public static final ItemKC2KineticDiamondSword kineticDiamondSword      = new ItemKC2KineticDiamondSword();

    public static final ItemKC2KineticAxe kineticWoodenAxe                  = new ItemKC2KineticAxe(Item.ToolMaterial.WOOD, "kc2KineticWoodenAxe", 1000, 100, 5, 2, 1.0f);
    public static final ItemKC2KineticAxe kineticStoneAxe                   = new ItemKC2KineticAxe(Item.ToolMaterial.STONE, "kc2KineticStoneAxe", 10000, 1000, 50, 4, 1.5f);
    public static final ItemKC2KineticAxe kineticIronAxe                    = new ItemKC2KineticAxe(Item.ToolMaterial.IRON, "kc2KineticIronAxe", 50000, 5000, 250, 8, 2.0f);
    public static final ItemKC2KineticAxe kineticGoldenAxe                  = new ItemKC2KineticAxe(Item.ToolMaterial.GOLD, "kc2KineticGoldenAxe", 100000, 10000, 1000, 10, 4.0f);
    public static final ItemKC2KineticAxe kineticDiamondAxe                 = new ItemKC2KineticAxe(Item.ToolMaterial.EMERALD, "kc2KineticDiamondAxe", 1000000, 32000, 5000, 20, 8.0f);

    public static final ItemKC2KineticShovel kineticWoodenShovel            = new ItemKC2KineticShovel(Item.ToolMaterial.WOOD, "kc2KineticWoodenShovel", 1000, 100, 5, 2, 1.0f);
    public static final ItemKC2KineticShovel kineticStoneShovel             = new ItemKC2KineticShovel(Item.ToolMaterial.STONE, "kc2KineticStoneShovel", 10000, 1000, 50, 4, 1.5f);
    public static final ItemKC2KineticShovel kineticIronShovel              = new ItemKC2KineticShovel(Item.ToolMaterial.IRON, "kc2KineticIronShovel", 50000, 5000, 250, 8, 2.0f);
    public static final ItemKC2KineticShovel kineticGoldenShovel            = new ItemKC2KineticShovel(Item.ToolMaterial.GOLD, "kc2KineticGoldenShovel", 100000, 10000, 1000, 10, 4.0f);
    public static final ItemKC2KineticShovel kineticDiamondShovel           = new ItemKC2KineticShovel(Item.ToolMaterial.EMERALD, "kc2KineticDiamondShovel", 1000000, 32000, 5000, 20, 8.0f);

    public static void init() {
        /* Register Items */
        GameRegistry.registerItem(kineticDust, "kineticDust");
        GameRegistry.registerItem(kineticIngot, "kineticIngot");
        GameRegistry.registerItem(kineticGear, "kineticGear");
        GameRegistry.registerItem(kineticFrame, "kineticFrame");

        // Cores
        GameRegistry.registerItem(kineticEnergyCore, "kineticEnergyCore");

        // Pickaxes
        GameRegistry.registerItem(kineticWoodenPickaxe, "kineticWoodenPickaxe");
        GameRegistry.registerItem(kineticStonePickaxe, "kineticStonePickaxe");
        GameRegistry.registerItem(kineticIronPickaxe, "kineticIronPickaxe");
        GameRegistry.registerItem(kineticGoldenPickaxe, "kineticGoldenPickaxe");
        GameRegistry.registerItem(kineticDiamondPickaxe, "kineticDiamondPickaxe");

        // Swords
        GameRegistry.registerItem(kineticWoodenSword, "kineticWoodenSword");
        GameRegistry.registerItem(kineticStoneSword, "kineticStoneSword");
        GameRegistry.registerItem(kineticIronSword, "kineticIronSword");
        GameRegistry.registerItem(kineticGoldenSword, "kineticGoldenSword");
        GameRegistry.registerItem(kineticDiamondSword, "kineticDiamondSword");

        // Axes
        GameRegistry.registerItem(kineticWoodenAxe, "kineticWoodenAxe");
        GameRegistry.registerItem(kineticStoneAxe, "kineticStoneAxe");
        GameRegistry.registerItem(kineticIronAxe, "kineticIronAxe");
        GameRegistry.registerItem(kineticGoldenAxe, "kineticGoldenAxe");
        GameRegistry.registerItem(kineticDiamondAxe, "kineticDiamondAxe");

        // Shovels
        GameRegistry.registerItem(kineticWoodenShovel, "kineticWoodenShovel");
        GameRegistry.registerItem(kineticStoneShovel, "kineticStoneShovel");
        GameRegistry.registerItem(kineticIronShovel, "kineticIronShovel");
        GameRegistry.registerItem(kineticGoldenShovel, "kineticGoldenShovel");
        GameRegistry.registerItem(kineticDiamondShovel, "kineticDiamondShovel");

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

        // Pickaxes
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kineticWoodenPickaxe, 1), new Object[]{
                "IGI",
                "GTG",
                "IGI",
                'G', kineticGear,
                'I', kineticIngot,
                'T', Items.wooden_pickaxe
        }));
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
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kineticGoldenPickaxe, 1), new Object[]{
                "IGI",
                "GTG",
                "IGI",
                'G', kineticGear,
                'I', kineticIngot,
                'T', Items.golden_pickaxe
        }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kineticDiamondPickaxe, 1), new Object[]{
                "IGI",
                "GTG",
                "IGI",
                'G', kineticGear,
                'I', kineticIngot,
                'T', Items.diamond_pickaxe
        }));

        // Swords
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kineticWoodenSword, 1), new Object[]{
                "IGI",
                "GTG",
                "IGI",
                'G', kineticGear,
                'I', kineticIngot,
                'T', Items.wooden_sword
        }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kineticStoneSword, 1), new Object[]{
                "IGI",
                "GTG",
                "IGI",
                'G', kineticGear,
                'I', kineticIngot,
                'T', Items.stone_sword
        }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kineticIronSword, 1), new Object[]{
                "IGI",
                "GTG",
                "IGI",
                'G', kineticGear,
                'I', kineticIngot,
                'T', Items.iron_sword
        }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kineticGoldenSword, 1), new Object[]{
                "IGI",
                "GTG",
                "IGI",
                'G', kineticGear,
                'I', kineticIngot,
                'T', Items.golden_sword
        }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kineticDiamondSword, 1), new Object[]{
                "IGI",
                "GTG",
                "IGI",
                'G', kineticGear,
                'I', kineticIngot,
                'T', Items.diamond_sword
        }));

        // Axes
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kineticWoodenAxe, 1), new Object[]{
                "IGI",
                "GTG",
                "IGI",
                'G', kineticGear,
                'I', kineticIngot,
                'T', Items.wooden_axe
        }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kineticStoneAxe, 1), new Object[]{
                "IGI",
                "GTG",
                "IGI",
                'G', kineticGear,
                'I', kineticIngot,
                'T', Items.stone_axe
        }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kineticIronAxe, 1), new Object[]{
                "IGI",
                "GTG",
                "IGI",
                'G', kineticGear,
                'I', kineticIngot,
                'T', Items.iron_axe
        }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kineticGoldenAxe, 1), new Object[]{
                "IGI",
                "GTG",
                "IGI",
                'G', kineticGear,
                'I', kineticIngot,
                'T', Items.golden_axe
        }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kineticDiamondAxe, 1), new Object[]{
                "IGI",
                "GTG",
                "IGI",
                'G', kineticGear,
                'I', kineticIngot,
                'T', Items.diamond_axe
        }));

        // Shovels
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kineticWoodenShovel, 1), new Object[]{
                "IGI",
                "GTG",
                "IGI",
                'G', kineticGear,
                'I', kineticIngot,
                'T', Items.wooden_shovel
        }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kineticStoneShovel, 1), new Object[]{
                "IGI",
                "GTG",
                "IGI",
                'G', kineticGear,
                'I', kineticIngot,
                'T', Items.stone_shovel
        }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kineticIronShovel, 1), new Object[]{
                "IGI",
                "GTG",
                "IGI",
                'G', kineticGear,
                'I', kineticIngot,
                'T', Items.iron_shovel
        }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kineticGoldenShovel, 1), new Object[]{
                "IGI",
                "GTG",
                "IGI",
                'G', kineticGear,
                'I', kineticIngot,
                'T', Items.golden_shovel
        }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kineticDiamondShovel, 1), new Object[]{
                "IGI",
                "GTG",
                "IGI",
                'G', kineticGear,
                'I', kineticIngot,
                'T', Items.diamond_shovel
        }));
    }
}