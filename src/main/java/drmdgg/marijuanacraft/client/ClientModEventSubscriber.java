package drmdgg.marijuanacraft.client;

import org.apache.logging.log4j.LogManager;

import drmdgg.marijuanacraft.MarijuanaCraft;
import drmdgg.marijuanacraft.client.gui.ColumnScreen;
import drmdgg.marijuanacraft.client.gui.GuiVO;
import drmdgg.marijuanacraft.client.renders.CentaurRender;
import drmdgg.marijuanacraft.client.renders.CrackHeadRender;
import drmdgg.marijuanacraft.client.renders.GhostRender;
import drmdgg.marijuanacraft.client.renders.LunaRender;
import drmdgg.marijuanacraft.init.Entities;
import drmdgg.marijuanacraft.init.ModContainerTypes;
import drmdgg.marijuanacraft.lists.BlockList;
import drmdgg.marijuanacraft.util.Registries;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = MarijuanaCraft.modid, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)

public final class ClientModEventSubscriber {



	public static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(MarijuanaCraft.modid + " Client Mod Event Subscriber");
	
	
	@SubscribeEvent

	public static void onFMLClientSetupEvent(final FMLClientSetupEvent event) {


		// Register ContainerType Screens

		ScreenManager.registerFactory(ModContainerTypes.column, ColumnScreen::new);
		ScreenManager.registerFactory(ModContainerTypes.vacuumoven, GuiVO::new);
	
		// Register Entities
		RenderingRegistry.registerEntityRenderingHandler(Registries.CENTAUR.get(), CentaurRender::new);
		RenderingRegistry.registerEntityRenderingHandler(Registries.CRACK_HEAD, CrackHeadRender::new);
		RenderingRegistry.registerEntityRenderingHandler(Registries.GHOST.get(), GhostRender::new);
		RenderingRegistry.registerEntityRenderingHandler(Registries.LUNA.get(), LunaRender::new);
		
		
	
		RenderTypeLookup.setRenderLayer(BlockList.clone, layer -> layer == RenderType.translucent());
		RenderTypeLookup.setRenderLayer(BlockList.mplant, layer -> layer == RenderType.translucent());


		LOGGER.debug("Registered ContainerType Screens");



	}
}