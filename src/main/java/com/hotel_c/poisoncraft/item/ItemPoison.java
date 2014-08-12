package com.hotel_c.poisoncraft.item;

import com.hotel_c.poisoncraft.item.poison.EnumPoison;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;

import java.util.HashMap;
import java.util.Map;

/**
 * ItemPoison - the item that may be applied to foods, and is crafted out of a valid combination of ingredients.
 */
public class ItemPoison extends Item {
    private static Map<Item, EnumPoison> ingredients = new HashMap<Item, EnumPoison>();
    private static Map<EnumPoison, Potion> effects = new HashMap<EnumPoison, Potion>();

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
    public static void poisonEffects() {
        effects.put(EnumPoison.POISON_HARM,         Potion.harm);
        effects.put(EnumPoison.POISON_POISON,     Potion.poison);
        effects.put(EnumPoison.POISON_WEAK,     Potion.weakness);
        effects.put(EnumPoison.POISON_BLIND,   Potion.blindness);
        effects.put(EnumPoison.POISON_TIRED, Potion.digSlowdown);
        effects.put(EnumPoison.POISON_CONFUSE, Potion.confusion);
        effects.put(EnumPoison.POISON_HUNGER,     Potion.hunger);
        effects.put(EnumPoison.POISON_WITHER,     Potion.wither);
        effects.put(EnumPoison.POISON_SLOW, Potion.moveSlowdown);
    }
    public static Map getEffects() { return effects; }

    /**
     * @param effect the ID of the effect (as according to EnumPoison)
     * @param skill the ID of the skill (as according to EnumSkill)
     * @param amplifier the id of the amplifier (as according to EnumStrength)
     * @return the 3-digit damage value to be used by the ItemS tack of the poisoned food
     */
    public static int calculateDamageFromInputs(int effect, int skill, int amplifier) {
        return (effect * 100) + (skill * 10) + amplifier;
    }
}



