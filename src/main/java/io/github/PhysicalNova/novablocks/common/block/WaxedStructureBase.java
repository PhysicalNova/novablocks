package io.github.PhysicalNova.novablocks.common.block;

import io.github.PhysicalNova.novablocks.core.init.BlockInit;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class WaxedStructureBase extends StructureBase{

	private final WeatherState weatherState;
	
	public WaxedStructureBase(WeatherState weatherState, Properties properties) {
		super(properties);
		this.weatherState = weatherState;
	}
	
	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand,
			BlockHitResult result) {
		
		if(player.getItemInHand(hand).getItem() instanceof AxeItem) {
	        boolean succeeded_interaction = false;
	        Block block;
	        switch(this.weatherState) {
	        case OXIDIZED:
	        	block=BlockInit.OXIDIZED_COPPER_STRUCTURE_BLOCK.get();
	        	break;
	        case EXPOSED:
	        	block=BlockInit.EXPOSED_COPPER_STRUCTURE_BLOCK.get();
	        	break;
	        case WEATHERED:
	        	block=BlockInit.WEATHERED_COPPER_STRUCTURE_BLOCK.get();
	        	break;
			default:
				block= BlockInit.COPPER_STRUCTURE_BLOCK.get();
				break;
	        }
	        try {
			BlockState previous_state = block.defaultBlockState()
					.setValue(WATERLOGGED, state.getValue(WATERLOGGED))
					.setValue(NORTH, state.getValue(NORTH))
					.setValue(SOUTH, state.getValue(SOUTH))
					.setValue(EAST, state.getValue(EAST))
					.setValue(WEST, state.getValue(WEST))
					.setValue(UP, state.getValue(UP))
					.setValue(DOWN, state.getValue(DOWN));
			level.setBlockAndUpdate(pos, previous_state);
			succeeded_interaction=true;
			}catch(Exception e) {
				succeeded_interaction=false;
				System.out.println("Failed interaction");
				return InteractionResult.PASS;
			}
			if(succeeded_interaction) {
				level.playSound(player, pos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);
		         level.levelEvent(player, 3004, pos, 0);
		        if(!player.isCreative())
					player.getItemInHand(hand).setDamageValue(player.getItemInHand(hand).getDamageValue()+1);
		        
		        if(player.getItemInHand(hand).getDamageValue()>=player.getItemInHand(hand).getMaxDamage()) {
		        	if (player != null) {
		                player.getItemInHand(hand).hurtAndBreak(1, player, (p_150686_) -> {
		                   p_150686_.broadcastBreakEvent(hand);
		                });
		        	}
		        }
				if(!level.isClientSide) {
					CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, pos, player.getItemInHand(hand));
				}
				return InteractionResult.SUCCESS;
			}
		}
		return super.use(state, level, pos, player, hand, result);
	}

	public static enum WeatherState {
	      UNAFFECTED,
	      EXPOSED,
	      WEATHERED,
	      OXIDIZED;
	   }
}
