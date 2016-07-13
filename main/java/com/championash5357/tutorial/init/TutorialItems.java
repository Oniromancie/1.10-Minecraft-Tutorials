package com.championash5357.tutorial.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.championash5357.tutorial.client.Reference;
import com.championash5357.tutorial.item.ItemAcidReinforcedBucket;
import com.championash5357.tutorial.item.ItemPurpleGlowstoneDust;
import com.championash5357.tutorial.item.ItemStrawberry;
import com.championash5357.tutorial.item.ItemStrawberrySeeds;
import com.championash5357.tutorial.item.ItemStructureSpawner;

public class TutorialItems {
	
	public static Item purple_glowstone_dust;
	public static Item structure_spawner;
	public static Item strawberry_seeds;
	public static Item strawberry;
	public static Item acid_bucket;
	
	public static void init() {
		
	}
	
	public static void register() {
		GameRegistry.registerItem(purple_glowstone_dust = new ItemPurpleGlowstoneDust(), purple_glowstone_dust.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(structure_spawner = new ItemStructureSpawner(), structure_spawner.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(strawberry = new ItemStrawberry(2, 1.0f, false), strawberry.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(strawberry_seeds = new ItemStrawberrySeeds(TutorialBlocks.strawberry_crop, Blocks.FARMLAND), strawberry_seeds.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(acid_bucket = new ItemAcidReinforcedBucket(), acid_bucket.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders() {
		registerRender(purple_glowstone_dust);
		registerRender(structure_spawner);
		registerRender(strawberry);
		registerRender(strawberry_seeds);
		registerRender(acid_bucket);
	}
	
	public static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
