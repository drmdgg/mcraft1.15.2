package drmdgg.marijuanacraft.init.blocks.trees;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

public class PotPlant extends Tree {
	   @Nullable
	   protected AbstractTreeFeature<BaseTreeFeatureConfig> getTreeFeature(Random random) {
	      return new BasicTreeFeature(BaseTreeFeatureConfig::deserialize, true);
	   }

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> func_225546_b_(Random arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return null;
	}
}
	   
	 
