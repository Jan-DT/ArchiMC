package nl.jandt.archimc.registry;

import net.minecraft.block.Blocks;
import nl.jandt.archimc.ArchiMC;
import nl.jandt.archimc.blocks.ArmlessChair;
import nl.jandt.archimc.blocks.LargeBollard;
import nl.jandt.archimc.blocks.ModernBollard;
import nl.jandt.archimc.blocks.OldBollard;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public final class BlockRegistry {
    /// STREET DECORATIONS
    // Modern Bollard
    public static final ModernBollard LIGHT_STEEL_MODERN_BOLLARD = new ModernBollard(FabricBlockSettings.create().strength(5.0f, 10.0f).sounds(BlockSoundGroup.NETHERITE));
    public static final ModernBollard STEEL_MODERN_BOLLARD = new ModernBollard(FabricBlockSettings.create().strength(5.0f, 10.0f).sounds(BlockSoundGroup.NETHERITE));
    public static final ModernBollard STONE_MODERN_BOLLARD = new ModernBollard(FabricBlockSettings.create().strength(5.0f, 10.0f).sounds(BlockSoundGroup.STONE));
    public static final ModernBollard BLACK_MODERN_BOLLARD = new ModernBollard(FabricBlockSettings.create().strength(5.0f, 10.0f).sounds(BlockSoundGroup.COPPER));
    // Old Bollard
    public static final OldBollard LIGHT_STEEL_OLD_BOLLARD = new OldBollard(FabricBlockSettings.create().strength(4.0f, 8.0f).sounds(BlockSoundGroup.COPPER));
    public static final OldBollard STEEL_OLD_BOLLARD = new OldBollard(FabricBlockSettings.create().strength(4.0f, 8.0f).sounds(BlockSoundGroup.COPPER));
    public static final OldBollard BLACK_OLD_BOLLARD = new OldBollard(FabricBlockSettings.create().strength(4.0f, 8.0f).sounds(BlockSoundGroup.COPPER));
    public static final OldBollard GREEN_OLD_BOLLARD = new OldBollard(FabricBlockSettings.create().strength(4.0f, 8.0f).sounds(BlockSoundGroup.COPPER));
    public static final OldBollard RED_OLD_BOLLARD = new OldBollard(FabricBlockSettings.create().strength(4.0f, 8.0f).sounds(BlockSoundGroup.COPPER));
    // Large Bollard
    public static final LargeBollard LIGHT_STEEL_LARGE_BOLLARD = new LargeBollard(FabricBlockSettings.create().strength(6.0f, 12.0f).sounds(BlockSoundGroup.COPPER));
    public static final LargeBollard STEEL_LARGE_BOLLARD = new LargeBollard(FabricBlockSettings.create().strength(6.0f, 12.0f).sounds(BlockSoundGroup.COPPER));

    /// FURNITURE
    public static final ArmlessChair OAK_ARMLESS_CHAIR = new ArmlessChair(FabricBlockSettings.copyOf(Blocks.OAK_STAIRS));
    public static final ArmlessChair SPRUCE_ARMLESS_CHAIR = new ArmlessChair(FabricBlockSettings.copyOf(Blocks.OAK_STAIRS));
    public static final ArmlessChair BIRCH_ARMLESS_CHAIR = new ArmlessChair(FabricBlockSettings.copyOf(Blocks.OAK_STAIRS));
    public static final ArmlessChair JUNGLE_ARMLESS_CHAIR = new ArmlessChair(FabricBlockSettings.copyOf(Blocks.OAK_STAIRS));
    public static final ArmlessChair ACACIA_ARMLESS_CHAIR = new ArmlessChair(FabricBlockSettings.copyOf(Blocks.OAK_STAIRS));
    public static final ArmlessChair DARK_OAK_ARMLESS_CHAIR = new ArmlessChair(FabricBlockSettings.copyOf(Blocks.OAK_STAIRS));
    public static final ArmlessChair MANGROVE_ARMLESS_CHAIR = new ArmlessChair(FabricBlockSettings.copyOf(Blocks.OAK_STAIRS));
    public static final ArmlessChair CHERRY_ARMLESS_CHAIR = new ArmlessChair(FabricBlockSettings.copyOf(Blocks.OAK_STAIRS));
    public static final ArmlessChair BAMBOO_ARMLESS_CHAIR = new ArmlessChair(FabricBlockSettings.copyOf(Blocks.OAK_STAIRS));
    public static final ArmlessChair CRIMSON_ARMLESS_CHAIR = new ArmlessChair(FabricBlockSettings.copyOf(Blocks.OAK_STAIRS));
    public static final ArmlessChair WARPED_ARMLESS_CHAIR = new ArmlessChair(FabricBlockSettings.copyOf(Blocks.OAK_STAIRS));

    /**
     * Registers all blocks in the mod. Does not contain items.
     */
    public static void registerAll() {
        /// STREET DECORATIONS
        // Modern Bollard
        registerBlockItem(new Identifier(ArchiMC.MOD_ID, "light_steel_modern_bollard"), LIGHT_STEEL_MODERN_BOLLARD, ArchiMC.ITEM_GROUP_STREET_DECORATION);
        registerBlockItem(new Identifier(ArchiMC.MOD_ID, "steel_modern_bollard"), STEEL_MODERN_BOLLARD, ArchiMC.ITEM_GROUP_STREET_DECORATION);
        registerBlockItem(new Identifier(ArchiMC.MOD_ID, "stone_modern_bollard"), STONE_MODERN_BOLLARD, ArchiMC.ITEM_GROUP_STREET_DECORATION);
        registerBlockItem(new Identifier(ArchiMC.MOD_ID, "black_modern_bollard"), BLACK_MODERN_BOLLARD, ArchiMC.ITEM_GROUP_STREET_DECORATION);
        // Old Bollard
        registerBlockItem(new Identifier(ArchiMC.MOD_ID, "light_steel_old_bollard"), LIGHT_STEEL_OLD_BOLLARD, ArchiMC.ITEM_GROUP_STREET_DECORATION);
        registerBlockItem(new Identifier(ArchiMC.MOD_ID, "steel_old_bollard"), STEEL_OLD_BOLLARD, ArchiMC.ITEM_GROUP_STREET_DECORATION);
        registerBlockItem(new Identifier(ArchiMC.MOD_ID, "black_old_bollard"), BLACK_OLD_BOLLARD, ArchiMC.ITEM_GROUP_STREET_DECORATION);
        registerBlockItem(new Identifier(ArchiMC.MOD_ID, "green_old_bollard"), GREEN_OLD_BOLLARD, ArchiMC.ITEM_GROUP_STREET_DECORATION);
        registerBlockItem(new Identifier(ArchiMC.MOD_ID, "red_old_bollard"), RED_OLD_BOLLARD, ArchiMC.ITEM_GROUP_STREET_DECORATION);
        // Large Bollard
        registerBlockItem(new Identifier(ArchiMC.MOD_ID, "light_steel_large_bollard"), LIGHT_STEEL_LARGE_BOLLARD, ArchiMC.ITEM_GROUP_STREET_DECORATION);
        registerBlockItem(new Identifier(ArchiMC.MOD_ID, "steel_large_bollard"), STEEL_LARGE_BOLLARD, ArchiMC.ITEM_GROUP_STREET_DECORATION);

        /// FURNITURE
        registerBlockItem(new Identifier(ArchiMC.MOD_ID, "oak_armless_chair"), OAK_ARMLESS_CHAIR, ArchiMC.ITEM_GROUP_FURNITURE);
        registerBlockItem(new Identifier(ArchiMC.MOD_ID, "spruce_armless_chair"), SPRUCE_ARMLESS_CHAIR, ArchiMC.ITEM_GROUP_FURNITURE);
        registerBlockItem(new Identifier(ArchiMC.MOD_ID, "birch_armless_chair"), BIRCH_ARMLESS_CHAIR, ArchiMC.ITEM_GROUP_FURNITURE);
        registerBlockItem(new Identifier(ArchiMC.MOD_ID, "dark_oak_armless_chair"), DARK_OAK_ARMLESS_CHAIR, ArchiMC.ITEM_GROUP_FURNITURE);
        registerBlockItem(new Identifier(ArchiMC.MOD_ID, "acacia_armless_chair"), ACACIA_ARMLESS_CHAIR, ArchiMC.ITEM_GROUP_FURNITURE);
        registerBlockItem(new Identifier(ArchiMC.MOD_ID, "jungle_armless_chair"), JUNGLE_ARMLESS_CHAIR, ArchiMC.ITEM_GROUP_FURNITURE);
        registerBlockItem(new Identifier(ArchiMC.MOD_ID, "mangrove_armless_chair"), MANGROVE_ARMLESS_CHAIR, ArchiMC.ITEM_GROUP_FURNITURE);
        registerBlockItem(new Identifier(ArchiMC.MOD_ID, "cherry_armless_chair"), CHERRY_ARMLESS_CHAIR, ArchiMC.ITEM_GROUP_FURNITURE);
        registerBlockItem(new Identifier(ArchiMC.MOD_ID, "bamboo_armless_chair"), BAMBOO_ARMLESS_CHAIR, ArchiMC.ITEM_GROUP_FURNITURE);
        registerBlockItem(new Identifier(ArchiMC.MOD_ID, "crimson_armless_chair"), CRIMSON_ARMLESS_CHAIR, ArchiMC.ITEM_GROUP_FURNITURE);
        registerBlockItem(new Identifier(ArchiMC.MOD_ID, "warped_armless_chair"), WARPED_ARMLESS_CHAIR, ArchiMC.ITEM_GROUP_FURNITURE);
    }

    /**
     * Registers a block and the corresponding item, and adds it to an {@link ItemGroup}.
     *
     * @param id Identifier for this block
     * @param block Block instance for this block
     * @param itemGroupKey {@link RegistryKey} of the ItemGroup to add this block to (optional)
     */
    public static void registerBlockItem(Identifier id, Block block, RegistryKey<ItemGroup> itemGroupKey) {
        // Registers blocks as both block and item. When ItemGroup is specified, add the item to it.
        Registry.register(Registries.BLOCK, id, block);
        Registry.register(Registries.ITEM, id, new BlockItem(block, new FabricItemSettings()));

        ItemGroupEvents.modifyEntriesEvent(itemGroupKey).register(content -> content.add(block));
    }

    /**
     * Same as {@link BlockRegistry#registerBlockItem(Identifier, Block, RegistryKey)},
     * but does not register the {@link ItemGroup}.
     *
     * @see BlockRegistry#registerBlockItem(Identifier, Block, RegistryKey)
     */
    public static void registerBlockItem(Identifier id, Block block) {
        // Registers blocks as both block and item. Will not register to ItemGroup.
        Registry.register(Registries.BLOCK, id, block);
        Registry.register(Registries.ITEM, id, new BlockItem(block, new FabricItemSettings()));
    }
}
