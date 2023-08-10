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

public class ArchiMC implements ModInitializer {

    // These two lines were directly stolen from Farmer's Delight
    public static final String MOD_ID = "archimc";
    public static final RegistryKey<ItemGroup> ITEM_GROUP_STREET_DECORATION = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(MOD_ID, "street_decoration"));

    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM_GROUP, ITEM_GROUP_STREET_DECORATION, FabricItemGroup.builder()
                .icon(() -> new ItemStack(BlockRegistry.STEEL_MODERN_BOLLARD))
                .displayName(Text.translatable("itemGroup.archimc.street_decoration"))
                .special()
                .build());

        BlockRegistry.registerAll();
    }
}
