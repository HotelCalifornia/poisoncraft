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
    public static EnumSkill getSkillForID(int id) {
        switch (id) {
            case 0: return SKILL_SPOILED;
            case 1: return SKILL_SPOILED;
            case 2: return SKILL_ODD;
            case 3: return SKILL_HIDDEN;
            default:return null;
        }
    }
    public static int getIDForSkill(EnumSkill skill) {
        switch (skill) {
            case SKILL_POISON:
                return 0;
            case SKILL_SPOILED:
                return 1;
            case SKILL_ODD:
                return 2;
            case SKILL_HIDDEN:
                return 3;
            default:
                return 4;
        }
    }
    public static EnumSkill getSkillForTimesInfused(int times) {
        if(times >= 0 && times < 4096) {
            return EnumSkill.SKILL_POISON;
        }
        else if(times >= 4096 && times < 8192) {
            return EnumSkill.SKILL_SPOILED;
        }
        else if(times >= 8192 && times < 12288) {
            return EnumSkill.SKILL_ODD;
        }
        else {
            return EnumSkill.SKILL_HIDDEN;
        }
    }
}
