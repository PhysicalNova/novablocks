package io.github.PhysicalNova.novablocks.core.init;

import io.github.PhysicalNova.novablocks.Novablocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class SoundInit {
	
	private SoundInit() {}
	
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Novablocks.MODID);

	public static final RegistryObject<SoundEvent> WRENCHAMMER = SOUNDS.register("item.wrenchammer.use", 
			() -> new SoundEvent(new ResourceLocation(Novablocks.MODID, "item.wrenchammer.use")));
	
}