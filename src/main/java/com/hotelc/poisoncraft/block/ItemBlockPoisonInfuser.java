package com.hotelc.poisoncraft.block;

import com.hotelc.poisoncraft.Poisoncraft;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

/**
 * This file created by Alex Brooke
 * please seek the author's permission before
 * distributing this software.
 * 'Do you know Java? Because your method body is sexy'
 * :3
 */
public class ItemBlockPoisonInfuser extends ItemBlock {
    public ItemBlockPoisonInfuser(Block block) {
        super(block);
        setUnlocalizedName("poison_infuser");
        setTextureName(Poisoncraft.MODID + ":poison_infuser");
    }
}
