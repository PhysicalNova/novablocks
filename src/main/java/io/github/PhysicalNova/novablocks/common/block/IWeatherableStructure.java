package io.github.PhysicalNova.novablocks.common.block;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;

import io.github.PhysicalNova.novablocks.core.init.BlockInit;

import java.util.Optional;
import java.util.function.Supplier;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChangeOverTimeBlock;
import net.minecraft.world.level.block.state.BlockState;

public interface IWeatherableStructure extends ChangeOverTimeBlock<IWeatherableStructure.WeatherState> {
   Supplier<BiMap<WeatherableStructureBase, WeatherableStructureBase>> NEXT_BY_BLOCK = Suppliers.memoize(() -> {
      return ImmutableBiMap.<WeatherableStructureBase, WeatherableStructureBase>builder().put(BlockInit.COPPER_STRUCTURE_BLOCK.get(), BlockInit.EXPOSED_COPPER_STRUCTURE_BLOCK.get()).put(BlockInit.EXPOSED_COPPER_STRUCTURE_BLOCK.get(), BlockInit.WEATHERED_COPPER_STRUCTURE_BLOCK.get()).put(BlockInit.WEATHERED_COPPER_STRUCTURE_BLOCK.get(), BlockInit.OXIDIZED_COPPER_STRUCTURE_BLOCK.get()).build();
   }); //toChange
   Supplier<BiMap<WeatherableStructureBase, WeatherableStructureBase>> PREVIOUS_BY_BLOCK = Suppliers.memoize(() -> {
      return NEXT_BY_BLOCK.get().inverse();
   });

   static Optional<Block> getPrevious(Block p_154891_) {
      return Optional.ofNullable(PREVIOUS_BY_BLOCK.get().get(p_154891_));
   }

   static Block getFirst(Block p_154898_) {
      Block block = p_154898_;

      for(Block block1 = PREVIOUS_BY_BLOCK.get().get(p_154898_); block1 != null; block1 = PREVIOUS_BY_BLOCK.get().get(block1)) {
         block = block1;
      }

      return block;
   }

   static Optional<BlockState> getPrevious(BlockState p_154900_) {
      return getPrevious(p_154900_.getBlock()).map((p_154903_) -> {
         return p_154903_.withPropertiesOf(p_154900_);
      });
   }

   static Optional<Block> getNext(Block p_154905_) {
      return Optional.ofNullable(NEXT_BY_BLOCK.get().get(p_154905_));
   }

   static BlockState getFirst(BlockState p_154907_) {
      return getFirst(p_154907_.getBlock()).withPropertiesOf(p_154907_);
   }

   default Optional<BlockState> getNext(BlockState p_154893_) {
      return getNext(p_154893_.getBlock()).map((p_154896_) -> {
         return p_154896_.withPropertiesOf(p_154893_);
      });
   }

   default float getChanceModifier() {
      return this.getAge() == IWeatherableStructure.WeatherState.UNAFFECTED ? 0.75F : 1.0F;
   }

   public static enum WeatherState {
      UNAFFECTED,
      EXPOSED,
      WEATHERED,
      OXIDIZED;
   }
}