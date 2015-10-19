package com.techmafia.mcmods.KinetiCraft2.proxy;

import com.techmafia.mcmods.KinetiCraft2.init.KinetiCraft2Blocks;
import com.techmafia.mcmods.KinetiCraft2.renderers.TileEntityItemRendererKC2HardenedKineticEnergyCube;
import com.techmafia.mcmods.KinetiCraft2.renderers.TileEntityItemRendererKC2KineticEnergyCube;
import com.techmafia.mcmods.KinetiCraft2.renderers.TileEntityRendererKC2HardenedKineticEnergyCube;
import com.techmafia.mcmods.KinetiCraft2.renderers.TileEntityRendererKC2KineticEnergyCube;
import com.techmafia.mcmods.KinetiCraft2.renderers.base.TileEntityItemRendererKC2Base;
import com.techmafia.mcmods.KinetiCraft2.renderers.base.TileEntityRendererKC2Base;
import com.techmafia.mcmods.KinetiCraft2.tileentities.TileEntityKC2HardenedKineticEnergyCube;
import com.techmafia.mcmods.KinetiCraft2.tileentities.TileEntityKC2KineticEnergyCube;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

/**
 * Created by Meng on 7/31/2015.
 */
@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit() {
        super.preInit();
    }

    @Override
    public void registerClientStuff() {
        //TileEntitySpecialRenderer kineticEnergyCubeSpecialRenderer = new TileEntityRendererKC2KineticEnergyCube();
        //TileEntitySpecialRenderer hardenedKineticEnergyCubeSpecialRenderer = new TileEntityRendererKC2HardenedKineticEnergyCube();

        //ClientRegistry.bindTileEntitySpecialRenderer(TileEntityKC2KineticEnergyCube.class, kineticEnergyCubeSpecialRenderer);
        //ClientRegistry.bindTileEntitySpecialRenderer(TileEntityKC2HardenedKineticEnergyCube.class, hardenedKineticEnergyCubeSpecialRenderer);

        //MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(KinetiCraft2Blocks.kineticEnergyCube), new TileEntityItemRendererKC2Base(kineticEnergyCubeSpecialRenderer, new TileEntityKC2KineticEnergyCube()));
        //MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(KinetiCraft2Blocks.kineticEnergyCube), new TileEntityItemRendererKC2Base(hardenedKineticEnergyCubeSpecialRenderer, new TileEntityKC2HardenedKineticEnergyCube()));
    }
}
