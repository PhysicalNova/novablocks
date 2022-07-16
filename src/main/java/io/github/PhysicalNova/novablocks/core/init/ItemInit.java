package io.github.PhysicalNova.novablocks.core.init;

import io.github.PhysicalNova.novablocks.Novablocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ItemInit {
	private ItemInit() {}
		
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Novablocks.MODID);
	
	public static final RegistryObject<Item> WRENCHAMMER = ITEMS.register("wrenchammer_item", 
			() -> new Item(new Item.Properties().tab(Novablocks.NOVABLOCKS_TAB)));
	
	//Block items
	//full block items
	public static final RegistryObject<BlockItem> HAZARD_BLOCK_ITEM = ITEMS.register("hazard_block", 
			() -> new BlockItem(BlockInit.HAZARD_BLOCK.get(), new Item.Properties().tab(Novablocks.NOVABLOCKS_TAB)));
	
	public static final RegistryObject<BlockItem> RED_METAL_BLOCK_ITEM = ITEMS.register("red_metal_block", 
			() -> new BlockItem(BlockInit.RED_METAL_BLOCK.get(), new Item.Properties().tab(Novablocks.NOVABLOCKS_TAB)));
	
	public static final RegistryObject<BlockItem> RUSTY_METAL_BLOCK_ITEM = ITEMS.register("rusty_metal_block", 
			() -> new BlockItem(BlockInit.RUSTY_METAL_BLOCK.get(), new Item.Properties().tab(Novablocks.NOVABLOCKS_TAB)));
	
	//Structure block items
	
	public static final RegistryObject<BlockItem> IRON_STRUCTURE_BLOCK_ITEM = ITEMS.register("iron_structure_block", 
			() -> new BlockItem(BlockInit.IRON_STRUCTURE_BLOCK.get(), new Item.Properties().tab(Novablocks.NOVABLOCKS_TAB)));
	
	public static final RegistryObject<BlockItem> COPPER_STRUCTURE_BLOCK_ITEM = ITEMS.register("copper_structure_block", 
			() -> new BlockItem(BlockInit.COPPER_STRUCTURE_BLOCK.get(), new Item.Properties().tab(Novablocks.NOVABLOCKS_TAB)));
	
	public static final RegistryObject<BlockItem> EXPOSED_COPPER_STRUCTURE_BLOCK_ITEM = ITEMS.register("exposed_copper_structure_block", 
			() -> new BlockItem(BlockInit.EXPOSED_COPPER_STRUCTURE_BLOCK.get(), new Item.Properties().tab(Novablocks.NOVABLOCKS_TAB)));
	
	public static final RegistryObject<BlockItem> WEATHERED_COPPER_STRUCTURE_BLOCK_ITEM = ITEMS.register("weathered_copper_structure_block", 
			() -> new BlockItem(BlockInit.WEATHERED_COPPER_STRUCTURE_BLOCK.get(), new Item.Properties().tab(Novablocks.NOVABLOCKS_TAB)));
	
	public static final RegistryObject<BlockItem> OXIDIZED_COPPER_STRUCTURE_BLOCK_ITEM = ITEMS.register("oxidized_copper_structure_block", 
			() -> new BlockItem(BlockInit.OXIDIZED_COPPER_STRUCTURE_BLOCK.get(), new Item.Properties().tab(Novablocks.NOVABLOCKS_TAB)));
	
	public static final RegistryObject<BlockItem> WAXED_COPPER_STRUCTURE_BLOCK_ITEM = ITEMS.register("waxed_copper_structure_block", 
			() -> new BlockItem(BlockInit.WAXED_COPPER_STRUCTURE_BLOCK.get(), new Item.Properties().tab(Novablocks.NOVABLOCKS_TAB)));
	
	public static final RegistryObject<BlockItem> WAXED_EXPOSED_COPPER_STRUCTURE_BLOCK_ITEM = ITEMS.register("waxed_exposed_copper_structure_block", 
			() -> new BlockItem(BlockInit.WAXED_EXPOSED_COPPER_STRUCTURE_BLOCK.get(), new Item.Properties().tab(Novablocks.NOVABLOCKS_TAB)));
	
	public static final RegistryObject<BlockItem> WAXED_WEATHERED_COPPER_STRUCTURE_BLOCK_ITEM = ITEMS.register("waxed_weathered_copper_structure_block", 
			() -> new BlockItem(BlockInit.WAXED_WEATHERED_COPPER_STRUCTURE_BLOCK.get(), new Item.Properties().tab(Novablocks.NOVABLOCKS_TAB)));
	
	public static final RegistryObject<BlockItem> WAXED_OXIDIZED_COPPER_STRUCTURE_BLOCK_ITEM = ITEMS.register("waxed_oxidized_copper_structure_block", 
			() -> new BlockItem(BlockInit.WAXED_OXIDIZED_COPPER_STRUCTURE_BLOCK.get(), new Item.Properties().tab(Novablocks.NOVABLOCKS_TAB)));
	
	
	public static final RegistryObject<BlockItem> RED_METAL_STRUCTURE_BLOCK_ITEM = ITEMS.register("red_metal_structure_block", 
			() -> new BlockItem(BlockInit.RED_METAL_STRUCTURE_BLOCK.get(), new Item.Properties().tab(Novablocks.NOVABLOCKS_TAB)));
	
	public static final RegistryObject<BlockItem> RUSTY_METAL_STRUCTURE_BLOCK_ITEM = ITEMS.register("rusty_metal_structure_block", 
			() -> new BlockItem(BlockInit.RUSTY_METAL_STRUCTURE_BLOCK.get(), new Item.Properties().tab(Novablocks.NOVABLOCKS_TAB)));
	
	public static final RegistryObject<BlockItem> HAZARD_STRUCTURE_BLOCK_ITEM = ITEMS.register("hazard_structure_block", 
			() -> new BlockItem(BlockInit.HAZARD_STRUCTURE_BLOCK.get(), new Item.Properties().tab(Novablocks.NOVABLOCKS_TAB)));
	
	public static final RegistryObject<BlockItem> OAK_LOG_STRUCTURE_BLOCK_ITEM = ITEMS.register("oak_log_structure_block", 
			() -> new BlockItem(BlockInit.OAK_LOG_STRUCTURE_BLOCK.get(), new Item.Properties().tab(Novablocks.NOVABLOCKS_TAB)));
	
	public static final RegistryObject<BlockItem> BIRCH_LOG_STRUCTURE_BLOCK_ITEM = ITEMS.register("birch_log_structure_block", 
			() -> new BlockItem(BlockInit.BIRCH_LOG_STRUCTURE_BLOCK.get(), new Item.Properties().tab(Novablocks.NOVABLOCKS_TAB)));
	
	public static final RegistryObject<BlockItem> JUNGLE_LOG_STRUCTURE_BLOCK_ITEM = ITEMS.register("jungle_log_structure_block", 
			() -> new BlockItem(BlockInit.JUNGLE_LOG_STRUCTURE_BLOCK.get(), new Item.Properties().tab(Novablocks.NOVABLOCKS_TAB)));
	
	public static final RegistryObject<BlockItem> SPRUCE_LOG_STRUCTURE_BLOCK_ITEM = ITEMS.register("spruce_log_structure_block", 
			() -> new BlockItem(BlockInit.SPRUCE_LOG_STRUCTURE_BLOCK.get(), new Item.Properties().tab(Novablocks.NOVABLOCKS_TAB)));
	
	public static final RegistryObject<BlockItem> ACACIA_LOG_STRUCTURE_BLOCK_ITEM = ITEMS.register("acacia_log_structure_block", 
			() -> new BlockItem(BlockInit.ACACIA_LOG_STRUCTURE_BLOCK.get(), new Item.Properties().tab(Novablocks.NOVABLOCKS_TAB)));
	
	public static final RegistryObject<BlockItem> DARK_OAK_LOG_STRUCTURE_BLOCK_ITEM = ITEMS.register("dark_oak_log_structure_block", 
			() -> new BlockItem(BlockInit.DARK_OAK_LOG_STRUCTURE_BLOCK.get(), new Item.Properties().tab(Novablocks.NOVABLOCKS_TAB)));
	
	public static final RegistryObject<BlockItem> STRIPPED_OAK_LOG_STRUCTURE_BLOCK_ITEM = ITEMS.register("stripped_oak_log_structure_block", 
			() -> new BlockItem(BlockInit.STRIPPED_OAK_LOG_STRUCTURE_BLOCK.get(), new Item.Properties().tab(Novablocks.NOVABLOCKS_TAB)));
	
	public static final RegistryObject<BlockItem> STRIPPED_BIRCH_LOG_STRUCTURE_BLOCK_ITEM = ITEMS.register("stripped_birch_log_structure_block", 
			() -> new BlockItem(BlockInit.STRIPPED_BIRCH_LOG_STRUCTURE_BLOCK.get(), new Item.Properties().tab(Novablocks.NOVABLOCKS_TAB)));
	
	public static final RegistryObject<BlockItem> STRIPPED_JUNGLE_LOG_STRUCTURE_BLOCK_ITEM = ITEMS.register("stripped_jungle_log_structure_block", 
			() -> new BlockItem(BlockInit.STRIPPED_JUNGLE_LOG_STRUCTURE_BLOCK.get(), new Item.Properties().tab(Novablocks.NOVABLOCKS_TAB)));
	
	public static final RegistryObject<BlockItem> STRIPPED_SPRUCE_LOG_STRUCTURE_BLOCK_ITEM = ITEMS.register("stripped_spruce_log_structure_block", 
			() -> new BlockItem(BlockInit.STRIPPED_SPRUCE_LOG_STRUCTURE_BLOCK.get(), new Item.Properties().tab(Novablocks.NOVABLOCKS_TAB)));
	
	public static final RegistryObject<BlockItem> STRIPPED_ACACIA_LOG_STRUCTURE_BLOCK_ITEM = ITEMS.register("stripped_acacia_log_structure_block", 
			() -> new BlockItem(BlockInit.STRIPPED_ACACIA_LOG_STRUCTURE_BLOCK.get(), new Item.Properties().tab(Novablocks.NOVABLOCKS_TAB)));
	
	public static final RegistryObject<BlockItem> STRIPPED_DARK_OAK_LOG_STRUCTURE_BLOCK_ITEM = ITEMS.register("stripped_dark_oak_log_structure_block", 
			() -> new BlockItem(BlockInit.STRIPPED_DARK_OAK_LOG_STRUCTURE_BLOCK.get(), new Item.Properties().tab(Novablocks.NOVABLOCKS_TAB)));
	
}
