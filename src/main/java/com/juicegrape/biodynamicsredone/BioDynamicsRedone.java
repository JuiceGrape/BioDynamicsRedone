package com.juicegrape.biodynamicsredone;

import com.juicegrape.biodynamicsredone.blocks.ModBlocks;
import com.juicegrape.biodynamicsredone.proxy.CommonProxy;
import com.juicegrape.biodynamicsredone.items.ModItems;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = BioDynamicsRedone.MODID, name = BioDynamicsRedone.NAME, version = BioDynamicsRedone.VERSION)
public class BioDynamicsRedone
{
    public static final String MODID = "biodynamicsredone";
    public static final String NAME = "BioDynamics Redone";
    public static final String VERSION = "0.1.0";

    public static Logger logger;

    public static final BioDynamicsTab modTab = new BioDynamicsTab();

    @Mod.Instance(MODID)
    public static BioDynamicsRedone instance;

    @SidedProxy(serverSide = "com.juicegrape.biodynamicsredone.proxy.ServerProxy", clientSide = "com.juicegrape.biodynamicsredone.proxy.ClientProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        logger.info("Starting " + NAME + " preInit");
        proxy.preInit();
        logger.info("Finished " + NAME + " preInit");
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        logger.info("Starting " + NAME + " init");
        proxy.init();
        logger.info("Finished " + NAME + " init");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        logger.info("Starting " + NAME + " postInit");
        proxy.postInit();
        logger.info("Finished " + NAME + " postInit");
    }
}
