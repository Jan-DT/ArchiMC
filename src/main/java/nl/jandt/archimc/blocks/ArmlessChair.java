package nl.jandt.archimc.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import nl.jandt.archimc.util.RotatableVoxelShape;

import java.util.Objects;

public class ArmlessChair extends HorizontalFacingBlock {
    public ArmlessChair(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING);
    }

    /**
     * Builds the VoxelShape for this block, to be passed to the RotatableVoxelShape initializer.
     * @return {@link VoxelShape} for the block
     */
    private static VoxelShape baseShape() {
        VoxelShape shape = VoxelShapes.empty();

        // Uses a simplified VoxelShape due to its complicated shape.
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.1875, 0, 0.1875, 0.8125, 0.5, 0.8125));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.1875, 0.5, 0.6875, 0.8125, 1.0625, 0.8125));

        return shape;
    }

    // Initializes the RotatableVoxelShape, which calculates all rotations on init.
    private final RotatableVoxelShape rotatableShape = new RotatableVoxelShape(baseShape(), Direction.NORTH);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        Direction direction = state.get(FACING);
        // Gets the rotated VoxelShape in the requested direction from the RotatableVoxelShape.
        return rotatableShape.get(direction);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return Objects.requireNonNull(super.getPlacementState(ctx)).with(Properties.HORIZONTAL_FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }
}
