/*
 * @author "Hannah Brooke <hannah@mail.yttrium.io>" a.k.a hotel, HotelCalifornia, hotel_california
 *
 * Copyright (c) 2014.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.hotel_c.poisoncraft.gui;

import com.hotel_c.poisoncraft.container.ContainerPoisonInfuser;
import com.hotel_c.poisoncraft.tileentity.TileEntityPoisonInfuser;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

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
