package com.hotelc.poisoncraft;

import com.hotelc.poisoncraft.item.ItemPoison;
import com.hotelc.poisoncraft.item.Items;
import com.hotelc.poisoncraft.item.poison.ItemPoisonBooster;
import com.hotelc.poisoncraft.proxy.ClientProxy;
import com.hotelc.poisoncraft.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Poisoncraft.MODID, version = Poisoncraft.VERSION)
@SuppressWarnings("unused")
public class Poisoncraft {
    public static final String MODID = "poisoncraft";
    public static final String VERSION = "1.0";
    public static final Logger LOGGER = LogManager.getLogger(Poisoncraft.MODID);

    public static event.EventHandler eventHandler;
    @SidedProxy(
            clientSide = "com.hotelc.poisoncraft.proxy.ClientProxy",
            serverSide = "com.hotelc.poisoncraft.proxy.CommonProxy"
    )
    public static CommonProxy commonProxy;
    public static ClientProxy clientProxy;
    @Instance
    public static Poisoncraft instance;
    @EventHandler
    public void init(FMLInitializationEvent event) {
        /** register items */
        Items.registerItems();
        /** register recipes */
        Items.registerRecipes();
        /** register ingredients with their effects */
        ItemPoison.poisonIngredients();
        /** register effects with their potions */
        ItemPoison.poisonEffects();
        /** register booster items with their amplifier */
        ItemPoisonBooster.boosterIngredients();
        /** register gui handlers */
        NetworkRegistry.INSTANCE.registerGuiHandler(Poisoncraft.instance, Poisoncraft.clientProxy);
        /** create and register event handler */
        eventHandler = new event.EventHandler();
        eventHandler.register();
    }
}

