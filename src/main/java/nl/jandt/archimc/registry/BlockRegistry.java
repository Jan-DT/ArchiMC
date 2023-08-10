package nl.jandt.archimc.registry;

import nl.jandt.archimc.ArchiMC;
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
    public static final Block LIGHT_STEEL_MODERN_BOLLARD = new ModernBollard(FabricBlockSettings.create().strength(5.0f, 10.0f).sounds(BlockSoundGroup.NETHERITE));
    public static final Block STEEL_MODERN_BOLLARD = new ModernBollard(FabricBlockSettings.create().strength(5.0f, 10.0f).sounds(BlockSoundGroup.NETHERITE));
    public static final Block STONE_MODERN_BOLLARD = new ModernBollard(FabricBlockSettings.create().strength(5.0f, 10.0f).sounds(BlockSoundGroup.STONE));
    public static final Block BLACK_MODERN_BOLLARD = new ModernBollard(FabricBlockSettings.create().strength(5.0f, 10.0f).sounds(BlockSoundGroup.COPPER));

    // Old Bollard
    public static final Block LIGHT_STEEL_OLD_BOLLARD = new OldBollard(FabricBlockSettings.create().strength(5.0f, 10.0f).sounds(BlockSoundGroup.COPPER));
    public static final Block STEEL_OLD_BOLLARD = new OldBollard(FabricBlockSettings.create().strength(5.0f, 10.0f).sounds(BlockSoundGroup.COPPER));
    public static final Block BLACK_OLD_BOLLARD = new OldBollard(FabricBlockSettings.create().strength(5.0f, 10.0f).sounds(BlockSoundGroup.COPPER));
    public static final Block GREEN_OLD_BOLLARD = new OldBollard(FabricBlockSettings.create().strength(5.0f, 10.0f).sounds(BlockSoundGroup.COPPER));
    public static final Block RED_OLD_BOLLARD = new OldBollard(FabricBlockSettings.create().strength(5.0f, 10.0f).sounds(BlockSoundGroup.COPPER));

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
    }

    public static void registerBlockItem(Identifier id, Block block, RegistryKey<ItemGroup> itemGroupKey) {
        Registry.register(Registries.BLOCK, id, block);
        Registry.register(Registries.ITEM, id, new BlockItem(block, new FabricItemSettings()));

        ItemGroupEvents.modifyEntriesEvent(itemGroupKey).register(content -> content.add(block));
    }
}
