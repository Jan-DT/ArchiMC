package nl.jandt.archimc.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class LargeBollard extends LowerableBlock {
    public LargeBollard(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        VoxelShape shape = VoxelShapes.empty();

        // If the 'lowered' BlockState is true, subtract .5 blocks from the VoxelShape y-position.
        float y_change = state.get(LOWERED) ? -0.5f : 0.0f;

        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.21875, 0.0 + y_change, 0.21875, 0.78125, 0.1875 + y_change, 0.78125));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.25, 0.1875 + y_change, 0.25, 0.75, 0.9375 + y_change, 0.75));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.21875, 0.9375 + y_change, 0.21875, 0.78125, 1.0625 + y_change, 0.78125));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.28125, 1.0625 + y_change, 0.28125, 0.71875, 1.125 + y_change, 0.71875));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 1.125 + y_change, 0.375, 0.625, 1.1875 + y_change, 0.625));

        return shape;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        // If the 'lowered' BlockState is true, subtract .5 blocks from the VoxelShape y-position.
        float y_change = state.get(LOWERED) ? -0.5f : 0.0f;
        return VoxelShapes.cuboid(0.25f, 0.0f + y_change, 0.25f, 0.75f, 1.3f + y_change, 0.75f);
    }
}
