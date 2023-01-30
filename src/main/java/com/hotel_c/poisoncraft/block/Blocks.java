/*
 * @author "Hannah Brooke <hannah@mail.yttrium.io>" a.k.a hotel, HotelCalifornia, hotel_california
 *
 * Copyright (c) 2014.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.hotel_c.poisoncraft.block;

import com.hotel_c.poisoncraft.item.ItemBlockPoisonInfuser;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class Blocks {
    public static final Block poison_infuser_block = new BlockPoisonInfuser();
    public static final ItemBlock poison_infuser = new ItemBlockPoisonInfuser(poison_infuser_block);
    public static void registerBlocks() {
        /** ItemBlocks */
        GameRegistry.registerBlock(poison_infuser_block, poison_infuser.getClass(), "block_poison_infuser");
    }
    public static void registerRecipes() {
        /** shaped recipes */
        GameRegistry.addRecipe(
                new ItemStack(poison_infuser, 1),
                "xyx", " y ", " z ",
                'x', net.minecraft.init.Items.glass_bottle,
                'y', net.minecraft.init.Items.blaze_rod,
                'z', net.minecraft.init.Items.cauldron
        );
    }
}
