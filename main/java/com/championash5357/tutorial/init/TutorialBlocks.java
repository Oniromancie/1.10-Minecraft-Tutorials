package com.championash5357.tutorial.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.championash5357.tutorial.block.BlockPurpleGlowstone;
import com.championash5357.tutorial.block.BlockStrawberry;
import com.championash5357.tutorial.block.BlockTable;
import com.championash5357.tutorial.client.Reference;

public class TutorialBlocks {
	
	public static Block purple_glowstone;
	public static Block table;
	public static Block strawberry_crop;
	
	public static void init() {
		
	}
	
	public static void register() {
		GameRegistry.registerBlock(purple_glowstone = new BlockPurpleGlowstone(Material.GLASS), purple_glowstone.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(table = new BlockTable(Material.WOOD), table.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(strawberry_crop = new BlockStrawberry(), strawberry_crop.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders() {
		registerRender(purple_glowstone);
		registerRender(table);
		registerRender(strawberry_crop);
	}
	
	public static void registerRender(Block block) {
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
