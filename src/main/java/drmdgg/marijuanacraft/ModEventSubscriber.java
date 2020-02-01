package drmdgg.marijuanacraft;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Preconditions;

import drmdgg.marijuanacraft.container.ColumnContainer;
import drmdgg.marijuanacraft.container.VacuumOvenContainer;
import drmdgg.marijuanacraft.init.blocks.tileentities.ColumnTileEntity;
import drmdgg.marijuanacraft.init.blocks.tileentities.VacuumOvenTileEntity;
import drmdgg.marijuanacraft.lists.BlockList;
import drmdgg.marijuanacraft.lists.VORecipeList;
import drmdgg.marijuanacraft.potion.StonedEffect;
import drmdgg.marijuanacraft.recipes.PurgingRecipe;
import drmdgg.marijuanacraft.recipes.VORecipeSerializer;
import drmdgg.marijuanacraft.util.Registries;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.potion.Effect;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.network.IContainerFactory;
import net.minecraftforge.registries.IForgeRegistryEntry;


@EventBusSubscriber(modid = MarijuanaCraft.modid, bus = EventBusSubscriber.Bus.MOD)
public final class ModEventSubscriber {
	
	private static final Logger LOGGER = LogManager.getLogger(MarijuanaCraft.modid + " Mod Event Subscriber");
	
	//Register recipes
	@SubscribeEvent
	public static void registerRecipes(final RegistryEvent.Register<IRecipeSerializer<?>> event) {
		LOGGER.info("Registering all recipes");
		
		LOGGER.info("Registering PurgingRecipe");
		event.getRegistry().register(VORecipeList.PURGING = new VORecipeSerializer<>(PurgingRecipe::new, 200));
		
		LOGGER.info("Recipes registered");
	}
	
	
	@SubscribeEvent
	public static void onEffectRegistry(final RegistryEvent.Register<Effect> event) {
		StonedEffect.RegisterEffects(event);
		
		LOGGER.debug("Registered Effects");
	}
	

		
			
	@SubscribeEvent
	public static void onRegisterTileEntityTypes(RegistryEvent.Register<TileEntityType<?>> event) 
	{
		event.getRegistry().registerAll(
				setup(TileEntityType.Builder.create(ColumnTileEntity::new, BlockList.column).build(null), "column"),
				setup(TileEntityType.Builder.create(VacuumOvenTileEntity::new, BlockList.vacuumoven).build(null), "vacuumoven")
				
			);
		LOGGER.debug("Registered TileEntityTypes");
	}
	
	

	@SubscribeEvent

	public static void onRegisterContainerTypes(@Nonnull final RegistryEvent.Register<ContainerType<?>> event) {

		// Register your ContainerTypes here if you have them

		event.getRegistry().registerAll(

				setup(IForgeContainerType.create(ColumnContainer::new), "column"),
				setup(new ContainerType<>((IContainerFactory<Container>) VacuumOvenContainer::new), "vacuumoven")
				

		);

		LOGGER.debug("Registered ContainerTypes");

	}
	
	@Nonnull

	private static <T extends IForgeRegistryEntry<T>> T setup(@Nonnull final T entry, @Nonnull final String name) {

		Preconditions.checkNotNull(name, "Name to assign to entry cannot be null!");

		return setup(entry, new ResourceLocation(MarijuanaCraft.modid, name));

	}


	@Nonnull

	private static <T extends IForgeRegistryEntry<T>> T setup(@Nonnull final T entry, @Nonnull final ResourceLocation registryName) {

		Preconditions.checkNotNull(entry, "Entry cannot be null!");

		Preconditions.checkNotNull(registryName, "Registry name to assign to entry cannot be null!");

		entry.setRegistryName(registryName);

		return entry;

	}
	
}
