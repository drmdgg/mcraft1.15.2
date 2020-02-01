package drmdgg.marijuanacraft.entities;

import drmdgg.marijuanacraft.init.Entities;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.BegGoal;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.NonTamedTargetGoal;
import net.minecraft.entity.ai.goal.OwnerHurtByTargetGoal;
import net.minecraft.entity.ai.goal.OwnerHurtTargetGoal;
import net.minecraft.entity.ai.goal.SitGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class LunaEntity extends WolfEntity {

	@SuppressWarnings("unchecked")
	public LunaEntity(EntityType<? extends WolfEntity> type, World worldIn) {
		super(type, worldIn);
		
	}
	@Override
	public int getMaxSpawnedInChunk() {
		
		return 1; //super.getMaxSpawnedInChunk();
	}

	@Override
	protected void registerGoals()
	{
		 this.sitGoal = new SitGoal(this);
	      this.goalSelector.addGoal(1, new SwimGoal(this));
	      this.goalSelector.addGoal(2, this.sitGoal);
	      this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
	      this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
	      this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.0D, 10.0F, 5.0F, isSprinting()));
	      this.goalSelector.addGoal(7, new BreedGoal(this, 2.0D));
	      this.goalSelector.addGoal(8, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
	      this.goalSelector.addGoal(9, new BegGoal(this, 8.0F));
	      this.goalSelector.addGoal(10, new LookAtGoal(this, PlayerEntity.class, 8.0F));
	      this.goalSelector.addGoal(10, new LookRandomlyGoal(this));
	      this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
	      this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
	      this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setCallsForHelp());
	      this.targetSelector.addGoal(4, new NonTamedTargetGoal<>(this, AnimalEntity.class, false, field_213441_bD));
	      this.targetSelector.addGoal(4, new NonTamedTargetGoal<>(this, TurtleEntity.class, false, TurtleEntity.TARGET_DRY_BABY));
	      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, AbstractSkeletonEntity.class, false));
	}
	
  
	      
	 }

