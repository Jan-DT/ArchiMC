package nl.jandt.archimc.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.enums.SlabType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

public class OldBollard extends Block {
    public static final BooleanProperty LOWERED = BooleanProperty.of("lowered");

    public OldBollard(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(LOWERED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LOWERED);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockPos posBelow = ctx.getBlockPos().down();
        BlockState stateBelow = ctx.getWorld().getBlockState(posBelow);

        if (stateBelow.getBlock() instanceof SlabBlock && stateBelow.get(SlabBlock.TYPE) == SlabType.BOTTOM) {
            return getDefaultState().with(LOWERED, true);
        }

        return super.getPlacementState(ctx);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (direction == Direction.DOWN) {
            if (neighborState.getBlock() instanceof SlabBlock && neighborState.get(SlabBlock.TYPE) == SlabType.BOTTOM) {
                return state.with(LOWERED, true);
            } else {
                return state.with(LOWERED, false);
            }
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        VoxelShape shape = VoxelShapes.empty();

        float y_change = state.get(LOWERED) ? -0.5f : 0.0f;

        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.40625, 0.1875 + y_change, 0.40625, 0.59375, 1.25 + y_change, 0.59375));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, y_change, 0.375, 0.625, 0.1875 + y_change, 0.625));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 0.4375 + y_change, 0.375, 0.625, 0.5 + y_change, 0.625));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 1.0625 + y_change, 0.375, 0.625, 1.1875 + y_change, 0.625));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 0.75 + y_change, 0.375, 0.625, 0.8125 + y_change, 0.625));

        return shape;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        float y_change = state.get(LOWERED) ? -0.5f : 0.0f;
        return VoxelShapes.cuboid(0.375f, y_change, 0.375f, 0.625f, 1.5f + y_change, 0.625f);
    }
}
