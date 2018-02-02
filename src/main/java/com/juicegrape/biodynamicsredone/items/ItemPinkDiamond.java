package com.juicegrape.biodynamicsredone.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
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
    private static final String NBTLOCATION = "biodynamicsredone.location";
    private static final String NBTLOCATIONSET  = "biodynamicsredone.locationSet";
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
        if (hasLocation(stack))
        {
            int[] location = getLocation(stack);
            tooltip.add("Location set to: " + location[0] + ", " + location[1] + ", " + location[2]);
        }

    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
    {
        if (this.isInCreativeTab(tab))
        {
            ItemStack meh = new ItemStack(this);
            setPurity(meh, 10f);
            setCapacity(meh, 50f);
            setSize(meh, 1f);
            setHasLocation(meh, false);
            items.add(meh);

            ItemStack perfect = new ItemStack(this);
            setPurity(perfect, 100f);
            setCapacity(perfect, 100f);
            setSize(perfect, 10f);
            items.add(perfect);
        }
    }

    @Override
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

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        return hasLocation(stack);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (!player.isSneaking())
        {
            return EnumActionResult.PASS;
        }
        ItemStack stack = player.getHeldItem(hand);
        setLocation(stack, pos.getX(), pos.getY(), pos.getZ());
        setHasLocation(stack, true);
        return EnumActionResult.SUCCESS;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if (!playerIn.isSneaking())
        {
            return new ActionResult<ItemStack>(EnumActionResult.PASS, stack);
        }
        setHasLocation(stack, false);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
    }

    public static NBTTagCompound getCompound(ItemStack stack)
    {
        if (stack.hasTagCompound())
        {
            return stack.getTagCompound();
        }
        else
        {
            return new NBTTagCompound();
        }
    }

    public static float getPurity(ItemStack pinkDiamond)
    {
        if (pinkDiamond.getItem() instanceof ItemPinkDiamond && pinkDiamond.hasTagCompound())
        {
            NBTTagCompound nbt = getCompound(pinkDiamond);
            return nbt.getFloat(NBTPURITY);
        }

        return 0;
    }

    public static float getCapacity(ItemStack pinkDiamond)
    {
        if (pinkDiamond.getItem() instanceof ItemPinkDiamond && pinkDiamond.hasTagCompound())
        {
            NBTTagCompound nbt = getCompound(pinkDiamond);
            return nbt.getFloat(NBTCAPACITY);
        }

        return 0;
    }

    public static float getSize(ItemStack pinkDiamond)
    {
        if (pinkDiamond.getItem() instanceof ItemPinkDiamond && pinkDiamond.hasTagCompound())
        {
            NBTTagCompound nbt = getCompound(pinkDiamond);
            return nbt.getFloat(NBTSIZE);
        }

        return 0;
    }

    public static boolean hasLocation(ItemStack pinkDiamond)
    {
        if (pinkDiamond.getItem() instanceof ItemPinkDiamond && pinkDiamond.hasTagCompound())
        {
            NBTTagCompound nbt = getCompound(pinkDiamond);
            return nbt.getBoolean(NBTLOCATIONSET);
        }
        return false;
    }

    public static int[] getLocation(ItemStack pinkDiamond)
    {
        if (hasLocation(pinkDiamond))
        {
            NBTTagCompound nbt = getCompound(pinkDiamond);
            return nbt.getIntArray(NBTLOCATION);
        }
        return new int[] {0, 0, 0};
    }


    public static void setPurity(ItemStack pinkDiamond, float purity)
    {
        if (pinkDiamond.getItem() instanceof ItemPinkDiamond)
        {
            NBTTagCompound nbt = getCompound(pinkDiamond);

            nbt.setFloat(NBTPURITY, purity);

            pinkDiamond.setTagCompound(nbt);
        }
    }

    public static void setCapacity(ItemStack pinkDiamond, float capacity)
    {
        if (pinkDiamond.getItem() instanceof ItemPinkDiamond)
        {
            NBTTagCompound nbt = getCompound(pinkDiamond);

            nbt.setFloat(NBTCAPACITY, capacity);

            pinkDiamond.setTagCompound(nbt);
        }
    }

    public static void setSize(ItemStack pinkDiamond, float size)
    {
        if (pinkDiamond.getItem() instanceof ItemPinkDiamond)
        {
            NBTTagCompound nbt = getCompound(pinkDiamond);

            nbt.setFloat(NBTSIZE, size);

            pinkDiamond.setTagCompound(nbt);
        }
    }

    public static void setHasLocation(ItemStack pinkDiamond, boolean hasLocation)
    {
        if (pinkDiamond.getItem() instanceof ItemPinkDiamond)
        {
            NBTTagCompound nbt = getCompound(pinkDiamond);

            nbt.setBoolean(NBTLOCATIONSET, hasLocation);

            pinkDiamond.setTagCompound(nbt);
        }
    }

    public static void setLocation(ItemStack pinkDiamond, int x, int y, int z)
    {
        if (pinkDiamond.getItem() instanceof ItemPinkDiamond)
        {
            NBTTagCompound nbt = getCompound(pinkDiamond);

            nbt.setIntArray(NBTLOCATION, new int[] {x, y, z});

            pinkDiamond.setTagCompound(nbt);
        }
    }




}
