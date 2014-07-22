package com.hotelc.poisoncraft.item;

import com.hotelc.poisoncraft.item.poison.EnumPoison;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

/**
 * ItemPoison - the item that may be applied to foods, and is crafted out of a valid combination of ingredients.
 */
public class ItemPoison extends Item {
    private static Map<Item, EnumPoison> ingredients = new HashMap<Item, EnumPoison>();

    /**
     * Associates ingredients with an effect
     */
    public static void poisonIngredients() {
        ingredients.put(Items.blaze_eye,                               EnumPoison.POISON_HARM);
        ingredients.put(net.minecraft.init.Items.spider_eye,         EnumPoison.POISON_POISON);
        ingredients.put(net.minecraft.init.Items.fermented_spider_eye, EnumPoison.POISON_WEAK);
        ingredients.put(Items.rotten_carrot,                          EnumPoison.POISON_BLIND);
        ingredients.put(Items.warm_milk,                              EnumPoison.POISON_TIRED);
        ingredients.put(net.minecraft.init.Items.sugar,             EnumPoison.POISON_CONFUSE);
        ingredients.put(net.minecraft.init.Items.rotten_flesh,       EnumPoison.POISON_HUNGER);
        ingredients.put(Items.black_meal,                            EnumPoison.POISON_WITHER);
        ingredients.put(Items.metal_powder,                            EnumPoison.POISON_SLOW);
    }
    public static Map getIngredients() { return ingredients; }
}
