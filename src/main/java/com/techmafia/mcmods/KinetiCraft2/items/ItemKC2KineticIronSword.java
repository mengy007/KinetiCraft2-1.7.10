package com.techmafia.mcmods.KinetiCraft2.items;

import com.techmafia.mcmods.KinetiCraft2.items.base.ItemKC2KineticSword;

/**
 * Created by myang on 10/20/15.
 */
public class ItemKC2KineticIronSword extends ItemKC2KineticSword {
    public ItemKC2KineticIronSword() {
        super(ToolMaterial.IRON);

        setUnlocalizedName("kc2KineticIronSword");
        setTextureName("kc2KineticIronSword");

        capacity = 50000;
        maxReceive = 5000;
        maxExtract = 5000;
        energyFromUsing = 100;
        overChargeBuffer = 8;
        overChargeDamage = 2.0f;
    }
}
