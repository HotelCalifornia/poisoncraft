package com.hotelc.poisoncraft.gui;

import com.hotelc.poisoncraft.container.ContainerPoisonInfuser;
import com.hotelc.poisoncraft.tileentity.TileEntityPoisonInfuser;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * This file created by Alex Brooke
 * please seek the author's permission before
 * distributing this software.
 * 'Do you know Java? Because your method body is sexy'
 * :3
 */
public class Handler implements IGuiHandler {
    public static final int GUI_POISON_INFUSER = 0;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity te = world.getTileEntity(x, y, z);
        if(te == null) return null;
        else {
            switch (ID) {
                case GUI_POISON_INFUSER:
                    return new ContainerPoisonInfuser(player.inventory, (TileEntityPoisonInfuser)world.getTileEntity(x, y, z));
                default:
                    return null;
            }
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity te = world.getTileEntity(x, y, z);
        if(te == null) return null;
        else {
            switch (ID) {
                case GUI_POISON_INFUSER:
                    return new GuiPoisonInfuser(player.inventory, (TileEntityPoisonInfuser)te);
                default:
                    return null;
            }
        }
    }
}
