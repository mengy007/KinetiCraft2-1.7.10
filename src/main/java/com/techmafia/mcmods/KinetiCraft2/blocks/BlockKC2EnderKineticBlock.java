package com.techmafia.mcmods.KinetiCraft2.blocks;

import com.techmafia.mcmods.KinetiCraft2.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;

/**
 * Created by myang on 11/4/15.
 */
public class BlockKC2EnderKineticBlock extends Block {
    private IIcon blockIcon;

    public BlockKC2EnderKineticBlock() {
        super(Material.ground);
        this.setBlockName("kineticBlock");
        this.setBlockTextureName(Reference.TEXTURE_NAME_PREFIX + "enderKineticBlock");
        this.setHardness(0.5f);
        this.setStepSound(Block.soundTypeGravel);
    }
}
