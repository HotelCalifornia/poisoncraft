/*
 * @author "Hannah Brooke <hannah@mail.yttrium.io>" a.k.a hotel, HotelCalifornia, hotel_california
 *
 * Copyright (c) 2014.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.hotel_c.poisoncraft.event;

import com.hotel_c.poisoncraft.item.ItemBlockPoisonInfuser;
import com.hotel_c.poisoncraft.entity.PoisonSkillStats;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.command.CommandGive;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class EventHandler {
    public void register() {
        MinecraftForge.EVENT_BUS.register(this);
    }
    @SubscribeEvent
    public void onEntityConstructing(EntityEvent.EntityConstructing event) {
        if(event.entity instanceof EntityPlayer) {
            PoisonSkillStats.init(event.entity);
        }
    }
    @SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event) {
        PoisonSkillStats eep = (PoisonSkillStats)event.original.getExtendedProperties(PoisonSkillStats.IDENTIFIER);
        NBTTagCompound nbt = new NBTTagCompound();
        eep.saveNBTData(nbt);
        event.entity.getExtendedProperties(PoisonSkillStats.IDENTIFIER).loadNBTData(nbt);
    }
    @SubscribeEvent
    public void onItemCrafted(ItemCraftedEvent event) {
        if(event.crafting.getItem() instanceof ItemBlockPoisonInfuser) {
            NBTTagCompound nbt = new NBTTagCompound();
            nbt.setString("owner", event.player.getUniqueID().toString());
            event.crafting.setTagCompound(nbt);
        }
    }
    @SubscribeEvent
    public void onChatCommand(CommandEvent event) {
        if(event.command instanceof CommandGive) {
            CommandGive cmd = (CommandGive)event.command;
            cmd.get
        }
    }
}
