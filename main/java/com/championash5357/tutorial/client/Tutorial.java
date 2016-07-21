package com.championash5357.tutorial.client;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.championash5357.tutorial.entity.EntityFourArms;
import com.championash5357.tutorial.entity.TutorialEntity;
import com.championash5357.tutorial.init.TutorialBlocks;
import com.championash5357.tutorial.init.TutorialFluids;
import com.championash5357.tutorial.init.TutorialItems;
import com.championash5357.tutorial.init.TutorialSounds;
import com.championash5357.tutorial.init.TutorialTab;
import com.championash5357.tutorial.proxy.CommonProxy;
import com.championash5357.tutorial.world.TutorialStructureGenerator;
import com.championash5357.tutorial.world.TutorialWorldGenerator;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class Tutorial {
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static int getNextAvailableTabIndex() {
		return CreativeTabs.CREATIVE_TAB_ARRAY.length;
	}
	
	@Instance(Reference.MOD_ID)
	public static Tutorial modInstance;
	
	public static TutorialTab tabTutorial = new TutorialTab(getNextAvailableTabIndex(), "tabTutorial");
	static {
			FluidRegistry.enableUniversalBucket(); // Must be called before preInit
	}
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		TutorialFluids.register();
		FluidRegistry.addBucketForFluid(TutorialFluids.FluidAcid.instance);
		TutorialBlocks.init();
		TutorialBlocks.register();
		TutorialItems.init();
		TutorialItems.register();
		TutorialSounds.registerSounds();
		
		//Entity Spawns
		EntityRegistry.addSpawn(EntityFourArms.class, 5, 1, 2, EnumCreatureType.CREATURE, Biome.REGISTRY.getObjectById(1));
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.registerRenders();
		GameRegistry.addRecipe(new ItemStack(TutorialBlocks.purple_glowstone), "PPP", "PPP", "PPP", 'P', TutorialItems.purple_glowstone_dust);
		GameRegistry.registerWorldGenerator(new TutorialWorldGenerator(), 0);
		GameRegistry.registerWorldGenerator(new TutorialStructureGenerator(), 0);
		TutorialEntity.registerEntity();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
	@EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		
	}
}
