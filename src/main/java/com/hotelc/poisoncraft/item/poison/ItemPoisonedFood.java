package com.hotelc.poisoncraft.item.poison;

import com.hotelc.poisoncraft.item.ItemPoison;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * This file created by Alex Brooke
 * please seek the author's permission before
 * distributing this software.
 * 'Do you know Java? Because your method body is sexy'
 * :3
 */
public class ItemPoisonedFood extends ItemFood {
    private int amplifier;

    /**
     * constructor for a new hunk of poisoned food
     * @param saturation how many haunches this will return to the player
     * @param doggyMeat do dogs like it?
     * @param texture the texture of the previous piece of real food
     * @param skill the skill level the player crafting this potion has
     * the texture name will be used to keep the food looking the same.
     * the skill level determines the display name of the food
     */
    public ItemPoisonedFood(int saturation,  boolean doggyMeat, String texture, EnumSkill skill, int boost) {
        super(saturation, doggyMeat);
        this.amplifier = boost; //this will undoubtedly go through some calculations at some point
        this.setTextureName("texture");
        switch (skill) {
            case SKILL_POISON  :

            case SKILL_SPOILED :

            case SKILL_ODD     :

            case SKILL_HIDDEN  :

        }
    }

    /**
     * This method is different from onEaten, probably because it occurs about a second or so after onEaten.
     * I will not implement onEaten here, because this class should be as similar to
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
            char[] charDigits = Integer.toString(stack.getItemDamage()).toCharArray();
            int[] digits = new int[charDigits.length];
            for (int i = 0; i < charDigits.length; i++) {
                digits[i] = Integer.parseInt(Character.toString(charDigits[i]));
            }
            EnumPoison potionID = EnumPoison.getTypeForID(digits[0]);
            /** digits[1] is the skill, and that's handled in the constructor.. err somewhere other than this method :) */
            EnumStrength duration = EnumStrength.getStrengthForID(digits[2]);
            Potion potion = null;
            switch (potionID) {
                case POISON_HARM:
                    potion = (Potion) ItemPoison.getEffects().get(EnumPoison.POISON_HARM);
                    break;
                case POISON_POISON:
                    potion = (Potion) ItemPoison.getEffects().get(EnumPoison.POISON_POISON);
                    break;
                case POISON_WEAK:
                    potion = (Potion) ItemPoison.getEffects().get(EnumPoison.POISON_WEAK);
                    break;
                case POISON_BLIND:
                    potion = (Potion) ItemPoison.getEffects().get(EnumPoison.POISON_HARM);
                    break;
                case POISON_TIRED:
                    potion = (Potion) ItemPoison.getEffects().get(EnumPoison.POISON_TIRED);
                    break;
                case POISON_CONFUSE:
                    potion = (Potion) ItemPoison.getEffects().get(EnumPoison.POISON_CONFUSE);
                    break;
                case POISON_HUNGER:
                    potion = (Potion) ItemPoison.getEffects().get(EnumPoison.POISON_HUNGER);
                    break;
                case POISON_WITHER:
                    potion = (Potion) ItemPoison.getEffects().get(EnumPoison.POISON_WITHER);
                    break;
                case POISON_SLOW:
                    potion = (Potion) ItemPoison.getEffects().get(EnumPoison.POISON_SLOW);
                    break;
            }
            int ticks = 0;
            switch (duration) {
                case STRENGTH_WEAK:
                    ticks = EnumStrength.getTicksForType(EnumStrength.STRENGTH_WEAK);
                    break;
                case STRENGTH_NORMAL:
                    ticks = EnumStrength.getTicksForType(EnumStrength.STRENGTH_NORMAL);
                    break;
                case STRENGTH_STRONG:
                    ticks = EnumStrength.getTicksForType(EnumStrength.STRENGTH_STRONG);
                    break;
            }

            player.addPotionEffect(new PotionEffect(potion.getId(), ticks, this.amplifier));
        }
    }




}
