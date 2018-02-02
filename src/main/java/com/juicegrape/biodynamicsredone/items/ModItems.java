package com.juicegrape.biodynamicsredone.items;

import com.juicegrape.biodynamicsredone.BioDynamicsRedone;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ModItems {

    public static ItemWrench wrench = new ItemWrench("wrench");

    public static ItemBase organicIronIngot = new ItemBase("ingot_organic_iron");
    public static ItemBase organicIronNugget = new ItemBase("nugget_organic_iron");
    public static ItemBase organicIronDust = new ItemBase("dust_organic_iron");
    public static ItemBase ironDust = new ItemBase("dust_iron");

    public static ItemBase organicGoldIngot = new ItemBase("ingot_organic_gold");
    public static ItemBase organicGoldNugget = new ItemBase("nugget_organic_gold");
    public static ItemBase organicGoldDust = new ItemBase("dust_organic_gold");
    public static ItemBase goldDust = new ItemBase("dust_gold");

    public static ItemPinkDiamond pinkDiamond = new ItemPinkDiamond("gem_pink_diamond");


    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(
                organicIronIngot,
                organicIronNugget,
                organicIronDust,
                ironDust,
                organicGoldIngot,
                organicGoldNugget,
                organicGoldDust,
                goldDust,
                pinkDiamond
        );
    }

    @SubscribeEvent
    public static void registerItemModels(ModelRegistryEvent event)
    {
        organicIronIngot.registerItemModel();
        organicIronNugget.registerItemModel();
        organicIronDust.registerItemModel();
        ironDust.registerItemModel();
        organicGoldIngot.registerItemModel();
        organicGoldNugget.registerItemModel();
        organicGoldDust.registerItemModel();
        goldDust.registerItemModel();
        pinkDiamond.registerItemModel();
    }
}
