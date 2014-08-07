package com.hotelc.poisoncraft.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

import java.util.ArrayList;
import java.util.UUID;

/**
 * This file created by Alex Brooke
 * please seek the author's permission before
 * distributing this software.
 * 'Do you know Java? Because your method body is sexy'
 * :3
 */
@SuppressWarnings("unchecked")
public class Helper {
    public static EntityPlayer getPlayerFromUUID(UUID uuid) {
        for(EntityPlayer ep : (ArrayList<EntityPlayer>)MinecraftServer.getServer().getConfigurationManager().playerEntityList) {
            if(ep.getUniqueID().equals(uuid)) {
                return ep;
            }
        }
        return null;
    }
    public static boolean isPlayerOnline(EntityPlayer player) {
        for (EntityPlayer ep : (ArrayList<EntityPlayer>) MinecraftServer.getServer().getConfigurationManager().playerEntityList) {
            if(ep.getUniqueID().equals(player.getUniqueID())) {
                return true;
            }
        }
        return false;
    }
}