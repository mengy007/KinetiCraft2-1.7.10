package com.techmafia.mcmods.KinetiCraft2.items;

import com.techmafia.mcmods.KinetiCraft2.items.base.ItemKC2KineticPickaxe;
import net.minecraft.item.Item;

/**
 * Created by myang on 10/20/15.
 */
public class ItemKC2KineticDiamondPickaxe extends ItemKC2KineticPickaxe {
    public ItemKC2KineticDiamondPickaxe() {
        super(ToolMaterial.EMERALD);
        setUnlocalizedName("kc2KineticDiamondPickaxe");
        setTextureName("kc2KineticDiamondPickaxe");

        capacity = 1000000;
        maxReceive = 32000;
        maxExtract = 32000;
        energyFromUsing = 5000;
        overChargeBuffer = 20;
        overChargeDamage = 8.0f;
    }
}
