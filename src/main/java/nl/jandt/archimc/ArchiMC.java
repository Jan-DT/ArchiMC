package nl.jandt.archimc;

import nl.jandt.archimc.registry.BlockRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ArchiMC implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("ArchiMC");

    // This structure was kinda stolen from Farmers Delight
    public static final String MOD_ID = "archimc";

    public static final RegistryKey<ItemGroup> ITEM_GROUP_STREET_DECORATION = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(MOD_ID, "street_decoration"));
    public static final RegistryKey<ItemGroup> ITEM_GROUP_FURNITURE = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(MOD_ID, "furniture"));

    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM_GROUP, ITEM_GROUP_STREET_DECORATION, FabricItemGroup.builder()
                .icon(() -> new ItemStack(BlockRegistry.LIGHT_STEEL_OLD_BOLLARD))
                .displayName(Text.translatable("itemGroup.archimc.street_decoration"))
                .build());

        Registry.register(Registries.ITEM_GROUP, ITEM_GROUP_FURNITURE, FabricItemGroup.builder()
                .icon(() -> new ItemStack(BlockRegistry.OAK_ARMLESS_CHAIR))
                .displayName(Text.translatable("itemGroup.archimc.furniture"))
                .build());

        BlockRegistry.registerAll();
    }
}
