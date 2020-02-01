package drmdgg.marijuanacraft;

import java.io.IOException;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.TableLootEntry;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MarijuanaCraft.modid)

public class EventHandler{

private static ResourceLocation grass = new ResourceLocation("minecraft", "blocks/grass");

    @SubscribeEvent

    public static void onLootLoad(LootTableLoadEvent event) throws IOException 
    {
        if (event.getName().equals(grass)) 

        {
            event.getTable().addPool(LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation(MarijuanaCraft.modid, "blocks/grass"))).build());
        }
    }
}