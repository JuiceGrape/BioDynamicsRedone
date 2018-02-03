package com.juicegrape.biodynamicsredone.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ModBlocks {

    public static BlockMetal organicIronBlock = new BlockMetal("block_organic_iron", 5f, 30f);
    public static BlockMetal organicGoldBlock = new BlockMetal("block_organic_gold", 3f, 30f);

    public static BlockEnertreeSapling enertreeSaplingBlock = new BlockEnertreeSapling("block_enertree_sapling");
    public static BlockEnertreeLog enertreeLog = new BlockEnertreeLog("block_enertree_log");
    public static BlockEnertreeLeaves enertreeLeaves = new BlockEnertreeLeaves("block_enertree_leaves");

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                organicIronBlock,
                organicGoldBlock,
                enertreeSaplingBlock,
                enertreeLog,
                enertreeLeaves
        );
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(
                organicIronBlock.createItemBlock(),
                organicGoldBlock.createItemBlock(),
                enertreeSaplingBlock.createItemBlock(),
                enertreeLog.createItemBlock(),
                enertreeLeaves.createItemBlock()
        );
    }

    @SubscribeEvent
    public static void registerItemModels(ModelRegistryEvent event)
    {
        organicIronBlock.registerItemModel(Item.getItemFromBlock(organicIronBlock));
        organicGoldBlock.registerItemModel(Item.getItemFromBlock(organicGoldBlock));
        enertreeSaplingBlock.registerItemModel(Item.getItemFromBlock(enertreeSaplingBlock));
        enertreeLog.registerItemModel(Item.getItemFromBlock(enertreeLog));
        enertreeLeaves.registerItemModel(Item.getItemFromBlock(enertreeLeaves));
    }
}
