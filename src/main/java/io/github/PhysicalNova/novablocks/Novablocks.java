package io.github.PhysicalNova.novablocks;

import io.github.PhysicalNova.novablocks.core.init.BlockInit;
import io.github.PhysicalNova.novablocks.core.init.ItemInit;
import io.github.PhysicalNova.novablocks.core.init.SoundInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Novablocks.MODID)
public class Novablocks {
	public static final String MODID="novablocks";
	
	public Novablocks() {
		var bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		BlockInit.BLOCK.register(bus);
		ItemInit.ITEMS.register(bus);
		SoundInit.SOUNDS.register(bus);
	}
	
	public static final CreativeModeTab NOVABLOCKS_TAB = new CreativeModeTab(MODID) {//itemGroup.novablocks

		@Override
		public ItemStack makeIcon() {
			return ItemInit.IRON_STRUCTURE_BLOCK_ITEM.get().getDefaultInstance();
		}
		
	};
	
}
