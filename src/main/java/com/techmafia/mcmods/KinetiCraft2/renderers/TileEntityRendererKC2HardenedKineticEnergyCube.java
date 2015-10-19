package com.techmafia.mcmods.KinetiCraft2.renderers;

import com.techmafia.mcmods.KinetiCraft2.reference.Reference;
import com.techmafia.mcmods.KinetiCraft2.renderers.base.TileEntityRendererKC2Base;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Meng on 10/18/2015.
 */
public class TileEntityRendererKC2HardenedKineticEnergyCube extends TileEntityRendererKC2Base {
    public TileEntityRendererKC2HardenedKineticEnergyCube() {
        super();

        textureFull = new ResourceLocation(Reference.MOD_NAME + ":textures/blocks/hardenedKineticEnergyCube.png");
        textureFrame = new ResourceLocation(Reference.MOD_NAME + ":textures/blocks/hardenedKineticEnergyCubeFrame.png");
        textureSide = new ResourceLocation(Reference.MOD_NAME + ":textures/blocks/hardenedKineticEnergyCubeSide.png");
    }
}
