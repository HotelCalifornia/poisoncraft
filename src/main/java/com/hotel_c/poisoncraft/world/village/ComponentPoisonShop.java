/*
 * @author "Hannah Brooke <hannah@mail.yttrium.io>" a.k.a hotel, HotelCalifornia, hotel_california
 *
 * Copyright (c) 2014.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */


package com.hotel_c.poisoncraft.world.village;

import static net.minecraft.world.gen.structure.StructureVillagePieces.Start;

import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureVillagePieces;

import java.util.List;
import java.util.Random;

public class ComponentPoisonShop extends StructureVillagePieces.House1 {
    private int groundLvl = -1;
    public ComponentPoisonShop() { }
    public ComponentPoisonShop(Start villagePiece, List pieces, Random random, StructureBoundingBox sbb, int par5) {
        super();
        this.coordBaseMode = par5;
        this.boundingBox = sbb;
    }

}
