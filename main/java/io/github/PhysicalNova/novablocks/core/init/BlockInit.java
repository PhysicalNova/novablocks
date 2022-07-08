package io.github.PhysicalNova.novablocks.core.init;

import io.github.PhysicalNova.novablocks.Novablocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class BlockInit {
	
	private BlockInit() {}
	
	public static final DeferredRegister<Block> BLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS, Novablocks.MODID);
	
	public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCK.register("example_block", 
			() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.GOLD).strength(2.0f, 15f)
					.requiresCorrectToolForDrops().friction(0.5f))); //exemple
	
	public static final RegistryObject<Block> HAZARD_BLOCK = BLOCK.register("hazard_block",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
					.requiresCorrectToolForDrops().strength(5.0f, 15.0f)));
}
