package nl.jandt.archimc.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class ModernBollard extends Block {
    public ModernBollard(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        VoxelShape shape = VoxelShapes.empty();

        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.25, 0, 0.25, 0.75, 0.9375, 0.75));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.265625, 0.9375, 0.265625, 0.734375, 1, 0.734375));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.25, 1, 0.25, 0.75, 1.0625, 0.75));

        return shape;
    }
}
