package com.hotel_c.poisoncraft.world.village;

import static net.minecraft.world.gen.structure.StructureVillagePieces.Start;

import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureVillagePieces;

import java.util.List;
import java.util.Random;

/**
 * This file created by Alex Brooke
 * please seek the author's permission before
 * distributing this software.
 * 'Do you know Java? Because your method body is sexy'
 * :3
 */
public class ComponentPoisonShop extends StructureVillagePieces.House1 {
    private int groundLvl = -1;
    public ComponentPoisonShop() { }
    public ComponentPoisonShop(Start villagePiece, List pieces, Random random, StructureBoundingBox sbb, int par5) {
        super();
        this.coordBaseMode = par5;
        this.boundingBox = sbb;
    }

}
