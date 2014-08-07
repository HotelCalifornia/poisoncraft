package com.hotelc.poisoncraft.event;

import com.hotelc.poisoncraft.entity.PoisonSkillStats;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

/**
 * This file created by Alex Brooke
 * please seek the author's permission before
 * distributing this software.
 * 'Do you know Java? Because your method body is sexy'
 * :3
 */
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
}
