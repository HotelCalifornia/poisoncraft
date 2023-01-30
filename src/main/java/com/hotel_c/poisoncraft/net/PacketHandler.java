/*
 * @author "Hannah Brooke <hannah@mail.yttrium.io>" a.k.a hotel, HotelCalifornia, hotel_california
 *
 * Copyright (c) 2014.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.hotel_c.poisoncraft.net;


import com.hotel_c.poisoncraft.net.message.MessagePoisonInfuser;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;


public class PacketHandler {
    public static SimpleNetworkWrapper INSTANCE;
    public static void init() {
        INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("Poisoncraft");
        INSTANCE.registerMessage(MessagePoisonInfuser.class, MessagePoisonInfuser.class, 0, Side.CLIENT);
    }
}


