package io.github.PhysicalNova.novablocks.common.block;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import io.github.PhysicalNova.novablocks.core.init.ItemInit;
import io.github.PhysicalNova.novablocks.core.init.SoundInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class StructureBase extends RotatedPillarBlock implements SimpleWaterloggedBlock {
	public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
	public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
	public static final BooleanProperty EAST = BlockStateProperties.EAST;
	public static final BooleanProperty WEST = BlockStateProperties.WEST;
	public static final BooleanProperty UP = BlockStateProperties.UP;
	public static final BooleanProperty DOWN = BlockStateProperties.DOWN;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	
	public static Map<Integer, VoxelShape> SHAPES = new HashMap<Integer, VoxelShape>();
	
	public StructureBase(Properties properties) {
		super(properties);
		CalculateAllShapes();
	}
	
	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player,
			InteractionHand hand, BlockHitResult result) {
		
		if (player.getItemInHand(hand).getItem().equals(ItemInit.WRENCHAMMER.get())) {
			level.playSound(player, pos, SoundInit.WRENCHAMMER.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
			if(!level.isClientSide) {
				Direction sideClicked=result.getDirection();
			
				double x = result.getLocation().x;
				double y = result.getLocation().y;
				double z = result.getLocation().z;
			
				double floor_x = Math.floor(x);
				double floor_y = Math.floor(y);
				double floor_z = Math.floor(z);
			
				boolean inside = ((int)(floor_x)==pos.getX() && (int)(floor_y)==pos.getY() && (int)(floor_z)==pos.getZ() && 
						!(x-floor_x<=0.0625 || y-floor_y<=0.0625 || z-floor_z<=0.0625
						||x-floor_x>=0.9375 || y-floor_y>=0.9375 || z-floor_z>=0.9375));
			
				BlockState newState = invertSide(state, getAssociatedSide(sideClicked, inside));
				level.setBlockAndUpdate(pos, newState);
				updateShape(state, sideClicked, newState, level, pos, pos);
			}
			return InteractionResult.SUCCESS;
		} else return InteractionResult.PASS;
	}
	
	public BlockState invertSide(BlockState state, BooleanProperty face) {
		return state.setValue(face, !state.getValue(face));
	}
	
	public BooleanProperty getAssociatedSide(Direction direction, boolean inside) {
		switch(direction) {
		case UP:
			return inside ? DOWN : UP;
		case DOWN:
			return inside ? UP : DOWN;
		case EAST:
			return inside ? WEST : EAST;
		case WEST:
			return inside ? EAST : WEST;
		case SOUTH:
			return inside ? NORTH : SOUTH;
		default:
			return inside ? SOUTH : NORTH;
		}
	}
	
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockPos blockpos = context.getClickedPos();
		FluidState fluidstate = context.getLevel().getFluidState(blockpos);
		return this.defaultBlockState().setValue(AXIS, context.getClickedFace().getAxis())
	    		  .setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER));
	}
	
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
	      builder.add(AXIS).add(NORTH).add(SOUTH).add(EAST).add(WEST).add(UP).add(DOWN).add(WATERLOGGED);
	}
	
	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState state) {
	   return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}
	
	public boolean placeLiquid(LevelAccessor level, BlockPos pos, BlockState state, FluidState fluidState) {
		return SimpleWaterloggedBlock.super.placeLiquid(level, pos, state, fluidState);
	}

	public boolean canPlaceLiquid(BlockGetter getter, BlockPos pos, BlockState state, Fluid fluid) {
		return SimpleWaterloggedBlock.super.canPlaceLiquid(getter, pos, state, fluid);
	}
	   
	   @SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction direction, BlockState state2, LevelAccessor level, BlockPos pos, BlockPos pos2) {
		      if (state.getValue(WATERLOGGED)) {
		         level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
		      }
		      return super.updateShape(state, direction, state2, level, pos, pos2);
		   }
	
	@SuppressWarnings("deprecation")
	@Override
	public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block,
			BlockPos neighbor, boolean block2) {
		if(level.getBlockState(neighbor).getBlock() instanceof StructureBase) {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			int n_x = neighbor.getX(); //x value of neighbor block
			int n_y = neighbor.getY();
			int n_z = neighbor.getZ();
			boolean disableFace = !(level.getBlockState(neighbor).getBlock() instanceof StructureBase);
			BlockState newState;
			//Brutal way of dealing with the cases, but there don't seem to be a better way
			if (x-1==n_x ) {
				newState = state.setValue(WEST, disableFace);
			} else if (x+1==n_x){
				newState = state.setValue(EAST, disableFace);
			} else if (y-1==n_y) {
				newState = state.setValue(DOWN, disableFace);
			} else if (y+1==n_y) {
				newState = state.setValue(UP, disableFace);
			} else if (z-1==n_z) {
				newState = state.setValue(NORTH, disableFace);
			} else{ //Last possible case, z+1==n_z
				newState = state.setValue(SOUTH, disableFace);
			}
		level.setBlockAndUpdate(pos, newState);
		}
		super.neighborChanged(state, level, pos, block, neighbor, block2);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return getShapeFromProperties(state, NORTH, SOUTH, EAST, WEST, UP, DOWN, AXIS, SHAPES);
	}
	
	public static void CalculateAllShapes() {
		//Now, we just have to go through all the possible ids and calculate their respective shape.
		for(int axis = 0; axis<3; axis++) { //Dumb but working way of representing the 3 axis. As a block can't have 2 axis, it's necessary
			for(int i=0; i<(power_int(2,6));i++) { //All the states with the sides.
				int id = (axis==0 ? i : (power_int(2,5+axis) + i));
				SHAPES.put(Integer.valueOf(id), CalculateOneShape(ALL_SHAPES_AABB_ARRAY, id));
			}
		}
	}
	
	//Beyond this are all of the block's shape shenanigans
	
	protected static final VoxelShape BOTTOM_AABB = Block.box(0, 1, 0, 16, 2, 16);
	protected static final VoxelShape TOP_AABB = Block.box(0, 14, 0, 16, 15, 16);
	protected static final VoxelShape WEST_AABB = Block.box(1, 0, 0, 2, 16, 16);
	protected static final VoxelShape EAST_AABB = Block.box(14, 0, 0, 15, 16, 16);
	protected static final VoxelShape NORTH_AABB = Block.box(0, 0, 1, 16, 16, 2);
	protected static final VoxelShape SOUTH_AABB = Block.box(0, 0, 14, 16, 16, 15);
	
	protected static final VoxelShape BASE_Y_1 = Block.box(0, 0, 0, 3, 16, 3);
	protected static final VoxelShape BASE_Y_2 = Block.box(13, 0, 0, 16, 16, 3);
	protected static final VoxelShape BASE_Y_3 = Block.box(0, 0, 13, 3, 16, 16);
	protected static final VoxelShape BASE_Y_4 = Block.box(13, 0, 13, 16, 16, 16);
	
	protected static final VoxelShape BASE_X_1 = Block.box(0, 0, 0, 16, 3, 3);
	protected static final VoxelShape BASE_X_2 = Block.box(0, 0, 13, 16, 3, 16);
	protected static final VoxelShape BASE_X_3 = Block.box(0, 13, 0, 16, 16, 3);
	protected static final VoxelShape BASE_X_4 = Block.box(0, 13, 13, 16, 16, 16);
	
	protected static final VoxelShape BASE_Z_1 = Block.box(0, 0, 0, 3, 3, 16);
	protected static final VoxelShape BASE_Z_2 = Block.box(13, 0, 0, 16, 3, 16);
	protected static final VoxelShape BASE_Z_3 = Block.box(0, 13, 0, 3, 16, 16);
	protected static final VoxelShape BASE_Z_4 = Block.box(13, 13, 0, 16, 16, 16);
	
	
	protected static final Optional<VoxelShape> BASE_Y = Stream.of(
			BASE_Y_1,
			BASE_Y_2,
			BASE_Y_3, 
			BASE_Y_4
			).reduce((v1,v2) -> Shapes.join(v1, v2, BooleanOp.OR));
	
	protected static final Optional<VoxelShape> BASE_X = Stream.of(
			BASE_X_1,
			BASE_X_2,
			BASE_X_3, 
			BASE_X_4
			).reduce((v1,v2) -> Shapes.join(v1, v2, BooleanOp.OR));
	
	protected static final Optional<VoxelShape> BASE_Z = Stream.of(
			BASE_Z_1,
			BASE_Z_2,
			BASE_Z_3, 
			BASE_Z_4
			).reduce((v1,v2) -> Shapes.join(v1, v2, BooleanOp.OR));
	
	protected static final VoxelShape[] ALL_SHAPES_AABB_ARRAY = {NORTH_AABB, SOUTH_AABB, EAST_AABB, WEST_AABB, TOP_AABB, BOTTOM_AABB,
			BASE_X.orElse(Shapes.block()), BASE_Y.orElse(Shapes.block()), BASE_Z.orElse(Shapes.block())};
	
	//Now for the useful functions


	public static VoxelShape CalculateOneShape(VoxelShape[] shapes, int id) {
		VoxelShape shape = Shapes.empty();
		boolean[] facesProperties = getPropertiesFromId(id);
		Axis axis = getAxisFromId(id);
		switch(axis) {
		case X:
			shape = Shapes.or(shape, shapes[6]);
			break;
		case Z:
			shape = Shapes.or(shape, shapes[8]);
			break;
		default:
			shape = Shapes.or(shape, shapes[7]);
			break;
		}
		//Main axis done, now for the sides
		for(int i=0; i<facesProperties.length; i++) {
			if(facesProperties[i])
				shape = Shapes.or(shape, shapes[i]);
		}
		
		return shape;
	}
	
	public static boolean[] getPropertiesFromId(int id) {
		//Here, we can use a boolean array instead of a BooleanProperty Array, it's probably lighter and gives enough info.
		//Here, we use an inverse application to get back the properties out of the id.
		boolean[] result = {false, false, false, false, false, false}; //resp north, south, east, west, up and down.
		int propertyId;
		Axis axis = getAxisFromId(id);
		switch(axis) {
		case Y:
			propertyId = id-power_int(2,6);
			break;
		case Z:
			propertyId = id-power_int(2,7);
			break;
		default:
			propertyId=id;
			break;
		}
		
		//Of course, we're mindful of the axis bits, or else the following logic doesn't apply.
		for(int i=5 ; i>=0; i--) { //We work backwards
			if((propertyId-power_int(2,i))>=0) {
				propertyId-=power_int(2,i);
				result[i]=true;
			}
		}
		return result;
	}
	
	public static Axis getAxisFromId(int id) {
		if((id-power_int(2,7))>=0) 
			return Direction.Axis.Z;
		 else if((id-power_int(2,6))>=0) 
			return Direction.Axis.Y;
		 else
			return Direction.Axis.X;
	}
	
	public static int getIdFromShape(BlockState state, BooleanProperty north, BooleanProperty south, BooleanProperty east, BooleanProperty west, 
			BooleanProperty up, BooleanProperty down, EnumProperty<Direction.Axis> axis) {
		int id = 0;
		BooleanProperty[] propertyArray =  new BooleanProperty[]{north, south, east, west, up, down};
		//The array is used for the for loop
		for (int i = 0 ; i<propertyArray.length ; i++) {
			id+= state.getValue(propertyArray[i]) ? power_int(2,i) : 0; //Encoding like bits
		}
		//We still have to take into account the axis by keeping the encoding style
		switch(state.getValue(axis)) {
		case Y:
			id+=power_int(2,(propertyArray.length)); //So 2^6
			break;
		case Z:
			id+=power_int(2,(propertyArray.length+1));// And here 2^7
			break;
		default:
			break; //Case X
		}
		return id; //This result is unique
	}
	
	public static VoxelShape getShapeFromId(Map<Integer, VoxelShape> shapes, int id) {
		return shapes.get(Integer.valueOf(id));
	}
	
	public static VoxelShape getShapeFromProperties(BlockState state, BooleanProperty north, BooleanProperty south, BooleanProperty east, BooleanProperty west, 
			BooleanProperty up, BooleanProperty down, EnumProperty<Direction.Axis> axis, Map<Integer, VoxelShape> shapes) {
		int id = getIdFromShape(state, north, south, east, west, up, down, axis);
		return getShapeFromId(shapes, id);
	}
	
	public static int power_int(int a, int b) {
		int result=1;
		for(int i=0; i<b;i++)
			result*=a;
		return result;
	}
}
