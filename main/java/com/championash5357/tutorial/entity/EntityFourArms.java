package com.championash5357.tutorial.entity;

import javax.annotation.Nullable;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import com.championash5357.tutorial.init.TutorialItems;
import com.championash5357.tutorial.init.TutorialSounds;

public class EntityFourArms extends EntityMob{

	public EntityFourArms(World worldIn) {
		super(worldIn);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(0, new EntityAITempt(this, 0.5d, TutorialItems.structure_spawner, false));
		this.tasks.addTask(2, new EntityAIWander(this, 2.0d));
		this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		this.tasks.addTask(3, new EntityAIAttackMelee(this, 2.0d, true));
		this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityCreeper.class, 100.0f, 2.0d, 5.0d));
		this.experienceValue = 200;
	}
	
	public boolean isAIEnabled() {
		return true;
	}
	
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(128.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(200.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(2.0D);
	}
	
	protected void addRandomArmor() {
		this.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, new ItemStack(Items.SHIELD));
	}
	
	protected Item getDropItem() {
		return TutorialItems.purple_glowstone_dust;
	}
	
	protected void dropRareDrop(int item) {
		this.dropItem(TutorialItems.structure_spawner, 1);
	}
	
	protected SoundEvent getAmbientSound() {
        return TutorialSounds.TutorialLive;
    }

    protected SoundEvent getHurtSound() {
        return TutorialSounds.TutorialHurt;
    }

    protected SoundEvent getDeathSound() {
        return TutorialSounds.TutorialDeath;
    }
}
