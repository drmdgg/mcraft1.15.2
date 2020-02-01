package drmdgg.marijuanacraft.world;

import drmdgg.marijuanacraft.config.OreGenConfig;
import drmdgg.marijuanacraft.lists.BlockList;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGeneration
{
    public static void setupOreGen()
    {
    	
    	if(OreGenConfig.generate_overworld.get())
 
       
        for(Biome biome : ForgeRegistries.BIOMES)
        {  
        	biome.addFeature(Decoration.UNDERGROUND_ORES,(Feature.ORE.withConfiguration(new OreFeatureConfig(FillerBlockType.NATURAL_STONE, 
        			BlockList.tblock.getDefaultState(), OreGenConfig.tblock_chance.get()))));
        	biome.addFeature(Decoration.UNDERGROUND_ORES, (Feature.ORE.withConfiguration(new OreFeatureConfig(FillerBlockType.NETHERRACK, 
        			BlockList.butane.getDefaultState(), OreGenConfig.butane_chance.get()))));
   
    }
}
}
