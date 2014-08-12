package com.hotel_c.poisoncraft.gui;

import com.hotel_c.poisoncraft.container.ContainerPoisonInfuser;
import com.hotel_c.poisoncraft.tileentity.TileEntityPoisonInfuser;
import com.hotel_c.poisoncraft.util.Helper;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.util.UUID;

/**
 * This file created by Alex Brooke
 * please seek the author's permission before
 * distributing this software.
 * 'Do you know Java? Because your method body is sexy'
 * :3
 */
@SuppressWarnings("unchecked")
public class GuiPoisonInfuser extends GuiContainer {
    private TileEntityPoisonInfuser tile;
    private UUID owner;
    public int numPoisons;
    public GuiPoisonInfuser(InventoryPlayer playerInv, TileEntityPoisonInfuser tile) {
        super(new ContainerPoisonInfuser(playerInv, tile));
        this.tile = tile;
        this.owner = tile.getOwner();
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        /** write the localised name of the container */
        String s = this.tile.hasCustomInventoryName() ? this.tile.getInventoryName() : I18n.format(this.tile.getInventoryName());
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        /** write the localised name of the player inventory */
        this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
        /** write the number of poisons brewed by the owner */
        this.fontRendererObj.drawString(I18n.format("container.poison.num"), this.xSize - 76, this.ySize - 124, 4210752); //"Poisons Made"
        this.fontRendererObj.drawString(Integer.toString(numPoisons), this.xSize - 76, this.ySize - 106, 4210752); //number of poisons
        /** write the IGN of the owner */
        int colour = 0xff690000; //red by default (offline)
        if(Helper.isPlayerOnline(this.owner)) {
            colour = 0xff006909; //green if online
        }
        this.fontRendererObj.drawString(I18n.format("container.poison.owner"), this.xSize - 76, this.ySize - 76, 4210752); //"Name"
        this.fontRendererObj.drawString(Helper.getPlayerFromUUID(this.owner).getDisplayName(), this.xSize - 76, this.ySize - 100, colour); //player name
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(new ResourceLocation("poisoncraft:textures/gui/poison_infuser.png"));
        int x =  (width - xSize) / 2;
        int y = (height - ySize) / 2;
        /** draw the gui */
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
        /** get the current time in the operation */
        int i = this.tile.getTime();
        /** draw the updated progress bar */
        if(i > 0) {
            int time = (int)(28.0F * (1.0F - (float)i / 400.0F));
            if(time > 0) {
                this.drawTexturedModalRect(x + 97, y + 42, 185, 0, 12, time);
            }
        }

    }
}
