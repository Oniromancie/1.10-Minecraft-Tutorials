package com.championash5357.tutorial.item;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.championash5357.tutorial.client.Tutorial;
import com.championash5357.tutorial.world.House;

public class ItemStructureSpawner extends Item{
	
	House house = new House();
	Random rand;
	
	public ItemStructureSpawner() {
		this.setUnlocalizedName("structure_spawner");
		this.setCreativeTab(Tutorial.tabTutorial);
		this.setMaxStackSize(1);
	}
	
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		house.generate(worldIn, rand, pos);
		return EnumActionResult.SUCCESS;
    }
}
