package com.hotelc.poisoncraft.tileentity;

import com.hotelc.poisoncraft.item.ItemPoison;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

/**
 * This file created by Alex Brooke
 * please seek the author's permission before
 * distributing this software.
 * 'Do you know Java? Because your method body is sexy'
 * :3
 */
public class TileEntityPoisonInfuser extends TileEntity implements ISidedInventory {
    private ItemStack inventory[] = new ItemStack[4];
    /** contains the index/indices of the output slot(s)
     *  @see net.minecraft.tileentity.TileEntityBrewingStand#field_145941_a */
    private static final int[] outputSlots = new int[] {3};
    /** contains the index/indices of the input slot(s)
     *  @see net.minecraft.tileentity.TileEntityBrewingStand#field_145947_i */
    private static final int[] inputSlots = new int[] {0, 1, 2};

    /** TIL that the default (no-argument; empty) constructor is implicit */

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
