package io.github.PhysicalNova.novablocks.core.init;

import io.github.PhysicalNova.novablocks.Novablocks;
import io.github.PhysicalNova.novablocks.common.block.IWeatherableStructure;
import io.github.PhysicalNova.novablocks.common.block.StructureBase;
import io.github.PhysicalNova.novablocks.common.block.WaxedStructureBase;
import io.github.PhysicalNova.novablocks.common.block.WeatherableStructureBase;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class BlockInit {
	
	private BlockInit() {}
	
	public static final DeferredRegister<Block> BLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS, Novablocks.MODID);
	
	//full blocks
	
	public static final RegistryObject<Block> HAZARD_BLOCK = BLOCK.register("hazard_block",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
					.requiresCorrectToolForDrops().strength(5.0f, 15.0f)));
	
	public static final RegistryObject<Block> RED_METAL_BLOCK = BLOCK.register("red_metal_block",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
					.requiresCorrectToolForDrops()));
	
	public static final RegistryObject<Block> RUSTY_METAL_BLOCK = BLOCK.register("rusty_metal_block",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
					.requiresCorrectToolForDrops()));
	
	//structure blocks
	
	public static final RegistryObject<StructureBase> IRON_STRUCTURE_BLOCK = BLOCK.register("iron_structure_block",
			() -> new StructureBase(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
	
	public static final RegistryObject<WeatherableStructureBase> COPPER_STRUCTURE_BLOCK = BLOCK.register("copper_structure_block",
			() -> new WeatherableStructureBase(IWeatherableStructure.WeatherState.UNAFFECTED, BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK).noOcclusion()));
	
	public static final RegistryObject<WeatherableStructureBase> EXPOSED_COPPER_STRUCTURE_BLOCK = BLOCK.register("exposed_copper_structure_block",
			() -> new WeatherableStructureBase(IWeatherableStructure.WeatherState.EXPOSED, BlockBehaviour.Properties.copy(Blocks.EXPOSED_COPPER).noOcclusion()));
	
	public static final RegistryObject<WeatherableStructureBase> WEATHERED_COPPER_STRUCTURE_BLOCK = BLOCK.register("weathered_copper_structure_block",
			() -> new WeatherableStructureBase(IWeatherableStructure.WeatherState.WEATHERED, BlockBehaviour.Properties.copy(Blocks.WEATHERED_COPPER).noOcclusion()));
	
	public static final RegistryObject<WeatherableStructureBase> OXIDIZED_COPPER_STRUCTURE_BLOCK = BLOCK.register("oxidized_copper_structure_block",
			() -> new WeatherableStructureBase(IWeatherableStructure.WeatherState.OXIDIZED, BlockBehaviour.Properties.copy(Blocks.OXIDIZED_COPPER).noOcclusion()));
	
	public static final RegistryObject<WaxedStructureBase> WAXED_COPPER_STRUCTURE_BLOCK = BLOCK.register("waxed_copper_structure_block",
			() -> new WaxedStructureBase(WaxedStructureBase.WeatherState.UNAFFECTED,BlockBehaviour.Properties.copy(Blocks.WAXED_COPPER_BLOCK).noOcclusion()));
	
	public static final RegistryObject<WaxedStructureBase> WAXED_EXPOSED_COPPER_STRUCTURE_BLOCK = BLOCK.register("waxed_exposed_copper_structure_block",
			() -> new WaxedStructureBase(WaxedStructureBase.WeatherState.EXPOSED, BlockBehaviour.Properties.copy(Blocks.WAXED_EXPOSED_COPPER).noOcclusion()));
	
	public static final RegistryObject<WaxedStructureBase> WAXED_WEATHERED_COPPER_STRUCTURE_BLOCK = BLOCK.register("waxed_weathered_copper_structure_block",
			() -> new WaxedStructureBase(WaxedStructureBase.WeatherState.WEATHERED, BlockBehaviour.Properties.copy(Blocks.WAXED_WEATHERED_COPPER).noOcclusion()));
	
	public static final RegistryObject<WaxedStructureBase> WAXED_OXIDIZED_COPPER_STRUCTURE_BLOCK = BLOCK.register("waxed_oxidized_copper_structure_block",
			() -> new WaxedStructureBase(WaxedStructureBase.WeatherState.OXIDIZED, BlockBehaviour.Properties.copy(Blocks.WAXED_OXIDIZED_COPPER).noOcclusion()));
	
	public static final RegistryObject<StructureBase> RED_METAL_STRUCTURE_BLOCK = BLOCK.register("red_metal_structure_block",
			() -> new StructureBase(BlockBehaviour.Properties.copy(RED_METAL_BLOCK.get()).noOcclusion()));
	
	public static final RegistryObject<StructureBase> RUSTY_METAL_STRUCTURE_BLOCK = BLOCK.register("rusty_metal_structure_block",
			() -> new StructureBase(BlockBehaviour.Properties.copy(RUSTY_METAL_BLOCK.get()).noOcclusion()));
	
	public static final RegistryObject<StructureBase> HAZARD_STRUCTURE_BLOCK = BLOCK.register("hazard_structure_block",
			() -> new StructureBase(BlockBehaviour.Properties.copy(HAZARD_BLOCK.get()).noOcclusion()));
	
	public static final RegistryObject<StructureBase> OAK_LOG_STRUCTURE_BLOCK = BLOCK.register("oak_log_structure_block",
			() -> new StructureBase(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).noOcclusion()));
	
	public static final RegistryObject<StructureBase> BIRCH_LOG_STRUCTURE_BLOCK = BLOCK.register("birch_log_structure_block",
			() -> new StructureBase(BlockBehaviour.Properties.copy(Blocks.BIRCH_LOG).noOcclusion()));
	
	public static final RegistryObject<StructureBase> JUNGLE_LOG_STRUCTURE_BLOCK = BLOCK.register("jungle_log_structure_block",
			() -> new StructureBase(BlockBehaviour.Properties.copy(Blocks.JUNGLE_LOG).noOcclusion()));
	
	public static final RegistryObject<StructureBase> SPRUCE_LOG_STRUCTURE_BLOCK = BLOCK.register("spruce_log_structure_block",
			() -> new StructureBase(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LOG).noOcclusion()));
	
	public static final RegistryObject<StructureBase> ACACIA_LOG_STRUCTURE_BLOCK = BLOCK.register("acacia_log_structure_block",
			() -> new StructureBase(BlockBehaviour.Properties.copy(Blocks.ACACIA_LOG).noOcclusion()));
	
	public static final RegistryObject<StructureBase> DARK_OAK_LOG_STRUCTURE_BLOCK = BLOCK.register("dark_oak_log_structure_block",
			() -> new StructureBase(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_LOG).noOcclusion()));
	
	public static final RegistryObject<StructureBase> STRIPPED_OAK_LOG_STRUCTURE_BLOCK = BLOCK.register("stripped_oak_log_structure_block",
			() -> new StructureBase(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).noOcclusion()));
	
	public static final RegistryObject<StructureBase> STRIPPED_BIRCH_LOG_STRUCTURE_BLOCK = BLOCK.register("stripped_birch_log_structure_block",
			() -> new StructureBase(BlockBehaviour.Properties.copy(Blocks.STRIPPED_BIRCH_LOG).noOcclusion()));
	
	public static final RegistryObject<StructureBase> STRIPPED_JUNGLE_LOG_STRUCTURE_BLOCK = BLOCK.register("stripped_jungle_log_structure_block",
			() -> new StructureBase(BlockBehaviour.Properties.copy(Blocks.STRIPPED_JUNGLE_LOG).noOcclusion()));
	
	public static final RegistryObject<StructureBase> STRIPPED_SPRUCE_LOG_STRUCTURE_BLOCK = BLOCK.register("stripped_spruce_log_structure_block",
			() -> new StructureBase(BlockBehaviour.Properties.copy(Blocks.STRIPPED_SPRUCE_LOG).noOcclusion()));
	
	public static final RegistryObject<StructureBase> STRIPPED_ACACIA_LOG_STRUCTURE_BLOCK = BLOCK.register("stripped_acacia_log_structure_block",
			() -> new StructureBase(BlockBehaviour.Properties.copy(Blocks.STRIPPED_ACACIA_LOG).noOcclusion()));
	
	public static final RegistryObject<StructureBase> STRIPPED_DARK_OAK_LOG_STRUCTURE_BLOCK = BLOCK.register("stripped_dark_oak_log_structure_block",
			() -> new StructureBase(BlockBehaviour.Properties.copy(Blocks.STRIPPED_DARK_OAK_LOG).noOcclusion()));
	
}
