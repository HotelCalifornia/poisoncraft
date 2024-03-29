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

import com.hotel_c.poisoncraft.item.poison.ingredient.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class Items {
    /** ingredients */
    public static final Item blaze_eye     = new       ItemBlazeEye();
    public static final Item rotten_carrot = new   ItemRottenCarrot();
    public static final Item warm_milk     = new ItemBucketWarmMilk();
    public static final Item metal_powder  = new    ItemMetalPowder();
    public static final Item black_meal    = new  ItemBlackBonemeal();
    public static void registerItems() {
        /** ingredients */
        GameRegistry.registerItem(blaze_eye,             "blaze_eye");
        GameRegistry.registerItem(rotten_carrot,     "rotten_carrot");
        GameRegistry.registerItem(warm_milk,             "warm_milk");
        GameRegistry.registerItem(metal_powder,       "metal_powder");
        GameRegistry.registerItem(black_meal,           "black_meal");
    }
    public static void registerRecipes() {
        /** shapeless recipes */
        GameRegistry.addShapelessRecipe(new ItemStack(blaze_eye, 2), new ItemStack(net.minecraft.init.Items.blaze_powder, 1), new ItemStack(net.minecraft.init.Items.spider_eye, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(rotten_carrot, 1), new ItemStack(net.minecraft.init.Items.golden_carrot, 1), new ItemStack(net.minecraft.init.Items.fermented_spider_eye, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(metal_powder, 2), new ItemStack(net.minecraft.init.Items.iron_ingot, 1), new ItemStack(net.minecraft.init.Items.sugar, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(black_meal, 2), new ItemStack(net.minecraft.init.Items.dye, 1, 15), new ItemStack(net.minecraft.init.Items.skull, 1, 1));

        /** smelting */
        GameRegistry.addSmelting(net.minecraft.init.Items.milk_bucket, new ItemStack(warm_milk, 1), 5f);
    }
}
