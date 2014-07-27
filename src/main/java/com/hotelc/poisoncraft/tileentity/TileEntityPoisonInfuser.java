package com.hotelc.poisoncraft.tileentity;

import com.hotelc.poisoncraft.Poisoncraft;
import com.hotelc.poisoncraft.entity.PoisonSkillHelper;
import com.hotelc.poisoncraft.item.ItemPoison;
import com.hotelc.poisoncraft.item.poison.ItemPoisonedFood;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import org.apache.logging.log4j.Level;

import java.lang.reflect.Field;

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
    /** the player who placed this (owner) */
    private EntityPlayer owner;
    /** handles the skill updates to the player */
    private PoisonSkillHelper skillHelper;

    private ItemStack inventory[] = new ItemStack[4];
    /** contains the index/indices of the output slot(s)
     *  @see net.minecraft.tileentity.TileEntityBrewingStand#field_145941_a */
    private static final int[] outputSlots = new int[] {3};
    /** contains the index/indices of the input slot(s)
     *  @see net.minecraft.tileentity.TileEntityBrewingStand#field_145947_i */
    private static final int[] inputSlots = new int[] {0, 1, 2};

    /** TIL that the default (no-argument; empty) constructor is implicit
     *  however, i need to tell this TE who its owner is, so i can't use that magic :(
     */
    public TileEntityPoisonInfuser(EntityPlayer owner) {
        this.owner = owner;
        this.skillHelper = PoisonSkillHelper.getSkillHelper(this.owner);
    }
    @Override
    public void updateEntity() {
        if(this.time > 0) {
            --time;
            if(this.time == 0) {
                this.infuse();
                this.markDirty();
            }
        }
    }

    public int getTime() { return this.time; }
    public void setTime(int time) { this.time = time; }

    private boolean canOperate() {
        /** well, IDEA, you said it could be simplified. */
        /** returns true if:
         *  there is an ingredient and a food
         *  the ingredient is valid
         *  the food is valid
         *  the output slot isn't full
         */
        return this.inventory[0] != null && this.inventory[2] != null && ItemPoison.getIngredients().containsKey(this.inventory[0].getItem()) && this.inventory[2].getItem() instanceof ItemFood || this.inventory[3].stackSize >= 0 && this.inventory[3].stackSize < this.getInventoryStackLimit();
    }

    /**
     * infuses one piece of food with poison per update
     */
    private void infuse() {
        //TODO: set the damage on the output ItemStack based on the ingredient, the skill, and the booster item (see below)
        if(this.canOperate()) {
            ItemStack ingredient = this.inventory[0];
            inventory[2].stackSize--;
            ItemFood temp = (ItemFood)inventory[2].getItem();
            int boost  = 1;
            if(inventory[1] != null || inventory[1].stackSize > 0) {
                //TODO: handle amplifiers
            }
            try {
                /** get the healAmount (saturation) and whether or not dogs like this food */
                Field f  = ItemFood.class.getDeclaredField("healAmount");
                Field f1 = ItemFood.class.getDeclaredField("isWolfsFavoriteMeat");
                /** make them accessible so we can use their values to make the Poisoned food */
                f.setAccessible(true);
                f1.setAccessible(true);
                if(inventory[3] == null || inventory[3].stackSize <= 0) {
                    inventory[3] = new ItemStack(new ItemPoisonedFood(f.getInt(temp), f1.getBoolean(temp), temp, boost));
                }
                else {
                    inventory[3].stackSize++;
                    skillHelper.addPoisonOp();
                }
            } catch (NoSuchFieldException e) {
                Poisoncraft.LOGGER.log(Level.WARN, "TileEntityPoisonInfuser unable to infuse, likely due to a mapping change.");
                Poisoncraft.LOGGER.log(Level.WARN, "Please go to www.github.com/HotelCalifornia/poisoncraft for more information about bugs like this.");
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                Poisoncraft.LOGGER.log(Level.WARN, "TileEntityPoisonInfuser unable to infuse, likely due to a mapping change.");
                Poisoncraft.LOGGER.log(Level.WARN, "Please go to www.github.com/HotelCalifornia/poisoncraft for more information about bugs like this.");
                e.printStackTrace();
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
                //TODO: for the amplifier
                return false;
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
