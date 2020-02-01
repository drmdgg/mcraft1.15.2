package drmdgg.marijuanacraft.util;

import drmdgg.marijuanacraft.MarijuanaCraft;
import drmdgg.marijuanacraft.entities.CentaurEntity;
import drmdgg.marijuanacraft.entities.CrackHeadEntity;
import drmdgg.marijuanacraft.entities.GhostEntity;
import drmdgg.marijuanacraft.entities.LunaEntity;
import drmdgg.marijuanacraft.items.CentaurEggItem;
import drmdgg.marijuanacraft.items.CrackHeadEggItem;
import drmdgg.marijuanacraft.items.GhostEggItem;
import drmdgg.marijuanacraft.items.LunaEggItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registries {

	
    private static final DeferredRegister<EntityType<?>> ENTITIES = new DeferredRegister<>(ForgeRegistries.ENTITIES, MarijuanaCraft.modid);
    private static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, MarijuanaCraft.modid);


    
    public static void init() {
    	 ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
         ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

    }
    
    
    public static final RegistryObject<EntityType<CentaurEntity>> CENTAUR = ENTITIES.register("centaur", () -> EntityType.Builder.create(CentaurEntity::new, EntityClassification.CREATURE)
            .size(1, 1)
            .setShouldReceiveVelocityUpdates(false)
            .build("centaur"));
    
    public static final EntityType<CrackHeadEntity> CRACK_HEAD = register("crack_head", EntityType.Builder.<CrackHeadEntity>create(CrackHeadEntity::new, EntityClassification.MISC).size(0.6F, 1.95F));

    
    public static final RegistryObject<EntityType<GhostEntity>> GHOST = ENTITIES.register("ghost", () -> EntityType.Builder.create(GhostEntity::new, EntityClassification.MONSTER)
            .size(1, 1)
            .setShouldReceiveVelocityUpdates(false)
            .build("ghost"));
    
    public static final RegistryObject<EntityType<LunaEntity>> LUNA = ENTITIES.register("luna", () -> EntityType.Builder.create(LunaEntity::new, EntityClassification.CREATURE)
            .size(1, 1)
            .setShouldReceiveVelocityUpdates(false)
            .build("luna"));
    
    public static final RegistryObject<CentaurEggItem> centaur_egg = ITEMS.register("centaur_egg", CentaurEggItem::new);
    public static final RegistryObject<CrackHeadEggItem> crack_head_egg = ITEMS.register("crack_head_egg", CrackHeadEggItem::new);
    public static final RegistryObject<LunaEggItem> luna_egg = ITEMS.register("luna_egg", LunaEggItem::new);
    public static final RegistryObject<GhostEggItem> ghost_egg = ITEMS.register("ghost_egg", GhostEggItem::new);

    
    private static <T extends Entity> EntityType<T> register(String key, EntityType.Builder<T> builder) {
        return Registry.register(Registry.ENTITY_TYPE, key, builder.build(key));
     }

}
