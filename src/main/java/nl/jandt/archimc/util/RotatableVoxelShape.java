package nl.jandt.archimc.util;

import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

/**
 * Custom class for handling the VoxelShapes of blocks that can be rotated,
 * instead of manually rotating the entire VoxelShape.
 * Calculates the rotation on initialization to save on performance later on.
 * <p>
 * Currently only supports the standard compass bearings like NORTH, EAST, SOUTH, and WEST,
 * but might add support for other directions later (like 45 deg intervals).
 *
 * @author 4FA
 * @version 1.0
 * @since 0.1-ALPHA-2
 */
public class RotatableVoxelShape {
    // VoxelShape from which all rotations will be calculated
    private final VoxelShape baseShape;
    // Direction of the original VoxelShape, usually Direction.NORTH
    private final Direction baseDirection;

    // Initialize the variables in which the rotations will be stored
    private final VoxelShape north;
    private final VoxelShape east;
    private final VoxelShape south;
    private final VoxelShape west;

    /**
     * Initializes a RotatableVoxelShape. Requires a baseShape and a baseDirection,
     * which it uses to calculate the VoxelShapes for the rotations.
     *
     * @param baseShape VoxelShape from which all rotations will be calculated
     * @param baseDirection Direction of the {@code baseShape}, usually {@link Direction#NORTH}
     */
    public RotatableVoxelShape(VoxelShape baseShape, Direction baseDirection) {
        this.baseShape = baseShape;
        this.baseDirection = baseDirection;

        // Calculates all rotations
        this.north = rotate(this.baseDirection, Direction.NORTH);
        this.east = rotate(this.baseDirection, Direction.EAST);
        this.south = rotate(this.baseDirection, Direction.SOUTH);
        this.west = rotate(this.baseDirection, Direction.WEST);
    }

    /**
     * Get the rotated VoxelShape for a specific {@link Direction}.
     * <p>
     * Currently, this only supports the NORTH, EAST, SOUTH, and WEST directions,
     * but support for other directions might be added later.
     *
     * @param direction The {@link Direction} for which to get the VoxelShape
     * @return Returns the rotated VoxelShape for the specified direction. Defaults to {@link net.minecraft.util.shape.VoxelShapes#fullCube}
     */
    public VoxelShape get(Direction direction) {
        return switch (direction) {
            case NORTH -> this.north;
            case EAST -> this.east;
            case SOUTH -> this.south;
            case WEST -> this.west;
            default -> VoxelShapes.fullCube();
        };
    }

    /**
     * Private method that calculates the required rotations for the VoxelShape to undergo.
     *
     * @param fromDirection {@link Direction} from which to calculate the rotation steps
     * @param toDirection {@link Direction} to which to calculate the rotation steps
     * @return {@link VoxelShape} that is rotated in the specified direction
     */
    private VoxelShape rotate(Direction fromDirection, Direction toDirection) {
        // Get the amount of rotations to perform.
        // This is not optimized at all, as it loops over each rotation multiple times, instead of doing it once,
        // but the performance cost is currently negligible.
        int rotations = (toDirection.getHorizontal() - fromDirection.getHorizontal() + 4) % 4;

        if (rotations == 0) {
            return baseShape;
        } else {
            VoxelShape rotatedShape = baseShape;
            // Rotate it 90 degrees until the required direction is reached.
            for (int i = 0; i < rotations; i++) {
                rotatedShape = rotate90Degrees(rotatedShape);
            }
            return rotatedShape;
        }
    }

    /**
     * Temporary method which rotates a VoxelShape 90 degrees clockwise.
     * Will probably be removed / changed later,
     * to allow for the support of more special rotations.
     * <p>
     * I think a matrix transformation might be more suitable,
     * but I was lazy and might or might not have used ChatGPT for this.
     *
     * @param shape VoxelShape to be rotated 90 degrees
     * @return VoxelShape that has been rotated 90 degrees
     */
    private static VoxelShape rotate90Degrees(VoxelShape shape) {
        VoxelShape[] rotatedShapes = new VoxelShape[3];
        for (int i = 0; i < 3; i++) {
            rotatedShapes[i] = VoxelShapes.empty();
        }

        // Rotates all the shapes within the VoxelShape.
        // This is the part I didn't bother understanding.
        shape.forEachBox((minX, minY, minZ, maxX, maxY, maxZ) -> {
            rotatedShapes[0] = VoxelShapes.union(
                    rotatedShapes[0],
                    VoxelShapes.cuboid(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX)
            );

            rotatedShapes[1] = VoxelShapes.union(
                    rotatedShapes[1],
                    VoxelShapes.cuboid(minX, minY, 1 - maxX, maxZ, maxY, 1 - minZ)
            );

            rotatedShapes[2] = VoxelShapes.union(
                    rotatedShapes[2],
                    VoxelShapes.cuboid(1 - maxX, minY, 1 - maxZ, 1 - minX, maxY, 1 - minZ)
            );
        });

        return rotatedShapes[0];
    }

}
