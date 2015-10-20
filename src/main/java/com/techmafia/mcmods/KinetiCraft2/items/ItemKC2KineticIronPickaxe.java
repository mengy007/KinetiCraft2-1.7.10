package com.techmafia.mcmods.KinetiCraft2.items;

import com.techmafia.mcmods.KinetiCraft2.items.base.ItemKC2KineticPickaxe;
import net.minecraft.item.Item;

/**
 * Created by myang on 10/20/15.
 */
public class ItemKC2KineticIronPickaxe extends ItemKC2KineticPickaxe {
    public ItemKC2KineticIronPickaxe() {
        super(Item.ToolMaterial.IRON);
        setUnlocalizedName("kc2KineticIronPickaxe");
        setTextureName("kc2KineticIronPickaxe");

        capacity = 100000;
        maxReceive = 5000;
        maxExtract = 5000;
        energyFromUsing = 250;
        overChargeBuffer = 8;
        overChargeDamage = 2.0f;
    }
}
