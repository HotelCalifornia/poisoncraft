package com.hotelc.poisoncraft.block;

import com.hotelc.poisoncraft.Poisoncraft;
import com.hotelc.poisoncraft.tileentity.TileEntityPoisonInfuser;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.List;

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

    @Override
    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB aabb,
                                        List list, Entity entity) {
        setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 2.0f, 1.0f);
        super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
        this.setBlockBoundsForItemRender();
        super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
    }

    @Override
    public void setBlockBoundsForItemRender() {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player,
                                    int num, float hitx, float hity, float hitz) {
        if(world.isRemote) {
            return false;
        }
        else {
            TileEntityPoisonInfuser te = (TileEntityPoisonInfuser)world.getTileEntity(x, y, z);
            if(te != null) {
                //TODO: change the magic number 0 to a constant from a list of GUIIDs
                player.openGui(Poisoncraft.instance, 0, world, x, y, z);
            }
            return true;
        }
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity,
                                ItemStack stack) {
        if(stack.hasDisplayName()){

        }
    }
}
