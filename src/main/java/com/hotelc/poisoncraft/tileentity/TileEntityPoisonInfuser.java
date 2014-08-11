package com.hotelc.poisoncraft.tileentity;

import com.hotelc.poisoncraft.entity.PoisonSkillStats;
import com.hotelc.poisoncraft.item.ItemPoison;
import com.hotelc.poisoncraft.item.poison.*;
import com.hotelc.poisoncraft.util.Helper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import java.util.UUID;

/**
 * This file created by Alex Brooke
 * please seek the author's permission before
 * distributing this software.
 * 'Do you know Java? Because your method body is sexy'
 * :3
 */
public class TileEntityPoisonInfuser extends TileEntity implements ISidedInventory {
    /** the time remaining for the current operation */
    private int time;
    /** handles the skill updates to the player */
    private PoisonSkillStats skillHelper;
    /** the owner */
    private UUID owner;
    public void setOwner(UUID uuid) {
        this.owner = uuid;
        this.skillHelper = PoisonSkillStats.getSkillStats(Helper.getPlayerFromUUID(uuid));
    }
    public UUID getOwner() { return this.owner; }
    private ItemStack inventory[] = new ItemStack[4];
    /** contains the index/indices of the output slot(s)
     *  @see net.minecraft.tileentity.TileEntityBrewingStand#field_145941_a */
    private static final int[] outputSlots = new int[] {3};
    /** contains the index/indices of the input slot(s)
     *  @see net.minecraft.tileentity.TileEntityBrewingStand#field_145947_i */
    private static final int[] inputSlots = new int[] {0, 1, 2};
    /** used to validate the existence of the input items during operation, to prevent cheating */

    /** TIL that the default (no-argument; empty) constructor is implicit
     *  however, i need to tell this TE who its owner is, so i can't use that magic :(
     *  EDIT: hehe, i can use the magic now :D
     *  <strikethrough>Monsieur</strikethrough> Great Lord Almighty Ivorius (Ivorforce)
     *  told me not to use constructor injection
     */
    @Override
    public void updateEntity() {
        if(this.time > 0) {
            --time;
            if(this.time == 0) {
                this.infuse();
                this.markDirty();
            }
            else if(!this.canOperate()) {
                this.time = 0;
                this.markDirty();
            }
        }
        else if(this.canOperate()) {
            this.time = 400;
        }
        super.updateEntity();
    }

    public int getTime() { return this.time; }
    public void setTime(int time) { this.time = time; }

    private boolean canOperate() {
        /** returns true if:
         *  there is an ingredient and a food
         *  the ingredient is valid
         *  the food is valid
         *  the output slot isn't full
         */
        if(this.inventory[0] != null && this.inventory[2] != null) {
            if(ItemPoison.getIngredients().containsKey(this.inventory[0].getItem())) {
                if(this.inventory[2].getItem() instanceof ItemFood) {
                    if(this.inventory[2].stackSize > 0 && this.inventory[0].stackSize > 0) {
                        if(this.inventory[3] != null) {
                            if(this.inventory[3].stackSize < this.getInventoryStackLimit()) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * infuses one piece of food with poison per update
     */
    private void infuse() {
        if(this.canOperate()) {
            /** the skill associated with this TileEntity's owner */
            EnumSkill skill = EnumSkill.getSkillForTimesInfused(skillHelper.getNumFoodsPoisoned());
            ItemStack ingredient = this.inventory[0];
            inventory[2].stackSize--;
            ItemFood temp = (ItemFood)inventory[2].getItem();
            EnumStrength boost  = EnumStrength.STRENGTH_DEFAULT;
            if(inventory[1] != null || inventory[1].stackSize > 0) {
                boost = (EnumStrength)ItemPoisonBooster.getBoosters().get(inventory[1].getItem()); //..why doesn't Map#get(K key) return type V? oh java...
            }
            int damage = ItemPoison.calculateDamageFromInputs(EnumPoison.getIDForType((EnumPoison)ItemPoison.getIngredients().get(ingredient.getItem())),
                                                              EnumSkill.getIDForSkill(skill), EnumStrength.getIDforStrength(boost));
            if(inventory[3] == null || inventory[3].stackSize <= 0) {
                inventory[3] = new ItemStack(new ItemPoisonedFood(temp.func_150905_g(inventory[2]), temp.isWolfsFavoriteMeat(), temp), damage);
            }
            else {
                /** add one to the output, increment the number of poisons made by the owner */
                inventory[3].stackSize++;
                skillHelper.addPoisonOp(this);
            }
        }
    }
    /** ISidedInventory */
    @Override
    public int getSizeInventory() {
        return this.inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return this.inventory[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {
        if (slot >= 0 && slot < this.inventory.length) {
            ItemStack itemstack = this.inventory[slot];
            this.inventory[slot] = null;
            return itemstack;
        }
        else {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        if (slot >= 0 && slot < this.inventory.length) {
            ItemStack itemstack = this.inventory[slot];
            this.inventory[slot] = null;
            return itemstack;
        }
        else {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        if (slot >= 0 && slot < this.inventory.length) {
            this.inventory[slot] = stack;
        }
    }

    @Override
    public String getInventoryName() {
        return "container.poison";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return true;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this && p_70300_1_.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        switch(slot) {
            case 0:
                /** Poison slot */
                return ItemPoison.getIngredients().containsKey(stack.getItem());
            case 1:
                /** Booster slot */
                return ItemPoisonBooster.getBoosters().containsKey(stack.getItem());
            case 2:
                /** Food slot */
                return stack.getItem() instanceof ItemFood;
            case 3:
                /** Output slot */
                return false;
            default:
                return false;
        }
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
        return side == 1 ? outputSlots : inputSlots;
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack stack, int p_102007_3_) {
        return this.isItemValidForSlot(slot, stack);
    }

    @Override
    public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
        return true;
    }
}
