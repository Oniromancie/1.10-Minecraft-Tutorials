package com.championash5357.tutorial.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import com.championash5357.tutorial.client.Tutorial;

public class BlockTable extends Block{
	
	protected static final AxisAlignedBB RENDER = new AxisAlignedBB(0.0d, 0.0d, 0.0d, 1.0d, 0.875d, 1.0d);
	
	public BlockTable(Material materialIn) {
		super(materialIn);
		this.setUnlocalizedName("table");
		this.setCreativeTab(Tutorial.tabTutorial);
		this.setHardness(10.0f);
		this.setResistance(1.5f);
		this.setSoundType(SoundType.WOOD);
	}
	
	public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    public boolean isFullCube(IBlockState state) {
        return false;
    }
    
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return RENDER;
    }
}
