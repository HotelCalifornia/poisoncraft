package com.hotel_c.poisoncraft;

import com.hotel_c.poisoncraft.block.Blocks;
import com.hotel_c.poisoncraft.gui.Handler;
import com.hotel_c.poisoncraft.item.ItemPoison;
import com.hotel_c.poisoncraft.item.Items;
import com.hotel_c.poisoncraft.item.poison.ItemPoisonBooster;
import com.hotel_c.poisoncraft.net.PacketHandler;
import com.hotel_c.poisoncraft.proxy.CommonProxy;
import com.hotel_c.poisoncraft.tileentity.TileEntityPoisonInfuser;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Poisoncraft.MODID, version = Poisoncraft.VERSION)
@SuppressWarnings("unused")
public class Poisoncraft {
    public static final String MODID = "poisoncraft";
    public static final String VERSION = "1.0";
    public static final Logger LOGGER = LogManager.getLogger(Poisoncraft.MODID);

    public static IGuiHandler guiHandler;
    public static com.hotel_c.poisoncraft.event.EventHandler eventHandler;
    @SidedProxy(
            clientSide = "com.hotel_c.poisoncraft.proxy.ClientProxy",
            serverSide = "com.hotel_c.poisoncraft.proxy.CommonProxy"
    )
    public static CommonProxy commonProxy;
    @Instance
    public static Poisoncraft instance;
    @EventHandler
    public void init(FMLInitializationEvent event) {
        /** register items */
        Items.registerItems();
        /** register blocks */
        Blocks.registerBlocks();
        /** register recipes */
        Items.registerRecipes();
        Blocks.registerRecipes();
        /** register ingredients with their effects */
        ItemPoison.poisonIngredients();
        /** register effects with their potions */
        ItemPoison.poisonEffects();
        /** register booster items with their amplifier */
        ItemPoisonBooster.boosterIngredients();
        /** register gui handler */
        guiHandler = new Handler();
        NetworkRegistry.INSTANCE.registerGuiHandler(Poisoncraft.instance, guiHandler);
        /** create and register event handler */
        eventHandler = new com.hotel_c.poisoncraft.event.EventHandler();
        eventHandler.register();
        /** create a network channel and register packets on the channel */
        PacketHandler.init();
        /** register renderer bullshit */
        commonProxy.registerRenderers();
        /** register TileEntities */
        GameRegistry.registerTileEntity(TileEntityPoisonInfuser.class, "poison_infuser");
    }
}

