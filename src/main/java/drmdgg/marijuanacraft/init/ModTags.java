package drmdgg.marijuanacraft.init;

import drmdgg.marijuanacraft.MarijuanaCraft;
import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

public class ModTags

{

    private static ResourceLocation

        tagVOFuels = new ResourceLocation(MarijuanaCraft.modid, "vacuumoven_fuels");



    public static Tag<Item> getVOFuels()

    {

        return ItemTags.getCollection().getOrCreate(tagVOFuels);

    }



} 