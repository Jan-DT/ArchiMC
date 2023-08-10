package nl.jandt.archimc.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class OldBollard extends Block {
    public OldBollard(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        VoxelShape shape = VoxelShapes.empty();

        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.40625, 0.1875, 0.40625, 0.59375, 1.25, 0.59375));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 0, 0.375, 0.625, 0.1875, 0.625));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 0.4375, 0.375, 0.625, 0.5, 0.625));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 1.0625, 0.375, 0.625, 1.1875, 0.625));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 0.75, 0.375, 0.625, 0.8125, 0.625));

        return shape;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0.375f, 0.0f, 0.375f, 0.625f, 1.5f, 0.625f);
    }
}
