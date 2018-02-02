package com.juicegrape.biodynamicsredone.blocks;

import com.juicegrape.biodynamicsredone.BioDynamicsRedone;
import com.juicegrape.biodynamicsredone.BioDynamicsTab;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockEnertreeSapling extends BlockBush implements IGrowable
{
    public String name;

    public BlockEnertreeSapling(String name)
    {
        super(Material.GRASS);

        this.name = name;

        setUnlocalizedName(name);
        setRegistryName(name);

        setSoundType(SoundType.PLANT);
        setTickRandomly(true);
        setCreativeTab(BioDynamicsRedone.modTab);
    }

    public void registerItemModel(Item itemBlock) {
        BioDynamicsRedone.proxy.registerItemRenderer(itemBlock, 0, name);
    }

    public Item createItemBlock() {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }

    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return (double)worldIn.rand.nextFloat() < 0.45D;
    }

    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        BioDynamicsRedone.logger.info("TEST");
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        BioDynamicsRedone.logger.info("TEST2");
        if (!worldIn.isRemote)
        {
            super.updateTick(worldIn, pos, state, rand);

            if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0)
            {
                this.grow(worldIn, rand, pos, state);
            }
        }
    }
}
