package drmdgg.marijuanacraft.entities;

import drmdgg.marijuanacraft.init.Entities;
import drmdgg.marijuanacraft.lists.ItemList;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MoveThroughVillageGoal;
import net.minecraft.entity.ai.goal.MoveTowardsVillageGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class CrackHeadEntity extends VillagerEntity {

	@SuppressWarnings("unchecked")
	public CrackHeadEntity(EntityType<? extends VillagerEntity> type, World worldIn) {
		super(type, worldIn);
		
	}

	@Override
	protected void registerGoals()
	{
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 0.2d));
		this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(3, new PanicGoal(this, hurtTime));
		this.goalSelector.addGoal(4, new MoveTowardsVillageGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new MoveThroughVillageGoal(this, 0.6D, false, 4, () -> {
	         return false;
		}));
		
	}
	

	@Override
	protected void registerAttributes()
	{
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0d);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.1d);
		
	}
	
	@Override
	public int getMaxSpawnedInChunk() {
		
		return 1; //super.getMaxSpawnedInChunk();
	}
	@Override
    protected void spawnDrops(DamageSource src) {
        entityDropItem(ItemList.mseed);
        super.spawnDrops(src);
    }
}
