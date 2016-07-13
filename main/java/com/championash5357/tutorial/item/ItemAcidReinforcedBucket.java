package com.championash5357.tutorial.item;

import com.championash5357.tutorial.client.Tutorial;
import com.championash5357.tutorial.init.TutorialFluids;
import com.championash5357.tutorial.init.TutorialItems;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemAcidReinforcedBucket extends Item{
	
	public ItemAcidReinforcedBucket() {
		this.setUnlocalizedName("acid_bucket");
		this.setCreativeTab(Tutorial.tabTutorial);
	}
	
	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        worldIn.setBlockState(new BlockPos(pos.getX(),pos.getY()+1,pos.getZ()), TutorialFluids.BlockAcid.instance.getDefaultState());
        return EnumActionResult.SUCCESS;
    }
}
