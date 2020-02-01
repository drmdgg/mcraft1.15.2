package drmdgg.marijuanacraft;




import java.util.List;



import com.google.common.collect.Lists;



import drmdgg.marijuanacraft.init.blocks.trees.BasicTreeFeature;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import net.minecraft.world.gen.feature.NoFeatureConfig;



public class MarijuanaCraftFeatures {

	

	public static List<Feature<?>> features = Lists.newArrayList();

	

	@SuppressWarnings("unchecked")

	public static final Feature<NoFeatureConfig> POTPLANT = registerFeature("potplant", new BasicTreeFeature(BaseTreeFeatureConfig::deserializeJungle, false));

	

	@SuppressWarnings("rawtypes")

	private static Feature registerFeature(String name, Feature feature){

		

		feature.setRegistryName(MarijuanaCraft.modid, name);

		features.add(feature);

		return feature;

		

	}



}