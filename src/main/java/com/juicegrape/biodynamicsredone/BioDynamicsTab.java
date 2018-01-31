package com.juicegrape.biodynamicsredone;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class BioDynamicsTab extends CreativeTabs
{

    public BioDynamicsTab()
    {
        super(BioDynamicsRedone.MODID);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(Blocks.SAPLING, 1, 0);
    }
}
