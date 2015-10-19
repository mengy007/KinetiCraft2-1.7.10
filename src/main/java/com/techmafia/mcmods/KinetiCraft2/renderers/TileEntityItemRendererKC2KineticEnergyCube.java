package com.techmafia.mcmods.KinetiCraft2.renderers;

import com.techmafia.mcmods.KinetiCraft2.renderers.base.TileEntityItemRendererKC2Base;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

/**
 * Created by Meng on 7/31/2015.
 */
public class TileEntityItemRendererKC2KineticEnergyCube extends TileEntityItemRendererKC2Base {
    public TileEntityItemRendererKC2KineticEnergyCube(TileEntitySpecialRenderer render, TileEntity entity) {
        super(render, entity);
    }
}
