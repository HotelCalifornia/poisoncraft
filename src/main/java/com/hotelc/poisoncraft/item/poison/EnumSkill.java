package com.hotelc.poisoncraft.item.poison;

/**
 * This file created by Alex Brooke
 * please seek the author's permission before
 * distributing this software.
 * 'Do you know Java? Because your method body is sexy'
 * :3
 */
public enum EnumSkill {
    SKILL_POISON(0),
    SKILL_SPOILED(1),
    SKILL_ODD(2),
    SKILL_HIDDEN(3);
    private int skill;
    EnumSkill(int skill) {
        this.skill = skill;
    }
    public int getSkill() {
        return this.skill;
    }
}
