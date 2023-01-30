/*
 * @author "Hannah Brooke <hannah@mail.yttrium.io>" a.k.a hotel, HotelCalifornia, hotel_california
 *
 * Copyright (c) 2014.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.hotel_c.poisoncraft.container;

import com.hotel_c.poisoncraft.item.ItemPoison;
import com.hotel_c.poisoncraft.item.poison.ItemPoisonBooster;
import com.hotel_c.poisoncraft.tileentity.TileEntityPoisonInfuser;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ContainerPoisonInfuser extends Container {
    private TileEntityPoisonInfuser tile;
    private int time;
    public ContainerPoisonInfuser(InventoryPlayer inventory, TileEntityPoisonInfuser te) {
        this.tile = te;
        //poison slot
        this.addSlotToContainer(new Poison(inventory.player, inventory, 0, 55,  21));
        //booster slot
        this.addSlotToContainer(new Poison(inventory.player, inventory, 1, 101, 21));
        //food slot
        this.addSlotToContainer(new Poison(inventory.player, inventory, 2, 78,  37));
        //output
        this.addSlotToContainer(new Poison(inventory.player, inventory, 3, 78,  57));
        int i;
        /** add the player inventory slots */
        for(i = 0; i < 3; i++) {
            for(int j = 0; j < 9; j++) {
                this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for(i = 0; i < 9; i++) {
            this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
        }
    }
    @Override
    public void addCraftingToCrafters(ICrafting crafting) {
        super.addCraftingToCrafters(crafting);
        crafting.sendProgressBarUpdate(this, 0, this.tile.getTime());
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (Object crafter : this.crafters) {
            ICrafting crafting = (ICrafting) crafter;
            if (this.time != this.tile.getTime()) {
                crafting.sendProgressBarUpdate(this, 0, this.tile.getTime());
            }
        }
        this.time = this.tile.getTime();
    }

    @SideOnly(Side.CLIENT)
    @Override
    /**
     * this is an odd method; all it seems to do is set tile.time to par2.
     * my guess is that @param par1 can only ever be 0, because whenever ContainerBrewingStand calls ICrafting#sendProgressBarUpdate, the first int is always 0.
     * why does what ContainerBrewingStand does matter here?
     * let's face it: most of the code is the same.
     */
    public void updateProgressBar(int par1, int par2) {
        if(par1 == 0) {
            this.tile.setTime(par2);
        }
    }

    /** uhhh.. let's worry about shift-clicking another time.. hehehe...
     * for now, it's vital that we do not shift click, or else we crash :)
     */

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return this.tile.isUseableByPlayer(player);
    }

    static class Poison extends Slot {
        private EntityPlayer player;
        private int slotIndex;
        public Poison(EntityPlayer player, IInventory inventory, int slotIndex, int guiX, int guiY) {
            super(inventory, slotIndex, guiX, guiY);
            this.player = player;
            this.slotIndex = slotIndex;
        }
        @Override
        public boolean isItemValid(ItemStack stack) {
            switch(this.slotIndex) {
                case 0 : return ItemPoison.getIngredients().containsKey(stack.getItem()); //poison slot
                case 1 : return ItemPoisonBooster.getBoosters().containsKey(stack.getItem()); //booster slot
                case 2 : return stack.getItem() instanceof ItemFood; //food slot
                case 3 : return false; //output
                default: return false; //anyfink else, mate?
            }
        }
        @Override
        public int getSlotStackLimit() {
            return 64;
        }
    }
}

