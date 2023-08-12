package nl.jandt.archimc.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class LargeBollard extends Block {
    public LargeBollard(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        VoxelShape shape = VoxelShapes.empty();

        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.21875, 0, 0.21875, 0.78125, 0.1875, 0.78125));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.25, 0.1875, 0.25, 0.75, 0.9375, 0.75));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.21875, 0.9375, 0.21875, 0.78125, 1.0625, 0.78125));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.28125, 1.0625, 0.28125, 0.71875, 1.125, 0.71875));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 1.125, 0.375, 0.625, 1.1875, 0.625));

        return shape;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0.25f, 0.0f, 0.25f, 0.75f, 1.3f, 0.75f);
    }
}
