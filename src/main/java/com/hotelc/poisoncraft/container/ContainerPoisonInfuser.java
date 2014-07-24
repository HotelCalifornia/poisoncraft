package com.hotelc.poisoncraft.container;

import com.hotelc.poisoncraft.item.ItemPoison;
import com.hotelc.poisoncraft.tileentity.TileEntityPoisonInfuser;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

/**
 * This file created by Alex Brooke
 * please seek the author's permission before
 * distributing this software.
 * 'Do you know Java? Because your method body is sexy'
 * :3
 */
public class ContainerPoisonInfuser extends Container {
    private TileEntityPoisonInfuser tile;
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

    }

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
                case 1 : return false; //TODO: make ItemPoisonBooster or something
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

