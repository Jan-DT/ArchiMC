package nl.jandt.archimc.utils;

import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class RotatableVoxelShape {
    private final VoxelShape baseShape;
    private final Direction baseDirection;

    private final VoxelShape north;
    private final VoxelShape east;
    private final VoxelShape south;
    private final VoxelShape west;

    public RotatableVoxelShape(VoxelShape baseShape, Direction baseDirection) {
        this.baseShape = baseShape;
        this.baseDirection = baseDirection;

        this.north = rotate(this.baseDirection, Direction.NORTH);
        this.east = rotate(this.baseDirection, Direction.EAST);
        this.south = rotate(this.baseDirection, Direction.SOUTH);
        this.west = rotate(this.baseDirection, Direction.WEST);
    }

    public VoxelShape get(Direction direction) {
        return switch (direction) {
            case NORTH -> this.north;
            case EAST -> this.east;
            case SOUTH -> this.south;
            case WEST -> this.west;
            default -> VoxelShapes.fullCube();
        };
    }

    public VoxelShape rotate(Direction fromDirection, Direction toDirection) {
        int rotations = (toDirection.getHorizontal() - fromDirection.getHorizontal() + 4) % 4;

        if (rotations == 0) {
            return baseShape;
        } else {
            VoxelShape rotatedShape = baseShape;
            for (int i = 0; i < rotations; i++) {
                rotatedShape = rotate90Degrees(rotatedShape);
            }
            return rotatedShape;
        }
    }

    private static VoxelShape rotate90Degrees(VoxelShape shape) {
        VoxelShape[] rotatedShapes = new VoxelShape[3];
        for (int i = 0; i < 3; i++) {
            rotatedShapes[i] = VoxelShapes.empty();
        }

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
