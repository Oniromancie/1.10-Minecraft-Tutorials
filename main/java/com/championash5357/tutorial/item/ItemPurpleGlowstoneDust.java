package com.championash5357.tutorial.item;

import com.championash5357.tutorial.client.Reference;
import com.championash5357.tutorial.client.Tutorial;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemPurpleGlowstoneDust extends Item{
	 
	public ItemPurpleGlowstoneDust() {
		this.setMaxStackSize(64);
		this.setUnlocalizedName("purple_glowstone_dust");
		this.setCreativeTab(Tutorial.tabTutorial);
	}
	
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
    	worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()), Blocks.DIRT.getDefaultState());
		worldIn.setBlockState(new BlockPos(pos.getX()+1, pos.getY()+1, pos.getZ()), Blocks.DIRT.getDefaultState());
		worldIn.setBlockState(new BlockPos(pos.getX()+1, pos.getY()+2, pos.getZ()), Blocks.DIRT.getDefaultState());
		worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY()+2, pos.getZ()), Blocks.DIRT.getDefaultState());
		worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()+2), Blocks.DIRT.getDefaultState());
		worldIn.setBlockState(new BlockPos(pos.getX()+1, pos.getY()+1, pos.getZ()+2), Blocks.DIRT.getDefaultState());
		worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY()+2, pos.getZ()+2), Blocks.DIRT.getDefaultState());
		worldIn.setBlockState(new BlockPos(pos.getX()+1, pos.getY()+2, pos.getZ()+2), Blocks.DIRT.getDefaultState());
		worldIn.setBlockState(new BlockPos(pos.getX()+2, pos.getY()+1, pos.getZ()+1), Blocks.DIRT.getDefaultState());
		worldIn.setBlockState(new BlockPos(pos.getX()+2, pos.getY()+2, pos.getZ()+1), Blocks.DIRT.getDefaultState());
		worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY()+3, pos.getZ()+1), Blocks.DIRT.getDefaultState());
		worldIn.setBlockState(new BlockPos(pos.getX()+1, pos.getY()+3, pos.getZ()+1), Blocks.DIRT.getDefaultState());
		ItemDoor.placeDoor(worldIn, new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()+1), EnumFacing.EAST, Blocks.OAK_DOOR, false);
    	return EnumActionResult.SUCCESS;
    }
}
