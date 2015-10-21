package com.techmafia.mcmods.KinetiCraft2.items;

import com.techmafia.mcmods.KinetiCraft2.items.base.ItemKC2KineticSword;

/**
 * Created by myang on 10/20/15.
 */
public class ItemKC2KineticGoldenSword extends ItemKC2KineticSword {
    public ItemKC2KineticGoldenSword() {
        super(ToolMaterial.GOLD);

        setUnlocalizedName("kc2KineticGoldenSword");
        setTextureName("kc2KineticGoldenSword");

        capacity = 100000;
        maxReceive = 10000;
        maxExtract = 10000;
        energyFromUsing = 400;
        overChargeBuffer = 10;
        overChargeDamage = 4.0f;
    }
}
