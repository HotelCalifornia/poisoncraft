package com.hotel_c.poisoncraft.proxy;

import com.hotel_c.poisoncraft.tileentity.TileEntityPoisonInfuser;
import com.hotel_c.poisoncraft.tileentity.render.TileEntitySpecialRendererPoisonInfuser;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * This file created by Alex Brooke
 * please seek the author's permission before
 * distributing this software.
 * 'Do you know Java? Because your method body is sexy'
 * :3
 */
public class ClientProxy extends CommonProxy {
    @Override
    @SideOnly(Side.CLIENT)
    public void registerRenderers() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPoisonInfuser.class,
                new TileEntitySpecialRendererPoisonInfuser());
    }
}
