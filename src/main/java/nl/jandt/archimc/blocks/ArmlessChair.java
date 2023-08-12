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
import nl.jandt.archimc.utils.RotatableVoxelShape;

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

    private static VoxelShape baseShape() {
        VoxelShape shape = VoxelShapes.empty();

        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.1875, 0, 0.1875, 0.8125, 0.5, 0.8125));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.1875, 0.5, 0.6875, 0.8125, 1.0625, 0.8125));

        return shape;
    }

    private final RotatableVoxelShape rotatableShape = new RotatableVoxelShape(baseShape(), Direction.NORTH);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        Direction direction = state.get(FACING);
        return switch (direction) {
            case NORTH, EAST, SOUTH, WEST -> rotatableShape.get(direction);
            default -> VoxelShapes.fullCube();
        };
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return Objects.requireNonNull(super.getPlacementState(ctx)).with(Properties.HORIZONTAL_FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }
}
