package com.hotel_c.poisoncraft.util;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
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
        if(MinecraftServer.getServer().getConfigurationManager() == null) {
            return Minecraft.getMinecraft().thePlayer;
        }
        for(EntityPlayer ep : (ArrayList<EntityPlayer>)MinecraftServer.getServer().getConfigurationManager().playerEntityList) {
            if(ep.getUniqueID().equals(uuid)) {
                return ep;
            }
        }
        return null;
    }
    public static boolean isPlayerOnline(UUID player) {
        if(MinecraftServer.getServer().getConfigurationManager() == null) return true;
        for (EntityPlayer ep : (ArrayList<EntityPlayer>) MinecraftServer.getServer().getConfigurationManager().playerEntityList) {
            if(ep != null && ep.getUniqueID().equals(player)) {
                return true;
            }
        }
        return false;
    }
    public static NBTTagCompound getTagCompound(ItemStack stack) {
        if(stack.getTagCompound() == null) {
            stack.setTagCompound(new NBTTagCompound());
        }
        return stack.getTagCompound();
    }
}