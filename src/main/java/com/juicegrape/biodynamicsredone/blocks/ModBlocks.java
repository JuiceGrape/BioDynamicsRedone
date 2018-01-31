package com.juicegrape.biodynamicsredone.blocks;

import com.juicegrape.biodynamicsredone.BioDynamicsRedone;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ModBlocks {

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        BioDynamicsRedone.logger.info("INIT BLOCKS");
    }
}
