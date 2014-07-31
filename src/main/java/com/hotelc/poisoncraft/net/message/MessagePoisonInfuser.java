package com.hotelc.poisoncraft.net.message;

import com.hotelc.poisoncraft.gui.GuiPoisonInfuser;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

/**
 * This file created by Alex Brooke
 * please seek the author's permission before
 * distributing this software.
 * 'Do you know Java? Because your method body is sexy'
 * :3
 */
public class MessagePoisonInfuser implements IMessage, IMessageHandler<MessagePoisonInfuser, IMessage> {
    private int numPoisoned;
    public int x;
    public int y;
    public int z;
    public MessagePoisonInfuser(int numPoisoned, int x, int y, int z) {
        this.numPoisoned = numPoisoned;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.numPoisoned = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.numPoisoned);
    }

    @Override
    public IMessage onMessage(MessagePoisonInfuser message, MessageContext ctx) {
        GuiScreen gui = Minecraft.getMinecraft().currentScreen;
        if(gui != null && gui instanceof GuiPoisonInfuser) {
            GuiPoisonInfuser temp = (GuiPoisonInfuser)gui;
            temp.numPoisons = message.numPoisoned;
        }
        return null;
    }
}
