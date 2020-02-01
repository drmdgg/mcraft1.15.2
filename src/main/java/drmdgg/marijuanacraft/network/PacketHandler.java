package drmdgg.marijuanacraft.network;

import drmdgg.marijuanacraft.MarijuanaCraft;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class PacketHandler  {
	
	private static final String PROTOCOL_VERSION = Integer.toString(1);
	private static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(MarijuanaCraft.modid, "marijuanacraft"),
			() -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
            );
	
	
		public static void register()
	{
		int MId = 0;
		INSTANCE.registerMessage(MId++, C2SRequestStartOven.class, C2SRequestStartOven::encode, C2SRequestStartOven::decode, C2SRequestStartOven::handle);
		
	}
	
		public static <MSG> void sendToServer(MSG msg)
	{
		INSTANCE.sendToServer(msg);
	}


	/**
	 * Send a packet to a specific player.<br>
	 * Must be called Server side. 
	 */
	public static <MSG> void sendToPlayer(MSG message, ServerPlayerEntity player)
	{
		 INSTANCE.sendTo(message, player.connection.netManager, NetworkDirection.PLAY_TO_CLIENT);
		}
		
		
	}



