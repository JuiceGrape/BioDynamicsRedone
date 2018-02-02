package com.juicegrape.biodynamicsredone.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

public class BlockMetal extends BlockBase
{
    public BlockMetal(String name, float hardness, float blastResistance)
    {
        super(Material.IRON, name);

        setHardness(hardness);
        setResistance(blastResistance);
    }
}
