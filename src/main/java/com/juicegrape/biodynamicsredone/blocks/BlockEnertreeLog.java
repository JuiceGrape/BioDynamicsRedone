package com.juicegrape.biodynamicsredone.blocks;

import com.juicegrape.biodynamicsredone.BioDynamicsRedone;
import net.minecraft.block.BlockLog;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockEnertreeLog extends BlockLog
{
    public static String name;

    public BlockEnertreeLog(String name)
    {
        super();
        this.name = name;

        setUnlocalizedName(name);
        setRegistryName(name);
        this.setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
        setCreativeTab(BioDynamicsRedone.modTab);
    }


    public void registerItemModel(Item itemBlock) {
        BioDynamicsRedone.proxy.registerItemRenderer(itemBlock, 0, name);
    }

    public Item createItemBlock() {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState state = this.getDefaultState();

        switch (meta & 0b1100)
        {
            case 0b0000:
                state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.Y);
                break;

            case 0b0100:
                state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
                break;

            case 0b1000:
                state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.Z);
                break;

            case 0b1100:
                state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.NONE);
                break;
        }

        return state;
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        switch (state.getValue(LOG_AXIS))
        {
            case X: return 0b0100;
            case Y: return 0b0000;
            case Z: return 0b1000;
            case NONE: return 0b1100;
            default: return  0b1100;
        }
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {LOG_AXIS});
    }

}
