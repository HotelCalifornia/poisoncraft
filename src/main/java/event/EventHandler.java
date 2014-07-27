package event;

import com.hotelc.poisoncraft.entity.PoisonSkillHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityEvent;

/**
 * This file created by Alex Brooke
 * please seek the author's permission before
 * distributing this software.
 * 'Do you know Java? Because your method body is sexy'
 * :3
 */
public class EventHandler {
    public void register() {
        MinecraftForge.EVENT_BUS.register(this);
    }
    @SubscribeEvent
    public void onEntityConstructing(EntityEvent.EntityConstructing event) {
        if(event.entity instanceof EntityPlayer) {
            PoisonSkillHelper.init(event.entity);
        }
    }
}
