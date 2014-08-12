package com.hotel_c.poisoncraft.item.poison;

/**
 * This file created by Alex Brooke
 * please seek the author's permission before
 * distributing this software.
 * 'Do you know Java? Because your method body is sexy'
 * :3
 */
public enum EnumStrength {
    STRENGTH_DEFAULT(0),
    STRENGTH_WEAK(1),
    STRENGTH_NORMAL(2),
    STRENGTH_STRONG(3);
    private int ID;
    EnumStrength(int id) {
        this.ID = id;
    }
    public int getID() {
        return this.ID;
    }

    /**
     * return the length of time (in ticks) for each level of strength
     * @param type the level of strength
     * @return the length of time (in ticks) for which the poison effect will be active.
     */
    public static int getTicksForType(EnumStrength type) {
        switch (type) {
            case STRENGTH_DEFAULT: return 150;
            case STRENGTH_WEAK   : return 300;
            case STRENGTH_NORMAL : return 600;
            case STRENGTH_STRONG : return 900;
            default              : return   0;
        }
    }
    public static int getIDforStrength(EnumStrength strength) {
        switch (strength) {
            case STRENGTH_DEFAULT:
                return 0;
            case STRENGTH_WEAK   :
                return 1;
            case STRENGTH_NORMAL :
                return 2;
            case STRENGTH_STRONG :
                return 3;
            default:
                return 4;
        }
    }
    public static EnumStrength getStrengthForID(int id) {
        switch (id) {
            case 0 : return STRENGTH_DEFAULT;
            case 1 : return    STRENGTH_WEAK;
            case 2 : return  STRENGTH_NORMAL;
            case 3 : return  STRENGTH_STRONG;
            default: return             null;
        }
    }
}
