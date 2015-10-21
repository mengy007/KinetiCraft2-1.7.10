package com.techmafia.mcmods.KinetiCraft2.items;

import com.techmafia.mcmods.KinetiCraft2.items.base.ItemKC2KineticPickaxe;
import net.minecraft.item.Item;

/**
 * Created by myang on 10/20/15.
 */
public class ItemKC2KineticGoldenPickaxe extends ItemKC2KineticPickaxe {
    public ItemKC2KineticGoldenPickaxe() {
        super(Item.ToolMaterial.GOLD);
        setUnlocalizedName("kc2KineticGoldenPickaxe");
        setTextureName("kc2KineticGoldenPickaxe");

        capacity = 100000;
        maxReceive = 10000;
        maxExtract = 10000;
        energyFromUsing = 1000;
        overChargeBuffer = 10;
        overChargeDamage = 4.0f;
    }
}