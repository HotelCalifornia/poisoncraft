package com.hotel_c.poisoncraft.item.poison;

import net.minecraft.init.Items;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

/**
 * This file created by Alex Brooke
 * please seek the author's permission before
 * distributing this software.
 * 'Do you know Java? Because your method body is sexy'
 * :3
 */
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
