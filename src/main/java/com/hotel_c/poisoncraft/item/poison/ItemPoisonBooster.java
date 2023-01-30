/*
 * @author "Hannah Brooke <hannah@mail.yttrium.io>" a.k.a hotel, HotelCalifornia, hotel_california
 *
 * Copyright (c) 2014.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.hotel_c.poisoncraft.item.poison;

import net.minecraft.init.Items;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class ItemPoisonBooster {
    private static Map<Item, EnumStrength> boosters = new HashMap<Item, EnumStrength>();
    public static void boosterIngredients() {
        /** EnumStrength.STRENGTH_DEFAULT not handled here as it signifies the lack of an item */
        boosters.put(Items.gunpowder,        EnumStrength.STRENGTH_WEAK);
        boosters.put(Items.redstone,       EnumStrength.STRENGTH_NORMAL);
        boosters.put(Items.glowstone_dust, EnumStrength.STRENGTH_STRONG);
    }
    public static Map getBoosters() {
        return boosters;
    }
}
