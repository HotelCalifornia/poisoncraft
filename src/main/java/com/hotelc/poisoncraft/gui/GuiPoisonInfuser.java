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
    private InventoryPlayer playerInv;
    public GuiPoisonInfuser(InventoryPlayer playerInv, TileEntityPoisonInfuser tile) {
        super(new ContainerPoisonInfuser(playerInv, tile));
        this.tile = tile;
        this.playerInv = playerInv;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        String s = this.tile.hasCustomInventoryName() ? this.tile.getInventoryName() : I18n.format(this.tile.getInventoryName());
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(new ResourceLocation("poisoncraft:textures/gui/poison_infuser.png"));
        int x =  (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
        int time = this.tile.getTime();
        if(time > 0) {
            int j = (int)(28.0F * (1.0F - (float)time / 400.0F));
            if(j > 0) {
                this.drawTexturedModalRect(x + 97, y + 16, 176, 0, 9, j);
            }
            int k = time / 2 % 7;
            switch(k) {
                case 0:
                    time = 29;
                    break;
                case 1:
                    time = 24;
                    break;
                case 2:
                    time = 20;
                    break;
                case 3:
                    time = 16;
                    break;
                case 4:
                    time = 11;
                    break;
                case 5:
                    time = 6;
                    break;
                case 6:
                    time = 0;
            }
            if (j > 0) {
                this.drawTexturedModalRect(k + 65, x + 14 + 29 - j, 185, 29 - j, 12, j);
            }
        }

    }
}
