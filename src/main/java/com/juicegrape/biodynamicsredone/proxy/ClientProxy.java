package com.juicegrape.biodynamicsredone.proxy;

import com.juicegrape.biodynamicsredone.BioDynamicsRedone;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit()
    {
        super.preInit();
    }

    @Override
    public void init()
    {
        super.init();
    }

    @Override
    public void postInit()
    {
        super.postInit();
    }

    @Override
    public void registerItemRenderer(Item item, int meta, String id)
    {
        super.registerItemRenderer(item, meta, id);
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(BioDynamicsRedone.MODID + ":" + id, "inventory"));
    }

}
