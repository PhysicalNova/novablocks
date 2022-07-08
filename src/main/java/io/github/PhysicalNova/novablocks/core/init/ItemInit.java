package io.github.PhysicalNova.novablocks.core.init;

import io.github.PhysicalNova.novablocks.Novablocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ItemInit {
	private ItemInit() {}
		
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Novablocks.MODID);
	
	public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item", 
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	
	//Block items
	public static final RegistryObject<BlockItem> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block", 
			() -> new BlockItem(BlockInit.EXAMPLE_BLOCK.get(), new Item.Properties().tab(Novablocks.NOVABLOCKS_TAB)));
	
	public static final RegistryObject<BlockItem> HAZARD_BLOCK_ITEM = ITEMS.register("hazard_block", 
			() -> new BlockItem(BlockInit.HAZARD_BLOCK.get(), new Item.Properties().tab(Novablocks.NOVABLOCKS_TAB)));;
}
