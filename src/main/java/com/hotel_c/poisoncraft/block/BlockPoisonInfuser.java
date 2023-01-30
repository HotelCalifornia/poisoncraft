/*
 * @author "Hannah Brooke <hannah@mail.yttrium.io>" a.k.a hotel, HotelCalifornia, hotel_california
 *
 * Copyright (c) 2014.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.hotel_c.poisoncraft.block;

import com.hotel_c.poisoncraft.Poisoncraft;
import com.hotel_c.poisoncraft.gui.Handler;
import com.hotel_c.poisoncraft.tileentity.TileEntityPoisonInfuser;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class BlockPoisonInfuser extends Block implements ITileEntityProvider {
    private Random random = new Random();

    public BlockPoisonInfuser() {
        super(Material.iron);
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
        if(entity instanceof EntityPlayer && world.getTileEntity(x, y, z) != null) {
            TileEntityPoisonInfuser te = (TileEntityPoisonInfuser)world.getTileEntity(x, y, z);
            te.setOwner(entity.getUniqueID());
        }
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public int getRenderType() {
        return Poisoncraft.instance.BLOCKPOISONINFUSER_RENDER;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int p_149915_2_) {
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
        if (world.isRemote) {
            return false;
        } else {
            TileEntityPoisonInfuser te = (TileEntityPoisonInfuser) world.getTileEntity(x, y, z);
            if (te != null) {
                player.openGui(Poisoncraft.instance, Handler.GUI_POISON_INFUSER, world, x, y, z);
            }
            return true;
        }
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block,
                           int i) {
        TileEntity tileentity = world.getTileEntity(x, y, z);

        if (tileentity instanceof TileEntityPoisonInfuser) {
            TileEntityPoisonInfuser te = (TileEntityPoisonInfuser) tileentity;

            for (int i1 = 0; i1 < te.getSizeInventory(); ++i1) {
                ItemStack itemstack = te.getStackInSlot(i1);

                if (itemstack != null) {
                    float f = this.random.nextFloat() * 0.8F + 0.1F;
                    float f1 = this.random.nextFloat() * 0.8F + 0.1F;
                    float f2 = this.random.nextFloat() * 0.8F + 0.1F;

                    while (itemstack.stackSize > 0) {
                        int j1 = this.random.nextInt(21) + 10;

                        if (j1 > itemstack.stackSize) {
                            j1 = itemstack.stackSize;
                        }

                        itemstack.stackSize -= j1;
                        EntityItem entityitem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1),
                                                                      (double) ((float) z + f2), new ItemStack(itemstack.getItem(),
                                                                      j1, itemstack.getItemDamage()));
                        float f3 = 0.05F;
                        entityitem.motionX = (double) ((float) this.random.nextGaussian() * f3);
                        entityitem.motionY = (double) ((float) this.random.nextGaussian() * f3 + 0.2F);
                        entityitem.motionZ = (double) ((float) this.random.nextGaussian() * f3);
                        world.spawnEntityInWorld(entityitem);
                    }
                }
            }
        }
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
        double dx = (double)((float)x + 0.4F + rand.nextFloat() * 0.2F);
        double dy = (double)((float)y + 0.7F + rand.nextFloat() * 0.3F);
        double dz = (double)((float)z + 0.4F + rand.nextFloat() * 0.2F);
        world.spawnParticle("smoke", dx, dy, dz, 0.0D, 0.0D, 0.0D);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z){
        return com.hotel_c.poisoncraft.block.Blocks.poison_infuser;
    }

    @Override
    public boolean hasComparatorInputOverride() {
        return true;
    }

    @Override
    public int getComparatorInputOverride(World world, int x, int y, int z, int i) {
        return Container.calcRedstoneFromInventory((IInventory) world.getTileEntity(x, y, z));
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return com.hotel_c.poisoncraft.block.Blocks.poison_infuser;
    }
}
