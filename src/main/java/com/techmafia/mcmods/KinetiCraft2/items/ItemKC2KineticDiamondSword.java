package com.techmafia.mcmods.KinetiCraft2.items;

import com.techmafia.mcmods.KinetiCraft2.items.base.ItemKC2KineticSword;

/**
 * Created by myang on 10/20/15.
 */
public class ItemKC2KineticDiamondSword extends ItemKC2KineticSword {
    public ItemKC2KineticDiamondSword() {
        super(ToolMaterial.EMERALD);

        setUnlocalizedName("kc2KineticDiamondSword");
        setTextureName("kc2KineticDiamondSword");

        capacity = 1000000;
        maxReceive = 32000;
        maxExtract = 32000;
        energyFromUsing = 2000;
        overChargeBuffer = 20;
        overChargeDamage = 8.0f;
    }
}
