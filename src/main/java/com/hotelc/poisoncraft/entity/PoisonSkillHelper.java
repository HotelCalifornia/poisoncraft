package com.hotelc.poisoncraft.entity;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

/**
 * This file created by Alex Brooke
 * please seek the author's permission before
 * distributing this software.
 * 'Do you know Java? Because your method body is sexy'
 * :3
 */
public class PoisonSkillHelper implements IExtendedEntityProperties {
    private int foodsPoisoned;

    /**
     * registers this as an ExtendedProperty of the given entity
     * @param entity the entity for which to register the properties. should only ever be EntityPlayer, as that's what the EntityConstructing event handler will
     *               pass to it
     */
    public static void init(Entity entity) {
        entity.registerExtendedProperties("PoisonSkill", new PoisonSkillHelper());
    }
    public static PoisonSkillHelper getSkillHelper(Entity entity) {
        return entity != null ? (PoisonSkillHelper) entity.getExtendedProperties("PoisonSkill") : null;
    }
    public void addPoisonOp() {
        foodsPoisoned ++;
    }

    @Override
    public void saveNBTData(NBTTagCompound compound) {
        compound.setInteger("poisonSkill", foodsPoisoned);
    }

    @Override
    public void loadNBTData(NBTTagCompound compound) {
        foodsPoisoned = compound.getInteger("poisonSkill");
    }

    @Override
    public void init(Entity entity, World world) {

    }
}
