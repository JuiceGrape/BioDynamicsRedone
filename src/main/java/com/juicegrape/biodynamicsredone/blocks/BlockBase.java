package com.juicegrape.biodynamicsredone.blocks;

import com.juicegrape.biodynamicsredone.BioDynamicsRedone;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block
{
    public String name;

    public BlockBase(Material material, String name) {
        super(material);

        this.name = name;

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(BioDynamicsRedone.modTab);
    }

    public void registerItemModel(Item itemBlock) {
        BioDynamicsRedone.proxy.registerItemRenderer(itemBlock, 0, name);
    }

    public Item createItemBlock() {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }
}
