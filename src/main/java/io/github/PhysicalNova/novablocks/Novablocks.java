package io.github.PhysicalNova.novablocks;

import io.github.PhysicalNova.novablocks.core.init.ItemInit;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Novablocks.MODID)
public class Novablocks {
	public static final String MODID="novablocks";
	
	public Novablocks() {
		var bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		ItemInit.ITEMS.register(bus);
	}
}
