package com.hotelc.poisoncraft.net;


import com.hotelc.poisoncraft.net.message.MessagePoisonInfuser;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

/**
 * This file created by Alex Brooke
 * please seek the author's permission before
 * distributing this software.
 * 'Do you know Java? Because your method body is sexy'
 * :3
 */

public class PacketHandler {
    public static SimpleNetworkWrapper INSTANCE;
    public static void init() {
        INSTANCE  = NetworkRegistry.INSTANCE.newSimpleChannel("Poisoncraft");
        INSTANCE.registerMessage(MessagePoisonInfuser.class, MessagePoisonInfuser.class, 0, Side.CLIENT);
    }
}


