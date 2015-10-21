package com.techmafia.mcmods.KinetiCraft2.items;

import com.techmafia.mcmods.KinetiCraft2.items.base.ItemKC2KineticSword;

/**
 * Created by myang on 10/20/15.
 */
public class ItemKC2KineticWoodenSword extends ItemKC2KineticSword {
    public ItemKC2KineticWoodenSword() {
        super(ToolMaterial.WOOD);

        setUnlocalizedName("kc2KineticWoodenSword");
        setTextureName("kc2KineticWoodenSword");

        capacity = 1000;
        maxReceive = 100;
        maxExtract = 100;
        energyFromUsing = 2;
        overChargeBuffer = 2;
        overChargeDamage = 1.0f;
    }
}