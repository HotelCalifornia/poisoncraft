package com.hotelc.poisoncraft.gui;

import com.hotelc.poisoncraft.container.ContainerPoisonInfuser;
import com.hotelc.poisoncraft.tileentity.TileEntityPoisonInfuser;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * This file created by Alex Brooke
 * please seek the author's permission before
 * distributing this software.
 * 'Do you know Java? Because your method body is sexy'
 * :3
 */
public class GuiPoisonInfuser extends GuiContainer {
    private TileEntityPoisonInfuser tile;
    public GuiPoisonInfuser(InventoryPlayer playerInv, TileEntityPoisonInfuser tile) {
        super(new ContainerPoisonInfuser(playerInv, tile));
        this.tile = tile;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        /** write the localised name of the container */
        String s = this.tile.hasCustomInventoryName() ? this.tile.getInventoryName() : I18n.format(this.tile.getInventoryName());
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        /** write the localised name of the player inventory */
        this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
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
