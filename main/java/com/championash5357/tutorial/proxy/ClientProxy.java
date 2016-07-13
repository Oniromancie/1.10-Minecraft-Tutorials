package com.championash5357.tutorial.proxy;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import com.championash5357.tutorial.entity.EntityFourArms;
import com.championash5357.tutorial.init.TutorialBlocks;
import com.championash5357.tutorial.init.TutorialItems;
import com.championash5357.tutorial.model.ModelEntityFourArms;
import com.championash5357.tutorial.render.RenderEntityFourArms;

public class ClientProxy extends CommonProxy{
	@Override
	public void registerRenders() {
		TutorialBlocks.registerRenders();
		TutorialItems.registerRenders();
		RenderingRegistry.registerEntityRenderingHandler(EntityFourArms.class, new RenderEntityFourArms(Minecraft.getMinecraft().getRenderManager(), new ModelEntityFourArms(), 0));
	}
}
