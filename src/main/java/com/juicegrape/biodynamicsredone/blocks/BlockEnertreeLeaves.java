package com.juicegrape.biodynamicsredone.blocks;

import com.juicegrape.biodynamicsredone.BioDynamicsRedone;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.MinecraftException;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockEnertreeLeaves extends BlockLeaves {

    public String name;
    public BlockEnertreeLeaves(String name)
    {
        super();
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(BioDynamicsRedone.modTab);

        setGraphicsLevel(Minecraft.getMinecraft().gameSettings.fancyGraphics);

        this.setDefaultState(this.blockState.getBaseState().withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)));
    }

    public void registerItemModel(Item itemBlock) {
        BioDynamicsRedone.proxy.registerItemRenderer(itemBlock, 0, name);
    }

    public Item createItemBlock() {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }

    @SideOnly(Side.CLIENT)
    public boolean isTranslucent(IBlockState state)
    {
        setGraphicsLevel(Minecraft.getMinecraft().gameSettings.fancyGraphics);
        return super.isTranslucent(state);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(ModBlocks.enertreeSaplingBlock);
    }

    @Override
    public BlockPlanks.EnumType getWoodType(int meta)
    {
        return BlockPlanks.EnumType.OAK;
    }

    @Nonnull
    @Override
    public List<ItemStack> onSheared(@Nonnull ItemStack item, IBlockAccess world, BlockPos pos, int fortune)
    {
        List<ItemStack> shearDrop = new ArrayList<ItemStack>();
        shearDrop.add(new ItemStack(this));
        return shearDrop;
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {CHECK_DECAY, DECAYABLE});
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {

        //return this.getDefaultState().withProperty(VARIANT, this.getWoodType(meta)).withProperty(DECAYABLE, Boolean.valueOf((meta & 4) == 0)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 8) > 0));
        return this.getDefaultState().withProperty(CHECK_DECAY, Boolean.valueOf((meta&1) > 0)).withProperty(DECAYABLE, Boolean.valueOf((meta&2) == 0));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    @Override
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        if (!((Boolean)state.getValue(DECAYABLE)).booleanValue())
        {
            i |= 2;
        }

        if (((Boolean)state.getValue(CHECK_DECAY)).booleanValue())
        {
            i |= 1;
        }

        return i;
    }
}
