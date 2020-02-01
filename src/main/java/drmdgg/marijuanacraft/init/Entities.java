package drmdgg.marijuanacraft.init;

import drmdgg.marijuanacraft.MarijuanaCraft;
import drmdgg.marijuanacraft.entities.CentaurEntity;
import drmdgg.marijuanacraft.entities.CrackHeadEntity;
import drmdgg.marijuanacraft.entities.GhostEntity;
import drmdgg.marijuanacraft.entities.LunaEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.event.RegistryEvent;

public class Entities 
{
	
	public static Item registerEntitySpawnEgg(EntityType<?> type, int color1, int color2, String name)
	{
		SpawnEggItem item = new SpawnEggItem(type, color1, color2, new Item.Properties().group(MarijuanaCraft.marijuanaitems));
		item.setRegistryName(MarijuanaCraft.location(name));
		return item;
	}

	
	public static void registerEntityWorldSpawn(EntityType<?> entity, EntityClassification classification, Biome... biomes)
	{
		for(Biome biome : biomes)
		{
			if(biome != null)
			{
				biome.getSpawns(classification).add(new SpawnListEntry(entity, 1, 1, 1));
			}
		}
	}
}
