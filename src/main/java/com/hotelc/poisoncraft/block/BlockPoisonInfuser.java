package com.hotelc.poisoncraft.block;

import com.hotelc.poisoncraft.tileentity.TileEntityPoisonInfuser;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * This file created by Alex Brooke
 * please seek the author's permission before
 * distributing this software.
 * 'Do you know Java? Because your method body is sexy'
 * :3
 */
public class BlockPoisonInfuser extends BlockContainer {
    public BlockPoisonInfuser() {
        super(Material.iron);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public int getRenderType() {
        return 25;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityPoisonInfuser();
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }


}
