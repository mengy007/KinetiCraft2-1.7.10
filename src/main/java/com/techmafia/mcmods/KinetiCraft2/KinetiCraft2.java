package com.techmafia.mcmods.KinetiCraft2;

import com.techmafia.mcmods.KinetiCraft2.handlers.ConfigurationHandler;
import com.techmafia.mcmods.KinetiCraft2.init.KinetiCraft2Items;
import com.techmafia.mcmods.KinetiCraft2.reference.Reference;
import com.techmafia.mcmods.KinetiCraft2.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.Mod;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)

public class KinetiCraft2
{
    @Mod.Instance(Reference.MOD_ID)
    public static KinetiCraft2 instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent preInitializationEvent) {
        /* Config */
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

        /* Items */
        KinetiCraft2Items.init();

        LogHelper.info("Pre Init Complete!");
    }
}
