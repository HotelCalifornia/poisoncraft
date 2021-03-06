package com.hotel_c.poisoncraft.net.message;

import com.hotel_c.poisoncraft.gui.GuiPoisonInfuser;
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
    public MessagePoisonInfuser() {}
    public MessagePoisonInfuser(int numPoisoned) {
        this.numPoisoned = numPoisoned;
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
