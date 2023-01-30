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
import net.minecraft.item.Item;

public class ItemMetalPowder extends Item {
    public ItemMetalPowder() {
        setUnlocalizedName("metal_powder");
        setTextureName(Poisoncraft.MODID + ":metal_powder");
    }
}
