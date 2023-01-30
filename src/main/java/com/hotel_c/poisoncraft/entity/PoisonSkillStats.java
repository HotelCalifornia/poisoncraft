/*
 * @author "Hannah Brooke <hannah@mail.yttrium.io>" a.k.a hotel, HotelCalifornia, hotel_california
 *
 * Copyright (c) 2014.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.hotel_c.poisoncraft.entity;

import com.hotel_c.poisoncraft.net.PacketHandler;
import com.hotel_c.poisoncraft.net.message.MessagePoisonInfuser;
import com.hotel_c.poisoncraft.tileentity.TileEntityPoisonInfuser;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class PoisonSkillStats implements IExtendedEntityProperties {
    private int foodsPoisoned;
    public static final String IDENTIFIER = "PoisonSkill";
    public static final String NBT_IDENTIFIER = "poisonSkill";
    /**
     * registers this as an ExtendedProperty of the given entity
     * @param entity the entity for which to register the properties. should only ever be EntityPlayer, as that's what the EntityConstructing event handler will
     *               pass to it
     */
    public static void init(Entity entity) {
        entity.registerExtendedProperties("PoisonSkill", new PoisonSkillStats());
    }
    public static PoisonSkillStats getSkillStats(Entity entity) {
        return entity != null ? (PoisonSkillStats) entity.getExtendedProperties(IDENTIFIER) : null;
    }
    public int getNumFoodsPoisoned() { return this.foodsPoisoned; }
    public void addPoisonOp(TileEntityPoisonInfuser sender) {
        if(!(foodsPoisoned >= 12288)) {
            foodsPoisoned++;
        }
        PacketHandler.INSTANCE.sendToDimension(new MessagePoisonInfuser(foodsPoisoned),
                                            sender.getWorldObj().provider.dimensionId);
    }

    @Override
    public void saveNBTData(NBTTagCompound compound) {
        compound.setInteger(NBT_IDENTIFIER, foodsPoisoned);
    }

    @Override
    public void loadNBTData(NBTTagCompound compound) {
        foodsPoisoned = compound.getInteger(NBT_IDENTIFIER);
    }

    @Override
    public void init(Entity entity, World world) {
        /**
         * handled in onEntityConstructing
         * @see com.hotel_c.poisoncraft.event.EventHandler#onEntityConstructing(
         *      net.minecraftforge.event.entity.EntityEvent.EntityConstructing)
         */

    }
}
