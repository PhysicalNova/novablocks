package io.github.PhysicalNova.novablocks.client.event;

import io.github.PhysicalNova.novablocks.Novablocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Novablocks.MODID, bus = Bus.MOD, value = Dist.CLIENT)
public final class ClientModEvents {

	private ClientModEvents() {
	}
	
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
	}
	
}
