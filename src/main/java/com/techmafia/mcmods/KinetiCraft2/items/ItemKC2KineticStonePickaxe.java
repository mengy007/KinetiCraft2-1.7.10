package com.techmafia.mcmods.KinetiCraft2.items;

import com.techmafia.mcmods.KinetiCraft2.items.base.ItemKC2KineticPickaxe;
import net.minecraft.item.Item;

/**
 * Created by myang on 10/19/15.
 */
public class ItemKC2KineticStonePickaxe extends ItemKC2KineticPickaxe {
    public ItemKC2KineticStonePickaxe() {
        super(Item.ToolMaterial.STONE);
        setUnlocalizedName("kc2KineticStonePickaxe");
        setTextureName("kc2KineticStonePickaxe");

        capacity = 10000;
        maxReceive = 1000;
        maxExtract = 1000;
        energyFromUsing = 50;
        overChargeBuffer = 4;
        overChargeDamage = 1.5f;
    }
}
