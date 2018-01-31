package com.juicegrape.biodynamicsredone.items;

import com.juicegrape.biodynamicsredone.BioDynamicsRedone;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item
{

    public String name;

    ItemBase(String name)
    {
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(BioDynamicsRedone.modTab);
    }

    public void registerItemModel() {
        BioDynamicsRedone.proxy.registerItemRenderer(this, 0, name);
    }
}
