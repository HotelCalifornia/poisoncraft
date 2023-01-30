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

import com.hotel_c.poisoncraft.Poisoncraft;
import com.hotel_c.poisoncraft.util.Accessor;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import org.apache.logging.log4j.Level;
import java.lang.reflect.Method;

public class ItemPoisonedFood extends ItemFood {
    /**
     * constructor for a new hunk of poisoned food
     * @param saturation how many haunches this will return to the player
     * @param doggyMeat do dogs like it?
     * @param food the food being poisoned
     * the texture name will be used to keep the food looking the same.
     * the skill level determines the display name of the food
     */
    public ItemPoisonedFood(int saturation, boolean doggyMeat, ItemFood food) {
        super(saturation, doggyMeat);
        try {
            Method method = Accessor.getMethod(ItemFood.class, "getIconString()");
            Accessor.access(method);
            this.setTextureName((String)Accessor.invoke(method, food));
        } catch (Exception e) {
            Poisoncraft.LOGGER.log(Level.WARN, "ItemPoisonedFood was unable to obtain a texture, defaulting to the porkchop texture.");
            Poisoncraft.LOGGER.log(Level.WARN, "This is most likely a result of a remapping. Please go to www.github.com/HotelCalifornia/poisoncraft for more info about bugs like this.");
            e.printStackTrace();
            setTextureName("minecraft:porkchop_cooked");
        }
    }

    /**
     * This method is different from onEaten, probably because it occurs about a second or so after onEaten.
     * I will not implement onEaten here, because this class should be as similar to the food as possible
     * @param stack the stack of food
     * @param world it's the whole saaaaame woooorld
     * @param player what a playa
     * so yeah, there's a little char fuckery going on here. if anyone can ell me how to get the individual digits of a number more efficiently,
     * I'm open to suggestions. (mod 10 div 10 doesn't seem viable as it returns the digits in reverse order and would require some unwanted pushin' and poppin' of a stack)
     */
    @Override
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        /** no point in doing any of the calculations if the end result doesn't compute because it's client-side */
        if(!world.isRemote) {
            /** get the individual digits of the damage value */
            char[] charDigits = Integer.toString(stack.getItemDamage()).toCharArray();
            int[] digits = new int[charDigits.length];
            for (int i = 0; i < charDigits.length; i++) {
                digits[i] = Integer.parseInt(Character.toString(charDigits[i]));
            }
            /** get the potion info */
            EnumPoison potionID = EnumPoison.getTypeForID(digits[0]);
            Potion potion = EnumPoison.getPotionForType(potionID);
            /** digits[1] is the skill, and that's handled in the constructor.. err somewhere other than this method :) */
            /** get the duration */
            EnumStrength duration = EnumStrength.getStrengthForID(digits[2]);
            int ticks = EnumStrength.getTicksForType(duration);
            /** apply the effect */
            player.addPotionEffect(new PotionEffect(potion.getId(), ticks, 1));
        }
    }
    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        EnumSkill skill = EnumSkill.getSkillForID(Integer.parseInt(Character.toString(String.valueOf(stack.getItemDamage()).charAt(1))));
        String ident = "";
        switch (skill) {
            case SKILL_POISON: ident = "skill.poisoned";
                break;
            case SKILL_SPOILED:ident =  "skill.spoiled";
                break;
            case SKILL_ODD:    ident =      "skill.odd";
                break;
            case SKILL_HIDDEN: ident =               "";
                break;
        }
        return I18n.format(ident + " " + super.getItemStackDisplayName(stack));
    }
}
