package com.techmafia.mcmods.KinetiCraft2.items;

import com.techmafia.mcmods.KinetiCraft2.items.base.ItemKC2KineticSword;

/**
 * Created by myang on 10/20/15.
 */
public class ItemKC2KineticStoneSword extends ItemKC2KineticSword {
    public ItemKC2KineticStoneSword() {
        super(ToolMaterial.STONE);

        setUnlocalizedName("kc2KineticStoneSword");
        setTextureName("kc2KineticStoneSword");

        capacity = 10000;
        maxReceive = 1000;
        maxExtract = 1000;
        energyFromUsing = 20;
        overChargeBuffer = 4;
        overChargeDamage = 1.5f;
    }
}
