package com.juicegrape.biodynamicsredone.items;

import com.juicegrape.biodynamicsredone.BioDynamicsRedone;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemPinkDiamond extends ItemBase
{
    private static final String NBTPURITY = "biodyanmicsredone.purity";
    private static final String NBTSIZE = "biodyanmicsredone.size";
    private static final String NBTCAPACITY = "biodyanmicsredone.capacity";
    public ItemPinkDiamond(String name)
    {
        super(name);
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        tooltip.add("Purity: " + getPurity(stack));
        tooltip.add("Size: " + getSize(stack));
        tooltip.add("Capacity: " + getCapacity(stack));
    }

    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
    {
        if (this.isInCreativeTab(tab))
        {
            ItemStack meh = new ItemStack(this);
            setPurity(meh, 10f);
            setCapacity(meh, 50f);
            setSize(meh, 1f);
            items.add(meh);

            ItemStack perfect = new ItemStack(this);
            setPurity(perfect, 100f);
            setCapacity(perfect, 100f);
            setSize(perfect, 10f);
            items.add(perfect);
        }
    }

    public EnumRarity getRarity(ItemStack stack)
    {
        int rarity = 0;
        if (getPurity(stack) > 75f)
            rarity++;
        if (getSize(stack) > 7.5f)
            rarity++;
        if (getCapacity(stack) > 75f)
            rarity++;
        return EnumRarity.values()[rarity];
    }


    public static float getPurity(ItemStack pinkDiamond)
    {
        if (pinkDiamond.getItem() instanceof ItemPinkDiamond && pinkDiamond.hasTagCompound())
        {
            NBTTagCompound nbt = pinkDiamond.getTagCompound();
            return nbt.getFloat(NBTPURITY);
        }

        return 0;
    }

    public static float getCapacity(ItemStack pinkDiamond)
    {
        if (pinkDiamond.getItem() instanceof ItemPinkDiamond && pinkDiamond.hasTagCompound())
        {
            NBTTagCompound nbt = pinkDiamond.getTagCompound();
            return nbt.getFloat(NBTCAPACITY);
        }

        return 0;
    }

    public static float getSize(ItemStack pinkDiamond)
    {
        if (pinkDiamond.getItem() instanceof ItemPinkDiamond && pinkDiamond.hasTagCompound())
        {
            NBTTagCompound nbt = pinkDiamond.getTagCompound();
            return nbt.getFloat(NBTSIZE);
        }

        return 0;
    }


    public static void setPurity(ItemStack pinkDiamond, float purity)
    {
        if (pinkDiamond.getItem() instanceof ItemPinkDiamond)
        {
            NBTTagCompound nbt;
            if (pinkDiamond.hasTagCompound())
            {
                nbt = pinkDiamond.getTagCompound();
            }
            else
            {
                nbt = new NBTTagCompound();
            }

            nbt.setFloat(NBTPURITY, purity);

            pinkDiamond.setTagCompound(nbt);
        }
    }

    public static void setCapacity(ItemStack pinkDiamond, float capacity)
    {
        if (pinkDiamond.getItem() instanceof ItemPinkDiamond)
        {
            NBTTagCompound nbt;
            if (pinkDiamond.hasTagCompound())
            {
                nbt = pinkDiamond.getTagCompound();
            }
            else
            {
                nbt = new NBTTagCompound();
            }

            nbt.setFloat(NBTCAPACITY, capacity);

            pinkDiamond.setTagCompound(nbt);
        }
    }

    public static void setSize(ItemStack pinkDiamond, float size)
    {
        if (pinkDiamond.getItem() instanceof ItemPinkDiamond)
        {
            NBTTagCompound nbt;
            if (pinkDiamond.hasTagCompound())
            {
                nbt = pinkDiamond.getTagCompound();
            }
            else
            {
                nbt = new NBTTagCompound();
            }

            nbt.setFloat(NBTSIZE, size);

            pinkDiamond.setTagCompound(nbt);
        }
    }


}
