package com.techmafia.mcmods.KinetiCraft2.items.base;

import com.techmafia.mcmods.KinetiCraft2.creativetab.CreativeTabKC2;
import com.techmafia.mcmods.KinetiCraft2.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

/**
 * Created by Meng on 10/17/2015.
 */
public class ItemKC2Base extends Item {
    public ItemKC2Base() {
        super();
        this.setMaxStackSize(64);
        this.setCreativeTab(CreativeTabKC2.KC2_TAB);
    }

    public ItemKC2Base(String itemName, int stackSize, boolean canBeDamaged) {
        super();
        this.setUnlocalizedName(itemName);
        this.setMaxStackSize(stackSize);
        this.setCreativeTab(CreativeTabKC2.KC2_TAB);

        if (!canBeDamaged) {
            this.setNoRepair();
        }
    }

    public String getUnwrappedUnlocalizedName(final String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(final ItemStack itemStack) {
        return getUnlocalizedName();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(Reference.MOD_NAME + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(":") + 1));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int par1) {
        return this.itemIcon;
    }

    @Override
    public boolean hasCustomEntity(ItemStack itemStack) {
        return false;
    }
}
