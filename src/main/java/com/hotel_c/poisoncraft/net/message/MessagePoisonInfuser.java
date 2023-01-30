/*
 * @author "Hannah Brooke <hannah@mail.yttrium.io>" a.k.a hotel, HotelCalifornia, hotel_california
 *
 * Copyright (c) 2014.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.hotel_c.poisoncraft.net.message;

import com.hotel_c.poisoncraft.gui.GuiPoisonInfuser;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

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
