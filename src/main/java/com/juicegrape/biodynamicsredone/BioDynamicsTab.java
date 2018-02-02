package com.juicegrape.biodynamicsredone;

import com.juicegrape.biodynamicsredone.items.ModItems;
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
        return new ItemStack(ModItems.pinkDiamond, 1, 0);
    }
}
