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

/**
 * Block class that allows for blocks to be lowered when bottom slabs are placed underneath.
 * Contains methods for the lowering of blocks on neighbor updates and placement.
 * Meant to be inherited from blocks. The actual model for the lowerable blocks should be handled
 * using the BlockStates file for that specific block (i.e. adding "lowered=false" and "lowered=true" in the .json).
 *
 * @author 4FA
 * @version 1.0
 * @since 0.1-ALPHA-3
 */
public class LowerableBlock extends Block {
    public static final BooleanProperty LOWERED = BooleanProperty.of("lowered");

    public LowerableBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(LOWERED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LOWERED);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        // Get the BlockState for the block below.
        BlockPos posBelow = ctx.getBlockPos().down();
        BlockState stateBelow = ctx.getWorld().getBlockState(posBelow);

        // If the block below is a 'SlabBlock', and has the state TYPE == BOTTOM, then set the lowered state to true.
        if (stateBelow.getBlock() instanceof SlabBlock && stateBelow.get(SlabBlock.TYPE) == SlabType.BOTTOM) {
            return getDefaultState().with(LOWERED, true);
        }

        return super.getPlacementState(ctx);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        // Check if the updated block is below this block.
        if (direction == Direction.DOWN) {
            if (neighborState.getBlock() instanceof SlabBlock && neighborState.get(SlabBlock.TYPE) == SlabType.BOTTOM) {
                // Then if the block below is a 'SlabBlock', and is a bottom slab, then set the lowered state to true.
                return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos).with(LOWERED, true);
            } else {
                // Otherwise, set the lowered state to false.
                return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos).with(LOWERED, false);
            }
        }

        // Any other block updates will just inherit the method.
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        // By default, the OutlineShape for the block will be a full cube,
        // otherwise it will be a cube moved .5 blocks down.
        return state.get(LOWERED)
                ? VoxelShapes.cuboid(0.0f, -0.5f, 0.0f, 1.0f, 0.5f, 1.0f)
                : VoxelShapes.fullCube();
    }
}
