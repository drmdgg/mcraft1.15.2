package drmdgg.marijuanacraft.config;

import java.io.File;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import drmdgg.marijuanacraft.MarijuanaCraft;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber

public class Config 

{

	private static final ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();

	public static final ForgeConfigSpec SERVER;

	

	private static final ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

	public static final ForgeConfigSpec CLIENT;

	

	static

	{

		OreGenConfig.init(SERVER_BUILDER, CLIENT_BUILDER);

		

		SERVER = SERVER_BUILDER.build();

		CLIENT = CLIENT_BUILDER.build();

	}

	

	public static void loadConfig(ForgeConfigSpec config, String path)

	{

		MarijuanaCraft.LOGGER.info("Loading config: " + path);

		final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();

		MarijuanaCraft.LOGGER.info("Built config: " + path);

		file.load();

		MarijuanaCraft.LOGGER.info("Loaded config: " + path);

		config.setConfig(file);

	}

}