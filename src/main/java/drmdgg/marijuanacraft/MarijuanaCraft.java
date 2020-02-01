package drmdgg.marijuanacraft;
 
import org.apache.logging.log4j.LogManager;

import drmdgg.marijuanacraft.config.Config;
import drmdgg.marijuanacraft.init.Entities;
import drmdgg.marijuanacraft.init.blocks.plants.MPlant;
import drmdgg.marijuanacraft.init.blocks.tileentities.ColumnBlock;
import drmdgg.marijuanacraft.init.blocks.tileentities.VOBlock;
import drmdgg.marijuanacraft.init.blocks.trees.Clone;
import drmdgg.marijuanacraft.init.blocks.trees.PotPlant;
import drmdgg.marijuanacraft.init.blocks.trees.PotStalk;
import drmdgg.marijuanacraft.items.ButaneFuel;
import drmdgg.marijuanacraft.items.ItemCustomScissors;
import drmdgg.marijuanacraft.lists.ArmorMaterialList;
import drmdgg.marijuanacraft.lists.BlockList;
import drmdgg.marijuanacraft.lists.FoodList;
import drmdgg.marijuanacraft.lists.ItemList;
import drmdgg.marijuanacraft.lists.ToolMaterialList;
import drmdgg.marijuanacraft.network.PacketHandler;
import drmdgg.marijuanacraft.util.Registries;
import drmdgg.marijuanacraft.world.OreGeneration;
import net.minecraft.block.Block;
import net.minecraft.block.HayBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
 
@Mod("marijuanacraft")
public class MarijuanaCraft 
{
    public static MarijuanaCraft instance;
    public static final String modid = "marijuanacraft";
    public static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(modid);
    
    public static final ModItemGroup marijuanaitems = new ModItemGroup("marijuanaitems", ()->(ItemList.marijuana_bud));
    

    public MarijuanaCraft()
    {
        instance = this;
        
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.SERVER, "marijuanacraft-server.toml");

		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT, "marijuanacraft-client.toml");
        
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
        
        Config.loadConfig(Config.CLIENT, FMLPaths.CONFIGDIR.get().resolve("marijuanacraft-client.toml").toString());

		Config.loadConfig(Config.SERVER, FMLPaths.CONFIGDIR.get().resolve("marijuanacraft-server.toml").toString());
     
        MinecraftForge.EVENT_BUS.register(this);
        PacketHandler.register();
        Registries.init();
       
        
    } 
        
    private void setup(final FMLCommonSetupEvent event) 
    {

    	OreGeneration.setupOreGen();
    	
        LOGGER.info("Setup method registered.");
    }
    
    private void clientRegistries(final FMLClientSetupEvent event) 
    {
    	
        LOGGER.info("ClientRegistries method registered.");
    }
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents
    {
        @SubscribeEvent 
        public static void registerItems(final RegistryEvent.Register<Item> event) 
        {
            event.getRegistry().registerAll
            (
            		
            		new BlockNamedItem(BlockList.mplant, (new Item.Properties()).group(marijuanaitems)).setRegistryName(location("mseed")),
                   
                    new Item(new Item.Properties().group(marijuanaitems)).setRegistryName(location("marijuana_bud")),
                    new Item(new Item.Properties().group(marijuanaitems)).setRegistryName(location("valve")),
                    new Item(new Item.Properties().group(marijuanaitems)).setRegistryName(location("shatter")),
                    new Item(new Item.Properties().group(marijuanaitems)).setRegistryName(location("dial")),
                    
                    new Item(new Item.Properties().group(marijuanaitems)).setRegistryName(location("mplant")),
                    new Item(new Item.Properties().group(marijuanaitems)).setRegistryName(location("marijuana_stalk")),
                            
                    new Item(new Item.Properties().group(marijuanaitems)).setRegistryName(location("metal_bowl")),
                    new Item(new Item.Properties().group(marijuanaitems)).setRegistryName(location("plastic_pen")),
                    new Item(new Item.Properties().group(marijuanaitems)).setRegistryName(location("plastic_bottle")),
                    new Item(new Item.Properties().group(marijuanaitems)).setRegistryName(location("weed_butter")),
                    new Item(new Item.Properties().group(marijuanaitems)).setRegistryName(location("butter")),
                    new Item(new Item.Properties().group(marijuanaitems)).setRegistryName(location("butane_bottle")),
                    new Item(new Item.Properties().group(marijuanaitems)).setRegistryName(location("compressed_butane")),
                    new Item(new Item.Properties().group(marijuanaitems)).setRegistryName(location("cream")),
                    new Item(new Item.Properties().group(marijuanaitems)).setRegistryName(location("crystal")),
                    new Item(new Item.Properties().group(marijuanaitems)).setRegistryName(location("empty_can")),
                    new Item(new Item.Properties().group(marijuanaitems)).setRegistryName(location("fabric")),
                    new Item(new Item.Properties().group(marijuanaitems)).setRegistryName(location("fermp")),
                    new Item(new Item.Properties().group(marijuanaitems)).setRegistryName(location("hash")),
                   
                    new Item(new Item.Properties().group(marijuanaitems)).setRegistryName(location("hashbut")),
                    new Item(new Item.Properties().group(marijuanaitems)).setRegistryName(location("sifter")),
                    new Item(new Item.Properties().group(marijuanaitems)).setRegistryName(location("alcmix1")),
                    new Item(new Item.Properties().group(marijuanaitems)).setRegistryName(location("alcmix2")),
                   
                    new Item(new Item.Properties().group(marijuanaitems)).setRegistryName(location("centaur_hide")),
                    
                    new Item(new Item.Properties().group(marijuanaitems).food(FoodList.apple_bong)).setRegistryName(location("apple_bong")),
                    new Item(new Item.Properties().group(marijuanaitems).food(FoodList.plastic_bong)).setRegistryName(location("plastic_bong")),
                    new Item(new Item.Properties().group(marijuanaitems).food(FoodList.hashbrow)).setRegistryName(location("hashbrow")),
                    new Item(new Item.Properties().group(marijuanaitems).food(FoodList.pot_cookie)).setRegistryName(location("pot_cookie")),
                    new Item(new Item.Properties().group(marijuanaitems).food(FoodList.baked_apple)).setRegistryName(location("baked_apple")),
                    
                    new ButaneFuel(new Item.Properties().group(marijuanaitems)).setRegistryName(location("butane_can")),
                    new Item(new Item.Properties().group(marijuanaitems)).setRegistryName(location("extract2")),
                    new ItemCustomScissors(ToolMaterialList.hempscissors, -1.0f, 6.0f, new Item.Properties().group(marijuanaitems)).setRegistryName(location("hemp_scissors")),
                    new HoeItem(ToolMaterialList.hemphoe, -1.0f, new Item.Properties().group(marijuanaitems)).setRegistryName(location("hemp_hoe")),
                    
                    new BlockItem(BlockList.bulb, new Item.Properties().group(marijuanaitems)).setRegistryName(BlockList.bulb.getRegistryName()),
                    new BlockItem(BlockList.column, new Item.Properties().group(marijuanaitems)).setRegistryName(BlockList.column.getRegistryName()),

                    new BlockItem(BlockList.vacuumoven, new Item.Properties().group(marijuanaitems)).setRegistryName(BlockList.vacuumoven.getRegistryName()),
                    
                    new BlockItem(BlockList.tblock, new Item.Properties().group(marijuanaitems)).setRegistryName(BlockList.tblock.getRegistryName()),
                    new BlockItem(BlockList.butane, new Item.Properties().group(marijuanaitems)).setRegistryName(BlockList.butane.getRegistryName()),
                    new BlockItem(BlockList.clone, new Item.Properties().group(marijuanaitems)).setRegistryName(BlockList.clone.getRegistryName()),
                    new BlockItem(BlockList.potleaves, new Item.Properties().group(marijuanaitems)).setRegistryName(BlockList.potleaves.getRegistryName()),                                
                    new BlockItem(BlockList.potstalk, new Item.Properties().group(marijuanaitems)).setRegistryName(BlockList.potstalk.getRegistryName()),
                    new BlockItem(BlockList.potbale, new Item.Properties().group(marijuanaitems)).setRegistryName(BlockList.potbale.getRegistryName()),
                  
                             
                    
                    new ArmorItem(ArmorMaterialList.flower, EquipmentSlotType.HEAD, new Item.Properties().group(marijuanaitems)).setRegistryName(location("flower_crown")),
                    new ArmorItem(ArmorMaterialList.flower, EquipmentSlotType.CHEST, new Item.Properties().group(marijuanaitems)).setRegistryName(location("flower_shirt")),
                    new ArmorItem(ArmorMaterialList.flower, EquipmentSlotType.LEGS, new Item.Properties().group(marijuanaitems)).setRegistryName(location("flower_pants")),
                    new ArmorItem(ArmorMaterialList.flower, EquipmentSlotType.FEET, new Item.Properties().group(marijuanaitems)).setRegistryName(location("flower_boots"))
                      
                    
            		);
                    
                LOGGER.info("Items registered.");
        }
 
        @SubscribeEvent
        
        public static void registerBlocks(final RegistryEvent.Register<Block> event) 
        {
            event.getRegistry().registerAll
        (
        		new MPlant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().sound(SoundType.CROP)).setRegistryName(location("mplant")),
                new Block(Block.Properties.create(Material.GLASS).hardnessAndResistance(2.0f, 3.0f).lightValue(100).sound(SoundType.GLASS)).setRegistryName(location("bulb")),
                new VOBlock(Block.Properties.create(Material.GLASS).hardnessAndResistance(2.0f, 3.0f).lightValue(30).sound(SoundType.METAL)).setRegistryName(location("vacuumoven")),
                new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(2.0f, 3.0f).lightValue(0).sound(SoundType.GLASS)).setRegistryName(location("tblock")),
                new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(2.0f, 3.0f).lightValue(0).sound(SoundType.GLASS)).setRegistryName(location("butane")),
                new ColumnBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).lightValue(30).sound(SoundType.METAL)).setRegistryName(location("column")),
                new HayBlock(Block.Properties.create(Material.ORGANIC, MaterialColor.YELLOW).hardnessAndResistance(0.5F).sound(SoundType.PLANT)).setRegistryName(location("potbale")),
                new Clone(new PotPlant(),Block.Properties.create(Material.PLANTS).hardnessAndResistance(0, 0).sound(SoundType.PLANT).harvestTool(ToolType.AXE).harvestLevel(0)).setRegistryName(location("clone")),
                new PotStalk(MaterialColor.EMERALD, Block.Properties.create(Material.WOOD).hardnessAndResistance(1, 3).sound(SoundType.WOOD).harvestTool(ToolType.AXE).harvestLevel(0)).setRegistryName(location("potstalk")),       
                new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).harvestTool(ToolType.AXE).harvestLevel(0)).setRegistryName(location("potleaves")));


            
                LOGGER.info("Blocks registered.");
        }
        

   
    }
	public static ResourceLocation location(String name) 
	{
		return new ResourceLocation(modid, name);
	}
	
	

}

