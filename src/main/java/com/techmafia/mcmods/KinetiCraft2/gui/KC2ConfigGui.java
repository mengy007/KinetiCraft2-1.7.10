package com.techmafia.mcmods.KinetiCraft2.gui;

import com.techmafia.mcmods.KinetiCraft2.KinetiCraft2;
import com.techmafia.mcmods.KinetiCraft2.handlers.ConfigurationHandler;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

/**
 * Created by myang on 11/7/15.
 */
public class KC2ConfigGui extends GuiConfig {
    public KC2ConfigGui(GuiScreen parent) {
        super(parent,
                new ConfigElement(ConfigurationHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                "KinetiCraft 2", false, false, GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString()));
    }
}
