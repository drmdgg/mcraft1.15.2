package drmdgg.marijuanacraft.entities;

import drmdgg.marijuanacraft.lists.ItemList;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class CentaurEntity extends CreatureEntity 
{
	
	
	public CentaurEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
		super(type, worldIn);
		
	}

	@Override
	protected void registerGoals()
	{
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 0.2d));
		this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(3, new PanicGoal(this, 0.1));
		
	}


	@Override
	protected void registerAttributes()
	{
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0d);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.9d);
		
	}
	
	protected void dropRareDrop(int par1)
	{
		this.entityDropItem(new ItemStack(ItemList.flower_crown, (int) (1)).getItem(), 1);
	}
	
	@Override
	public int getMaxSpawnedInChunk() {
		
		return 1; //super.getMaxSpawnedInChunk();
	}
	@Override
    protected void spawnDrops(DamageSource src) {
        entityDropItem(ItemList.flower_crown);
        super.spawnDrops(src);
    }
}


