package com.techmafia.mcmods.KinetiCraft2.items;

import com.techmafia.mcmods.KinetiCraft2.items.base.ItemKC2KineticPickaxe;
import net.minecraft.item.Item;

/**
 * Created by myang on 10/20/15.
 */
public class ItemKC2KineticWoodenPickaxe extends ItemKC2KineticPickaxe {
    public ItemKC2KineticWoodenPickaxe() {
        super(Item.ToolMaterial.WOOD);
        setUnlocalizedName("kc2KineticWoodenPickaxe");
        setTextureName("kc2KineticWoodenPickaxe");

        capacity = 1000;
        maxReceive = 100;
        maxExtract = 100;
        energyFromUsing = 5;
        overChargeBuffer = 2;
        overChargeDamage = 1.0f;
    }
}