/*
 * @author "Hannah Brooke <hannah@mail.yttrium.io>" a.k.a hotel, HotelCalifornia, hotel_california
 *
 * Copyright (c) 2014.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.hotel_c.poisoncraft.item;

import com.hotel_c.poisoncraft.Poisoncraft;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemBlockPoisonInfuser extends ItemBlock {
    public ItemBlockPoisonInfuser(Block block) {
        super(block);
        setUnlocalizedName("poison_infuser");
        setTextureName(Poisoncraft.MODID + ":poison_infuser");
    }

}
