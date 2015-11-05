package com.techmafia.mcmods.KinetiCraft2.proxy;

import com.techmafia.mcmods.KinetiCraft2.init.KinetiCraft2TileEntities;
import com.techmafia.mcmods.KinetiCraft2.init.KinetiCraft2Blocks;
import com.techmafia.mcmods.KinetiCraft2.init.KinetiCraft2Items;
import com.techmafia.mcmods.KinetiCraft2.net.CommonPacketHandler;

/**
 * Created by Meng on 7/31/2015.
 */
public class CommonProxy {
    public void preInit() {
        /* Network stuff */
        CommonPacketHandler.init();

        /* Items */
        KinetiCraft2Items.init();

        /* Blocks */
        KinetiCraft2Blocks.init();

        /* Tile Entities */
        KinetiCraft2TileEntities.init();
    }

    public void registerClientStuff() {}
}
