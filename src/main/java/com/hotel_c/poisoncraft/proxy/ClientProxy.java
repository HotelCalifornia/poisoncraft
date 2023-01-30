/*
 * @author "Hannah Brooke <hannah@mail.yttrium.io>" a.k.a hotel, HotelCalifornia, hotel_california
 *
 * Copyright (c) 2014.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.hotel_c.poisoncraft.proxy;

import com.hotel_c.poisoncraft.tileentity.TileEntityPoisonInfuser;
import com.hotel_c.poisoncraft.tileentity.render.TileEntitySpecialRendererPoisonInfuser;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy {
    @Override
    @SideOnly(Side.CLIENT)
    public void registerRenderers() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPoisonInfuser.class,
                new TileEntitySpecialRendererPoisonInfuser());
    }
}
