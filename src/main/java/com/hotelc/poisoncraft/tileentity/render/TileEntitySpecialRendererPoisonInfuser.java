package com.hotelc.poisoncraft.tileentity.render;

import com.hotelc.poisoncraft.Poisoncraft;
import com.hotelc.poisoncraft.tileentity.render.model.ModelPoisonInfuser;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * This file created by Alex Brooke
 * please seek the author's permission before
 * distributing this software.
 * 'Do you know Java? Because your method body is sexy'
 * :3
 */
public class TileEntitySpecialRendererPoisonInfuser extends TileEntitySpecialRenderer{
    ModelPoisonInfuser model = new ModelPoisonInfuser();
    private static final ResourceLocation locTex = new ResourceLocation(Poisoncraft.MODID + ":textures/models/blocks/poison_infuser");

    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
        GL11.glPushMatrix();

        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);

        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);

        Minecraft.getMinecraft().renderEngine.bindTexture(locTex);
        model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);

        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
}
