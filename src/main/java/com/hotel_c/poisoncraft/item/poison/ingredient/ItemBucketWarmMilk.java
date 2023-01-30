/*
 * @author "Hannah Brooke <hannah@mail.yttrium.io>" a.k.a hotel, HotelCalifornia, hotel_california
 *
 * Copyright (c) 2014.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.hotel_c.poisoncraft.item.poison.ingredient;

import com.hotel_c.poisoncraft.Poisoncraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemBucketWarmMilk extends ItemBucketMilk {
    public ItemBucketWarmMilk() {
        setUnlocalizedName("warm_milk");
        setTextureName(Poisoncraft.MODID + ":warm_milk");
    }

    /**
     * applies 30 seconds (300 ticks) of mining fatigue when eaten
     * @param stack the stack containing the bucket
     * @param world the world
     * @param player the player eating the item
     * @return a bucket (I guess :I)
     */
    @Override
    public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
        if(!player.capabilities.isCreativeMode) {
            --stack.stackSize;
        }
        if(!world.isRemote) {
            player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 300, 1, false));
        }
        return stack.stackSize <= 0 ? new ItemStack(Items.bucket) : stack;
    }
}
