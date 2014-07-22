package com.hotelc.poisoncraft.item.poison;

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
}
