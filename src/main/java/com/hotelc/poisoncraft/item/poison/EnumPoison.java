package com.hotelc.poisoncraft.item.poison;

import com.hotelc.poisoncraft.item.ItemPoison;
import net.minecraft.potion.Potion;

/**
 * This file created by Alex Brooke
 * please seek the author's permission before
 * distributing this software.
 * 'Do you know Java? Because your method body is sexy'
 * :3
 */
public enum EnumPoison {
    POISON_HARM(1),
    POISON_POISON(2),
    POISON_WEAK(3),
    POISON_BLIND(4),
    POISON_TIRED(5),
    POISON_CONFUSE(6),
    POISON_HUNGER(7),
    POISON_WITHER(8),
    POISON_SLOW(9);
    private int ID;
    EnumPoison(int id) {
        this.ID = id;
    }
    public int getID() {
        return this.ID;
    }
    public static EnumPoison getTypeForID(int id) {
        switch (id) {
            case 1: return POISON_HARM;
            case 2: return POISON_POISON;
            case 3: return POISON_WEAK;
            case 4: return POISON_BLIND;
            case 5: return POISON_TIRED;
            case 6: return POISON_CONFUSE;
            case 7: return POISON_HUNGER;
            case 8: return POISON_WITHER;
            case 9: return POISON_SLOW;
            default: return null;
        }
    }
    public static Potion getPotionForType(EnumPoison potionID) {
        switch (potionID) {
            case POISON_HARM:
                return (Potion)    ItemPoison.getEffects().get(EnumPoison.POISON_HARM);
            case POISON_POISON:
                return (Potion)  ItemPoison.getEffects().get(EnumPoison.POISON_POISON);
            case POISON_WEAK:
                return (Potion)    ItemPoison.getEffects().get(EnumPoison.POISON_WEAK);
            case POISON_BLIND:
                return (Potion)    ItemPoison.getEffects().get(EnumPoison.POISON_HARM);
            case POISON_TIRED:
                return (Potion)   ItemPoison.getEffects().get(EnumPoison.POISON_TIRED);
            case POISON_CONFUSE:
                return (Potion) ItemPoison.getEffects().get(EnumPoison.POISON_CONFUSE);
            case POISON_HUNGER:
                return (Potion)  ItemPoison.getEffects().get(EnumPoison.POISON_HUNGER);
            case POISON_WITHER:
                return (Potion)  ItemPoison.getEffects().get(EnumPoison.POISON_WITHER);
            case POISON_SLOW:
                return (Potion)    ItemPoison.getEffects().get(EnumPoison.POISON_SLOW);
            default: return null;
        }
    }
    public static int getIDForType(EnumPoison poison) {
        switch (poison) {
            case POISON_HARM:
                return 1;
            case POISON_POISON:
                return 2;
            case POISON_WEAK:
                return 3;
            case POISON_BLIND:
                return 4;
            case POISON_TIRED:
                return 5;
            case POISON_CONFUSE:
                return 6;
            case POISON_HUNGER:
                return 7;
            case POISON_WITHER:
                return 8;
            case POISON_SLOW:
                return 9;
            default:
                return 0;
        }
    }
}
