package drmdgg.marijuanacraft.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OreGenConfig 

{

	public static ForgeConfigSpec.IntValue tblock_chance;
	public static ForgeConfigSpec.IntValue butane_chance;

	public static ForgeConfigSpec.BooleanValue generate_overworld;

	

	public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client)

	{

		server.comment("Oregen Config");

		

		tblock_chance = server

				.comment("Maximum number of ore veins of the tutorial ore that can spawn in one chunk.")

				.defineInRange("oregen.tblock_chance", 1, 2, 10);

		

		generate_overworld = server

				.comment("Decide if you want ores to spawn in the overworld")

				.define("oregen.generate_overworld", true);

        
        butane_chance = server
                .comment("Maximum number of ore veins of the butane ore that can spawn in one chunk (Set 0 to disable spawns, Default= 8)")
                .translation("marijuanacraft.config.butane_chance")
                .defineInRange("oregen.butane_chance", 1, 2, 10);
    }
}
